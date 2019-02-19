package com.example.andrii.rxprojectlesson.ui.car.list.presentation;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.ToolbarActivity;
import com.example.andrii.rxprojectlesson.ui.car.detail.presentation.CarDetailActivity;
import com.example.andrii.rxprojectlesson.ui.car.list.viewmodel.CarViewModel;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.andrii.rxprojectlesson.ui.car.list.presentation.CarsLinearLayoutAdapter.*;

public class CarsActivity extends ToolbarActivity<CarsContract.View, CarsContract.Presenter> implements CarsContract.View {

    public static void start(Context context) {
        Intent intent = new Intent(context, CarsActivity.class);
        context.startActivity(intent);
    }

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    protected CarsLinearLayoutAdapter linearAdapter;

    @Inject
    protected CarGridLayoutAdapter gridAdapter;

    @Inject
    protected CarStaggeredGridLayoutAdapter staggeredGridAdapter;

    @OnClick(R.id.filter)
    void filterClick() {
        showNoImplementedFeatureMessage();
    }

    @OnClick(R.id.save_filter)
    void saveFilterClick() {
        showNoImplementedFeatureMessage();
    }

    @OnClick(R.id.view_recycler_item)
    void changeLayoutManagerClick() {
        if (drawableEquelsCurrent(R.drawable.ic_check_box_outline_blue_black_24dp)) {
            setRecyclerViewBackgroundButton(R.drawable.ic_border_all_blue_24dp);
            changeLayoutManager(gridAdapter, new GridLayoutManager(this, 2));
        } else if (drawableEquelsCurrent(R.drawable.ic_border_all_blue_24dp)) {
            setRecyclerViewBackgroundButton(R.drawable.ic_drag_handle_blue_24dp);
            changeLayoutManager(staggeredGridAdapter, new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        } else if (drawableEquelsCurrent(R.drawable.ic_drag_handle_blue_24dp)) {
            setRecyclerViewBackgroundButton(R.drawable.ic_check_box_outline_blue_black_24dp);
            changeLayoutManager(linearAdapter, new LinearLayoutManager(this));
        }
    }

    @Override
    protected void prepareView() {
        prepareRecycler();
        showSkeletonView(recyclerView, linearAdapter, R.layout.car_item_skeleton);
    }

    private void prepareRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(linearAdapter);
    }

    @Override
    protected int getLayoutResourceID() {
        return R.layout.cars_activity;
    }

    @Override
    public void showCars(List<CarViewModel> listCars) {
        linearAdapter.setItems(listCars, presenter::onItemAdapterClick);
        gridAdapter.setItems(listCars, presenter::onItemAdapterClick);
        staggeredGridAdapter.setItems(listCars, presenter::onItemAdapterClick);
    }

    @Override
    public void openCarDetailScreen(int id) {
        CarDetailActivity.start(this, id);
    }

    @Override
    public boolean isViewRecyclerItemVisibility() {
        return true;
    }

    private void changeLayoutManager(RecyclerView.Adapter adapter,  RecyclerView.LayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.recycler_view_animation);

        recyclerView.setLayoutAnimation(controller);
        Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    private void setRecyclerViewBackgroundButton(int resDrawable) {
        changeLayoutManagerButton.setBackground(getDrawable(resDrawable));
    }

    private boolean drawableEquelsCurrent(int resDrawable) {
        return drawableEquals(Objects.requireNonNull(getDrawable(resDrawable)));
    }
}
