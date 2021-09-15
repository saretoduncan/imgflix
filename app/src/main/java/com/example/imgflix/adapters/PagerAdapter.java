package com.example.imgflix.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.imgflix.models.UnsplashPhotoListResponse;
import com.example.imgflix.ui.imageDetailsFragment;

import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {
    private List<UnsplashPhotoListResponse> images;
    public PagerAdapter(@NonNull FragmentManager fm, int behavior, List<UnsplashPhotoListResponse> images) {
        super(fm,behavior);
        this.images=images;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return imageDetailsFragment.newInstance(images.get(position));
    }

    @Override
    public int getCount() {
        return images.size();
    }
}
