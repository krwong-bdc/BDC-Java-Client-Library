package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters for checking the validity of a given MFA Id
 */
public class MFAStatusRequestParams extends ApiResourceParams {
    @SerializedName("mfaId")
    private final String mfaId;

    @SerializedName("deviceId")
    private final String deviceId;

    private MFAStatusRequestParams(String mfaId, String deviceId) {
        this.mfaId = mfaId;
        this.deviceId = deviceId;
    }

    /**
     * Makes a new Builder for MFAStatusRequestParams
     *
     * @return a builder for MFAStatusRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds a MFAStatusRequestParams instance
     */
    public static class Builder {
        /** Id acquired from a previous call to {@link com.bill.java.api.models.Session#MFAAuthenticate(MFAAuthenticateRequestParams)} */
        public String mfaId;

        /** Id of device used to make previous call to {@link com.bill.java.api.models.Session#MFAAuthenticate(MFAAuthenticateRequestParams)} */
        public String deviceId;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a MFAStatusRequestParams instance with the set parameters
         *
         * @return MFAStatusRequestParams
         */
        public MFAStatusRequestParams build() {
            return new MFAStatusRequestParams(mfaId, deviceId);
        }
    }
}