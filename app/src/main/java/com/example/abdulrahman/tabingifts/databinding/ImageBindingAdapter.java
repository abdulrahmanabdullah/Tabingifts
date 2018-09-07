package com.example.abdulrahman.tabingifts.databinding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.example.abdulrahman.tabingifts.R;

public class ImageBindingAdapter {

    @BindingAdapter("imageUrl")
    public static void setImage(ImageView image , int imageUrl){
        Context context = image.getContext();
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);
        Glide.with(context).setDefaultRequestOptions(options)
                .load(imageUrl).into(image);
    }
    @BindingAdapter({"requestListener","imageResource"})
    public static void bindRequestListener(ImageView image , RequestListener listener , int imageListener){
        Context context = image.getContext();
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);
                // Glide
                Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(imageListener)
                        .listener(listener)
                        .into(image);
    }
}
