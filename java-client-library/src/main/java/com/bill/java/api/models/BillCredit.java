package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.BillCreditGetRequestParams;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.function.Consumer;

/**
 * The BillCredit represents the relationship between a Vendor Credit applied to a Bill for a Vendor Credit.
 */
@Getter
public class BillCredit extends ApiResource {
    /* Resource endpoints for everything BillCredit related */
    /** The URI for retrieving a BillCredit through the BDC API {@value} */
    public static final String READ_URL = "/Crud/Read/BillCredit.json";

    /** BillCredit */
    @SerializedName("entity")
    private String entity;

    /**
     * System generated Unique Identifier. It is used to retrieve and refer the object in subsequent API calls.
     */
    @SerializedName("id")
    private String id;

    /**
     * 	ID of the bill this vendor credit is being applied to
     */
    @SerializedName("billId")
    private String billId;

    /**
     * Id of the payment associated with the credit. If payment was made via Bill.com, vendor will see the vendor credit reference # and amount applied on the check payment stub / payment email.
     */
    @SerializedName("sentPayId")
    private String sentPayId;

    /**
     * ID of the vendor credit being applied
     */
    @SerializedName("vendorCreditId")
    private String vendorCreditId;

    /**
     * Applied amount
     */
    @SerializedName("amount")
    private BigDecimal amount;

    /**
     * Timestamp when this record was created in Bill.com.
     */
    @SerializedName("createdTime")
    private String createdTime;

    /**
     * Timestamp when this record was last updated in Bill.com.
     */
    @SerializedName("updatedTime")
    private String updatedTime;

    private BillCredit(String billId, String vendorCreditId, BigDecimal amount) {
        this.billId = billId;
        this.vendorCreditId = vendorCreditId;
        this.amount = amount;
    }

    /**
     * Makes a new Builder for BillCredit
     *
     * @return a builder for BillCredit
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an instance of BillCredit
     */
    public static class Builder {
        public String billId;
        public String vendorCreditId;
        public BigDecimal amount;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a new BillCredit with the set parameters.
         *
         * @return a new BillCredit object
         */
        public BillCredit build() {
            return new BillCredit(billId, vendorCreditId, amount);
        }
    }

    /**
     * The BillCredit represents the relationship between a Vendor Credit applied to a Bill for a Vendor Credit. The call returns billId, sentPayId, vendorCreditId, and amount.
     *
     * @param billCreditGetRequestParams data for BillCredit read request
     * @return                        the Invoice specified in the request
     * @throws BDCException           when the response from the API is unsuccessful
     * @throws IOException            when an I/O exception occurs on the underlying request
     */
    public static BillCredit get(BillCreditGetRequestParams billCreditGetRequestParams) throws BDCException, IOException {
        if(billCreditGetRequestParams == null) {
            throw new NullPointerException("BillCreditGetRequestParams required");
        }
        return create(READ_URL, billCreditGetRequestParams, BillCredit.class);
    }
}
