package com.example.imgflix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.imgflix.adapters.FirebaseImagesViewHolder;
import com.example.imgflix.adapters.MyAdapter;
import com.example.imgflix.models.UnsplashPhotoListResponse;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class savedImagesActivity extends AppCompatActivity {
    private DatabaseReference imageDetailsRef;
    private FirebaseRecyclerAdapter<UnsplashPhotoListResponse, FirebaseImagesViewHolder> firebaseAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MyAdapter adapter;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.errorTextView)
    TextView errorText;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_images);
        ButterKnife.bind(this);
        imageDetailsRef= FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_IMAGES);
        setUpFirebaseAdapter();
        hideProgressBar();
        showImageDetails();
    }
    private void setUpFirebaseAdapter() {// set up firebase
        FirebaseRecyclerOptions<UnsplashPhotoListResponse> options = //retrieve save imagedetails
                new FirebaseRecyclerOptions.Builder<UnsplashPhotoListResponse>()
                        .setQuery(imageDetailsRef, UnsplashPhotoListResponse.class)
                        .build();
        firebaseAdapter = new FirebaseRecyclerAdapter<UnsplashPhotoListResponse, FirebaseImagesViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseImagesViewHolder firebaseImagesViewHolder, int position, @NonNull UnsplashPhotoListResponse model) {
                firebaseImagesViewHolder.bindImages(model);//
            }

            @NonNull
            @Override
            public FirebaseImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_display_images, parent, false);//inflate correct layout for display
                return new FirebaseImagesViewHolder(mView);

            }
        };
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(firebaseAdapter);
    }
    @Override
    protected void onStart(){
        super.onStart();
        firebaseAdapter.startListening();
    }
    @Override
    protected  void onStop(){
        super.onStop();
        if(firebaseAdapter!= null){
            firebaseAdapter.stopListening();
        }
    }
    private void showImageDetails() {
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }


}