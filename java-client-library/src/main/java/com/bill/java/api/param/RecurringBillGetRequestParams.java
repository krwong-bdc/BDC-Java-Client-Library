package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters for retrieving a RecurringBill through the BDC API
 */
public class RecurringBillGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private RecurringBillGetRequestParams(String id) {
        this.id = id;
    }

    /**
     * Makes a new Builder for RecurringBillGetRequestParams.
     *
     * @return a builder for RecurringBillGetRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an RecurringBillGetRequestParams object.
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
         * Builds a RecurringBillGetRequestParams instance with the set parameters.
         *
         * @return RecurringBillGetRequestParams
         */
        public RecurringBillGetRequestParams build() {
            return new RecurringBillGetRequestParams(id);
        }
    }
}
