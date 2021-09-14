package com.example.imgflix.adapters;

import android.annotation.SuppressLint;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imgflix.R;
import com.example.imgflix.models.UnsplashPhotoListResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder> {
 private List<UnsplashPhotoListResponse> imgDetails;
 private Context mContext;
 public MyAdapter(Context context, List<UnsplashPhotoListResponse> imgDetails){
     this.mContext=context;
     this.imgDetails=imgDetails;
 }


    @NonNull
    @Override
    public MyAdapter.MyAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new MyAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyAdapterViewHolder holder, int position) {
        holder.bindImages(imgDetails.get(position));
    }

    @Override
    public int getItemCount() {
        return imgDetails.size() ;
    }
    public class MyAdapterViewHolder extends RecyclerView.ViewHolder{
      @BindView(R.id.imImageView) ImageView imageView;
      @SuppressLint("NonConstantResourceId")
      @BindView(R.id.tvImgTxt) TextView textView;
       private Context context;
       public MyAdapterViewHolder(View view){
           super(view);
           ButterKnife.bind(this, view);
           context= view.getContext();
       }
       public void bindImages(UnsplashPhotoListResponse img){
           Picasso.get().load(img.getUrls().getRegular()).into(imageView);
           textView.setText(img.getUser().getName());
       }
    }
}
