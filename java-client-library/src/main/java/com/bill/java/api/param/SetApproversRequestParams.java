package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;

public class SetApproversRequestParams extends ApiResourceParams {
    @SerializedName("objectId")
    private String objectId;

    @Setter(AccessLevel.PUBLIC)
    @SerializedName("entity")
    private String entity;

    @SerializedName("approvers")
    private List<String> approvers;

    private SetApproversRequestParams(String objectId, List<String> approvers) {
        this.objectId = objectId;
        this.approvers = approvers;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        public String objectId;
        public List<String> approvers;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public SetApproversRequestParams build() {
            return new SetApproversRequestParams(
                    objectId,
                    approvers
            );
        }
    }
}
