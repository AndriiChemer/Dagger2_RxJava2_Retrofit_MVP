package com.example.andrii.rxprojectlesson.ui.car.list.presentation.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public class CarGridLayoutAdapter extends ClickableAdapter<CarViewModel, ViewHolder<CarViewModel>, CarsLinearLayoutAdapter.CarItemCallback> {

    private final Context context;
    private final PriceConverter priceConverter;
    private final ImageLoader imageLoader;

    @Inject
    public CarGridLayoutAdapter(Context context, PriceConverter priceConverter, ImageLoader imageLoader) {
        this.context = context;
        this.priceConverter = priceConverter;
        this.imageLoader = imageLoader;
    }

    @NonNull
    @Override
    public ViewHolder<CarViewModel> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.car_grid_manager_item, parent, false);
        return new CarViewHolder(view);
    }

    public class CarViewHolder extends ViewHolder<CarViewModel> {

        @BindView(R.id.featured_container)
        RelativeLayout featuredContainer;
        @BindView(R.id.card_item_container)
        CardView container;
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
        @BindView(R.id.year)
        TextView year;

        CarViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void bind(CarViewModel car, int adapterPosition) {

            if (car.getPhoto() != null) {
                imageLoader.loadInto(car.getPhoto(), carImage);
            } else {
                carImage.setBackground(context.getResources().getDrawable(R.drawable.no_image));
            }

            if (car.isFeatured()) featuredContainer.setVisibility(View.VISIBLE);

            price.setText(priceConverter.convert(car.getPrice()));
            brandModelName.setText(car.getBrand() + " " + car.getModel());
            fuelType.setText(car.getFuel());
            container.setOnClickListener(v -> getListener().onClick(car.getId()));
        }
    }
}
