package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters for creating a Vendor through the BDC API
 */
public class VendorCreateRequestParams extends ApiResourceParams {
    /** Holds the actual api resource variables for creation */
    @SerializedName("obj")
    protected Params params;

    private VendorCreateRequestParams(Params params) {
        this.params = params;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public String isActive;
        public String name;
        public String shortName;
        public String nameOnCheck;
        public String companyName;
        public String accNumber;
        public String taxId;
        public Boolean track1099;
        public String address1;
        public String address2;
        public String address3;
        public String address4;
        public String addressCity;
        public String addressState;
        public String addressZip;
        public String addressCountry;
        public String email;
        public String fax;
        public String phone;
        public String paymentEmail;
        public String paymentPhone;
        public String description;
        public String contactFirstName;
        public String contactLastName;
        public String accountType;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public VendorCreateRequestParams build() {
             return new VendorCreateRequestParams(
                     new Params(
                         isActive,
                         name,
                         shortName,
                         nameOnCheck,
                         companyName,
                         accNumber,
                         taxId,
                         track1099,
                         address1,
                         address2,
                         address3,
                         address4,
                         addressCity,
                         addressState,
                         addressZip,
                         addressCountry,
                         email,
                         fax,
                         phone,
                         paymentEmail,
                         paymentPhone,
                         description,
                         contactFirstName,
                         contactLastName,
                         accountType)
             );
        }
    }

    private static class Params {
        @SerializedName("entity")
        private final String entity = "Vendor";

        @SerializedName("isActive")
        private final String isActive;

        @SerializedName("name")
        private final String name;

        @SerializedName("shortName")
        private final String shortName;

        @SerializedName("nameOnCheck")
        private final String nameOnCheck;

        @SerializedName("companyName")
        private final String companyName;

        @SerializedName("accNumber")
        private final String accNumber;

        @SerializedName("taxId")
        private final String taxId;

        @SerializedName("track1099")
        private final Boolean track1099;

        @SerializedName("address1")
        private final String address1;

        @SerializedName("address2")
        private final String address2;

        @SerializedName("address3")
        private final String address3;

        @SerializedName("address4")
        private final String address4;

        @SerializedName("addressCity")
        private final String addressCity;

        @SerializedName("addressState")
        private final String addressState;

        @SerializedName("addressZip")
        private final String addressZip;

        @SerializedName("addressCountry")
        private final String addressCountry;

        @SerializedName("email")
        private final String email;

        @SerializedName("fax")
        private final String fax;

        @SerializedName("phone")
        private final String phone;

        @SerializedName("paymentEmail")
        private final String paymentEmail;

        @SerializedName("paymentPhone")
        private final String paymentPhone;

        @SerializedName("description")
        private final String description;

        @SerializedName("contactFirstName")
        private final String contactFirstName;

        @SerializedName("contactLastName")
        private final String contactLastName;

        @SerializedName("accountType")
        private final String accountType;

        Params(String isActive,
                      String name,
                      String shortName,
                      String nameOnCheck,
                      String companyName,
                      String accNumber,
                      String taxId,
                      Boolean track1099,
                      String address1,
                      String address2,
                      String address3,
                      String address4,
                      String addressCity,
                      String addressState,
                      String addressZip,
                      String addressCountry,
                      String email,
                      String fax,
                      String phone,
                      String paymentEmail,
                      String paymentPhone,
                      String description,
                      String contactFirstName,
                      String contactLastName,
                      String accountType) {
            this.isActive = isActive;
            this.name = name;
            this.shortName = shortName;
            this.nameOnCheck = nameOnCheck;
            this.companyName = companyName;
            this.accNumber = accNumber;
            this.taxId = taxId;
            this.track1099 = track1099;
            this.address1 = address1;
            this.address2 = address2;
            this.address3 = address3;
            this.address4 = address4;
            this.addressCity = addressCity;
            this.addressState = addressState;
            this.addressZip = addressZip;
            this.addressCountry = addressCountry;
            this.email = email;
            this.fax = fax;
            this.phone = phone;
            this.paymentEmail = paymentEmail;
            this.paymentPhone = paymentPhone;
            this.description = description;
            this.contactFirstName = contactFirstName;
            this.contactLastName = contactLastName;
            this.accountType = accountType;
        }
    }
}
