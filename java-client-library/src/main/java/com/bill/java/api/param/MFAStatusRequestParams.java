package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
* Contains the parameters used in the {@link com.bill.java.api.models.Session#getMFAStatus(MFAStatusRequestParams) getMFAStatus method}
* to check the Multi Factor Authentication (MFA) session status of the current user.
*/
public class MFAStatusRequestParams extends ApiResourceParams {

    /**
    * the ID that is returned after successfully calling the {@link com.bill.java.api.models.Session#MFAAuthenticate(MFAAuthenticateRequestParams) MFAAuthenticate method}
    */
    @SerializedName("mfaId")
    private final String mfaId;

    /**
    * the ID defined by the user to identify the MFA device
    */
    @SerializedName("deviceId")
    private final String deviceId;

    /**
    * Creates a constructor with parameters required for Multi Factor Authentication (MFA).
    *
    * @param mfaId      the ID that is returned after successfully calling the {@link com.bill.java.api.models.Session#MFAAuthenticate(MFAAuthenticateRequestParams) MFAAuthenticate method}
    * @param deviceId   the ID defined by the user to identify the MFA device
    */
    private MFAStatusRequestParams(String mfaId, String deviceId) {
        this.mfaId = mfaId;
        this.deviceId = deviceId;
    }

    /**
     * Makes a new Builder for MFAStatusRequestParams.
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
        /** the ID that is returned after successfully calling the {@link com.bill.java.api.models.Session#MFAAuthenticate(MFAAuthenticateRequestParams) MFAAuthenticate method}*/
        public String mfaId;

        /** the ID defined by the user to identify the MFA device */
        public String deviceId;

        /**
        * the new MFAStatusRequestParams instance is assigned to this parameter
        */
        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds an MFAStatusRequestParams instance with the set parameters.
         *
         * @return the MFAStatusRequestParams
         */
        public MFAStatusRequestParams build() {
            return new MFAStatusRequestParams(mfaId, deviceId);
        }
    }
}
