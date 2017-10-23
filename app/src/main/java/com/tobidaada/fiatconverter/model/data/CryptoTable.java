package com.tobidaada.fiatconverter.model.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TOBI DAADA on 10/23/2017.
 */

public class CryptoTable {

    public static String getCryptoTickerSymbol(String text) {

        Map<String, String> mMap = new HashMap<>();

        mMap.put("Bitcoin", "BTC");
        mMap.put("Ethereum", "ETH");

        return mMap.get(text);
    }
}
