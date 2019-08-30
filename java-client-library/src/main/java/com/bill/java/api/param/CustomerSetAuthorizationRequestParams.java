package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters for recording a customer's authorization to charge
 */
public class CustomerSetAuthorizationRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    @SerializedName("hasAuthorizedToCharge")
    private final Boolean hasAuthorized;

    private CustomerSetAuthorizationRequestParams(String id, Boolean hasAuthorized) {
        this.id = id;
        this.hasAuthorized = hasAuthorized;
    }

    /**
     * Makes a new Builder for CustomerSetAuthorizationRequestParams
     *
     * @return a builder for CustomerSetAuthorizationRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds a CustomerSetAuthorizationRequestParams instance
     */
    public static class Builder {
        /**
         * System generated Unique Identifier
         * <p>
         * It is used to retrieve and refer the object in subsequent API calls. You can filter by this field on the List call
         */
        public String id;

        /** Customer has authorized user to charge their bank account. Must be set using {@link com.bill.java.api.models.Customer#setAuthorization(CustomerSetAuthorizationRequestParams) setAuthorization()} */
        public Boolean hasAuthorized;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a CustomerSetAuthorizationRequestParams instance with the set parameters
         *
         * @return CustomerSetAuthorizationRequestParams
         */
        public CustomerSetAuthorizationRequestParams build() { return new CustomerSetAuthorizationRequestParams(id, hasAuthorized); }
    }
}
