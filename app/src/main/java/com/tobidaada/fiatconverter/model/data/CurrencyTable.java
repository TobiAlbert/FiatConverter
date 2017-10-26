package com.tobidaada.fiatconverter.model.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TOBI DAADA on 10/22/2017.
 */

public class CurrencyTable {

    /*
    Man  has to find a better way around this.
    Method returns a String value based on the Selected value from the Fiat Spinner
     */
    public static String getTickerSymbol(String text) {

        Map<String, String> mMap = new HashMap<>();
        mMap.put("US Dollar", "USD");
        mMap.put("European Euro", "EUR");
        mMap.put("Japanese Yen", "JPY");
        mMap.put("Nigerian Naira", "NGN");
        mMap.put("Pound Sterling", "GBP");
        mMap.put("Australian Dollar", "AUD");
        mMap.put("Canadian Dollar", "CAD");
        mMap.put("Swiss Franc", "CHF");
        mMap.put("Chinese Yuan", "CNY");
        mMap.put("Swedish Krona", "SEK");
        mMap.put("Mexican Peso", "MXN");
        mMap.put("NZ Dollar", "NZD");
        mMap.put("Singapore Dollar", "SGD");
        mMap.put("Hong Kong Dollar", "HKD");
        mMap.put("Norwegian Krone", "NOK");
        mMap.put("South Korean Won", "KRW");
        mMap.put("Turkish Lira", "TRY");
        mMap.put("Indian Rupee", "INR");
        mMap.put("Russian Ruble", "RUB");
        mMap.put("Brazilian Real", "BRL");
        mMap.put("S.A. Rand", "ZAR");
        mMap.put("Bitcoin", "BTC");
        mMap.put("Ethereum", "ETH");

        return mMap.get(text);
    }

}
