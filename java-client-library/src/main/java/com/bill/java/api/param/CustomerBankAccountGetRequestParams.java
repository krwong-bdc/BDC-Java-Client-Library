package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters for retrieving a Customer Bank Account through the BDC API
 */
public class CustomerBankAccountGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private CustomerBankAccountGetRequestParams(String id) {
        this.id = id;
    }

    /**
     * Makes a new Builder for CustomerBankAccountGetRequestParams
     *
     * @return a builder for CustomerBankAccountGetRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds a CustomerBankAccountGetRequestParams instance
     */
    public static class Builder {
        /** BDC-assigned unique identifier for the bank account */
        public String id;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a CustomerBankAccountGetRequestParams instance with the set parameters
         *
         * @return CustomerBankAccountGetRequestParams
         */
        public CustomerBankAccountGetRequestParams build() {
            return new CustomerBankAccountGetRequestParams(id);
        }
    }
}
