package com.example.andrii.rxprojectlesson.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.example.andrii.rxprojectlesson.R;

import butterknife.BindView;
import butterknife.OnClick;

public abstract class ToolbarActivity<V extends BaseContract.View, P extends BaseContract.Presenter<V>>
        extends BaseActivity<V, P> {

    @BindView(R.id.arrow_back)
    ImageView arrowBack;

    @BindView(R.id.view_item)
    ImageView viewRecyclerItem;

    @BindView(R.id.star_favourite)
    ImageView starFavourite;

    @OnClick(R.id.arrow_back)
    void arrowBackClick() {
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isArrowBackWhite()) {
            arrowBack.setBackground(getDrawable(R.drawable.ic_keyboard_arrow_left_white_24dp));
        }

        if (isViewRecyclerItemVisibility()) {
            viewRecyclerItem.setVisibility(View.VISIBLE);
        }

        if (isStarVisibility()) {
            starFavourite.setVisibility(View.VISIBLE);
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

    public void isFavoriteClick(boolean isFavorite) {
        if (isFavorite) {
            starFavourite.setBackground(getDrawable(R.drawable.ic_star_white_40dp));
        } else {
            starFavourite.setBackground(getResources().getDrawable(R.drawable.ic_star_border_white_40dp));
        }
    }
}
