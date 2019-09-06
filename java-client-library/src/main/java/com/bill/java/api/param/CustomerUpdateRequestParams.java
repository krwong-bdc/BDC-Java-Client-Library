package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters for updating a Customer through the BDC API
 */
public class CustomerUpdateRequestParams extends ApiResourceParams {
    /* Holds the actual api resource variables for creation */
    @SerializedName("obj")
    protected final Params params;

    private CustomerUpdateRequestParams(Params params) { this.params = params; }

    /**
     * Makes a new Builder for CustomerUpdateRequestParams
     *
     * @return a builder for CustomerUpdateRequestParams
     */
    public static Builder builder() { return new Builder(); }

    /**
     * Builds a CustomerUpdateRequestParams instance
     */
    public static class Builder {
        /** BDC-assigned id for the Customer */
        public String id;

        /**
         * Denotes if a Customer is active or inactive
         * <p>
         * "1" - Active
         * "2" - Inactive
         */
        public String isActive;

        /** Name of Customer
         * <p>
         * Displayed in lists.
         * You can filter by this field on the List call
         */
        public String name;

        /** User-friendly identifer defined by user and/or third-party system */
        public String shortName;

        /** ID of parent object (denotes this object as child object). You can filter by this field on the List call */
        public String parentCustomerId;

        /** Full name of the customer's company */
        public String companyName;

        /** Primary contact's first name */
        public String contactFirstName;

        /** Primary contact's last name */
        public String contactLastName;

        /**
         * Optional identification of the customer's account
         * <p>Visible in the invoice and on the customer portal home page
         */
        public String accNumber;

        /** Billing address line */
        public String billAddress1;

        /** Additional billing address line */
        public String billAddress2;

        /** Additional billing address line */
        public String billAddress3;

        /** Additional billing address line */
        public String billAddress4;

        /** Billing address city */
        public String billAddressCity;

        /** Billing address state */
        public String billAddressState;

        /** Billing address country */
        public String billAddressCountry;

        /** Billing address zip */
        public String billAddressZip;

        /** Shipping address */
        public String shipAddress1;

        /** Additional shipping address line */
        public String shipAddress2;

        /** Additional shipping address line */
        public String shipAddress3;

        /** Additional shipping address line */
        public String shipAddress4;

        /** Shipping address city */
        public String shipAddressCity;

        /** Shipping address state */
        public String shipAddressState;

        /** Shipping address Country */
        public String shipAddressCountry;

        /** Shipping address zip */
        public String shipAddressZip;

        /** Customer's email */
        public String email;

        /** Main phone number for the customer */
        public String phone;

        /** Alternate phone number for the customer */
        public String altPhone;

        /** Fax number for the customer */
        public String fax;

        /** User-assigned description of the customer */
        public String description;

        /**  */
        public String printAs;

        /**
         * Type of Customer account
         * <p>
         * "0" - none
         * "1" - business
         * "2" - person
         */
        public String accountType;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a CustomerUpdateRequestParams instance with the set parameters
         *
         * @return CustomerUpdateRequestParams
         */
        public CustomerUpdateRequestParams build() {
            return new CustomerUpdateRequestParams(
                    new Params(
                            id,
                            isActive,
                            name,
                            shortName,
                            parentCustomerId,
                            companyName,
                            contactFirstName,
                            contactLastName,
                            accNumber,
                            billAddress1,
                            billAddress2,
                            billAddress3,
                            billAddress4,
                            billAddressCity,
                            billAddressState,
                            billAddressCountry,
                            billAddressZip,
                            shipAddress1,
                            shipAddress2,
                            shipAddress3,
                            shipAddress4,
                            shipAddressCity,
                            shipAddressState,
                            shipAddressCountry,
                            shipAddressZip,
                            email,
                            phone,
                            altPhone,
                            fax,
                            description,
                            printAs,
                            accountType)
            );
        }
    }

    private static class Params {
        @SerializedName("entity")
        private String entity = "Customer";

