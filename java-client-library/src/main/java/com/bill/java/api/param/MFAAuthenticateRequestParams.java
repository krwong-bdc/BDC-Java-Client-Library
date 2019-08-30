package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters for multi-factor-authenticating through the BDC API
 */
public class MFAAuthenticateRequestParams extends ApiResourceParams {
    @SerializedName("challengeId")
    private final String challengeId;

    @SerializedName("token")
    private final String token;

    @SerializedName("deviceId")
    private final String deviceId;

    @SerializedName("machineName")
    private final String machineName;

    @SerializedName("rememberMe")
    private final Boolean rememberMe;

    private MFAAuthenticateRequestParams(String challengeId, String token, String deviceId, String machineName, Boolean rememberMe) {
        this.challengeId = challengeId;
        this.token = token;
        this.deviceId = deviceId;
        this.machineName = machineName;
        this.rememberMe = rememberMe;

    }

    /**
     * Makes a new Builder for MFAAuthenticateRequestParams
     *
     * @return a builder for MFAAuthenticateRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds a MFAAuthenticateRequestParams object
     */
    public static class Builder {
        /** Id acquired from the preceding call to {@link com.bill.java.api.models.Session#MFAAuthenticate(MFAAuthenticateRequestParams)} */
        public String challengeId;

        /** Token acquired from the users phone as a result of the preceding call to {@link com.bill.java.api.models.Session#MFAAuthenticate(MFAAuthenticateRequestParams)} */
        public String token;

        /** String representation of the users device associated with the MFA challenge. Arbitrary value, but must stay consistent once MFA-authenticated */
        public String deviceId;

        /** The machine asoociated with the deviceId. Arbitrary value */
        public String machineName;

        /** If set to true, MFA-authentication will not be asked for again for 30 days */
        public Boolean rememberMe;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a MFAAuthenticateRequestParams instance with the set parameters
         *
         * @return MFAAuthenticateRequestParams
         */
        public MFAAuthenticateRequestParams build() {
            return new MFAAuthenticateRequestParams(challengeId, token, deviceId, machineName, rememberMe);
        }
    }
}