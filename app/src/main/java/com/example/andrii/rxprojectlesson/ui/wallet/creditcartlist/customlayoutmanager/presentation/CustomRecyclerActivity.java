package com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.customlayoutmanager.presentation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.BaseActivity;
import com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.customlayoutmanager.customlayoutmanagers.CustomLayoutManager;
import com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.customlayoutmanager.model.CardDetail;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class CustomRecyclerActivity
        extends BaseActivity<CustomRecyclerContract.View, CustomRecyclerContract.Presenter>
        implements CustomRecyclerContract.View {

    public static void start(Context context) {
        Intent intent = new Intent(context, CustomRecyclerActivity.class);
        context.startActivity(intent);
    }

    private final String LOREM_IPSUM = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer " +
            "took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, " +
            "but also the leap into electronic typesetting, remaining essentially unchanged.";

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    CustomRecyclerAdapter adapter;


    @Override
    protected int getLayoutResourceID() {
        return R.layout.custom_recycler_activity;
    }

    @Override
    protected void prepareView() {
        prepareRecycler();
        aetItemsAdapter();
    }

    private void prepareRecycler() {
        CustomLayoutManager layoutManager = new CustomLayoutManager();

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private void aetItemsAdapter() {
        adapter.setItems(loadCardDetails());
    }

    private List<CardDetail> loadCardDetails() {
        List<CardDetail> cardDetails = new ArrayList<>();
        cardDetails.add(new CardDetail(String.valueOf(R.drawable.bank_card), "Bank card 1", LOREM_IPSUM, "Footer short description 1."));
        cardDetails.add(new CardDetail(String.valueOf(R.drawable.bank_creditcard_gold), "Bank card 2", LOREM_IPSUM, "Footer short description 2."));

        return cardDetails;
    }
}
