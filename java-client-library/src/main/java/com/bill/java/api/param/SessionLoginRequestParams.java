package com.bill.java.api.param;

import java.util.function.Consumer;

/**
 * Parameters for logging in a user
 */
public class SessionLoginRequestParams {
    private final String orgId;
    private final String mfaId;
    private final String deviceId;

    private SessionLoginRequestParams(String orgId, String mfaId, String deviceId) {
        this.orgId = orgId;
        this.mfaId = mfaId;
        this.deviceId = deviceId;
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an instance of the SessionLoginRequestParams class
     */
    public static class Builder {
        public String orgId;
        public String mfaId;
        public String deviceId;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public SessionLoginRequestParams build() {
            return new SessionLoginRequestParams(orgId, mfaId, deviceId);
        }
    }

    public String getOrgId() {
        return orgId;
    }

    public String getMfaId() {
        return mfaId;
    }

    public String getDeviceId() {
        return deviceId;
    }
}
