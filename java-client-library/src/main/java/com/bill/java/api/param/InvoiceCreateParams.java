package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;


/* Ignore class for now. Made as example for reference */
public class InvoiceCreateParams extends ApiResourceParams {
    @SerializedName("amount")
    private int amount;


    public void setAmount(int amount) {
        this.amount = amount;
    }
}
