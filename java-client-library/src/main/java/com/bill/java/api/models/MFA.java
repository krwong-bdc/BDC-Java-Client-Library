package com.bill.java.api.models;

import com.google.gson.annotations.SerializedName;

/**
* An object of this class is returned when the {@link Session#MFAAuthenticate(MFAAuthenticateRequestParams) MFAAuthenticate method}
* is called.
*/
public class MFA {
    /** the ID that is returned after successfully calling the {@link com.bill.java.api.models.Session#MFAAuthenticate(MFAAuthenticateRequestParams) MFAAuthenticate method} */
    @SerializedName("mfaId")
    private String mfaId;

    /**
    * Gets the Multi Factor Authentication (MFA) ID.
    *
    * @return  the MFA ID
    */
    public String getMfaId() {
        return mfaId;
    }
}
