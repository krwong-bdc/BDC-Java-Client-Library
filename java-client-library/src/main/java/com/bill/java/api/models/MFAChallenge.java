package com.bill.java.api.models;

import com.google.gson.annotations.SerializedName;

public class MFAChallenge {
    @SerializedName("challengeId")
    private String id;

    public String getId() {
        return id;
    }
}
