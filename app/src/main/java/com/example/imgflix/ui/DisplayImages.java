package com.example.imgflix.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.imgflix.Constants;
import com.example.imgflix.adapters.MyAdapter;
import com.example.imgflix.R;
import com.example.imgflix.models.UnsplashPhotoListResponse;
import com.example.imgflix.models.Urls;
import com.example.imgflix.network.UnsplashClient;
import com.example.imgflix.network.UnsplashPhotosApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class DisplayImages extends AppCompatActivity {

 @SuppressLint("NonConstantResourceId")
 @BindView(R.id.recyclerView) RecyclerView recyclerView;
 private MyAdapter adapter;
 @SuppressLint("NonConstantResourceId")
 @BindView(R.id.errorTextView) TextView errorText;
 @SuppressLint("NonConstantResourceId")
 @BindView(R.id.progressBar) ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_images);
        ButterKnife.bind(this);
//        listView.setAdapter(new MyAdapter(this, names, images));

        UnsplashPhotosApi client = UnsplashClient.getClient();
        String clientId = Constants.UNSPLASH_API_KEY;
        Call<List<UnsplashPhotoListResponse>> call = client.getImages(clientId);
       call.enqueue(new Callback<List<UnsplashPhotoListResponse>>() {
           @Override
           public void onResponse(@NonNull Call<List<UnsplashPhotoListResponse>> call, Response<List<UnsplashPhotoListResponse>> response) {
               hideProgressBar();
               if(response.isSuccessful()){
                 List<UnsplashPhotoListResponse> images = response.body();
                 adapter = new MyAdapter(DisplayImages.this, images);
                 recyclerView.setAdapter(adapter);
                 RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(DisplayImages.this);
                 recyclerView.setLayoutManager(layoutManager);
                 recyclerView.setHasFixedSize(true);

                 showImagesContent();
               }else {
                   showUnSuccessfulMessage();
               }
           }

           @Override
           public void onFailure(Call<List<UnsplashPhotoListResponse>> call, Throwable t) {
               hideProgressBar();
               showFailureMessage();

           }
       });


    }
    @SuppressLint("SetTextI18n")
    private void showFailureMessage(){
        errorText.setText("Something went wrong. Please check your internet connection");
        errorText.setVisibility(View.VISIBLE);
    }
    @SuppressLint("SetTextI18n")
    private void showUnSuccessfulMessage(){
        errorText.setText("Something went wrong. Please try again");
        errorText.setVisibility(View.VISIBLE);
    }
    public void showImagesContent(){
        recyclerView.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar(){
        progressBar.setVisibility(View.GONE);

    }
}