package com.bill.java.api.models;

import com.google.gson.annotations.SerializedName;

public class SessionInfo {
    /** TODO: change all orgId getters to match across all endpoints */
    /** Id of the organization associated with the session */
    @SerializedName("organizationId")
    private String organizationId;

    /** Id of the user associated with the session */
    @SerializedName("userId")
    private String userId;

    /** Getter methods for the SessionInfo member variables */
    public String getOrganizationId() {
        return organizationId;
    }

    public String getUserId() {
        return userId;
    }
}