        @SerializedName("id")
        private String id;

        @SerializedName("isActive")
        private String isActive;

        @SerializedName("name")
        private String name;

        @SerializedName("shortName")
        private String shortName;

        @SerializedName("parentCustomerId")
        private String parentCustomerId;

        @SerializedName("companyName")
        private String companyName;

        @SerializedName("contactFirstName")
        private String contactFirstName;

        @SerializedName("contactLastName")
        private String contactLastName;

        @SerializedName("accNumber")
        private String accNumber;

        @SerializedName("billAddress1")
        private String billAddress1;

        @SerializedName("billAddress2")
        private String billAddress2;

        @SerializedName("billAddress3")
        private String billAddress3;

        @SerializedName("billAddress4")
        private String billAddress4;

        @SerializedName("billAddressCity")
        private String billAddressCity;

        @SerializedName("billAddressState")
        private String billAddressState;

        @SerializedName("billAddressCountry")
        private String billAddressCountry;

        @SerializedName("billAddressZip")
        private String billAddressZip;

        @SerializedName("shipAddress1")
        private String shipAddress1;

        @SerializedName("shipAddress2")
        private String shipAddress2;

        @SerializedName("shipAddress3")
        private String shipAddress3;

        @SerializedName("shipAddress4")
        private String shipAddress4;

        @SerializedName("shipAddressCity")
        private String shipAddressCity;

        @SerializedName("shipAddressState")
        private String shipAddressState;

        @SerializedName("shipAddressCountry")
        private String shipAddressCountry;

        @SerializedName("shipAddressZip")
        private String shipAddressZip;

        @SerializedName("email")
        private String email;

        @SerializedName("phone")
        private String phone;

        @SerializedName("altPhone")
        private String altPhone;

        @SerializedName("fax")
        private String fax;

        @SerializedName("description")
        private String description;

        @SerializedName("printAs")
        private String printAs;

        @SerializedName("accountType")
        private String accountType;

        Params(String id,
               String isActive,
               String name,
               String shortName,
               String parentCustomerId,
               String companyName,
               String contactFirstName,
               String contactLastName,
               String accNumber,
               String billAddress1,
               String billAddress2,
               String billAddress3,
               String billAddress4,
               String billAddressCity,
               String billAddressState,
               String billAddressCountry,
               String billAddressZip,
               String shipAddress1,
               String shipAddress2,
               String shipAddress3,
               String shipAddress4,
               String shipAddressCity,
               String shipAddressState,
               String shipAddressCountry,
               String shipAddressZip,
               String email,
               String phone,
               String altPhone,
               String fax,
               String description,
               String printAs,
               String accountType) {
            this.id = id;
            this.isActive = isActive;
            this.name = name;
            this.shortName = shortName;
            this.parentCustomerId = parentCustomerId;
            this.companyName = companyName;
            this.contactFirstName = contactFirstName;
            this.contactLastName = contactLastName;
            this.accNumber = accNumber;
            this.billAddress1 = billAddress1;
            this.billAddress2 = billAddress2;
            this.billAddress3 = billAddress3;
            this.billAddress4 = billAddress4;
            this.billAddressCity = billAddressCity;
            this.billAddressState = billAddressState;
            this.billAddressCountry = billAddressCountry;
            this.billAddressZip = billAddressZip;
            this.shipAddress1 = shipAddress1;
            this.shipAddress2 = shipAddress2;
            this.shipAddress3 = shipAddress3;
            this.shipAddress4 = shipAddress4;
            this.shipAddressCity = shipAddressCity;
            this.shipAddressState = shipAddressState;
            this.shipAddressCountry = shipAddressCountry;
            this.shipAddressZip = shipAddressZip;
            this.email = email;
            this.phone = phone;
            this.altPhone = altPhone;
            this.fax = fax;
            this.description = description;
            this.printAs = printAs;
            this.accountType = accountType;
        }
    }
}
