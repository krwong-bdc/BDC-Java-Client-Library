package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.ReceivedPayGetRequestParams;
import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Details on invoice receipts received through Bill.com (UI or API).
 */
@Getter
public class ReceivedPay extends ApiResource {
    /* Resource endpoints for everything vendor related */
    /** The URI for retrieving a ReceivedPay through the BDC API {@value} */
    public static final String READ_URL = "/Crud/Read/ReceivedPay.json";

    /* All retrievable attributes of a Customer */
    /** "ReceivedPay" */
    @SerializedName("entity")
    private String entity;

    /**
     * System generated Unique Identifier. It is used to retrieve and refer the object in subsequent API calls. You can filter by this field on the List call.
     */
    @SerializedName("id")
    private String id;

    /**
     * Timestamp when this record was created in Bill.com. You can filter by this field on the List call.
     */
    @SerializedName("createdTime")
    private String createdTime;

    /**
     * Timestamp when this record was last updated in Bill.com. You can filter by this field on the List call.
     */
    @SerializedName("updatedTime")
    private String updatedTime;

    /**
     * Id of the customer that made the payment. You can filter by this field on the List call.
     */
    @SerializedName("customerId")
    private String customerId;

    /**
     * Status of the payment received. You can filter by this field on the List call.
     * <p>
     * "0" - Paid
     * "1" - Void
     * "2" - Scheduled
     * "3" - Canceled
     * "4" - Escheated
     */
    @SerializedName("status")
    private String status;

    /**
     * Date on which the payment was processed or recorded. You can filter by this field on the List call.
     */
    @SerializedName("paymentDate")
    private String paymentDate;

    /**
     * Chart of Account that payment is posted to. You can filter by this field on the List call.
     */
    @SerializedName("depositToAccountId")
    private String depositToAccountId;

    /**
     * Flag indicating whether the payment is received through Bill.com
     */
    @SerializedName("isOnline")
    private Boolean isOnline;

    /**
     * Enum representing the type of the payment. Offline Payments - user-defined and updateable; Online Payments - automatically defined and read only. You can filter by this field on the List call.
     * <p>
     * "0" - Cash
     * "1" - Check
     * "2" - CreditCard
     * "3" - ACH
     * "4" - PayPal
     * "5" - Other
     */
    @SerializedName("paymentType")
    private String paymentType;

    /**
     * 	Payment amount
     */
    @SerializedName("amount")
    private BigDecimal amount;

    /**
     * 	Un-applied Payment amount
     */
    @SerializedName("unappliedAmount")
    private BigDecimal unappliedAmount;

    /**
     * Memo to identify the payment. Automatically generated for Bill.com payments, user defined for payments made outside Bill.com.
     */
    @SerializedName("description")
    private String description;

    /**
     * Reference to identify the payment (e.g. check number). User-defined for payments received outside of Bill.com (manually entered) or automatically generated for Bill.com Payments.
     */
    @SerializedName("refNumber")
    private String refNumber;

    /**
     * Convenience fee charged to the customer. You can filter by this field on the List call.
     */
    @SerializedName("convFeeAmount")
    private BigDecimal convFeeAmount;

    /**
     * Bank Account that the payment is deposited to. Only relevant for Bill.com payments. You can filter by this field on the List call.
     */
    @SerializedName("payToBankAccountId")
    private String payToBankAccountId;

    /**
     * List of convenience fees charged to the customer
     */
    @SerializedName("rPConvFee")
    private List<RPConvFee> rPConvFees;

    /**
     * List of Invoices this payment is being applied to
     */
    @SerializedName("invoicePays")
    private List<InvoicePay> invoicePays;

    /**
     * This returns details on invoice receipts received through Bill.com (UI or API). Receipts are tracked with RecordARPayment . If needed, it can be canceled with VoidARPayment. When properly authorized, ChargeCustomer can be used.
     *<p>
     * Received payments can be applied against Invoices or unapplied (the amount becomes a credit to be used on open invoices).
     *
     * The Response can contain zero or more InvoicePays (array of InvoicePay objects) applied against invoices.
     *
     * @param receivedPayGetRequestParams data for ReceivedPay read request
     * @return                        the Invoice specified in the request
     * @throws BDCException           when the response from the API is unsuccessful
     * @throws IOException            when an I/O exception occurs on the underlying request
     */
    public static ReceivedPay get(ReceivedPayGetRequestParams receivedPayGetRequestParams) throws BDCException, IOException {
        if(receivedPayGetRequestParams == null) {
            throw new NullPointerException("ReceivedPayGetRequestParams required");
        }
        return create(READ_URL, receivedPayGetRequestParams, ReceivedPay.class);
    }

    /* Needed to nest the response from the ChargeCustomer endpoint */
    @Getter
    public static class ChargedReceivedPay {
        @SerializedName("chargedReceivedPay")
        private ReceivedPay receivedPay;
    }
}
