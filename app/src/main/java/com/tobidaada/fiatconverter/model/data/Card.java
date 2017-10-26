package com.tobidaada.fiatconverter.model.data;

/**
 * Created by TOBI DAADA on 10/22/2017.
 */

public class Card {

    private String title;
    private String amount;

    public Card(String title, String amount) {

        this.title = title;
        this.amount = amount;

    }

    public String getTitle() {
        return this.title;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {this.amount = amount;}
}
