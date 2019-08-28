package com.bill.java.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * The MFAChallenge class represents the return value from the /MFAChallenge.json endpoint
 */
public class MFAChallenge {
    /** The challengeId returned on a successful Http request to be used in a subsequent MFAAuthenticate request */
    @SerializedName("challengeId")
    private String id;

    public String getId() {
        return id;
    }
}
