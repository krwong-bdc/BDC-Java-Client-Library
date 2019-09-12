package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 *  Parameters for retrieving a SentPay record through the BDC API
 */
public class SentPayGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private SentPayGetRequestParams(String id) {
        this.id = id;
    }

    /**
     * Makes a new Builder for SentPayGetRequestParams.
     *
     * @return a builder for SentPayGetRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an SentPayGetRequestParams object.
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
         * Builds a SentPayGetRequestParams instance with the set parameters.
         *
         * @return SentPayGetRequestParams
         */
        public SentPayGetRequestParams build() {
            return new SentPayGetRequestParams(id);
        }
    }
}
