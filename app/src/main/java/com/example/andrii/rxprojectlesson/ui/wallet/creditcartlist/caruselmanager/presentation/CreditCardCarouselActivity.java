package com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.caruselmanager.presentation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;
import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.BaseActivity;
import com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.caruselmanager.model.Card;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class CreditCardCarouselActivity
        extends BaseActivity<CreditCardCarouselContract.View, CreditCardCarouselContract.Presenter>
        implements CreditCardCarouselContract.View {

    public static void start(Context context) {
        Intent intent = new Intent(context, CreditCardCarouselActivity.class);
        context.startActivity(intent);
    }

    @Inject
    CreditCardCarouselAdapter adapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.credit_card_carusel_activity;
    }

    @Override
    protected void prepareView() {
        prepareRecycler();
        initAdapter();
    }

    private void prepareRecycler() {
        CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.VERTICAL, false);
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        layoutManager.setMaxVisibleItems(2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnScrollListener(new CenterScrollListener());
        recyclerView.setAdapter(adapter);
    }

    private void initAdapter() {
        adapter.setItems(loadBankCardList());
    }

    private List<Card> loadBankCardList() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(R.drawable.bank_card, "Owner 1"));
        cards.add(new Card(R.drawable.bank_creditcard_gold, "Owner 2"));

        return cards;
    }
}
