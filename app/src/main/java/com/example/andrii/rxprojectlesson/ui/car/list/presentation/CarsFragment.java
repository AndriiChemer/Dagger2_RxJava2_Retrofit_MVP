package com.example.andrii.rxprojectlesson.ui.car.list.presentation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.ClickableFragment;
import com.example.andrii.rxprojectlesson.ui.car.detail.presentation.CarDetailActivity;
import com.example.andrii.rxprojectlesson.ui.car.list.presentation.adapters.CarGridLayoutAdapter;
import com.example.andrii.rxprojectlesson.ui.car.list.presentation.adapters.CarStaggeredGridLayoutAdapter;
import com.example.andrii.rxprojectlesson.ui.car.list.presentation.adapters.CarsLinearLayoutAdapter;
import com.example.andrii.rxprojectlesson.ui.car.list.viewmodel.CarViewModel;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class CarsFragment
        extends ClickableFragment<CarsContract.View, CarsContract.Presenter, CarsFragment.CarListClickListener>
        implements CarsContract.View {

    @Inject
    public CarsFragment() {
    }

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    protected CarsLinearLayoutAdapter linearAdapter;

    @Inject
    protected CarGridLayoutAdapter gridAdapter;

    @Inject
    protected CarStaggeredGridLayoutAdapter staggeredGridAdapter;

    @BindView(R.id.view_recycler_item)
    protected ImageView changeLayoutManagerButton;

    @OnClick(R.id.filter)
    void filterClick() {
        showNoImplementedFeatureMessage();
    }

    @OnClick(R.id.save_filter)
    void saveFilterClick() {
        showNoImplementedFeatureMessage();
    }

    @OnClick(R.id.arrow_back)
    void arrowBackClick() {
        presenter.onArrowBackClick();
    }

    @OnClick(R.id.view_recycler_item)
    void changeLayoutManagerClick() {
        if (isDrawableEqualsCurrent(R.drawable.ic_check_box_outline_blue_black_24dp)) {
            setRecyclerViewBackgroundButton(R.drawable.ic_border_all_blue_24dp);
            changeLayoutManager(gridAdapter, new GridLayoutManager(getContext(), 2));
        } else if (isDrawableEqualsCurrent(R.drawable.ic_border_all_blue_24dp)) {
            setRecyclerViewBackgroundButton(R.drawable.ic_drag_handle_blue_24dp);
            changeLayoutManager(staggeredGridAdapter, new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        } else if (isDrawableEqualsCurrent(R.drawable.ic_drag_handle_blue_24dp)) {
            setRecyclerViewBackgroundButton(R.drawable.ic_check_box_outline_blue_black_24dp);
            changeLayoutManager(linearAdapter, new LinearLayoutManager(getContext()));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cars_fragment, container, false);
    }

    @Override
    protected void prepareView() {
        prepareRecycler();
        changeLayoutManagerButton.setVisibility(View.VISIBLE);
    }

    private void prepareRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(linearAdapter);
    }

    @Override
    public void showCars(List<CarViewModel> listCars) {
        linearAdapter.setItems(listCars, new CarsLinearLayoutAdapter.CarItemCallback() {
            @Override
            public void onClick(int id) {
                presenter.onItemAdapterClick(id);
            }

            @Override
            public void onFavoriteClick(int carId, boolean isFavorite, int adapterPosition) {
                presenter.onFavoriteButtonClick(carId, isFavorite);
            }
        });

        gridAdapter.setItems(listCars, new CarsLinearLayoutAdapter.CarItemCallback() {
            @Override
            public void onClick(int id) {
                presenter.onItemAdapterClick(id);
            }

            @Override
            public void onFavoriteClick(int carId, boolean isFavorite, int adapterPosition) {
                presenter.onFavoriteButtonClick(carId, isFavorite);
            }
        });

        staggeredGridAdapter.setItems(listCars, new CarsLinearLayoutAdapter.CarItemCallback() {
            @Override
            public void onClick(int id) {
                presenter.onItemAdapterClick(id);
            }

            @Override
            public void onFavoriteClick(int carId, boolean isFavorite, int adapterPosition) {
                presenter.onFavoriteButtonClick(carId, isFavorite);
            }
        });
    }

    @Override
    public void openCarDetailScreen(int id) {
        CarDetailActivity.start(getContext(), id);
    }

    @Override
    public void hideRecyclerSkeletonView() {

    }

    @Override
    public void finishCurrentActivity() {
        listener.finishCurrentActivity();
    }

    @Override
    public void showPositiveFavoriteMessage(int stringRes) {
        //TODO show notification
        String message = Objects.requireNonNull(getContext()).getString(stringRes);
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNegativeFavoriteMessage() {
        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
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
        onChangeLayoutManagerButton(resDrawable);
    }

    private boolean isDrawableEqualsCurrent(int resDrawable) {
        return drawableEquals(Objects.requireNonNull(Objects.requireNonNull(getContext()).getDrawable(resDrawable)));
    }

    private void onChangeLayoutManagerButton(int resDrawable) {
        changeLayoutManagerButton.setBackground(Objects.requireNonNull(getContext()).getDrawable(resDrawable));
    }

    private boolean drawableEquals(Drawable drawable) {
        Drawable.ConstantState currentDrawable = changeLayoutManagerButton.getBackground().getConstantState();
        Drawable.ConstantState sameDrawable = drawable.getConstantState();
        return Objects.requireNonNull(currentDrawable).equals(sameDrawable);
    }

    public interface CarListClickListener {
        void finishCurrentActivity();
    }
}
