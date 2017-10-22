package com.tobidaada.fiatconverter.model.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TOBI DAADA on 10/22/2017.
 */

public class FiatCurrency {

    @SerializedName("NGN")
    private double NGN;

    @SerializedName("USD")
    private double USD;

    @SerializedName("EUR")
    private double EUR;

    @SerializedName("JPY")
    private double JPY;

    @SerializedName("GBP")
    private double GBP;

    @SerializedName("AUD")
    private double AUD;

    @SerializedName("CAD")
    private double CAD;

    @SerializedName("CHF")
    private double CHF;

    @SerializedName("CNY")
    private double CNY;

    @SerializedName("SEK")
    private double SEK;

    @SerializedName("MXN")
    private double MXN;

    @SerializedName("NZD")
    private double NZD;

    @SerializedName("SGD")
    private double SGD;

    @SerializedName("HKD")
    private double HKD;

    @SerializedName("NOK")
    private double NOK;

    @SerializedName("KRW")
    private double KRW;

    @SerializedName("TRY")
    private double TRY;

    @SerializedName("INR")
    private double INR;

    @SerializedName("RUB")
    private double RUB;

    @SerializedName("BRL")
    private double BRL;

    @SerializedName("ZAR")
    private double ZAR;

    public double getNGN() {
        return NGN;
    }

    public double getUSD() {
        return USD;
    }

    public double getEUR() {
        return EUR;
    }

    public double getJPY() {
        return JPY;
    }

    public double getGBP() {
        return GBP;
    }

    public double getAUD() {
        return AUD;
    }

    public double getCAD() {
        return CAD;
    }

    public double getCHF() {
        return CHF;
    }

    public double getCNY() {
        return CNY;
    }

    public double getSEK() {
        return SEK;
    }

    public double getMXN() {
        return MXN;
    }

    public double getNZD() {
        return NZD;
    }

    public double getSGD() {
        return SGD;
    }

    public double getHKD() {
        return HKD;
    }

    public double getNOK() {
        return NOK;
    }

    public double getKRW() {
        return KRW;
    }

    public double getTRY() {
        return TRY;
    }

    public double getINR() {
        return INR;
    }

    public double getRUB() {
        return RUB;
    }

    public double getBRL() {
        return BRL;
    }

    public double getZAR() {
        return ZAR;
    }

    public double getCurrency(String currencyTicker) {

        switch (currencyTicker) {
            case "NGN":
                return getNGN();
            case "USD":
                return getUSD();
            case "EUR":
                return getEUR();
            case "JPY":
                return getJPY();
            case "GBP":
                return getGBP();
            case "AUD":
                return getAUD();
            case "CAD":
                return getCAD();
            case "CHF":
                return getCHF();
            case "CNY":
                return getCNY();
            case "SEK":
                return getSEK();
            case "MXN":
                return getMXN();
            case "NZD":
                return getNZD();
            case "SGD":
                return getSGD();
            case "HKD":
                return getHKD();
            case "NOK":
                return getNOK();
            case "KRW":
                return getKRW();
            case "TRY":
                return getTRY();
            case "INR":
                return getINR();
            case "RUB":
                return getRUB();
            case "BRL":
                return getBRL();
            case "ZAR":
                return getZAR();
            default:
                return 0;
        }
    }
}
