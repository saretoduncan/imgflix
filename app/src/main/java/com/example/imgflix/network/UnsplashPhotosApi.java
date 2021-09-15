package com.example.imgflix.network;

import com.example.imgflix.models.UnsplashPhotoListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UnsplashPhotosApi {
    @GET("photos")
    Call<List<UnsplashPhotoListResponse>>getImages(
            @Query("client_id") String client_id,
            @Query("page") String page,
            @Query("per_page") String per_page
    );



}
