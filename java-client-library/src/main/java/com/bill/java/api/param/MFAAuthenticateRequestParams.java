package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Wrapper around data required for the MFAChallenge endpoint
 *
 * TODO: may require user to make instance to keep consistent with rest of library usage
 */
public class MFAAuthenticateRequestParams extends ApiResourceParams {
    /** Id acquired from the preceding call to {@link com.bill.java.api.models.Session#MFAAuthenticate(MFAAuthenticateRequestParams)} */
    @SerializedName("challengeId")
    private final String challengeId;

    /** Token acquired from the users phone as a result of the preceding call to {@link com.bill.java.api.models.Session#MFAAuthenticate(MFAAuthenticateRequestParams)} */
    @SerializedName("token")
    private final String token;

    /** String representation of the users device associated with the MFA challenge. Arbitrary value, but must stay consistent once MFA-authenticated */
    @SerializedName("deviceId")
    private final String deviceId;

    /** The machine asoociated with the deviceId. Arbitrary value */
    @SerializedName("machineName")
    private final String machineName;

    /** If set to true, MFA-authentication will not be asked for again for 30 days */
    @SerializedName("rememberMe")
    private final Boolean rememberMe;

    public MFAAuthenticateRequestParams(String challengeId, String token, String deviceId, String machineName, Boolean rememberMe) {
        this.challengeId = challengeId;
        this.token = token;
        this.deviceId = deviceId;
        this.machineName = machineName;
        this.rememberMe = rememberMe;

    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public String challengeId;
        public String token;
        public String deviceId;
        public String machineName;
        public Boolean rememberMe;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public MFAAuthenticateRequestParams build() {
            return new MFAAuthenticateRequestParams(challengeId, token, deviceId, machineName, rememberMe);
        }
    }
}