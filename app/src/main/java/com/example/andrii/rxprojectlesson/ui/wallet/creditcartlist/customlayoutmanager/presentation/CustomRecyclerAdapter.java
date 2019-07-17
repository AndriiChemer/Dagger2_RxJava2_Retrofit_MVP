package com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.customlayoutmanager.presentation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.core.image.ImageLoader;
import com.example.andrii.rxprojectlesson.core.recyclerview.BaseAdapter;
import com.example.andrii.rxprojectlesson.core.recyclerview.ViewHolder;
import com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.customlayoutmanager.model.CardDetail;

import javax.inject.Inject;

import butterknife.BindView;

public class CustomRecyclerAdapter extends BaseAdapter<CardDetail, CustomRecyclerAdapter.CustomRecyclerViewHolder> {

    private final ImageLoader imageLoader;

    @Inject
    public CustomRecyclerAdapter(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    @NonNull
    @Override
    public CustomRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.card_detail_item, parent, false);
        return new CustomRecyclerViewHolder(view);
    }

    class CustomRecyclerViewHolder extends ViewHolder<CardDetail> {

        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.footer_description)
        TextView footerDescription;

        CustomRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(CardDetail cardDetail, int adapterPosition) {
            imageLoader.loadInto(cardDetail.getImage(), image);
            title.setText(cardDetail.getTitle());
            description.setText(cardDetail.getDescription());
            footerDescription.setText(cardDetail.getFooterDescription());
        }
    }
}
