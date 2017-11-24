package org.androidtown.signalapplication.Server.Interface;


import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FollowAPI {
    @POST("/account/following")
    @GET("/account/following")
    @DELETE("account/following/{publisher_id")
    @GET("account/follower")
}
