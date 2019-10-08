package com.example.andrii.rxprojectlesson.ui.main;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

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

    @OnClick(R.id.flow_1)
    public void onFlow_1() {
        showCustomDialog(this, "Update found", "Do you want to download and install latest update?", true, false);
    }

    @OnClick(R.id.flow_2)
    public void onFlow_2() {
        showCustomDialog(this, "Update found", "Do you want to install update from local drive?", true, true);
    }

    @OnClick(R.id.flow_3)
    public void onFlow_3() {
        showCustomDialog(this, "Update error", "Invalid update package", false, false);
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

    private void showCustomDialog(final Context mContext, String title, String message, final Boolean showCancel, final Boolean isLocal) {

        View content = View.inflate(mContext, R.layout.notify_dialog, null);

        if (!showCancel) content.findViewById(R.id.button_cancel).setVisibility(View.GONE);

        ((TextView) content.findViewById(R.id.button_ok)).setText(mContext.getString(android.R.string.ok));

        ((TextView) content.findViewById(R.id.notify)).setText(message);
        content.findViewById(R.id.description).setVisibility(View.GONE);


        final AlertDialog alertDialog = new AlertDialog.Builder(mContext, R.style.myDialogStyle)
                .setTitle(title)
                .setView(content)
                .setCancelable(false)
                .create();

        content.findViewById(R.id.button_ok).setOnClickListener(v -> {
            alertDialog.dismiss();
            if (showCancel) {
                Toast.makeText(this, "Dismiss clicked", Toast.LENGTH_SHORT).show();
            } else if (isLocal) {
                Toast.makeText(this, "Dismiss clicked", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Dismiss clicked", Toast.LENGTH_SHORT).show();
            }
        });

        content.findViewById(R.id.button_cancel).setOnClickListener(v -> {
            alertDialog.dismiss();
            Toast.makeText(this, "Cancel clicked", Toast.LENGTH_SHORT).show();
        });

        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }

}
