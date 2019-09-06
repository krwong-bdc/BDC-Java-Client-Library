package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters for initiating a MFA challenge through the BDC API
 */
public class MFAChallengeRequestParams extends ApiResourceParams {
    @SerializedName("useBackup")
    private final Boolean useBackup;

    private MFAChallengeRequestParams(Boolean useBackup) {
        this.useBackup = useBackup;
    }

    /**
     * Makes a new Builder for MFAChallengeRequestParams
     *
     * @return a builder for MFAChallengeRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds a MFAChallengeRequestParams instance
     */
    public static class Builder {
        /** Specifies whether the MFA token will be sent to the primary/backup phone of the user */
        public Boolean useBackup;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a MFAChallengeRequestParams instance with the set parameters
         *
         * @return MFAChallengeRequestParams
         */
        public MFAChallengeRequestParams build() {
            return new MFAChallengeRequestParams(useBackup);
        }
    }
}