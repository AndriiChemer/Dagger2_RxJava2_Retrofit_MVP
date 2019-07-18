package com.example.andrii.rxprojectlesson.core.image;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.andrii.rxprojectlesson.R;

import javax.inject.Inject;

public class GlideUrlImageLoader implements ImageLoader {

    private final Context context;

    @Inject
    public GlideUrlImageLoader(Context context) {
        this.context = context;
    }

    @Override
    public void loadInto(String imageUrl, ImageView imageView) {
        Glide.with(context)
                .load(imageUrl)
                .apply(new RequestOptions().placeholder(R.drawable.no_image).error(R.drawable.no_image))
                .into(imageView);
    }
}
