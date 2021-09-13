package com.example.imgflix.network;

import com.example.imgflix.models.UnsplashPhotoListResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UnsplashPhotosApi {
    @GET("photos")
    Call<UnsplashPhotoListResponse>getImages();



}
