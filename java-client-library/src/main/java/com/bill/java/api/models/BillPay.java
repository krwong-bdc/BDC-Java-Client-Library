package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.BillPayGetRequestParams;
import com.bill.java.api.param.ListRequestParams;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

/**
 * The BillPay represents the relationship between a SentPay applied to a Bill.
 */
@Getter
public class BillPay extends ApiResource {
    /* Resource endpoints for everything BillPay related */
    /** The URI for retrieving a BillPay through the BDC API {@value} */
    public static final String READ_URL = "/Crud/Read/BillPay.json";

    /** The URI for getting a list of BillPays */
    public static final String LIST_BILLPAYS_URL = "/List/BillPay.json";

    /** "BillPay */
    @SerializedName("entity")
    private String entity;

    /**
     * System generated Unique Identifier. It is used to retrieve and refer the object in subsequent API calls.
     */
    @SerializedName("id")
    private String id;

    /**
     * Id of the Bill with which the payment is associated
     */
    @SerializedName("billId")
    private String billId;

    /**
     * Automatically populated from SentPay object.
     */
    @SerializedName("name")
    private String name;

    /**
     * Automatically populated from SentPay object.
     * <p>
     * "1" - Scheduled
     * "2" - Paid
     * "3" - Canceled
     * "4" - Void
     */
    @SerializedName("paymentStatus")
    private String paymentStatus;

    /**
     * Bill amount paid
     */
    @SerializedName("amount")
    private BigDecimal amount;

    /**
     * Automatically populated from SentPay object.
     */
    @SerializedName("description")
    private String description;

    /**
     * 	Automatically populated from SentPay object.
     */
    @SerializedName("processDate")
    private String processDate;

    /**
     * 	Timestamp when this record was created in Bill.com.
     */
    @SerializedName("createdTime")
    private String createdTime;

    /**
     * Timestamp when this record was last updated in Bill.com.
     */
    @SerializedName("updatedTime")
    private String updatedTime;

    /**
     * Automatically populated from SentPay object.
     */
    @SerializedName("syncReference")
    private String syncReference;

    /**
     * Automatically populated from SentPay object.
     */
    @SerializedName("toPrintCheck")
    private Boolean toPrintCheck;

    /**
     * Automatically populated from SentPay object.
     */
    @SerializedName("chartOfAccountId")
    private String chartOfAccountId;

    /**
     * Automatically populated from SentPay object.
     * <p>
     * "0" - Online
     * "1" - Other
     */
    @SerializedName("paymentType")
    private String paymentType;

    /**
     * Id of the SentPay record associated with this BillPay
     */
    @SerializedName("sentPayId")
    private String sentPayId;

    @SerializedName("allowExport")
    private Boolean allowExport;

    private BillPay(String billId, BigDecimal amount) {
        this.billId = billId;
        this.amount = amount;
    }

    /**
     * Makes a new Builder for BillPay
     *
     * @return a builder for BillPay
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an instance of BillPay
     */
    public static class Builder {
        /**
         * 	The id of the bill to pay
         */
        public String billId;

        /**
         * The amount to pay/apply
         */
        public BigDecimal amount;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a new BillPay with the set parameters.
         *
         * @return a new BillPay object
         */
        public BillPay build() {
            return new BillPay(billId, amount);
        }
    }

    /**
     * The BillPay represents the relationship between a SentPay applied to a Bill. The Bill Id in the Request returns details about the bill.
     *
     * @param billPayGetRequestParams data for BillPay read request
     * @return                            the Invoice specified in the request
     * @throws BDCException               when the response from the API is unsuccessful
     * @throws IOException                when an I/O exception occurs on the underlying request
     */
    public static BillPay get(BillPayGetRequestParams billPayGetRequestParams) throws BDCException, IOException {
        if(billPayGetRequestParams == null) {
            throw new NullPointerException("BillPayGetRequestParams required");
        }
        return create(READ_URL, billPayGetRequestParams, BillPay.class);
    }

    /**
     * Get a list of Bill Pays
     *
     * @param billPayListRequestParams data for request to set authorization
     * @return                          a list of billPays belonging to the account
     * @throws BDCException             when the response from the API is unsuccessful
     * @throws IOException              when an I/O exception occurs on the underlying request
     */
    public static List<BillPay> list(ListRequestParams billPayListRequestParams) throws BDCException, IOException {
        if(billPayListRequestParams == null) {
            throw new NullPointerException("BillPayListRequestParams required");
        }
        return createCollection(LIST_BILLPAYS_URL, billPayListRequestParams, BillPay.class);
    }
}
