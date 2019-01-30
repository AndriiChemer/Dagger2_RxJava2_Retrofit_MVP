package com.example.andrii.rxprojectlesson.ui.car.list.presentation;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.BaseActivity;
import com.example.andrii.rxprojectlesson.app.base.ToolbarActivity;
import com.example.andrii.rxprojectlesson.core.recyclerview.ListItem;
import com.example.andrii.rxprojectlesson.ui.car.detail.presentation.CarDetailActivity;
import com.example.andrii.rxprojectlesson.ui.car.list.viewmodel.CarHeaderViewModel;
import com.example.andrii.rxprojectlesson.ui.car.list.viewmodel.CarViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class CarsActivity extends ToolbarActivity<CarsContract.View, CarsContract.Presenter> implements CarsContract.View {

    public static void start(Context context) {
        Intent intent = new Intent(context, CarsActivity.class);
        context.startActivity(intent);
    }

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    protected CarsAdapter adapter;

    @Override
    protected void prepareView() {
        prepareRecycler();
        showSkeletonView(recyclerView, adapter, R.layout.car_item_skeleton);
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
        List<ListItem> listItems = new ArrayList<>();
        listItems.add(new CarHeaderViewModel());
        listItems.addAll(listCars);

        adapter.setItems(listItems, new CarsAdapter.CarItemCallback(){
            @Override
            public void onClick(int id) {
                presenter.onItemAdapterClick(id);
            }

            @Override
            public void saveFilterClick() {
                showNoImplementedFeatureMessage();
            }

            @Override
            public void filterClick() {
                showNoImplementedFeatureMessage();
            }
        });
    }

    @Override
    public void openCarDetailScreen(int id) {
        CarDetailActivity.start(this, id);
    }

    @Override
    public boolean isViewRecyclerItemVisibility() {
        return true;
    }
}
