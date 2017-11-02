package com.tobidaada.fiatconverter.ui.conversion;

import java.util.Locale;

/**
 * Created by TOBI DAADA on 11/2/2017.
 */

public class ConversionPresenter implements ConversionMvpContract.Presenter {

    private ConversionMvpContract.View contractView;

    public ConversionPresenter(ConversionMvpContract.View contractView) {
        this.contractView = contractView;
    }


    @Override
    public void convertCurrency(String currencyConversion, String userInput) {

        double currencyConversionDouble = Double.parseDouble(currencyConversion);
        double userInputDouble = Double.parseDouble(userInput);

        double amount = userInputDouble / currencyConversionDouble;

        contractView.showConversion(String.format(Locale.getDefault(), "%,.5f", amount));
    }
}
