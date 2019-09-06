package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters for creating a CustomerBankAccount
 */
public class CustomerBankAccountCreateRequestParams extends ApiResourceParams {
    /* Holds the actual api resource variables for creation */
    @SerializedName("obj")
    protected final Params params;

    @SerializedName("agreedWithTOS")
    private final Boolean agreedWithTOS;

    private CustomerBankAccountCreateRequestParams(Params params, Boolean agreedWithTOS) {
        this.params = params;
        this.agreedWithTOS = agreedWithTOS;
    }

    /**
     * Makes a new Builder for CustomerBankAccountCreateRequestParams
     *
     * @return a builder for CustomerBankAccountCreateRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds a CustomerBankAccountCreateRequestParams instance
     */
    public static class Builder {
        /**
         * Denotes if bank account is active or inactive
         * <p>
         * "1" - Active
         * "2" - Inactive
         */
        public String isActive;

        /** Id of the customer this bank account if for */
        public String customerId;

        /** Name of individual on the account */
        public String nameOnAccount;

        /** Alternate name of individual on the account */
        public String nickname;

        /** Routing number of the bank account */
        public String routingNumber;

        /** Account number of the bank account */
        public String accountNumber;

        /** Denotes whether the bank account can be edited or deleted
         * <p>
         * Edits must be done through the Bill.com portal
         */
        public Boolean isLockedByOrg;

        /** Denotes whether the bank account is a savings account */
        public Boolean isSavings;

        /** Denotes whether the bank account is a personal account */
        public Boolean isPersonalAcct;

        /** */
        public Boolean isWrittenAuth;

        /** Customer has been presented with the Terms of Service and have submitted their agreement */
        public Boolean agreedWithTOS;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a CustomerBankAccountCreateRequestParams instance with the set parameters
         *
         * @return CustomerBankAccountCreateRequestParams
         */
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
