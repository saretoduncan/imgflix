package com.example.imgflix.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imgflix.Constants;
import com.example.imgflix.R;
import com.example.imgflix.models.UnsplashPhotoListResponse;
import com.example.imgflix.ui.ImagesDetails;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FirebaseImagesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View view;
    Context mContext;
    public FirebaseImagesViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
        mContext= itemView.getContext();
        itemView.setOnClickListener(this);
    }
    public void bindImages(UnsplashPhotoListResponse images){
        ImageView fullImg = (ImageView) view.findViewById(R.id.imImageView);
        CircleImageView profilePic = (CircleImageView)  view.findViewById(R.id.cardProfilePic);
        TextView profileName = (TextView) view.findViewById(R.id.tvImgTxt);
        Picasso.get().load(images.getUser().getProfileImage().getMedium()).into(profilePic);
        Picasso.get().load(images.getUrls().getRegular()).into(fullImg);
        profileName.setText(images.getUser().getName());
    }

    @Override
    public void onClick(View view) {
        final ArrayList<UnsplashPhotoListResponse> imagesDetailsList = new ArrayList<>();
        DatabaseReference imageDetailsRef= FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_IMAGES);
        imageDetailsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    imagesDetailsList.add(dataSnapshot.getValue(UnsplashPhotoListResponse.class));
                    int itemPosition = getLayoutPosition();
                    Intent intent = new Intent(mContext, ImagesDetails.class);
                    intent.putExtra("position", itemPosition+"");
                    intent.putExtra("images", Parcels.wrap(imagesDetailsList));
                    mContext.startActivity(intent);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
