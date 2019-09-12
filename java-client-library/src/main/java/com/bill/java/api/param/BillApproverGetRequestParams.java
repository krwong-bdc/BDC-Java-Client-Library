package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

public class BillApproverGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private BillApproverGetRequestParams(String id) {
        this.id = id;
    }

    /**
     * Makes a new Builder for BillApproverGetRequestParams.
     *
     * @return a builder for BillApproverGetRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an BillApproverGetRequestParams object.
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
         * Builds a BillApproverGetRequestParams instance with the set parameters.
         *
         * @return BillApproverGetRequestParams
         */
        public BillApproverGetRequestParams build() {
            return new BillApproverGetRequestParams(id);
        }
    }
}
