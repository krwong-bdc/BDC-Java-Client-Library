package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

public class VendorBankAcccountGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private VendorBankAcccountGetRequestParams(String id) {
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

        public VendorBankAcccountGetRequestParams build() {
            return new VendorBankAcccountGetRequestParams(id);
        }
    }
}
