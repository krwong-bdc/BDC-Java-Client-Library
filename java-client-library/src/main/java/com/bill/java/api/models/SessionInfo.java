package com.bill.java.api.models;

import com.google.gson.annotations.SerializedName;

public class SessionInfo {
    @SerializedName("organizationId")
    private String organizationId;

    @SerializedName("userId")
    private String userId;

    public String getOrganizationId() {
        return organizationId;
    }

    public String getUserId() {
        return userId;
    }
}
