package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 *  Parameters for retrieving a BillCredit record through the BDC API
 */
public class BillCreditGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private BillCreditGetRequestParams(String id) {
        this.id = id;
    }

    /**
     * Makes a new Builder for BillCreditGetRequestParams.
     *
     * @return a builder for BillCreditGetRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an BillCreditGetRequestParams object.
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
         * Builds a BillCreditGetRequestParams instance with the set parameters.
         *
         * @return BillCreditGetRequestParams
         */
        public BillCreditGetRequestParams build() {
            return new BillCreditGetRequestParams(id);
        }
    }
}
