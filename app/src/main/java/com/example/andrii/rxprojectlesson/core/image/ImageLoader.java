package com.example.andrii.rxprojectlesson.core.image;

import android.widget.ImageView;

public interface ImageLoader {

    void loadInto(String imageUrl, ImageView imageView);
}
