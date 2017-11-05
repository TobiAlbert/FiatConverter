package com.tobidaada.fiatconverter.ui.conversion;

/**
 * Created by TOBI DAADA on 11/2/2017.
 */

public class ConversionMvpContract {

    interface Presenter {

        void convertCurrency(String currencyConversion, String userInput);

    }

    interface View {

        void showConversion(String result);
    }
}
