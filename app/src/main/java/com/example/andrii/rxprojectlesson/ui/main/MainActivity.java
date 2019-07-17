package com.example.andrii.rxprojectlesson.ui.main;

import com.example.andrii.rxprojectlesson.R;
import com.example.andrii.rxprojectlesson.app.base.BaseActivity;
import com.example.andrii.rxprojectlesson.ui.car.presentation.CarActivity;
import com.example.andrii.rxprojectlesson.ui.registration.RegistrationActivity;
import com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.caruselmanager.presentation.CreditCardCarouselActivity;
import com.example.andrii.rxprojectlesson.ui.wallet.creditcartlist.customlayoutmanager.presentation.CustomRecyclerActivity;

import butterknife.OnClick;

public class MainActivity
        extends BaseActivity<MainContract.View, MainContract.Presenter>
        implements MainContract.View {

    @OnClick(R.id.registration_rx_validation)
    public void registrationRxValidationClick(){
        presenter.onRegistrationRxValidationButtonClick();
    }

    @OnClick(R.id.car_list_button)
    public void carListClick() {
        presenter.onCarListButtonClick();
    }

    @OnClick(R.id.show_credit_cards_button)
    public void onShowCreditCardsClick() {
        presenter.onShowCreditCardsClick();
    }

    @OnClick(R.id.show_custom_recycler_credit_cards_button)
    public void onShowCustomRecyclerCreditCardsClick() {
        presenter.onShowCustomRecyclerCreditCardsClick();
    }

    @Override
    protected int getLayoutResourceID() {
        return R.layout.activity_main;
    }

    @Override
    public void openRegistrationScreen() {
        RegistrationActivity.start(this);
    }

    @Override
    public void openCarListScreen() {
        CarActivity.start(this);
    }

    @Override
    public void openCreditCardsListScreen() {
        CreditCardCarouselActivity.start(this);
    }

    @Override
    public void openCustomRecyclerScreen() {
        CustomRecyclerActivity.start(this);
    }
}
