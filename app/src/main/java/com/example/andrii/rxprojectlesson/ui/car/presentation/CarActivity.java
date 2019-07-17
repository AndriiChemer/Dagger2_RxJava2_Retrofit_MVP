package com.example.andrii.rxprojectlesson.ui.car.presentation;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.BaseActivity;
import com.example.andrii.rxprojectlesson.app.base.ToolbarActivity;
import com.example.andrii.rxprojectlesson.ui.car.account.authorization.presentation.LoginFragment;
import com.example.andrii.rxprojectlesson.ui.car.favourite.presentation.FavoriteFragment;
import com.example.andrii.rxprojectlesson.ui.car.list.presentation.CarsFragment;
import com.example.andrii.rxprojectlesson.ui.car.list.viewmodel.CarViewModel;
import com.facebook.AccessToken;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class CarActivity
        extends BaseActivity<CarContract.View, CarContract.Presenter>
        implements CarContract.View, BottomNavigationView.OnNavigationItemSelectedListener,
        CarsFragment.CarListClickListener, FavoriteFragment.FavoriteClickListener {

    public static void start(Context context) {
        Intent intent = new Intent(context, CarActivity.class);
        context.startActivity(intent);
    }

    @Inject
    CarsFragment carsFragment;
    @Inject
    LoginFragment loginFragment;
    @Inject
    FavoriteFragment favoriteFragment;

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.car_activity;
    }

    @Override
    protected void prepareView() {
        loadFragment(carsFragment);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                return loadFragment(carsFragment);
            case R.id.navigation_favorite:
                return loadFragment(favoriteFragment);
            case R.id.navigation_notifications:
                if (isUserAuthorized()) {
                    return loadFragment(favoriteFragment);
                } else {
                    return loadFragment(loginFragment);
                }
        }
        return false;
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();

            return true;
        }
        return false;
    }

    private boolean isUserAuthorized() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();

        return accessToken != null;
    }

    @Override
    public void showCars(List<CarViewModel> carViewModels) {
        carsFragment.showCars(carViewModels);
    }

    @Override
    public void finishCurrentActivity() {
        finish();
    }
}
