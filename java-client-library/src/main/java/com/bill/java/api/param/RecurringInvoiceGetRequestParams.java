package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters for retrieving a RecurringInvoice through the BDC API
 */
public class RecurringInvoiceGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private RecurringInvoiceGetRequestParams(String id) {
        this.id = id;
    }

    /**
     * Makes a new Builder for RecurringInvoiceGetRequestParams.
     *
     * @return a builder for RecurringInvoiceGetRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an RecurringInvoiceGetRequestParams object.
     */
    public static class Builder {
        /**
         * System generated Unique Identifier
         * <p>
         * It is used to retrieve and refer the object in subsequent API calls. You can filter by this field on the List call
         */
        public String id;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a RecurringInvoiceGetRequestParams instance with the set parameters.
         *
         * @return RecurringInvoiceGetRequestParams
         */
        public RecurringInvoiceGetRequestParams build() {
            return new RecurringInvoiceGetRequestParams(id);
        }
    }
}
