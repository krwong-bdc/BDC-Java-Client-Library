package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Setter;

import java.util.function.Consumer;

public class ApproveRequestParams extends ApiResourceParams {
    @SerializedName("objectId")
    private String objectId;

    @Setter(AccessLevel.PUBLIC)
    @SerializedName("entity")
    private String entity;

    @SerializedName("comment")
    private String comment;

    private ApproveRequestParams(String objectId, String comment){
        this.objectId = objectId;
        this.comment = comment;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        public String objectId;
        public String comment;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public ApproveRequestParams build() {
            return new ApproveRequestParams(objectId, comment);
        }
    }
}
