package com.example.andrii.rxprojectlesson.ui.map.presentation;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.ToolbarActivity;
import com.example.andrii.rxprojectlesson.ui.map.viewmodel.CarDetailMapViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends ToolbarActivity<MapContract.View, MapContract.Presenter> implements MapContract.View, OnMapReadyCallback {

    private static final String CAR_DETAIL_MAP = "car_detail_map";

    public static void start(Context context, CarDetailMapViewModel carViewModel) {
        Intent intent = new Intent(context, MapActivity.class);
        intent.putExtra(CAR_DETAIL_MAP, carViewModel);
        context.startActivity(intent);
    }

    private GoogleMap googleMap;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.map_activity;
    }

    @Override
    protected void prepareView() {
        prepareGoogleMaps();
    }

    private void prepareGoogleMaps() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        map.setMyLocationEnabled(true);
        map.getUiSettings().setZoomGesturesEnabled(true);
        map.getUiSettings().setRotateGesturesEnabled(true);
        googleMap = map;

        addMarker(getVieModelFromExtra());
    }

    private void addMarker(CarDetailMapViewModel carViewModel) {
        LatLng latLng = new LatLng(carViewModel.getLat(), carViewModel.getLng());
        googleMap.addMarker(
                new MarkerOptions()
                        .position(latLng)
                        .title(carViewModel.getTitle()));
        animateCamera(latLng);
    }

    private void animateCamera(LatLng latLng) {
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f));
    }


    private CarDetailMapViewModel getVieModelFromExtra() {
        return getIntent().getParcelableExtra(CAR_DETAIL_MAP);
    }
}
