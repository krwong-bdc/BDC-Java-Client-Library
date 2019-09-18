package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.RPConvFeeGetRequestParams;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * This API reads invoices to determine if an extra convenience fee was charged to customer - usually for credit card/PayPal payment. The charge is applied when the Invoice is created.
 * <p>
 * NOTE: The RPConvFee must be entered on the UI. It cannot be created with an API (only Read and List operations are available)
 */
public class RPConvFee extends ApiResource {
    /* Resource endpoints for everything vendor related */
    /** The URI for retrieving a RPConvFee through the BDC API {@value} */
    public static final String READ_URL = "/Crud/Read/RPConvFee.json";

    /* All retrievable attributes of a Customer */
    /** "RPConvFee" */
    @SerializedName("entity")
    private String entity;

    @SerializedName("id")
    private String id;

    @SerializedName("refNumber")
    private String refNumber;

    @SerializedName("amount")
    private BigDecimal amount;

    @SerializedName("paymentDate")
    private String paymentDate;

    @SerializedName("chartOfAccountId")
    private String chartOfAccountId;

    /**
     * This API reads invoices to determine if an extra convenience fee was charged to customer - usually for credit card/PayPal payment. The charge is applied when the Invoice is created.
     *
     * @param rPConvFeeGetRequestParams data for ReceivedPay read request
     * @return                        the Invoice specified in the request
     * @throws BDCException           when the response from the API is unsuccessful
     * @throws IOException            when an I/O exception occurs on the underlying request
     */
    public static RPConvFee get(RPConvFeeGetRequestParams rPConvFeeGetRequestParams) throws BDCException, IOException {
        if(rPConvFeeGetRequestParams == null) {
            throw new NullPointerException("RPConvFeeGetRequestParams required");
        }
        return create(READ_URL, rPConvFeeGetRequestParams, RPConvFee.class);
    }
}
