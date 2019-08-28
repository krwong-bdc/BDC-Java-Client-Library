package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters needed to fetch a Customer Bank Account through the BDC API
 */
public class CustomerBankAccountGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private CustomerBankAccountGetRequestParams(String id) {
        this.id = id;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public String id;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public CustomerBankAccountGetRequestParams build() {
            return new CustomerBankAccountGetRequestParams(id);
        }
    }
}
