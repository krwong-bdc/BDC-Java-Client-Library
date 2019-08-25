package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.VendorBankAcccountGetRequestParams;
import com.bill.java.api.param.VendorBankAccountCreateRequestParams;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;

public class VendorBankAccount extends ApiResource {
    /** Resource endpoints for everything vendor bank account related */
    public static final String CREATE_URL = "/Crud/Create/VendorBankAccount.json";
    public static final String READ_URL = "/Crud/Read/VendorBankAccount.json";
    public static final String DELETE_URL = "/Crud/Delete/VendorBankAccount.json";

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

    public static VendorBankAccount get(VendorBankAcccountGetRequestParams vendorBankAcccountGetRequestParams) throws BDCException, IOException {
        if(vendorBankAcccountGetRequestParams == null) {
            throw new NullPointerException("VendorCreateRequestParams required");
        }
        return create(READ_URL, vendorBankAcccountGetRequestParams, VendorBankAccount.class);
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getSavings() {
        return isSavings;
    }

    public void setSavings(Boolean savings) {
        isSavings = savings;
    }

    public Boolean getPersonalAcct() {
        return isPersonalAcct;
    }

    public void setPersonalAcct(Boolean personalAcct) {
        isPersonalAcct = personalAcct;
    }
}
