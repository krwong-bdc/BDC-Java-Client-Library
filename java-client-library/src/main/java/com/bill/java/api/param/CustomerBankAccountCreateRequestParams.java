package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

public class CustomerBankAccountCreateRequestParams extends ApiResourceParams {
    /** Holds the actual api resource variables for creation */
    @SerializedName("obj")
    protected Params params;

    @SerializedName("agreedWithTOS")
    private final Boolean agreedWithTOS;

    private CustomerBankAccountCreateRequestParams(Params params, Boolean agreedWithTOS) {
        this.params = params;
        this.agreedWithTOS = agreedWithTOS;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public String isActive;
        public String customerId;
        public String nameOnAccount;
        public String nickname;
        public String routingNumber;
        public String accountNumber;
        public Boolean isLockedByOrg;
        public Boolean isSavings;
        public Boolean isPersonalAcct;
        public Boolean isWrittenAuth;
        public Boolean agreedWithTOS;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public CustomerBankAccountCreateRequestParams build() {
            return new CustomerBankAccountCreateRequestParams(
                    new Params(
                            isActive,
                            customerId,
                            nameOnAccount,
                            nickname,
                            routingNumber,
                            accountNumber,
                            isLockedByOrg,
                            isSavings,
                            isPersonalAcct,
                            isWrittenAuth
                    ), agreedWithTOS);
        }
    }

    private static class Params {
        @SerializedName("entity")
        private final String entity = "CustomerBankAccount";

        @SerializedName("isActive")
        private final String isActive;

        @SerializedName("customerId")
        private final String customerId;

        @SerializedName("nameOnAccount")
        private final String nameOnAccount;

        @SerializedName("nickname")
        private final String nickname;

        @SerializedName("routingNumber")
        private final String routingNumber;

        @SerializedName("accountNumber")
        private final String accountNumber;

        @SerializedName("isLockedByOrg")
        private final Boolean isLockedByOrg;

        @SerializedName("isSavings")
        private final Boolean isSavings;

        @SerializedName("isPersonalAcct")
        private final Boolean isPersonalAcct;

        @SerializedName("isWrittenAuth")
        private final Boolean isWrittenAuth;

        Params(String isActive,
               String customerId,
               String nameOnAccount,
               String nickname,
               String routingNumber,
               String accountNumber,
               Boolean isLockedByOrg,
               Boolean isSavings,
               Boolean isPersonalAcct,
               Boolean isWrittenAuth) {
            this.isActive =  isActive;
            this.customerId =  customerId;
            this.nameOnAccount =  nameOnAccount;
            this.nickname =  nickname;
            this.routingNumber =  routingNumber;
            this.accountNumber =  accountNumber;
            this.isLockedByOrg =  isLockedByOrg;
            this.isSavings =  isSavings;
            this.isPersonalAcct =  isPersonalAcct;
            this.isWrittenAuth = isWrittenAuth;
        }
    }
}
