package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters needed to fetch a Vendor from the BDC database
 */
public class VendorGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private VendorGetRequestParams(String id) {
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

        public VendorGetRequestParams build() {
            return new VendorGetRequestParams(id);
        }
    }
}
