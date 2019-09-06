package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters for creating a CustomerContactCreateRequestParams
 */
public class CustomerContactCreateRequestParams extends ApiResourceParams {
    /* Holds the actual api resource variables for creation */
    @SerializedName("obj")
    protected final Params params;

    private CustomerContactCreateRequestParams(Params params) { this.params = params; }

    /**
     * Makes a new Builder for CustomerContactCreateRequestParams
     *
     * @return a builder for CustomerContactCreateRequestParams
     */
    public static Builder builder() { return new Builder(); }

    /**
     * Builds a CustomerContactCreateRequestParams instance
     */
    public static class Builder {
        /**
         * Denotes if the contact is active
         * <p>
         * "1" - Active
         * "2" - Inactive
         */
        public String isActive;

        /** ID of the Customer this contact is for */
        public String customerId;

        /** First name of the contact */
        public String firstName;

        /** Last name of the contact */
        public String lastName;

        /** Email of the contact */
        public String email;

        /** Phone number for the contact */
        public String phone;

        /** Alternate phone number for the contact */
        public String altPhone;

        /** Fax number for the contact */
        public String fax;

        /** The time zone of the contact
         * <p>
         * "3" - PST
         * "4" - MST
         * "5" - CST
         * "6" - EST
         */
        public String timezoneId;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a CustomerContactCreateRequestParams instance with the set parameters
         *
         * @return CustomerContactCreateRequestParams
         */
        public CustomerContactCreateRequestParams build() {
            return new CustomerContactCreateRequestParams(
                    new Params(
                            isActive,
                            customerId,
                            firstName,
                            lastName,
                            email,
                            phone,
                            altPhone,
                            fax,
                            timezoneId)
            );
        }
    }

    private static class Params {
        @SerializedName("entity")
        private String entity = "CustomerContact";

        @SerializedName("isActive")
        private String isActive;

        @SerializedName("customerId")
        private String customerId;

        @SerializedName("firstName")
        private String firstName;

        @SerializedName("lastName")
        private String lastName;

        @SerializedName("email")
        private String email;

        @SerializedName("phone")
        private String phone;

        @SerializedName("altPhone")
        private String altPhone;

        @SerializedName("fax")
        private String fax;

        @SerializedName("timezoneId")
        private String timezoneId;

        Params(String isActive,
               String customerId,
               String firstName,
               String lastName,
               String email,
               String phone,
               String altPhone,
               String fax,
               String timezoneId) {
            this.isActive = isActive;
            this.customerId = customerId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.altPhone = altPhone;
            this.fax = fax;
            this.timezoneId = timezoneId;
        }
    }
}
