package com.bill.java.api.param;

import java.util.function.Consumer;

/**
 * Contains the parameters to validate the session of a user who is logged in.
 */
public class SessionLoginRequestParams {

    /** the system generated ID of the organization that the user has logged into */
    private final String orgId;

    /** an optional argument to be passed in along with a deviceId to login and be multi factor authenticated */
    private final String mfaId;

    /** an optional argument to be passed in along with a trusted mfaId to login and be multi factor authenticated */
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
     * Builds an instance of the SessionLoginRequestParams class.
     */
    public static class Builder {
        /** the system generated ID of the organization that the user has logged into */
        public String orgId;

        /** an optional argument to be passed in along with a deviceId to login and be multi factor authenticated */
        public String mfaId;

        /** an optional argument to be passed in along with a trusted mfaId to login and be multi factor authenticated */
        public String deviceId;

        /**
        * the new SessionLoginRequestParams instance is assigned to this parameter
        */
        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }
        /**
         * Builds a SessionLoginRequestParams instance with the set parameters.
         *
         * @return the SessionLoginRequestParams
         */
        public SessionLoginRequestParams build() {
            return new SessionLoginRequestParams(orgId, mfaId, deviceId);
        }
    }

    /**
    * The method which gets the organization ID.
    *
    * @return the system generated ID of the organization that the user has logged into
    */
    public String getOrgId() {
        return orgId;
    }

    /**
    * Gets the Multi Factor Authentication (MFA) ID.
    *
    * @return  the MFA ID that is returned after successfully calling the MFAAuthenticate method
    */
    public String getMfaId() {
        return mfaId;
    }

    /**
    * Gets the device ID that was defined by the user during Multi Factor Authentication (MFA).
    *
    * @return  the ID defined by the user to identify the MFA device
    */
    public String getDeviceId() {
        return deviceId;
    }
}
