package com.bill.java.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * The MFA class represents the return value from the /MFAAuthenticate.json endpoint
 */
public class MFA {
    /** The mfaId returned on a successful Http request to be used on subsequent Login requests */
    @SerializedName("mfaId")
    private String mfaId;

    public String getMfaId() {
        return mfaId;
    }
}
