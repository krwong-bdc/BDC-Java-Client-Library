package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

public class VendorBankAccountCreateRequestParams extends ApiResourceParams {
    /** Holds the actual api resource variables for creation */
    @SerializedName("obj")
    private Params params;

    private VendorBankAccountCreateRequestParams(Params params) {
        this.params = params;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public String id;
        public String isActive;
        public String createdTime;
        public String updatedTime;
        public String vendorId;
        public String accountNumber;
        public String routingNumber;
        public String usersId;
        public String status;
        public Boolean isSavings;
        public Boolean isPersonalAcct;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public VendorBankAccountCreateRequestParams build() {
            return new VendorBankAccountCreateRequestParams(
                    new Params(id, isActive, createdTime, updatedTime, vendorId, accountNumber, routingNumber, usersId, status, isSavings, isPersonalAcct)
            );
        }
    }

    private static class Params {
        @SerializedName("entity")
        private String entity = "VendorBankAccount";

        @SerializedName("id")
        private String id;

        @SerializedName("isActive")
        private String isActive;

        @SerializedName("createdTime")
        private String createdTime;

        @SerializedName("updatedTime")
        private String updatedTime;

        @SerializedName("vendorId")
        private String vendorId;

        @SerializedName("accountNumber")
        private String accountNumber;

        @SerializedName("routingNumber")
        private String routingNumber;

        @SerializedName("usersId")
        private String usersId;

        @SerializedName("status")
        private String status;

        @SerializedName("isSavings")
        private Boolean isSavings;

        @SerializedName("isPersonalAcct")
        private Boolean isPersonalAcct;

        public Params(String id, String isActive, String createdTime, String updatedTime, String vendorId, String accountNumber, String routingNumber, String usersId, String status, Boolean isSavings, Boolean isPersonalAcct) {
            this.id = id;
            this.isActive = isActive;
            this.createdTime = createdTime;
            this.updatedTime = updatedTime;
            this.vendorId = vendorId;
            this.accountNumber = accountNumber;
            this.routingNumber = routingNumber;
            this.usersId = usersId;
            this.status = status;
            this.isSavings = isSavings;
            this.isPersonalAcct = isPersonalAcct;
        }
    }
}
