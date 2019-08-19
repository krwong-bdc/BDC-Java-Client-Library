package com.bill.java.api.models;

import com.google.gson.annotations.SerializedName;

public class OrgInfo {
    @SerializedName("orgId")
    private String orgId;

    @SerializedName("orgName")
    private String orgName;

    public String getOrgId() {
        return orgId;
    }

    public String getOrgName() {
        return orgName;
    }
}
