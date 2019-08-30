package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.CustomerCreateRequestParams;
import com.bill.java.api.param.CustomerGetRequestParams;
import com.bill.java.api.param.CustomerSetAuthorizationRequestParams;
import com.bill.java.api.param.CustomerUpdateRequestParams;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

/**
 * Represents a Customer in the User's network
 */
public class Customer extends ApiResource {
    /* Resource endpoints for everything vendor related */
    /** The URI for creating a Customer through the BDC API {@value #CREATE_URL} */
    public static final String CREATE_URL = "/Crud/Create/Customer.json";

    /** The URI for retrieving a Customer through the BDC API {@value #READ_URL} */
    public static final String READ_URL = "/Crud/Read/Customer.json";

    /** The URI for updating a Customer through the BDC API {@value #UPDATE_URL} */
    public static final String UPDATE_URL = "/Crud/Update/Customer.json";

    /** The URI for disabling a Customer through the BDC API {@value #DELETE_URL} */
    public static final String DELETE_URL = "/Crud/Delete/Customer.json";

    /** The URI for undisabling a Customer through the BDC API {@value #UNDELETE_URL} */
    public static final String UNDELETE_URL = "/Crud/Undelete/Customer.json";

    /** The URI for setting a Customer's consent to charge through the BDC API {@value #SET_AUTHORIZATION_URL} */
    public static final String SET_AUTHORIZATION_URL = "/SetCustomerAuthorization.json";

    /* All retrievable attributes of a Customer */
    /** Customer */
    @Getter
    @SerializedName("entity")
    private String entity;

    /**
     * System generated Unique Identifier
     * <p>
     * It is used to retrieve and refer the object in subsequent API calls. You can filter by this field on the List call
     */
    @Getter
    @SerializedName("id")
    private String id;

    /**
     * Denotes if a Customer is active or inactive
     * <p>
     * "1" - Active
     * "2" - Inactive
     */
    @Getter
    @Setter
    @SerializedName("isActive")
    private String isActive;

    /**
     * Timestamp when this record was created in Bill.com
     * <p>
     * Filterable through the List call
     */
    @Getter
    @SerializedName("createdTime")
    private String createdTime;

    /**
     * Timestamp when this recorcd was last updated in Bill.com.
     * <p>
     * Filterable through the List call
     */
    @Getter
    @SerializedName("updatedTime")
    private String updatedTime;

    /** Name of Customer
     * <p>
     * Displayed in lists.
     * You can filter by this field on the List call
     */
    @Getter
    @Setter
    @SerializedName("name")
    private String name;

    /** User-friendly identifer defined by user and/or third-party system */
    @Getter
    @Setter
    @SerializedName("shortName")
    private String shortName;

    /** ID of parent object (denotes this object as child object). You can filter by this field on the List call */
    @Getter
    @Setter
    @SerializedName("parentCustomerId")
    private String parentCustomerId;

    /** Full name of the customer's company */
    @Getter
    @Setter
    @SerializedName("companyName")
    private String companyName;

    /** Primary contact's first name */
    @Getter
    @Setter
    @SerializedName("contactFirstName")
    private String contactFirstName;

    /** Primary contact's last name */
    @Getter
    @Setter
    @SerializedName("contactLastName")
    private String contactLastName;

    /**
     * Optional identification of the customer's account
     * <p>Visible in the invoice and on the customer portal home page
     */
    @Getter
    @Setter
    @SerializedName("accNumber")
    private String accNumber;

    /** Billing address line */
    @Getter
    @Setter
    @SerializedName("billAddress1")
    private String billAddress1;

    /** Additional billing address line */
    @Getter
    @Setter
    @SerializedName("billAddress2")
    private String billAddress2;

    /** Additional billing address line */
    @Getter
    @Setter
    @SerializedName("billAddress3")
    private String billAddress3;

    /** Additional billing address line */
    @Getter
    @Setter
    @SerializedName("billAddress4")
    private String billAddress4;

    /** Billing address city */
    @Getter
    @Setter
    @SerializedName("billAddressCity")
    private String billAddressCity;

    /** Billing address state */
    @Getter
    @Setter
    @SerializedName("billAddressState")
    private String billAddressState;

    /** Billing address country */
    @Getter
    @Setter
    @SerializedName("billAddressCountry")
    private String billAddressCountry;

    /** Billing address zip */
    @Getter
    @Setter
    @SerializedName("billAddressZip")
    private String billAddressZip;

    /** Shipping address */
    @Getter
    @Setter
    @SerializedName("shipAddress1")
    private String shipAddress1;

