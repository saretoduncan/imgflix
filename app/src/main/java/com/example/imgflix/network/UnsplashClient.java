package com.example.imgflix.network;

import static com.example.imgflix.Constants.UNSPLASH_API_KEY;
import static com.example.imgflix.Constants.UNSPLASH_BASE_URL;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class UnsplashClient {
    private  static Retrofit retrofit = null;
    public static UnsplashPhotosApi getClient(){
        if(retrofit==null){

            retrofit=new Retrofit.Builder()
                    .baseUrl(UNSPLASH_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(UnsplashPhotosApi.class);
    }
}
