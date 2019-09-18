package com.bill.java.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * An object of this class is returned when the {@link Session#getMFAStatus(MFAStatusRequestParams) getMFAStatus method}
 * is called.
 */
public class MFAStatus {
    /** indicates if the session is Multi Factor Authentication (MFA) trusted [value=true] or not [value=false]*/
    @SerializedName("isTrusted")
    private Boolean status;

    /**
    * Gets the Multi Factor Authentication (MFA) status of the session.
    *
    * @return  true if the session is MFA trusted
    */
    public Boolean getStatus() {
        return status;
    }
}
