package com.example.andrii.rxprojectlesson.app.base;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.andrii.rxprojectlesson.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;

public abstract class ToolbarActivity<V extends BaseContract.View, P extends BaseContract.Presenter<V>>
        extends BaseActivity<V, P> {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.line)
    View line;

    @BindView(R.id.arrow_back)
    ImageView arrowBack;

    @BindView(R.id.view_recycler_item)
    ImageView changeLayoutManagerButton;

    @BindView(R.id.star_favourite)
    ImageView starFavourite;

    @OnClick(R.id.arrow_back)
    void arrowBackClick() {
        finish();
    }

    @OnClick(R.id.view_recycler_item)
    void changeLayoutManagerClick() {
        if (drawableEquals(Objects.requireNonNull(getDrawable(R.drawable.ic_check_box_outline_blue_black_24dp)))) {
            setRecyclerViewBackgroundButton(R.drawable.ic_border_all_blue_24dp);
            //TODO set Layout Manager
        } else if (drawableEquals(Objects.requireNonNull(getDrawable(R.drawable.ic_border_all_blue_24dp)))) {
            setRecyclerViewBackgroundButton(R.drawable.ic_drag_handle_blue_24dp);
            //TODO change
        } else if (drawableEquals(Objects.requireNonNull(getDrawable(R.drawable.ic_drag_handle_blue_24dp)))) {
            setRecyclerViewBackgroundButton(R.drawable.ic_check_box_outline_blue_black_24dp);
            //TODO change
        }
    }

    private void setRecyclerViewBackgroundButton(int resDrawable) {
        changeLayoutManagerButton.setBackground(getDrawable(resDrawable));
    }

    private boolean drawableEquals(Drawable drawable) {
        Drawable.ConstantState currentDrawable = changeLayoutManagerButton.getBackground().getConstantState();
        Drawable.ConstantState sameDrawable = drawable.getConstantState();
        return Objects.requireNonNull(currentDrawable).equals(sameDrawable);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isArrowBackWhite()) {
            arrowBack.setBackground(getDrawable(R.drawable.ic_keyboard_arrow_left_white_24dp));
        }

        if (isViewRecyclerItemVisibility()) {
            changeLayoutManagerButton.setVisibility(View.VISIBLE);
        }

        if (isStarVisibility()) {
            starFavourite.setVisibility(View.VISIBLE);
        }

        if (isToolbarTransparent()) {
            toolbar.setBackgroundColor(Color.TRANSPARENT);
            line.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    public boolean isArrowBackWhite() {
        return false;
    }

    public boolean isViewRecyclerItemVisibility() {
        return false;
    }

    public boolean isStarVisibility() {
        return false;
    }

    public boolean isToolbarTransparent() {
        return false;
    }

    public void isFavoriteClick(boolean isFavorite) {
        if (isFavorite) {
            starFavourite.setBackground(getDrawable(R.drawable.ic_star_white_40dp));
        } else {
            starFavourite.setBackground(getResources().getDrawable(R.drawable.ic_star_border_white_40dp));
        }
    }
}
