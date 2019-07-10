package com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.caruselmanager.presentation.di;


import com.example.andrii.rxprojectlesson.core.image.ImageLoader;
import com.example.andrii.rxprojectlesson.core.image.ResourceImageLoader;
import com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.caruselmanager.presentation.CreditCardCarouselContract;
import com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.caruselmanager.presentation.CreditCardCarouselPresenter;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class CreditCardCarouselModule {
    @Binds
    abstract CreditCardCarouselContract.Presenter providePresenter(CreditCardCarouselPresenter presenter);

    @Binds
    @Named("ResourceImageLoader")
    abstract ImageLoader provideImageLoader(ResourceImageLoader imageLoader);
}