    /** Additional shipping address line */
    @Getter
    @Setter
    @SerializedName("shipAddress2")
    private String shipAddress2;

    /** Additional shipping address line */
    @Getter
    @Setter
    @SerializedName("shipAddress3")
    private String shipAddress3;

    /** Additional shipping address line */
    @Getter
    @Setter
    @SerializedName("shipAddress4")
    private String shipAddress4;

    /** Shipping address city */
    @Getter
    @Setter
    @SerializedName("shipAddressCity")
    private String shipAddressCity;

    /** Shipping address state */
    @Getter
    @Setter
    @SerializedName("shipAddressState")
    private String shipAddressState;

    /** Shipping address country */
    @Getter
    @Setter
    @SerializedName("shipAddressCountry")
    private String shipAddressCountry;

    /** Shipping address zip */
    @Getter
    @Setter
    @SerializedName("shipAddressZip")
    private String shipAddressZip;

    /** Customer's email */
    @Getter
    @Setter
    @SerializedName("email")
    private String email;

    /** Main phone number for the customer */
    @Getter
    @Setter
    @SerializedName("phone")
    private String phone;

    /** Alternate phone number for the customer */
    @Getter
    @Setter
    @SerializedName("altPhone")
    private String altPhone;

    /** Fax number for the Customer */
    @Getter
    @Setter
    @SerializedName("fax")
    private String fax;

    /** Description set to the customer */
    @Getter
    @Setter
    @SerializedName("description")
    private String description;

    /**  */
    @Getter
    @Setter
    @SerializedName("printAs")
    private String printAs;

    /** A CustomerId that this object got merged into */
    @Getter
    @Setter
    @SerializedName("mergedIntoId")
    private String mergedIntoId;

    /** Customer has authorized user to charge their bank account. Must be set using {@link #setAuthorization(CustomerSetAuthorizationRequestParams)} */
    @Getter
    @SerializedName("hasAuthorizedToCharge")
    private Boolean hasAuthorizedToCharge;

    /**
     * Type of Customer account
     * <p>
     * "0" - none
     * "1" - business
     * "2" - person
     */
    @Getter
    @Setter
    @SerializedName("accountType")
    private String accountType;


    /**
     * Creates a customer in BDC
     *
     * @param customerCreateRequestParams data for Vendor creation
     * @return the Customer that has been created through the BDC API
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static Customer create(CustomerCreateRequestParams customerCreateRequestParams) throws BDCException, IOException {
        if(customerCreateRequestParams == null) {
            throw new NullPointerException("CustomerCreateRequestParams required");
        }
        return create(CREATE_URL, customerCreateRequestParams, Customer.class);
    }

    /**
     * Retrieves a customer from the BDC
     *
     * @param customerGetRequestParams data for Customer read request
     * @return the Customer specified in the request
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static Customer get(CustomerGetRequestParams customerGetRequestParams) throws BDCException, IOException {
        if(customerGetRequestParams == null) {
            throw new NullPointerException("CustomerGetRequestParams required");
        }
        return create(READ_URL, customerGetRequestParams, Customer.class);
    }

    /**
     * Updates a customer in the BDC database
     *
     * @param customerUpdateRequestparams data for Customer update request
     * @return the Customer specified in the request
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static Customer update(CustomerUpdateRequestParams customerUpdateRequestparams) throws BDCException, IOException {
        if(customerUpdateRequestparams == null) {
            throw new NullPointerException("CustomerUpdateRequestParams required");
        }
        return create(UPDATE_URL, customerUpdateRequestparams, Customer.class);
    }

    /**
     * Updates a customer in the BDC database
     *
     * @param customer Customer object to be updated to the BDC database
     * @return the Customer specified in the request
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static Customer update(Customer customer) throws BDCException, IOException {
        if(customer == null) {
            throw new NullPointerException("Customer required");
        }
        return create(UPDATE_URL, customer, Customer.class);
    }

    /**
     * Set customer Authorization in the BDC database
     *
     * @param customerSetAuthorizationRequestParams
     * @return the Customer specified in the request
     * @throws BDCException
     * @throws IOException
     */
    public static Customer setAuthorization(CustomerSetAuthorizationRequestParams customerSetAuthorizationRequestParams) throws BDCException, IOException {
        if(customerSetAuthorizationRequestParams == null) {
            throw new NullPointerException("CustomerSetAuthorizationRequestParams required");
        }
        return create(SET_AUTHORIZATION_URL, customerSetAuthorizationRequestParams, Customer.class);
    }
}
