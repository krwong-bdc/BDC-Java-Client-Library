package com.bill.java.api.param;

public class InvoiceCreateParams extends ApiResourceParams {
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        params.put("amount", Integer.toString(amount));
        this.amount = amount;
    }
}
