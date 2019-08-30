package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters for retrieving a Vendor Bank Account through the BDC API
 */
public class VendorBankAccountGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private VendorBankAccountGetRequestParams(String id) {
        this.id = id;
    }

    /**
     * Makes a new Builder for VendorBankAccountGetRequestParams
     *
     * @return a builder for VendorBankAccountGetRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds a new VendorBankAccountGetRequestParams object
     */
    public static class Builder {
        public String id;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public VendorBankAccountGetRequestParams build() {
            return new VendorBankAccountGetRequestParams(id);
        }
    }
}
