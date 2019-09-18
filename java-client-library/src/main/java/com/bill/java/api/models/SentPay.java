package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.ListRequestParams;
import com.bill.java.api.param.SentPayGetRequestParams;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Getter
public class SentPay extends ApiResource {
    /* Resource endpoints for everything SentPay related */
    /** The URI for retrieving a SentPay through the BDC API {@value} */
    public static final String READ_URL = "/Crud/Read/SentPay.json";

    /** The URI for getting a list of sentpays */
    public static final String LIST_SENTPAYS_URL = "/List/SentPay.json";

    /** "SentPay" */
    @SerializedName("entity")
    private String entity;

    /**
     * System generated Unique Identifier. It is used to retrieve and refer the object in subsequent API calls. You can filter by this field on the List call.
     */
    @SerializedName("id")
    private String id;

    /**
     * The date on which payment is processed from payer's bank account. You can filter by this field on the List call.
     */
    @SerializedName("processDate")
    private String processDate;

    /**
     * Total payment amount
     */
    @SerializedName("amount")
    private BigDecimal amount;

    /**
     * Payment Status. You can filter by this field on the List call.
     * <p>
     * "0" - Approving
     * "1" - Scheduled
     * "2" - Paid
     * "3" - Canceled
     * "4" - Void
     * "5" - Escheated
     */
    @SerializedName("status")
    private String status;

    /**
     * Memo to identify the payment. Automatically generated for Bill.com payments, user defined for payments made outside Bill.com.
     */
    @SerializedName("description")
    private String description;

    /**
     * System generated payment Identification number. You can filter by this field on the List call.
     */
    @SerializedName("txnNumber")
    private String txnNumber;

    /**
     * This is the Payment Confirmation number assigned to the payment in Bill.com. It follows the format: P######## - ####### (where # are numbers; 8 numbers in first string, 7 numbers in second)
     */
    @SerializedName("name")
    private String name;

    /**
     * Id of the vendor that is receiving the payment. You can filter by this field on the List call.
     */
    @SerializedName("vendorId")
    private String vendorId;

    /**
     * 	If the payment is through Bill.com, isOnline would be true. If the payment is made outside of Bill.com and then recorded in Bill.com, this flag will be false.
     */
    @SerializedName("isOnline")
    private Boolean isOnline;

    @SerializedName("fasterPayment")
    private Boolean fasterPayment;

    /**
     *" 0" - standard
     *" 1" - usps_priority
     * "10" - ups_1day
     * "11" - ups_2day
     * "12" - ups_3day
     */
    @SerializedName("deliveryTypeRequested")
    private String deliveryTypeRequested;

    /**
     * GL Account (CoA object) that reflects where this payment should post. Offline payments: User-defined and updateable, Online Payments: automatically set to Bill.com Money Out Clearing account preference and read-only. You can filter by this field on the List call.
     */
    @SerializedName("chartOfAccountId")
    private String chartOfAccountId;

    /**
     * Only exposed for Offline Payments - user-defined reference for a payment (e.g. check number).
     */
    @SerializedName("syncReference")
    private String syncReference;

    /**
     * Only exposed for Offline Payments - flag to designate that payment should be printable when synced to third-party system.
     */
    @SerializedName("toPrintCheck")
    private Boolean toPrintCheck;

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
     * Only populated for Online Payments - ID of bank account object that provided funding for this Payment. You can filter by this field on the List call.
     */
    @SerializedName("bankAccountId")
    private String bankAccountId;

    @SerializedName("needAttnReviewed")
    private Boolean needAttnReviewed;

    /**
     * "0" - BDC
     * "1" - BillAutoPay
     * "2" - NetSyncFromOnlinePayment
     * "3" - NetSyncFromOfflinePayment
     */
    @SerializedName("source")
    private String source;

    /**
     * List of Bills this payment was applied to
     */
    @SerializedName("billPays")
    private List<BillPay> billPays;

    /**
     * List of BillCredits applied to this payment
     */
    @SerializedName("billCredits")
    private List<BillCredit> billCredits;

    /**
     * Sent Pay represents details on any payment made or recorded in the Bill.com account.
     *
     * @param sentPayGetRequestParams data for SentPay read request
     * @return                        the Invoice specified in the request
     * @throws BDCException           when the response from the API is unsuccessful
     * @throws IOException            when an I/O exception occurs on the underlying request
     */
    public static SentPay get(SentPayGetRequestParams sentPayGetRequestParams) throws BDCException, IOException {
        if(sentPayGetRequestParams == null) {
            throw new NullPointerException("SentPayGetRequestParams required");
        }
        return create(READ_URL, sentPayGetRequestParams, SentPay.class);
    }

    @Getter
    public static class SentPays {
        @SerializedName("sentPays")
        private List<SentPay> sentPays;
    }

    @Getter
    public static class Payments {
        @SerializedName("payments")
        private List<SentPay> sentPays;
    }

    /**
     * Get a list of sentpays
     *
     * @param sentPayListRequestParams data for request to set authorization
     * @return                          a list of sentPays belonging to the account
     * @throws BDCException             when the response from the API is unsuccessful
     * @throws IOException              when an I/O exception occurs on the underlying request
     */
    public static List<SentPay> list(ListRequestParams sentPayListRequestParams) throws BDCException, IOException {
        if(sentPayListRequestParams == null) {
            throw new NullPointerException("SentPayListRequestParams required");
        }
        return createCollection(LIST_SENTPAYS_URL, sentPayListRequestParams, SentPay.class);
    }
}
