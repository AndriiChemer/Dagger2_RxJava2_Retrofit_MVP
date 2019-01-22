package com.example.andrii.rxprojectlesson.ui.car.list.presentation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.core.image.GlideUrlImageLoader;
import com.example.andrii.rxprojectlesson.core.recyclerview.ClickableAdapter;
import com.example.andrii.rxprojectlesson.core.recyclerview.ViewHolder;
import com.example.andrii.rxprojectlesson.ui.car.list.domain.CarViewModel;

import javax.inject.Inject;

import butterknife.BindView;

public class CarsAdapter extends ClickableAdapter<CarViewModel, ViewHolder<CarViewModel>, CarsAdapter.CarItemCallback> {

    private final Context context;
    private final GlideUrlImageLoader imageLoader;

    @Inject
    public CarsAdapter(Context context, GlideUrlImageLoader imageLoader) {
        this.context = context;
        this.imageLoader = imageLoader;
    }

    @NonNull
    @Override
    public ViewHolder<CarViewModel> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.car_item, parent, false);
        return new CarViewHolder(view);
    }

    public class CarViewHolder extends ViewHolder<CarViewModel> {

        public static final int VIEW_TYPE = 0;

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
        @BindView(R.id.localization)
        TextView localization;

        CarViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void bind(CarViewModel car) {
            if (car.getPhoto() != null) {
                imageLoader.loadInto(car.getPhoto(), carImage);
            } else {
                carImage.setBackground(context.getResources().getDrawable(R.drawable.no_image));
            }

            price.setText(String.valueOf(car.getPrice()) + " " + "PLN");
            brandModelName.setText(car.getBrand() + " " + car.getModel());
            fuelType.setText(car.getFuel());
            localization.setText(car.getLocalization());
            container.setOnClickListener(v -> getListener().onClick(car.getId()));
        }
    }

    interface CarItemCallback {
        void onClick(int id);
    }
}
