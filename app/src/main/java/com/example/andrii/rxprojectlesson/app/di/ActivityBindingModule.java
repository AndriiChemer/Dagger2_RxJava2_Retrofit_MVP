package com.example.andrii.rxprojectlesson.app.di;

import com.example.andrii.rxprojectlesson.ui.car.account.authorization.presentation.di.LoginModule;
import com.example.andrii.rxprojectlesson.ui.car.account.registration.presentation.di.RegisterModule;
import com.example.andrii.rxprojectlesson.ui.car.detail.presentation.CarDetailActivity;
import com.example.andrii.rxprojectlesson.ui.car.detail.presentation.di.CarDetailModule;
import com.example.andrii.rxprojectlesson.ui.car.favourite.presentation.di.FavoriteModule;
import com.example.andrii.rxprojectlesson.ui.car.list.presentation.di.CarsModule;
import com.example.andrii.rxprojectlesson.ui.car.presentation.CarActivity;
import com.example.andrii.rxprojectlesson.ui.car.presentation.di.CarModule;
import com.example.andrii.rxprojectlesson.ui.main.MainActivity;
import com.example.andrii.rxprojectlesson.ui.main.di.MainModule;
import com.example.andrii.rxprojectlesson.ui.map.presentation.MapActivity;
import com.example.andrii.rxprojectlesson.ui.map.presentation.di.MapModule;
import com.example.andrii.rxprojectlesson.ui.registration.RegistrationActivity;
import com.example.andrii.rxprojectlesson.ui.registration.di.RegistrationModule;
import com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.caruselmanager.presentation.CreditCardCarouselActivity;
import com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.caruselmanager.presentation.di.CreditCardCarouselModule;
import com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.customlayoutmanager.presentation.CustomRecyclerActivity;
import com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.customlayoutmanager.presentation.di.CustomRecyclerModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = RegistrationModule.class)
    abstract RegistrationActivity bindRegistrationActivity();

    @ContributesAndroidInjector(modules = CarDetailModule.class)
    abstract CarDetailActivity bindCarsDetailActivity();

    @ContributesAndroidInjector(modules = CreditCardCarouselModule.class)
    abstract CreditCardCarouselActivity bindCreditCardCaruselActivity();

    @ContributesAndroidInjector(modules = MapModule.class)
    abstract MapActivity bindMapActivity();

    @ContributesAndroidInjector(modules = CustomRecyclerModule.class)
    abstract CustomRecyclerActivity bindCustomRecyclerActivity();

    @ContributesAndroidInjector(modules = {CarModule.class, FavoriteModule.class, CarsModule.class, LoginModule.class, RegisterModule.class})
    abstract CarActivity bindCarActivity();
}
