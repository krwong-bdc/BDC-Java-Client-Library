package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.ListRequestParams;
import com.bill.java.api.param.VendorBankAccountGetRequestParams;
import com.bill.java.api.param.VendorBankAccountCreateRequestParams;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.List;

/**
 * Represents a bank account for a vendor in the user's network
 */
public class VendorBankAccount extends ApiResource {
    /* Resource endpoints for everything vendor bank account related */
    public static final String CREATE_URL = "/Crud/Create/VendorBankAccount.json";
    public static final String READ_URL = "/Crud/Read/VendorBankAccount.json";
    public static final String DELETE_URL = "/Crud/Delete/VendorBankAccount.json";
    /** The URI for getting a list of customers */
    public static final String LIST_VENDOR_BANK_ACCOUNTS_URL = "/List/VendorBankAccount.json";

    /* All retrievable attributes of a Vendor */
    @SerializedName("entity")
    private String entity;

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

    /**
     * Creates a Vendor Bank Account in BDC
     *
     * @param vendorBankAccountCreateRequestParams data for VendorBankAccount creation
     * @return the VendorBankAccount that has been created through the BDC API
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static VendorBankAccount create(VendorBankAccountCreateRequestParams vendorBankAccountCreateRequestParams) throws BDCException, IOException {
        if(vendorBankAccountCreateRequestParams == null) {
            throw new NullPointerException("VendorCreateRequestParams required");
        }
        return create(CREATE_URL, vendorBankAccountCreateRequestParams, VendorBankAccount.class);
    }

    /**
     * Retrives a vendor bank account from the BDC
     *
     * @param vendorBankAcccountGetRequestParams data for Vendor read request
     * @return the Vendor specified in the request
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static VendorBankAccount get(VendorBankAccountGetRequestParams vendorBankAcccountGetRequestParams) throws BDCException, IOException {
        if(vendorBankAcccountGetRequestParams == null) {
            throw new NullPointerException("VendorCreateRequestParams required");
        }
        return create(READ_URL, vendorBankAcccountGetRequestParams, VendorBankAccount.class);
    }

    /**
     * Get a list of vendorBankAccounts
     *
     * @param vendorBankAccountListRequestParams data for request to set authorization
     * @return                          a list of vendorBankAccounts belonging to the account
     * @throws BDCException             when the response from the API is unsuccessful
     * @throws IOException              when an I/O exception occurs on the underlying request
     */
    public static List<VendorBankAccount> list(ListRequestParams vendorBankAccountListRequestParams) throws BDCException, IOException {
        if(vendorBankAccountListRequestParams == null) {
            throw new NullPointerException("VendorBankAccountListRequestParams required");
        }
        return createCollection(LIST_VENDOR_BANK_ACCOUNTS_URL, vendorBankAccountListRequestParams, VendorBankAccount.class);
    }

    /* Getter-Setter methods for VendorBankAccount variables */
    public String getEntity() {
        return entity;
    }

    public String getId() {
        return id;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }
    
    public String getVendorId() {
        return vendorId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public String getUsersId() {
        return usersId;
    }

    public String getStatus() {
        return status;
    }

    public Boolean isSavings() {
        return isSavings;
    }

    public Boolean isPersonalAcct() {
        return isPersonalAcct;
    }
}
