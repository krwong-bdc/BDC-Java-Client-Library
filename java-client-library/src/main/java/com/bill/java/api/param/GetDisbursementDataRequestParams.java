package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

public class GetDisbursementDataRequestParams extends ApiResourceParams {
    @SerializedName("sentPayId")
    private final String sentPayId;

    private GetDisbursementDataRequestParams(String sentPayId) {
        this.sentPayId = sentPayId;
    }

    /**
     * Makes a new Builder for GetDisbursementDataRequestParams.
     *
     * @return a builder for GetDisbursementDataRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an GetDisbursementDataRequestParams object.
     */
    public static class Builder {
        /**
         * Id of the SentPay whose disbursement data is being requested
         * <p>
         * It is used to retrieve and refer the object in subsequent API calls. You can filter by this field on the List call
         */
        public String sentPayId;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a GetDisbursementDataRequestParams instance with the set parameters.
         *
         * @return GetDisbursementDataRequestParams
         */
        public GetDisbursementDataRequestParams build() {
            return new GetDisbursementDataRequestParams(sentPayId);
        }
    }
}
