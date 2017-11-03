package com.tobidaada.fiatconverter.ui.main;

/**
 * Created by TOBI DAADA on 11/2/2017.
 */

public class MainPresenter implements MainMvpContract.Presenter {

    private MainMvpContract.View viewContract;

    public MainPresenter(MainMvpContract.View viewContract) {
        this.viewContract = viewContract;
    }


}
