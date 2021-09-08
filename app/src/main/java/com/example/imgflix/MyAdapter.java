package com.example.imgflix;

import android.annotation.SuppressLint;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    private Context context;

   private String[] names;
   private int[] imgId;
public MyAdapter(Context context, String[] name, int[] imgId){
    this.context=context;
    this.names= name;
    this.imgId=imgId;

}

    @Override
    public int getCount() {
        return imgId.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View cardView;
        if(view==null){
            cardView = inflater.inflate(R.layout.card,null);

          ImageView imageView = cardView.findViewById(R.id.imImageView);
          imageView.setImageResource(imgId[position]);
            TextView textView = cardView.findViewById(R.id.tvImgTxt);
            textView.setText(names[position]);

        }else{
            cardView= (View) view;
        }

        return cardView;
    }


}
