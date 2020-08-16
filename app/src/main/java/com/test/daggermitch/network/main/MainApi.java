package com.test.daggermitch.network.main;

import com.test.daggermitch.model.Post;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainApi {

    @GET("posts")
    Flowable<List<Post>> getPosts(@Query("userId") int id);
}
