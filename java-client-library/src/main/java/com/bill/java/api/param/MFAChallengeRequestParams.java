package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Wrapper around data required for the MFAChallenge endpoint
 */
public class MFAChallengeRequestParams extends ApiResourceParams {
    /** Specifies whether the MFA token will be sent to the primary/backup phone of the user */
    @SerializedName("useBackup")
    private Boolean useBackup;

    private MFAChallengeRequestParams(Boolean useBackup) {
        this.useBackup = useBackup;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public Boolean useBackup;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public MFAChallengeRequestParams build() {
            return new MFAChallengeRequestParams(useBackup);
        }
    }
}