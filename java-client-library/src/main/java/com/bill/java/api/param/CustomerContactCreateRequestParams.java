package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

public class CustomerContactCreateRequestParams extends ApiResourceParams {
    /** Holds the actual api resource variables for creation */
    @SerializedName("obj")
    protected Params params;

    private CustomerContactCreateRequestParams(Params params) { this.params = params; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        public String isActive;
        public String customerId;
        public String firstName;
        public String lastName;
        public String email;
        public String phone;
        public String altPhone;
        public String fax;
        public String timezoneId;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

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
