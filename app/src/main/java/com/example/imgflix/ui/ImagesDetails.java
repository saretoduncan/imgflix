package com.example.imgflix.ui;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.widget.Adapter;

import com.example.imgflix.R;
import com.example.imgflix.adapters.PagerAdapter;
import com.example.imgflix.models.UnsplashPhotoListResponse;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImagesDetails extends AppCompatActivity {
    List<UnsplashPhotoListResponse> images;
    private PagerAdapter pagerAdapter;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.viewPager) ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_details);
        ButterKnife.bind(this);
        images = Parcels.unwrap(getIntent().getParcelableExtra("images"));
        int startingPosition= getIntent().getIntExtra("position",0);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,images);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(startingPosition);

    }
}