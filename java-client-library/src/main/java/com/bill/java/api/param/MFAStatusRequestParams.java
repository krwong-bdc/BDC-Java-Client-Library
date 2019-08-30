package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

public class MFAStatusRequestParams extends ApiResourceParams {
    /** Id acquired from a previous call to {@link com.bill.java.api.models.Session#MFAAuthenticate(MFAAuthenticateRequestParams)} */
    @SerializedName("mfaId")
    private String mfaId;

    /** Id of device used to make previous call to {@link com.bill.java.api.models.Session#MFAAuthenticate(MFAAuthenticateRequestParams)} */
    @SerializedName("deviceId")
    private String deviceId;

    private MFAStatusRequestParams(String mfaId, String deviceId) {
        this.mfaId = mfaId;
        this.deviceId = deviceId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public String mfaId;
        public String deviceId;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public MFAStatusRequestParams build() {
            return new MFAStatusRequestParams(mfaId, deviceId);
        }
    }
}