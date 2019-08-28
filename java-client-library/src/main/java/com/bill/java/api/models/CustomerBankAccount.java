package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.CustomerBankAccountCreateRequestParams;
import com.bill.java.api.param.CustomerBankAccountGetRequestParams;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.io.IOException;

public class CustomerBankAccount extends ApiResource {
    /* Resource endpoints for everything related to Customer Bank Accounts */
    public static final String CREATE_URL = "/Crud/Create/CustomerBankAccount.json";
    public static final String READ_URL = "/Crud/Read/CustomerBankAccount.json";
    public static final String DELETE_URL = "/Crud/Delete/CustomerBankAccount.json";

    /* All retrievable attributes of a CustomerBankAccount */
    @Getter
    @SerializedName("entity")
    private String entity;

    @Getter
    @SerializedName("id")
    private String id;

    @Getter
    @SerializedName("isActive")
    private String isActive;

    @Getter
    @SerializedName("createdTime")
    private String createdTime;

    @Getter
    @SerializedName("updatedTime")
    private String updatedTime;

    @Getter
    @SerializedName("customerId")
    private String customerId;

    @Getter
    @SerializedName("nameOnAccount")
    private String nameOnAccount;

    @Getter
    @SerializedName("nickname")
    private String nickname;

    @Getter
    @SerializedName("routingNumber")
    private String routingNumber;

    @Getter
    @SerializedName("accountNumber")
    private String accountNumber;

    @Getter
    @SerializedName("isLockedByOrg")
    private Boolean isLockedByOrg;

    @Getter
    @SerializedName("isSavings")
    private Boolean isSavings;

    @Getter
    @SerializedName("isPersonalAcct")
    private Boolean isPersonalAcct;

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
