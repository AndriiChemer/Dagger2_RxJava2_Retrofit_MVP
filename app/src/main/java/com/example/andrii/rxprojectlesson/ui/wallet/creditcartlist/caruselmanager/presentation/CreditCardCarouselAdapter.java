package com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.caruselmanager.presentation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.core.image.ImageLoader;
import com.example.andrii.rxprojectlesson.core.recyclerview.BaseAdapter;
import com.example.andrii.rxprojectlesson.core.recyclerview.ViewHolder;
import com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.caruselmanager.model.Card;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;

public class CreditCardCarouselAdapter
        extends BaseAdapter<Card, CreditCardCarouselAdapter.CardViewHolder> {

    private ImageLoader imageLoader;

    @Inject
    public CreditCardCarouselAdapter(@Named("ResourceImageLoader") ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.card_item, parent, false);
        return new CardViewHolder(view);
    }

    public class CardViewHolder extends ViewHolder<Card> {

        @BindView(R.id.cardImage)
        ImageView cardImage;

        CardViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bind(Card card, int adapterPosition) {
            imageLoader.loadInto(String.valueOf(card.getResImage()), cardImage);
        }
    }
}
