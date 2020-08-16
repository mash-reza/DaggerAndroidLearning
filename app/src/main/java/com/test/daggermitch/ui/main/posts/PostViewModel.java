package com.test.daggermitch.ui.main.posts;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.test.daggermitch.SessionManager;
import com.test.daggermitch.model.Post;
import com.test.daggermitch.network.main.MainApi;
import com.test.daggermitch.ui.Resource;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends ViewModel {

    private static final String TAG = "PostViewModel";

    private MainApi mainApi;
    private SessionManager sessionManager;

    private MediatorLiveData<Resource<List<Post>>> postsLiveData;

    @Inject
    public PostViewModel(SessionManager sessionManager, MainApi mainApi) {
        Log.d(TAG, "PostViewModel: is working...");
        this.mainApi = mainApi;
        this.sessionManager = sessionManager;
    }

    public LiveData<Resource<List<Post>>> observePosts() {
        if (postsLiveData == null) {
            postsLiveData = new MediatorLiveData<Resource<List<Post>>>();
            postsLiveData.setValue(Resource.loading(null));
        }
        LiveData<Resource<List<Post>>> source = LiveDataReactiveStreams.fromPublisher(
                mainApi.getPosts(sessionManager.getAuthUser().getValue().data.getId())
                        .onErrorReturn(throwable -> {
                            Log.e(TAG, "observePosts: ", throwable);
                            List<Post> errorPosts = new LinkedList<>();
                            Post errorPost = new Post();
                            errorPost.setId(-1);
                            errorPosts.add(errorPost);
                            return errorPosts;
                        })
                        .map((Function<List<Post>, Resource<List<Post>>>) posts -> {
                            if (posts.size() > 0 && posts.get(0).getId() == -1) {
                                return Resource.error("Some Fucking Error Happened!", null);
                            }
                            return Resource.success(posts);
                        })
                        .subscribeOn(Schedulers.io()));
        postsLiveData.addSource(source, resource -> {
            postsLiveData.setValue(resource);
            postsLiveData.removeSource(source);
        });
        return postsLiveData;
    }
}








