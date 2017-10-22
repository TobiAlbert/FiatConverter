package com.tobidaada.fiatconverter.model.data;

/**
 * Created by TOBI DAADA on 10/22/2017.
 */

public class Card {

    private String title;
    private String amount;
    private int spinnerResource;


    public Card(String title, String amount, int spinnerResource) {

        this.title = title;
        this.amount = amount;
        this.spinnerResource = spinnerResource;

    }

    public String getTitle() {
        return this.title;
    }

    public String getAmount() {
        return this.amount;
    }

    public int getSpinnerResource() {
        return this.spinnerResource;
    }
}
