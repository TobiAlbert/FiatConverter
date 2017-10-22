package com.tobidaada.fiatconverter.model.remote;



/**
 * Created by TOBI DAADA on 10/22/2017.
 */

public class ApiUtils {

    public static final String BASE_URL = "https://min-api.cryptocompare.com/";

    public static CurrencyService getCurrencyService() {
        return RetrofitClient.getClient(BASE_URL).create(CurrencyService.class);
    }
}
