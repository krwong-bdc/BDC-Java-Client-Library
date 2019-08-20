package com.bill.java.api.models;

import com.google.gson.annotations.SerializedName;

public class MFA {
    @SerializedName("mfaId")
    private String mfaId;

    public String getMfaId() {
        return mfaId;
    }
}
