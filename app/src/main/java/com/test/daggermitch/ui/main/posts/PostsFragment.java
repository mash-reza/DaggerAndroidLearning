package com.test.daggermitch.ui.main.posts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.daggermitch.R;
import com.test.daggermitch.util.VerticalSpacingItemDecoration;
import com.test.daggermitch.viewmodel.ViewModelProvidersFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class PostsFragment extends DaggerFragment {

    private static final String TAG = "PostsFragment";

    private RecyclerView recyclerView;
    @Inject
    public ViewModelProvidersFactory viewModelProvidersFactory;
    private PostViewModel postViewModel;


    @Inject
    public PostsFragment() {
        // Required empty public constructor
    }

    @Inject
    public PostsRecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        postViewModel = new ViewModelProvider(this, viewModelProvidersFactory).get(PostViewModel.class);
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view);
        configRecyclerView();
        subscribeObservers();
    }

    private void subscribeObservers() {
        postViewModel.observePosts().removeObservers(getViewLifecycleOwner());
        postViewModel.observePosts().observe(getViewLifecycleOwner(), listResource -> {
            switch (listResource.status){
                case SUCCESS:{
                    adapter.setPosts(listResource.data);
                    break;
                }
                case LOADING:{
                    Log.d(TAG, "subscribeObservers: Loading posts...");
                    break;
                }
                case ERROR:{
                    Log.d(TAG, "subscribeObservers: Error in getting posts");
                    break;
                }
            }
        });
    }

    private void configRecyclerView() {
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new VerticalSpacingItemDecoration(15));
        recyclerView.setLayoutManager(new LinearLayoutManager(
                requireContext(), RecyclerView.VERTICAL, false));
    }
}