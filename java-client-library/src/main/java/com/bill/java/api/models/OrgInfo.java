package com.bill.java.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * This class represents the organizations a BDC user belongs to.
 * An object of this class is returned when the {@link Session#ListOrgs() list organization method} is called.
 */
public class OrgInfo {

    /** the organization ID associated with the session*/
    @SerializedName("orgId")
    private String orgId;

    /** the organization name associated with the session*/
    @SerializedName("orgName")
    private String orgName;

    /**
    * Gets the organization ID that is currently associated with the session.
    *
    * @return  the ID of the organization that is currently associated with the session
    */
    public String getOrgId() {
        return orgId;
    }

    /**
    * Gets the organization name that is currently associated with the session.
    *
    * @return  the name of the organization that is currently associated with the session
    */
    public String getOrgName() {
        return orgName;
    }
}
