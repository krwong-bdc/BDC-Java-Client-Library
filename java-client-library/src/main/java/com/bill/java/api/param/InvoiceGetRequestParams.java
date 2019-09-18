package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters for retrieving an Invoice through the BDC API
 */
public class InvoiceGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private InvoiceGetRequestParams(String id) {
        this.id = id;
    }

    /**
     * Makes a new Builder for InvoiceGetRequestParams.
     *
     * @return a builder for InvoiceGetRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an InvoiceGetRequestParams object.
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
         * Builds a InvoiceGetRequestParams instance with the set parameters.
         *
         * @return InvoiceGetRequestParams
         */
        public InvoiceGetRequestParams build() {
            return new InvoiceGetRequestParams(id);
        }
    }
}
