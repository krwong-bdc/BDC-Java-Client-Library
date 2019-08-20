package com.bill.java.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the return values from the /MFAStatus.json endpoint
 */
public class MFAStatus {
    /** True if session is MFA Authenticated, otherwise false */
    @SerializedName("isTrusted")
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }
}
