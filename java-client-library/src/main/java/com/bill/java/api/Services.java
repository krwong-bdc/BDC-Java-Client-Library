package com.bill.java.api;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.models.AccountsReceivableSummary;
import com.bill.java.api.models.ReceivedPay;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.ChargeCustomerRequestParams;

import java.io.IOException;

/**
 * Contains resources for accessing Bill.com services
 */
public class Services extends ApiResource {
    /* Resource endpoints for Bill.com services */
    /** The URI for charging a customer through the BDC API {@value} */
    public static final String CHARGE_CUSTOMER_URL = "/ChargeCustomer.json";

    /** The URI for retrieving a summary of the user's accounts receivable invoices and received payments */
    public static final String GET_AR_SUMMARY_URL = "/GetARSummary.json";

    /**
     * This processes a receipt from a customer to withdraw funds from the authorized CustomerBankAccount.
     *<p>
     * NOTE: Direct bank charges to customer's bank requires customer's authorization.
     *
     * @param chargeCustomerRequestParams data required to make the request
     * @return                            a ReceivedPay record
     * @throws BDCException               when the response from the API is unsuccessful
     * @throws IOException                when an I/O exception occurs on the underlying request
     */
    public static ReceivedPay chargeCustomer(ChargeCustomerRequestParams chargeCustomerRequestParams) throws IOException, BDCException {
        if(chargeCustomerRequestParams == null) {
            throw new NullPointerException("ChargeCustomerRequestParams required.");
        }

        ReceivedPay.ChargedReceivedPay chargedReceivedPay = create(CHARGE_CUSTOMER_URL, chargeCustomerRequestParams, ReceivedPay.ChargedReceivedPay.class);

        return chargedReceivedPay.getReceivedPay();
    }

    /**
     * This returns a summary of accounts receivable invoices and received payments. Use this as a review of current outstanding receivables and received payments.
     *
     * @return              an AccountsReceivableSummary object
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException  when an I/O exception occurs on the underlying request
     */
    public static AccountsReceivableSummary getARSummary() throws IOException, BDCException {
        return create(GET_AR_SUMMARY_URL, AccountsReceivableSummary.class);
    }
}
