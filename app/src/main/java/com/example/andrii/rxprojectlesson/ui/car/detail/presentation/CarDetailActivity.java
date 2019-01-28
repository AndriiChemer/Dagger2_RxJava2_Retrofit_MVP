package com.example.andrii.rxprojectlesson.ui.car.detail.presentation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.BaseActivity;
import com.example.andrii.rxprojectlesson.core.image.GlideUrlImageLoader;
import com.example.andrii.rxprojectlesson.ui.car.converter.PriceConverter;
import com.example.andrii.rxprojectlesson.ui.car.detail.viewmodel.CarDetailViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class CarDetailActivity
        extends BaseActivity<CarDetailContract.View, CarDetailContract.Presenter>
        implements CarDetailContract.View {

    private static final String CAR_ID_KEY = "car_id_key";

    public static void start(Context context, Integer idCar) {
        Intent intent = new Intent(context, CarDetailActivity.class);
        intent.putExtra(CAR_ID_KEY, idCar);
        context.startActivity(intent);
    }

    @Inject
    protected PriceConverter priceConverter;

    @Inject
    GlideUrlImageLoader imageLoader;

    @BindView(R.id.container)
    View container;

    @BindView(R.id.image)
    ImageView image;

    @BindView(R.id.brand_model_name)
    TextView brandModelName;

    @BindView(R.id.localization)
    TextView localization;

    @BindView(R.id.price)
    TextView price;

    @BindView(R.id.type)
    TextView type;

    @BindView(R.id.brand)
    TextView brand;

    @BindView(R.id.model)
    TextView model;

    @BindView(R.id.fuel)
    TextView fuel;

    @BindView(R.id.cm3)
    TextView cm3;

    @BindView(R.id.localize)
    TextView localizeDescription;

    @BindView(R.id.description)
    TextView description;

    @BindView(R.id.location_text)
    TextView locationText;

    @OnClick(R.id.show_number)
    void showNumberButtonClick() {
        showNoImplementedFeatureMessage();
    }

    @OnClick(R.id.location_click)
    void localizationClick() {
        showNoImplementedFeatureMessage();
    }

    @OnClick(R.id.violation)
    void violationClick() {
        showNoImplementedFeatureMessage();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.onCarDataSuccessfullyRetrieved(getIntegerFromExtra(CAR_ID_KEY));
    }

    @Override
    protected int getLayoutResourceID() {
        return R.layout.car_detail_activity;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showCarDetail(CarDetailViewModel carViewModel) {
        imageLoader.loadInto(carViewModel.getPhoto(), image);
        brandModelName.setText(carViewModel.getBrandModel());
        localization.setText(carViewModel.getLocalization());
        price.setText(priceConverter.convert(carViewModel.getPrice()));
        type.setText(carViewModel.getType());
        brand.setText(carViewModel.getBrand());
        model.setText(carViewModel.getModel());
        fuel.setText(carViewModel.getFuel());
        cm3.setText(carViewModel.getCm3() + " " + "cm3");
        localizeDescription.setText(carViewModel.getLocalization());
        description.setText(carViewModel.getDescription());
        locationText.setText(carViewModel.getLocalization());
    }

    @Override
    public void showSkeleton() {
        showSkeletonView(container, R.layout.car_detail_activity_skeleton);
    }
}
