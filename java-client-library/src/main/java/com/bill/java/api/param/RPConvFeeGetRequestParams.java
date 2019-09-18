package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 *  Parameters for retrieving a RPConvFee record through the BDC API
 */
public class RPConvFeeGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private RPConvFeeGetRequestParams(String id) {
        this.id = id;
    }

    /**
     * Makes a new Builder for RPConvFeeGetRequestParams.
     *
     * @return a builder for RPConvFeeGetRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an RPConvFeeGetRequestParams object.
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
         * Builds a RPConvFeeGetRequestParams instance with the set parameters.
         *
         * @return RPConvFeeGetRequestParams
         */
        public RPConvFeeGetRequestParams build() {
            return new RPConvFeeGetRequestParams(id);
        }
    }
}
