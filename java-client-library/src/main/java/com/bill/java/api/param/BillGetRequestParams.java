package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

public class BillGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private BillGetRequestParams(String id) {
        this.id = id;
    }

    /**
     * Makes a new Builder for BillGetRequestParams.
     *
     * @return a builder for BillGetRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an BillGetRequestParams object.
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
         * Builds a BillGetRequestParams instance with the set parameters.
         *
         * @return BillGetRequestParams
         */
        public BillGetRequestParams build() {
            return new BillGetRequestParams(id);
        }
    }
}
