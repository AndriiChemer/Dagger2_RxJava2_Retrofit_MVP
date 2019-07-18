package com.example.andrii.rxprojectlesson.app.modules;

import com.example.andrii.rxprojectlesson.core.image.ImageLoader;
import com.example.andrii.rxprojectlesson.core.image.GlideUrlImageLoader;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ImageLoaderModule {

    @Binds
    abstract ImageLoader bindImageLoader(GlideUrlImageLoader imageLoader);
}
