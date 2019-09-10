package com.bill.java.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * An object of this class is returned when the {@link Session#requestMFAChallenge(MFAChallengeRequestParams) requestMFAChallenge method}
 * is called.
 */
public class MFAChallenge {
    /** the ID that is returned after successfully calling the {@link Session#requestMFAChallenge(MFAChallengeRequestParams) requestMFAChallenge method}*/
    @SerializedName("challengeId")
    private String id;

    /**
    * Gets the challenge ID.
    *
    * @return the ID that is returned after successfully calling the requestMFAChallenge method
    */
    public String getId() {
        return id;
    }
}
