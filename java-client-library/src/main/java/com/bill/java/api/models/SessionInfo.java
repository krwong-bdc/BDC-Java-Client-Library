package com.bill.java.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * An object of this class is returned when the {@link Session#getSessionInfo() getSessionInfo method} is called.
 */
public class SessionInfo {

    /** the system generated ID of the organization that the user has logged into */
    @SerializedName("organizationId")
    private String organizationId;

    /** the system generated ID of the user who is logged into the system */
    @SerializedName("userId")
    private String userId;

    /**
    * Gets the system generated ID of the organization that the user has logged into.
    *
    * @return  the organization ID that is currently associated with the session
    */
    public String getOrganizationId() {
        return organizationId;
    }

    /**
    * Gets the ID of the user who is logged into the system.
    *
    * @return  the system generated ID of the user who is logged into the system
    */
    public String getUserId() {
        return userId;
    }
}
