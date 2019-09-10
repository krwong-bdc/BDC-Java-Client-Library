package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
  * Contains the parameters used in the {@link com.bill.java.api.models.Session#MFAAuthenticate(MFAAuthenticateRequestParams) MFAAuthenticate method} to validate the challenge ID,
  * token sent to the users mobile device, device ID, and the name that was given
  * to the machine at the time of generating the challenge ID.
  */
public class MFAAuthenticateRequestParams extends ApiResourceParams {

    /** the ID that is returned after successfully calling the {@link com.bill.java.api.models.Session#requestMFAChallenge(MFAChallengeRequestParams) requestMFAChallenge method}*/
    @SerializedName("challengeId")
    private final String challengeId;

    /** the token sent to the user's device after calling the {@link com.bill.java.api.models.Session#requestMFAChallenge(MFAChallengeRequestParams) requestMFAChallenge method}*/
    @SerializedName("token")
    private final String token;

    /** the ID defined by the user to identify the MFA device*/
    @SerializedName("deviceId")
    private final String deviceId;

    /** the name defined by the user to describe the MFA device*/
    @SerializedName("machineName")
    private final String machineName;

    /**
    * determines if the MFA ID that is returned needs to be trusted after the session has ended.
    * If set to true, the session expires in 30 days. If set to false, the session expires when the user logs out.
    */
    @SerializedName("rememberMe")
    private final Boolean rememberMe;

    /**
    * Creates a constructor with parameters required for Multi Factor Authentication (MFA).
    *
    * @param challengeId  gets the challenge ID that the user passed in
    * @param token        gets the token value that the user passed in
    * @param getDeviceId  gets the device ID that the user passed in
    * @param machineName  gets the machine name that the user passed in
    * @param rememberMe   gets the rememberMe boolean value that the user passed in
    */
    private MFAAuthenticateRequestParams(String challengeId, String token, String deviceId, String machineName, Boolean rememberMe) {
        this.challengeId = challengeId;
        this.token = token;
        this.deviceId = deviceId;
        this.machineName = machineName;
        this.rememberMe = rememberMe;

    }

    /**
     * Makes a new Builder for MFAAuthenticateRequestParams.
     *
     * @return a builder for MFAAuthenticateRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds a MFAAuthenticateRequestParams object.
     */
    public static class Builder {

        /** the ID that is returned after successfully calling the {@link com.bill.java.api.models.Session#requestMFAChallenge(MFAChallengeRequestParams) requestMFAChallenge method}*/
        public String challengeId;

        /** the token sent to the user's device after calling the {@link com.bill.java.api.models.Session#requestMFAChallenge(MFAChallengeRequestParams) requestMFAChallenge method}*/
        public String token;

        /** the ID defined by the user to identify the MFA device. Arbitrary value, but must stay consistent once MFA-authenticated */
        public String deviceId;

        /** the name defined by the user to describe the MFA device */
        public String machineName;

        /**
        * determines if the MFA ID that is returned needs to be trusted after the session is has ended.
        * If set to true, the session expires in 30 days. If set to false, the session expires when the user logs out.
        */
        public Boolean rememberMe;

        /**
        * the new MFAAuthenticateRequestParams instance is assigned to this parameter
        */
        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a MFAAuthenticateRequestParams instance with the set parameters.
         *
         * @return the MFAAuthenticateRequestParams
         */
        public MFAAuthenticateRequestParams build() {
            return new MFAAuthenticateRequestParams(challengeId, token, deviceId, machineName, rememberMe);
        }
    }
}
