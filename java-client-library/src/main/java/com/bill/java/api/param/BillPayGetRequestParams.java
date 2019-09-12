package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 *  Parameters for retrieving a BillPay record through the BDC API
 */
public class BillPayGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private BillPayGetRequestParams(String id) {
        this.id = id;
    }

    /**
     * Makes a new Builder for BillPayGetRequestParams.
     *
     * @return a builder for BillPayGetRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an BillPayGetRequestParams object.
     */
    public static class Builder {
        /**
         * System generated Unique Identifier
         * <p>
         * It is used to retrieve and refer the object in subsequent API calls.
         */
        public String id;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a BillPayGetRequestParams instance with the set parameters.
         *
         * @return BillPayGetRequestParams
         */
        public BillPayGetRequestParams build() {
            return new BillPayGetRequestParams(id);
        }
    }
}
