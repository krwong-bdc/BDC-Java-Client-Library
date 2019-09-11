package com.bill.java.api.models;

import com.bill.java.api.net.ApiResource;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class InvoicePay extends ApiResource {
    /** "InvoicePay" */
    @SerializedName("entity")
    private String entity;

    @SerializedName("id")
    private String id;

    @SerializedName("invoiceId")
    private String invoiceId;

    @SerializedName("amount")
    private BigDecimal amount;

    @SerializedName("status")
    private String status;

    @SerializedName("createdTime")
    private String createdTime;

    @SerializedName("updatedTime")
    private String updatedTime;

    private InvoicePay(String invoiceId, BigDecimal amount) {
        this.invoiceId = invoiceId;
        this.amount = amount;
    }

    /**
     * Makes a new Builder for InvoicePay
     *
     * @return a builder for InvoicePay
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an instance of InvoicePay
     */
    public static class Builder {
        public String invoiceId;
        public BigDecimal amount;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a new InvoicePay with the set parameters.
         *
         * @return a new InvoicePay object
         */
        public InvoicePay build() {
            return new InvoicePay(invoiceId, amount);
        }
    }
}
