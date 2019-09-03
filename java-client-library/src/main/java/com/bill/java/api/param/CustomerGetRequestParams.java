package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters for retrieving a Customer through the BDC API.
 */
public class CustomerGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private CustomerGetRequestParams(String id) {
        this.id = id;
    }

    /**
     * Makes a new Builder for CustomerGetRequestParams.
     *
     * @return a builder for CustomerGetRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an CustomerGetRequestParams object.
     */
    public static class Builder {
        /**
         * System generated Unique Identifier
         * <p>
         * It is used to retrieve and refer the object in subsequent API calls. You can filter by this field on the List call
         */
        public String id;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a CustomerGetRequestParams instance with the set parameters.
         *
         * @return CustomerGetRequestParams
         */
        public CustomerGetRequestParams build() {
            return new CustomerGetRequestParams(id);
        }
    }
}
