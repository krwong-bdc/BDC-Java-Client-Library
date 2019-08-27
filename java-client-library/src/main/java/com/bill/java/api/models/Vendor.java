package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.VendorCreateRequestParams;
import com.bill.java.api.param.VendorGetRequestParams;
import com.bill.java.api.param.VendorUpdateRequestParams;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;

/**
 * Represents a Vendor in the User's network
 */
public class Vendor extends ApiResource {
    /* Resource endpoints for everything vendor related */
    public static final String CREATE_URL = "/Crud/Create/Vendor.json";
    public static final String READ_URL = "/Crud/Read/Vendor.json";
    public static final String UPDATE_URL = "/Crud/Update/Vendor.json";
    public static final String DELETE_URL = "/Crud/Delete/Vendor.json";
    public static final String UNDELETE_URL = "/Crud/Undelete/Vendor.json";

    /* All retrievable attributes of a Vendor */
    @SerializedName("entity")
    private String entity;

    @SerializedName("id")
    private String id;

    @SerializedName("isActive")
    private String isActive;

    @SerializedName("name")
    private String name;

    @SerializedName("shortName")
    private String shortName;

    @SerializedName("nameOnCheck")
    private String nameOnCheck;

    @SerializedName("companyName")
    private String companyName;

    @SerializedName("accNumber")
    private String accNumber;

    @SerializedName("taxId")
    private String taxId;

    @SerializedName("track1099")
    private Boolean track1099;

    @SerializedName("address1")
    private String address1;

    @SerializedName("address2")
    private String address2;

    @SerializedName("address3")
    private String address3;

    @SerializedName("address4")
    private String address4;

    @SerializedName("addressCity")
    private String addressCity;

    @SerializedName("addressState")
    private String addressState;

    @SerializedName("addressZip")
    private String addressZip;

    @SerializedName("addressCountry")
    private String addressCountry;

    @SerializedName("email")
    private String email;

    @SerializedName("fax")
    private String fax;

    @SerializedName("phone")
    private String phone;

    @SerializedName("payBy")
    private String payBy;

    @SerializedName("paymentEmail")
    private String paymentEmail;

    @SerializedName("paymentPhone")
    private String paymentPhone;

    @SerializedName("description")
    private String description;

    @SerializedName("createdTime")
    private String createdTime;

    @SerializedName("updatedTime")
    private String updatedTime;

    @SerializedName("contactFirstName")
    private String contactFirstName;

    @SerializedName("contactLastName")
    private String contactLastName;

    @SerializedName("mergedIntoId")
    private String mergedIntoId;

    @SerializedName("accountType")
    private String accountType;

    /**
     * Creates a vendor in BDC
     *
     * @param vendorCreateRequestParams data for Vendor creation
     * @return the Vendor that has been created through the BDC API
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static Vendor create(VendorCreateRequestParams vendorCreateRequestParams) throws BDCException, IOException {
        if(vendorCreateRequestParams == null) {
            throw new NullPointerException("VendorCreateRequestParams required");
        }
        return create(CREATE_URL, vendorCreateRequestParams, Vendor.class);
    }

    /**
     * Retrives a vendor from the BDC
     *
     * @param vendorGetRequestParams data for Vendor read request
     * @return the Vendor specified in the request
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static Vendor get(VendorGetRequestParams vendorGetRequestParams) throws BDCException, IOException {
        if(vendorGetRequestParams == null) {
            throw new NullPointerException("VendorCreateRequestParams required");
        }
        return create(READ_URL, vendorGetRequestParams, Vendor.class);
    }

    /**
     * Updates a vendor in the BDC database
     *
     * @param vendorUpdateRequestparams data for Vendor read request
     * @return the Vendor specified in the request
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static Vendor update(VendorUpdateRequestParams vendorUpdateRequestparams) throws BDCException, IOException {
        if(vendorUpdateRequestparams == null) {
            throw new NullPointerException("VendorCreateRequestParams required");
        }
        return create(UPDATE_URL, vendorUpdateRequestparams, Vendor.class);
    }

    /* Getter-Setter methods for Vendor member variables */
    public String getEntity() {
        return entity;
    }

    public String getId() {
        return id;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getNameOnCheck() {
        return nameOnCheck;
    }

    public void setNameOnCheck(String nameOnCheck) {
        this.nameOnCheck = nameOnCheck;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Boolean getTrack1099() {
        return track1099;
    }

    public void setTrack1099(Boolean track1099) {
        this.track1099 = track1099;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressZip() {
        return addressZip;
    }

    public void setAddressZip(String addressZip) {
        this.addressZip = addressZip;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPayBy() {
        return payBy;
    }

    public void setPayBy(String payBy) {
        this.payBy = payBy;
    }

    public String getPaymentEmail() {
        return paymentEmail;
    }

    public void setPaymentEmail(String paymentEmail) {
        this.paymentEmail = paymentEmail;
    }

    public String getPaymentPhone() {
        return paymentPhone;
    }

    public void setPaymentPhone(String paymentPhone) {
        this.paymentPhone = paymentPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getMergedIntoId() {
        return mergedIntoId;
    }

    public void setMergedIntoId(String mergedIntoId) {
        this.mergedIntoId = mergedIntoId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
