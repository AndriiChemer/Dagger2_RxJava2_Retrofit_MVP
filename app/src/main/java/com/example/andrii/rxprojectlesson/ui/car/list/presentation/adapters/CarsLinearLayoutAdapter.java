package com.example.andrii.rxprojectlesson.ui.car.list.presentation.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.core.converter.PriceConverter;
import com.example.andrii.rxprojectlesson.core.image.ImageLoader;
import com.example.andrii.rxprojectlesson.core.recyclerview.ClickableAdapter;
import com.example.andrii.rxprojectlesson.core.recyclerview.ViewHolder;
import com.example.andrii.rxprojectlesson.ui.car.list.viewmodel.CarViewModel;

import javax.inject.Inject;

import butterknife.BindView;

public class CarsLinearLayoutAdapter extends ClickableAdapter<CarViewModel, ViewHolder<CarViewModel>, CarsLinearLayoutAdapter.CarItemCallback> {

    private final Context context;
    private final PriceConverter priceConverter;
    private final ImageLoader imageLoader;

    @Inject
    public CarsLinearLayoutAdapter(Context context, PriceConverter priceConverter, ImageLoader imageLoader) {
        this.context = context;
        this.priceConverter = priceConverter;
        this.imageLoader = imageLoader;
    }

    @NonNull
    @Override
    public ViewHolder<CarViewModel> onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.car_linear_manager_item, parent, false);
        return new CarViewHolder(view);
    }

    public class CarViewHolder extends ViewHolder<CarViewModel> {

        public static final int VIEW_TYPE = 0;

        @BindView(R.id.featured_container)
        RelativeLayout featuredContainer;
        @BindView(R.id.favorite_button)
        ImageView favoriteButton;
        @BindView(R.id.card_item_container)
        LinearLayout container;
        @BindView(R.id.image)
        ImageView carImage;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.brand_model_name)
        TextView brandModelName;
        @BindView(R.id.fuel_image)
        ImageView fuelImage;
        @BindView(R.id.fuel_type)
        TextView fuelType;
        @BindView(R.id.localization)
        TextView localization;

        CarViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void bind(CarViewModel car, int adapterPosition) {
            if (!lastPosition) {
                container.setLayoutParams(getLayoutParams());
            }

            if (car.getPhoto() != null) {
                imageLoader.loadInto(car.getPhoto(), carImage);
            } else {
                carImage.setBackground(context.getResources().getDrawable(R.drawable.no_image));
            }

            if (car.isFeatured()) featuredContainer.setVisibility(View.VISIBLE);

            price.setText(priceConverter.convert(car.getPrice()));
            brandModelName.setText(car.getBrand() + " " + car.getModel());
            fuelType.setText(car.getFuel());
            localization.setText(car.getLocalization());
            container.setOnClickListener(v -> getListener().onClick(car.getId()));
            favoriteButton.setOnClickListener(v -> {
                boolean isFavorite = changeFavoriteButton(car.isFavorite(), favoriteButton);
                car.setFavorite(isFavorite);
                getListener().onFavoriteClick(car.getId(), car.isFavorite(), adapterPosition);
            });
        }

        private RecyclerView.LayoutParams getLayoutParams() {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) container.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 20);

            return layoutParams;
        }
    }


    private boolean changeFavoriteButton(boolean isFavorite, ImageView favoriteButton) {
        if (isFavorite) {
            favoriteButton.setImageResource(R.drawable.ic_star_border_white_40dp);
            return false;
        } else {
            favoriteButton.setImageResource(R.drawable.ic_star_white_40dp);
            return true;
        }
    }

    public interface CarItemCallback {
        void onClick(int id);

        void onFavoriteClick(int id, boolean isFavorite, int adapterPosition);
    }
}
