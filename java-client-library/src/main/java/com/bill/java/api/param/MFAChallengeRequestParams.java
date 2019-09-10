package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Contains the parameters used in the {@link com.bill.java.api.models.Session#requestMFAChallenge(MFAChallengeRequestParams) requestMFAChallenge method} to generate
 * and return a challenge ID, and send a token to the user’s registered mobile device.
 */
public class MFAChallengeRequestParams extends ApiResourceParams {

    /** the argument which determines whether the token needs to be sent to the primary mobile device
    *[value = false] or back up mobile device [value = true]
    */
    @SerializedName("useBackup")
    private final Boolean useBackup;

    private MFAChallengeRequestParams(Boolean useBackup) {
        this.useBackup = useBackup;
    }

    /**
     * Makes a new Builder for MFAChallengeRequestParams method.
     *
     * @return a builder for MFAChallengeRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an MFAChallengeRequestParams instance.
     */
    public static class Builder {
        /** the argument which determines whether the token needs to be sent to the primary mobile device
        * [value = false] or back up mobile device [value = true]
        */
        public Boolean useBackup;

        /**
        * the new MFAChallengeRequestParams instance is assigned to this parameter
        */
        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds an MFAChallengeRequestParams instance with the set parameters.
         *
         * @return the MFAChallengeRequestParams
         */
        public MFAChallengeRequestParams build() {
            return new MFAChallengeRequestParams(useBackup);
        }
    }
}
