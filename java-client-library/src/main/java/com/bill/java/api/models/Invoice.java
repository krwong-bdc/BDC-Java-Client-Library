package com.bill.java.api.models;

import com.bill.java.api.BDC;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.InvoiceCreateParams;
import com.google.gson.annotations.SerializedName;


public class Invoice extends ApiResource {
// TODO: Serialize variable names to match what they are in the API (also may protect user when they obfuscate code)
// Do member variables need to be public in order for GSON to deserialize?
//    Stripe lets everything be package-private

    @SerializedName("entity")
    private String entity = "Invoice";

    @SerializedName("customerId")
    private String customerId;

    @SerializedName("invoiceNumber")
    private String invoiceNumber;

    @SerializedName("invoiceDate")
    private String invoiceDate;

    @SerializedName("dueDate")
    private String dueDate;

    /**
     * Creates an instance of the Invoice class
     *
     * <p>
     * Delegates work to ApiResource.create()
     * </p>
     *
     * @param params
     * @return Returns an instance of the Invoice class
     */
    public static Invoice create(InvoiceCreateParams params) throws Exception {
        String resourceUrl = BDC.getApiBase() + "/CRUD/create";
        return create(resourceUrl, params, Invoice.class);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
