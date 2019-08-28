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
    public static final String CREATE_URL = "/Crud/Create/Customer.json";
    public static final String READ_URL = "/Crud/Read/Customer.json";
    public static final String UPDATE_URL = "/Crud/Update/Customer.json";
    public static final String DELETE_URL = "/Crud/Delete/Customer.json";
    public static final String UNDELETE_URL = "/Crud/Undelete/Customer.json";
    public static final String SET_AUTHORIZATION_URL = "/SetCustomerAuthorization.json";

    @Getter
    @SerializedName("entity")
    private String entity;

    @Getter
    @SerializedName("id")
    private String id;

    @Getter
    @Setter
    @SerializedName("isActive")
    private String isActive;

    @Getter
    @SerializedName("createdTime")
    private String createdTime;

    @Getter
    @SerializedName("updatedTime")
    private String updatedTime;

    @Getter
    @Setter
    @SerializedName("name")
    private String name;

    @Getter
    @Setter
    @SerializedName("shortName")
    private String shortName;

    @Getter
    @Setter
    @SerializedName("parentCustomerId")
    private String parentCustomerId;

    @Getter
    @Setter
    @SerializedName("companyName")
    private String companyName;

    @Getter
    @Setter
    @SerializedName("contactFirstName")
    private String contactFirstName;

    @Getter
    @Setter
    @SerializedName("contactLastName")
    private String contactLastName;

    @Getter
    @Setter
    @SerializedName("accNumber")
    private String accNumber;

    @Getter
    @Setter
    @SerializedName("billAddress1")
    private String billAddress1;

    @Getter
    @Setter
    @SerializedName("billAddress2")
    private String billAddress2;

    @Getter
    @Setter
    @SerializedName("billAddress3")
    private String billAddress3;

    @Getter
    @Setter
    @SerializedName("billAddress4")
    private String billAddress4;

    @Getter
    @Setter
    @SerializedName("billAddressCity")
    private String billAddressCity;

    @Getter
    @Setter
    @SerializedName("billAddressState")
    private String billAddressState;

    @Getter
    @Setter
    @SerializedName("billAddressCountry")
    private String billAddressCountry;

    @Getter
    @Setter
    @SerializedName("billAddressZip")
    private String billAddressZip;

    @Getter
    @Setter
    @SerializedName("shipAddress1")
    private String shipAddress1;

    @Getter
    @Setter
    @SerializedName("shipAddress2")
    private String shipAddress2;

    @Getter
    @Setter
    @SerializedName("shipAddress3")
    private String shipAddress3;

    @Getter
    @Setter
    @SerializedName("shipAddress4")
    private String shipAddress4;

    @Getter
    @Setter
    @SerializedName("shipAddressCity")
    private String shipAddressCity;

    @Getter
    @Setter
    @SerializedName("shipAddressState")
    private String shipAddressState;

    @Getter
    @Setter
    @SerializedName("shipAddressCountry")
    private String shipAddressCountry;

    @Getter
    @Setter
    @SerializedName("shipAddressZip")
    private String shipAddressZip;

    @Getter
    @Setter
    @SerializedName("email")
    private String email;

    @Getter
    @Setter
    @SerializedName("phone")
    private String phone;

    @Getter
    @Setter
    @SerializedName("altPhone")
    private String altPhone;

    @Getter
    @Setter
    @SerializedName("fax")
    private String fax;

    @Getter
    @Setter
    @SerializedName("description")
    private String description;

    @Getter
    @Setter
    @SerializedName("printAs")
    private String printAs;

    @Getter
    @Setter
    @SerializedName("mergedIntoId")
    private String mergedIntoId;

    /**
     * Customer has authorized user to charge their bank account. Must be set using {@link #setAuthorization(CustomerSetAuthorizationRequestParams)}
     */
    @Getter
    @SerializedName("hasAuthorizedToCharge")
    private Boolean hasAuthorizedToCharge;

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
