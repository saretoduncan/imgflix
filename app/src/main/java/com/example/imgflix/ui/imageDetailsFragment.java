package com.example.imgflix.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imgflix.R;
import com.example.imgflix.models.UnsplashPhotoListResponse;
import com.example.imgflix.network.UnsplashPhotosApi;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;
import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link imageDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class imageDetailsFragment extends Fragment {
private UnsplashPhotoListResponse images;

@SuppressLint("NonConstantResourceId")
@BindView(R.id.frImageView) ImageView imageView;
@SuppressLint("NonConstantResourceId")
@BindView(R.id.ProfilePic)
    CircleImageView profilePic;
@SuppressLint("NonConstantResourceId")
@BindView(R.id.tvFragProf)
    TextView userName;
@BindView(R.id.viewsNumbers) TextView likes;

@BindView(R.id.share) TextView share;
@SuppressLint("NonConstantResourceId")
@BindView(R.id.insta) TextView instaName;


    public imageDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     */

    public static imageDetailsFragment newInstance(UnsplashPhotoListResponse img) {
        imageDetailsFragment fragment = new imageDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable("imageDetail", Parcels.wrap(img));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            images= Parcels.unwrap(getArguments().getParcelable("imageDetail"));
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_image_details, container, false);
        ButterKnife.bind(this,view);
        Picasso.get().load(images.getUrls().getRegular()).into(imageView);
        Picasso.get().load(images.getUser().getProfileImage().getMedium()).into(profilePic);
        userName.setText(images.getUser().getName());
        instaName.setText("@"+images.getUser().getInstagramUsername());

        likes.setText(images.getLikes().toString());
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }
        });
        return view;
    }
}