package com.example.andrii.rxprojectlesson.core.image;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

public class GlideUrlImageLoader {

    private final Context context;

    @Inject
    public GlideUrlImageLoader(Context context) {
        this.context = context;
    }

    public void loadInto(String imageUrl, ImageView imageView) {
        Glide.with(context)
                .load(imageUrl)
                .into(imageView);
    }
}
