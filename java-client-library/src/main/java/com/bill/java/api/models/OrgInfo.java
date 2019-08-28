package com.bill.java.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * <p>The OrgInfo class represents the organizations a BDC user belongs to.
 * Returned as part of a list from the /ListOrgs.json endpoint</p>
 */
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
