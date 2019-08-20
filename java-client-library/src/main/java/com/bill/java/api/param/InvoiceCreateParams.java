package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

public class InvoiceCreateParams extends ApiResourceParams {
    @SerializedName("amount")
    private int amount;


    public void setAmount(int amount) {
        this.amount = amount;
    }
}
