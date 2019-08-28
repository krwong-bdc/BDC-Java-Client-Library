package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

public class CustomerSetAuthorizationRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    @SerializedName("hasAuthorizedToCharge")
    private final Boolean hasAuthorized;

    private CustomerSetAuthorizationRequestParams(String id, Boolean hasAuthorized) {
        this.id = id;
        this.hasAuthorized = hasAuthorized;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public String id;
        public Boolean hasAuthorized;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public CustomerSetAuthorizationRequestParams build() { return new CustomerSetAuthorizationRequestParams(id, hasAuthorized); }
    }
}
