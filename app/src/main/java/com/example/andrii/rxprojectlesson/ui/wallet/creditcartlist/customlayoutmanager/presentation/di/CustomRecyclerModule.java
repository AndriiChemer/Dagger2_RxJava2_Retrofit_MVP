package com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.customlayoutmanager.presentation.di;

import com.example.andrii.rxprojectlesson.core.image.ImageLoader;
import com.example.andrii.rxprojectlesson.core.image.ResourceImageLoader;
import com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.customlayoutmanager.presentation.CustomRecyclerContract;
import com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.customlayoutmanager.presentation.CustomRecyclerPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class CustomRecyclerModule {

    @Binds
    abstract CustomRecyclerContract.Presenter bindPresenter(CustomRecyclerPresenter presenter);

    @Binds
    abstract ImageLoader bindImageLoader(ResourceImageLoader imageLoader);
}
