package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.CustomerContactCreateRequestParams;
import com.bill.java.api.param.CustomerContactGetRequestParams;
import com.bill.java.api.param.CustomerContactUpdateRequestParams;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

/**
 * Represents a point of contact for a customer
 */
public class CustomerContact extends ApiResource {
    /* Resource endpoints for everything related to contacts for a customer */
    public static final String CREATE_URL = "/Crud/Create/CustomerContact.json";
    public static final String READ_URL = "/Crud/Read/CustomerContact.json";
    public static final String UPDATE_URL = "/Crud/Update/CustomerContact.json";
    public static final String DELETE_URL = "/Crud/Delete/CustomerContact.json";
    public static final String UNDELETE_URL = "/Crud/Undelete/CustomerContact.json";

    /** CustomerContact */
    @Getter
    @Setter
    @SerializedName("entity")
    private String entity;

    /** System generated Unique Identifier */
    @Getter
    @SerializedName("id")
    private String id;

    /**
     * Denotes if the contact is active
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
     */
    @Getter
    @SerializedName("createdTime")
    private String createdTime;

    /**
     * Timestamp when this record was last updated in Bill.com
     */
    @Getter
    @SerializedName("updatedTime")
    private String updatedTime;

    /** ID of the Customer this contact is for */
    @Getter
    @Setter
    @SerializedName("customerId")
    private String customerId;

    /** First name of the contact */
    @Getter
    @Setter
    @SerializedName("firstName")
    private String firstName;

    /** Last name of the contact */
    @Getter
    @Setter
    @SerializedName("lastName")
    private String lastName;

    /** Email of the contact */
    @Getter
    @Setter
    @SerializedName("email")
    private String email;

    /** Phone number for the contact */
    @Getter
    @Setter
    @SerializedName("phone")
    private String phone;

    /** Alternate phone number for the contact */
    @Getter
    @Setter
    @SerializedName("altPhone")
    private String altPhone;

    /** Fax number for the contact */
    @Getter
    @Setter
    @SerializedName("fax")
    private String fax;

    /** The time zone of the contact
     * <p>
     * "3" - PST
     * "4" - MST
     * "5" - CST
     * "6" - EST
     */
    @Getter
    @Setter
    @SerializedName("timezoneId")
    private String timezoneId;

    /**
     * Creates a customerContact in BDC
     *
     * @param customerContactCreateRequestParams data for CustomerContact creation
     * @return the CustomerContact that has been created through the BDC API
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static CustomerContact create(CustomerContactCreateRequestParams customerContactCreateRequestParams) throws BDCException, IOException {
        if(customerContactCreateRequestParams == null) {
            throw new NullPointerException("CustomerContactCreateRequestParams required");
        }
        return create(CREATE_URL, customerContactCreateRequestParams, CustomerContact.class);
    }

    /**
     * Retrives a customerContact from the BDC
     *
     * @param customerContactGetRequestParams data for CustomerContact read request
     * @return the CustomerContact specified in the request
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static CustomerContact get(CustomerContactGetRequestParams customerContactGetRequestParams) throws BDCException, IOException {
        if(customerContactGetRequestParams == null) {
            throw new NullPointerException("CustomerContactGetRequestParams required");
        }
        return create(READ_URL, customerContactGetRequestParams, CustomerContact.class);
    }

    /**
     * Updates a customerContact in the BDC database
     *
     * @param customerContactUpdateRequestparams data for CustomerContact update request
     * @return the CustomerContact specified in the request
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static CustomerContact update(CustomerContactUpdateRequestParams customerContactUpdateRequestparams) throws BDCException, IOException {
        if(customerContactUpdateRequestparams == null) {
            throw new NullPointerException("CustomerContactUpdateRequestParams required");
        }
        return create(UPDATE_URL, customerContactUpdateRequestparams, CustomerContact.class);
    }

    /**
     * Updates a customerContact in the BDC database
     *
     * @param customerContact CustomerContact object to be updated to the BDC database
     * @return the CustomerContact specified in the request
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static CustomerContact update(CustomerContact customerContact) throws BDCException, IOException {
        if(customerContact == null) {
            throw new NullPointerException("CustomerContact required");
        }
        return create(UPDATE_URL, customerContact, CustomerContact.class);
    }
}
