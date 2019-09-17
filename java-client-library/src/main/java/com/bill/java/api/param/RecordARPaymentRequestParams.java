package com.bill.java.api.param;

import com.bill.java.api.models.InvoicePay;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

public class RecordARPaymentRequestParams extends ApiResourceParams {
    @SerializedName("customerId")
    private String customerId;

    @SerializedName("paymentDate")
    private String paymentDate;

    @SerializedName("paymentType")
    private String paymentType;

    @SerializedName("amount")
    private BigDecimal amount;

    @SerializedName("depositToAccountId")
    private String depositToAccountId;

    @SerializedName("description")
    private String description;

    @SerializedName("refNumber")
    private String refNumber;

    @SerializedName("invoicePays")
    private List<InvoicePay> invoicePays;

    private RecordARPaymentRequestParams(String customerId,
                                         String paymentDate,
                                         String paymentType,
                                         BigDecimal amount,
                                         String depositToAccountId,
                                         String description,
                                         String refNumber,
                                         List<InvoicePay> invoicePays) {
        this.customerId = customerId;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
        this.amount = amount;
        this.depositToAccountId = depositToAccountId;
        this.description = description;
        this.refNumber = refNumber;
        this.invoicePays = invoicePays;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        public String customerId;
        public String paymentDate;
        public String paymentType;
        public BigDecimal amount;
        public String depositToAccountId;
        public String description;
        public String refNumber;
        public List<InvoicePay> invoicePays;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public RecordARPaymentRequestParams build() {
            return new RecordARPaymentRequestParams(
                    customerId,
                    paymentDate,
                    paymentType,
                    amount,
                    depositToAccountId,
                    description,
                    refNumber,
                    invoicePays
            );
        }
    }
}
