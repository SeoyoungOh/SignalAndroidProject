package org.androidtown.signalapplication.Server.Interface;


import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SignalingAPI {
    @POST("/demand/meeting")
    @GET("/demand/meeting")
    @POST("/demand/person")
}
