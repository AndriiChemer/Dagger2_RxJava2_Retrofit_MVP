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
import com.example.andrii.rxprojectlesson.core.recyclerview.ListItem;
import com.example.andrii.rxprojectlesson.core.recyclerview.ViewHolder;
import com.example.andrii.rxprojectlesson.core.converter.PriceConverter;
import com.example.andrii.rxprojectlesson.ui.car.list.viewmodel.CarHeaderViewModel;
import com.example.andrii.rxprojectlesson.ui.car.list.viewmodel.CarViewModel;

import javax.inject.Inject;

import butterknife.BindView;

public class CarsAdapter extends ClickableAdapter<ListItem, ViewHolder<ListItem>, CarsAdapter.CarItemCallback> {

    private final Context context;
    private final PriceConverter priceConverter;
    private final GlideUrlImageLoader imageLoader;

    @Inject
    public CarsAdapter(Context context, PriceConverter priceConverter, GlideUrlImageLoader imageLoader) {
        this.context = context;
        this.priceConverter = priceConverter;
        this.imageLoader = imageLoader;
    }

    @NonNull
    @Override
    public ViewHolder<ListItem> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        if (viewType == CarViewHolder.VIEW_TYPE) {
            View view = inflater.inflate(R.layout.car_item, parent, false);
            return new CarViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.car_item_header, parent, false);
            return new HeaderViewHolder(view);
        }
    }

    public class HeaderViewHolder extends ViewHolder<ListItem> {

        public static final int HEADER_VIEW_TYPE = 1;

        @BindView(R.id.save_filter)
        TextView saveFilter;
        @BindView(R.id.filter)
        TextView filter;

        HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(ListItem carInterface) {
            saveFilter.setOnClickListener(v -> getListener().saveFilterClick());
            filter.setOnClickListener(v -> getListener().filterClick());
        }
    }

    public class CarViewHolder extends ViewHolder<ListItem> {

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
        public void bind(ListItem carInterface) {
            CarViewModel car = (CarViewModel) carInterface;

            if (car.getPhoto() != null) {
                imageLoader.loadInto(car.getPhoto(), carImage);
            } else {
                carImage.setBackground(context.getResources().getDrawable(R.drawable.no_image));
            }

            price.setText(priceConverter.convert(car.getPrice()));
            brandModelName.setText(car.getBrand() + " " + car.getModel());
            fuelType.setText(car.getFuel());
            localization.setText(car.getLocalization());
            container.setOnClickListener(v -> getListener().onClick(car.getId()));
        }
    }

    interface CarItemCallback {
        void onClick(int id);
        void saveFilterClick();
        void filterClick();
    }
}
