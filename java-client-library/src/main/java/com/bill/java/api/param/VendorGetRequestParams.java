package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters for retrieving a Vendor through the BDC API
 */
public class VendorGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private VendorGetRequestParams(String id) {
        this.id = id;
    }

    /**
     * Makes a new Builder for VendorGetRequestParams
     *
     * @return a builder for VendorGetRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds a new VendorGetRequestParams object
     */
    public static class Builder {
        public String id;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public VendorGetRequestParams build() {
            return new VendorGetRequestParams(id);
        }
    }
}
