package com.example.andrii.rxprojectlesson.core.image;

import android.content.Context;
import android.widget.ImageView;

import javax.inject.Inject;

public class ResourceImageLoader implements ImageLoader {

    private final Context context;

    @Inject
    public ResourceImageLoader(Context context) {
        this.context = context;
    }

    @Override
    public void loadInto(String imageUrl, ImageView imageView) {
        try {
            int resId = Integer.parseInt(imageUrl);

            imageView.setImageResource(resId);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Url must be a resource id string value", e);
        }
    }
}
