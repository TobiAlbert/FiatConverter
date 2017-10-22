package com.tobidaada.fiatconverter.model.remote;

import com.tobidaada.fiatconverter.model.data.FiatCurrency;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by TOBI DAADA on 10/22/2017.
 */

public interface CurrencyService {

    @GET("data/price")
    Call<FiatCurrency> getFiatCurrency(@Query("fsym") String fsym, @Query("tsyms") String tsyms);
}
