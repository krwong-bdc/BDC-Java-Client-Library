package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

public class MailInvoiceRequestParams extends ApiResourceParams {
    @SerializedName("invoiceId")
    private final String invoiceId;

    private MailInvoiceRequestParams(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * Makes a new Builder for MailInvoiceRequestParams
     *
     * @return a builder for MailInvoiceRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds a MailInvoiceRequestParams object
     */
    public static class Builder {
        /**
         * Id of invoice to be mailed.
         */
        public String invoiceId;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds an instance of MailInvoiceRequestParams with the set parameters
         *
         * @return a new MailInvoiceRequestParams instance
         */
        public MailInvoiceRequestParams build () {
            return new MailInvoiceRequestParams(invoiceId);
        }
    }
}
