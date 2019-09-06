package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

public class CustomerContactGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private CustomerContactGetRequestParams(String id) {
        this.id = id;
    }

    /**
     * Makes a new Builder for CustomerContactGetRequestParams
     *
     * @return a builder for CustomerContactGetRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds a CustomerContactGetRequestParams instance
     */
    public static class Builder {
        /** BDC-assigned unique identifier of the Customer Contact */
        public String id;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a CustomerContactGetRequestParams instance with the set parameters
         *
         * @return CustomerContactGetRequestParams
         */
        public CustomerContactGetRequestParams build() {
            return new CustomerContactGetRequestParams(id);
        }
    }
}
