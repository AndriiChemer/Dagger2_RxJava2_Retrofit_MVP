package com.example.andrii.rxprojectlesson.ui.car.list.presentation;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.BaseActivity;
import com.example.andrii.rxprojectlesson.core.skeleton.SkeletonView;
import com.example.andrii.rxprojectlesson.ui.car.list.domain.CarViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class CarsActivity extends BaseActivity<CarsContract.View, CarsContract.Presenter> implements CarsContract.View {

    public static void start(Context context) {
        Intent intent = new Intent(context, CarsActivity.class);
        context.startActivity(intent);
    }

    RecyclerViewSkeletonScreen recyclerViewSkeletonScreen;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    protected CarsAdapter adapter;

    @Override
    protected void prepareView() {
        prepareRecycler();
        prepareSkeleton();
    }

    private void prepareSkeleton() {
        recyclerViewSkeletonScreen = SkeletonView.showSkeleton(recyclerView, adapter, R.layout.car_item);
    }

    private void prepareRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected int getLayoutResourceID() {
        return R.layout.cars_activity;
    }

    @Override
    public void showCars(List<CarViewModel> listCars) {
        adapter.setItems(listCars, id -> presenter.onItemAdapterClick(id));
    }

    @Override
    public void openCarDetailScreen(int id) {
        showNoImplementedFeatureMessage();
    }

    @Override
    public void hideSkeleton() {
        recyclerViewSkeletonScreen.hide();
    }
}
