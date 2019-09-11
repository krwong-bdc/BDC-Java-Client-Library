package com.bill.java.api.param;

import com.bill.java.api.models.InvoicePay;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.function.Consumer;

public class ChargeCustomerRequestParams extends ApiResourceParams {
    @SerializedName("customerId")
    private String customerId;

    @SerializedName("paymentDate")
    private String paymentDate;

    @SerializedName("paymentType")
    private String paymentType;

    @SerializedName("paymentAccountId")
    private String paymentAccountId;

    @SerializedName("memo")
    private String memo;

    @SerializedName("invoicePays")
    private List<InvoicePay> invoicePays;

    private ChargeCustomerRequestParams(String customerId,
                                        String paymentDate,
                                        String paymentType,
                                        String paymentAccountId,
                                        String memo,
                                        List<InvoicePay> invoicePays){
        this.customerId = customerId;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
        this.paymentAccountId = paymentAccountId;
        this.memo = memo;
        this.invoicePays = invoicePays;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public String customerId;
        public String paymentDate;
        public String paymentType;
        public String paymentAccountId;
        public String memo;
        public List<InvoicePay> invoicePays;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public ChargeCustomerRequestParams build() {
            return new ChargeCustomerRequestParams(
                    customerId,
                    paymentDate,
                    paymentType,
                    paymentAccountId,
                    memo,
                    invoicePays);
        }
    }
}
