package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 *  Parameters for retrieving a ReceivedPay record through the BDC API
 */
public class ReceivedPayGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private ReceivedPayGetRequestParams(String id) {
        this.id = id;
    }

    /**
     * Makes a new Builder for ReceivedPayGetRequestParams.
     *
     * @return a builder for ReceivedPayGetRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an ReceivedPayGetRequestParams object.
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
         * Builds a ReceivedPayGetRequestParams instance with the set parameters.
         *
         * @return ReceivedPayGetRequestParams
         */
        public ReceivedPayGetRequestParams build() {
            return new ReceivedPayGetRequestParams(id);
        }
    }
}
