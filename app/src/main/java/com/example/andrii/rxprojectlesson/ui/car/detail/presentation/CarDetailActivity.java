package com.example.andrii.rxprojectlesson.ui.car.detail.presentation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.ToolbarActivity;
import com.example.andrii.rxprojectlesson.core.converter.PriceConverter;
import com.example.andrii.rxprojectlesson.core.image.ImageLoader;
import com.example.andrii.rxprojectlesson.core.permission.PermissionChecker;
import com.example.andrii.rxprojectlesson.ui.car.detail.viewmodel.CarDetailViewModel;
import com.example.andrii.rxprojectlesson.ui.map.presentation.MapActivity;
import com.example.andrii.rxprojectlesson.ui.map.viewmodel.CarDetailMapViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class CarDetailActivity
        extends ToolbarActivity<CarDetailContract.View, CarDetailContract.Presenter>
        implements CarDetailContract.View {

    private static final String CAR_ID_KEY = "car_id_key";

    public static void start(Context context, Integer idCar) {
        Intent intent = new Intent(context, CarDetailActivity.class);
        intent.putExtra(CAR_ID_KEY, idCar);
        context.startActivity(intent);
    }

    private MaterialDialog callDialog;

    @Inject
    protected PermissionChecker permissionChecker;

    @Inject
    protected PriceConverter priceConverter;

    @Inject
    protected ImageLoader imageLoader;

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
        callDialog.show();
    }

    @OnClick(R.id.location_click)
    void localizationClick() {
        presenter.onLocalizationClick();
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

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
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
        cm3.setText(String.format("%d cm3", carViewModel.getCm3()));
        localizeDescription.setText(carViewModel.getLocalization());
        description.setText(carViewModel.getDescription());
        locationText.setText(carViewModel.getLocalization());
    }

    @Override
    public void showSkeleton() {
        showSkeletonView(container, R.layout.car_detail_activity_skeleton);
    }

    @Override
    public void openMapScreen(CarDetailMapViewModel carViewModel) {
        MapActivity.start(this, carViewModel);
    }

    @Override
    public boolean hasCallPhonePermission() {
        return permissionChecker.hasPermission();
    }

    @SuppressLint("MissingPermission")
    @Override
    public void callPhoneNumber(String phoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        Uri uri = Uri.fromParts("tel", phoneNumber, null);
        callIntent.setData(uri);
        startActivity(callIntent);
    }

    @Override
    public void requestCallPhonePermission() {
        permissionChecker.requestPermission();
    }

    @Override
    public void prepareDialog(String phoneNumber) {
        callDialog = new MaterialDialog.Builder(this)
                .customView(R.layout.call_dialog,false)
                .autoDismiss(false)
                .build();

        if (callDialog.getWindow() != null) {
            callDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        View dialogCustomView = callDialog.getCustomView();
        if (dialogCustomView == null) {
            return;
        }

        Button positiveButton = dialogCustomView.findViewById(R.id.call_button);
        Button negativeButton = dialogCustomView.findViewById(R.id.cancel_button);
        TextView phone = dialogCustomView.findViewById(R.id.phone_number);

        phone.setText(phoneNumber);

        positiveButton.setOnClickListener(v -> {
            presenter.onCallButtonClick(phoneNumber);
            callDialog.dismiss();
        });

        negativeButton.setOnClickListener(v -> callDialog.dismiss());
    }

    @Override
    public boolean isArrowBackWhite() {
        return true;
    }

    @Override
    public boolean isStarVisibility() {
        return true;
    }

    @Override
    public boolean isToolbarTransparent() {
        return true;
    }
}
