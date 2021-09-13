package com.example.imgflix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import com.example.imgflix.adapters.MyAdapter;
import com.example.imgflix.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisplayImages extends AppCompatActivity {
    private String[] names = {"Image1", "image2", "image3"};
    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.lvListView) ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_images);
        ButterKnife.bind(this);
        listView.setAdapter(new MyAdapter(this, names, images));

    }
}