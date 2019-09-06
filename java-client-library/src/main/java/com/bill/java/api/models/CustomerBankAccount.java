package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.CustomerBankAccountCreateRequestParams;
import com.bill.java.api.param.CustomerBankAccountGetRequestParams;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.io.IOException;

/**
 * Represents a bank account belonging to a customer
 */
public class CustomerBankAccount extends ApiResource {
    /* Resource endpoints for everything related to Customer Bank Accounts */
    public static final String CREATE_URL = "/Crud/Create/CustomerBankAccount.json";
    public static final String READ_URL = "/Crud/Read/CustomerBankAccount.json";
    public static final String DELETE_URL = "/Crud/Delete/CustomerBankAccount.json";

    /* All retrievable attributes of a CustomerBankAccount */
    /** CustomerBankAccount */
    @Getter
    @SerializedName("entity")
    private String entity;

    /**
     * System generated Unique Identifier
     * <p>
     * It is used to retrieve and refer the object in subsequent API calls
     */
    @Getter
    @SerializedName("id")
    private String id;

    /**
     * Denotes if bank account is active or inactive
     * <p>
     * "1" - Active
     * "2" - Inactive
     */
    @Getter
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
     * Timestamp when this record was last updated in Bill.com
     * <p>
     * Filterable through the List call
     */
    @Getter
    @SerializedName("updatedTime")
    private String updatedTime;

    /** Id of the customer this bank account if for */
    @Getter
    @SerializedName("customerId")
    private String customerId;

    /** Name of individual on the account */
    @Getter
    @SerializedName("nameOnAccount")
    private String nameOnAccount;

    /** Alternate name of individual on the account */
    @Getter
    @SerializedName("nickname")
    private String nickname;

    /** Routing number of the bank account */
    @Getter
    @SerializedName("routingNumber")
    private String routingNumber;

    /** Account number of the bank account */
    @Getter
    @SerializedName("accountNumber")
    private String accountNumber;

    /** Denotes whether the bank account can be edited or deleted
     * <p>
     * Edits must be done through the Bill.com portal
     */
    @Getter
    @SerializedName("isLockedByOrg")
    private Boolean isLockedByOrg;

    /** Denotes whether the bank account is a savings account */
    @Getter
    @SerializedName("isSavings")
    private Boolean isSavings;

    /** Denotes whether the bank account is a personal account */
    @Getter
    @SerializedName("isPersonalAcct")
    private Boolean isPersonalAcct;

    /**  */
    @Getter
    @SerializedName("isWrittenAuth")
    private Boolean isWrittenAuth;

    /**
     * Creates a customerBankAccount in BDC
     *
     * @param customerBankAccountCreateRequestParams data for CustomerBankAccount creation
     * @return the CustomerBankAccount that has been created through the BDC API
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static CustomerBankAccount create(CustomerBankAccountCreateRequestParams customerBankAccountCreateRequestParams) throws BDCException, IOException {
        if(customerBankAccountCreateRequestParams == null) {
            throw new NullPointerException("CustomerBankAccountCreateRequestParams required");
        }
        return create(CREATE_URL, customerBankAccountCreateRequestParams, CustomerBankAccount.class);
    }

    /**
     * Retrieves a customerBankAccount from the BDC
     *
     * @param customerBankAccountGetRequestParams data for CustomerBankAccount read request
     * @return the CustomerBankAccount specified in the request
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static CustomerBankAccount get(CustomerBankAccountGetRequestParams customerBankAccountGetRequestParams) throws BDCException, IOException {
        if(customerBankAccountGetRequestParams == null) {
            throw new NullPointerException("CustomerBankAccountGetRequestParams required");
        }
        return create(READ_URL, customerBankAccountGetRequestParams, CustomerBankAccount.class);
    }
}
