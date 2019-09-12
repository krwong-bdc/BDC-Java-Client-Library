package com.bill.java.api;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.models.AccountsPayableSummary;
import com.bill.java.api.models.AccountsReceivableSummary;
import com.bill.java.api.models.ReceivedPay;
import com.bill.java.api.models.SentPay;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.ChargeCustomerRequestParams;
import com.bill.java.api.param.PayBillsRequestParams;
import com.bill.java.api.param.RecordAPPaymentRequestParams;

import java.io.IOException;
import java.util.List;

/**
 * Contains resources for accessing Bill.com services
 */
public class Services extends ApiResource {
    /* Resource endpoints for Bill.com services */
    /** The URI for charging a customer through the BDC API {@value} */
    public static final String CHARGE_CUSTOMER_URL = "/ChargeCustomer.json";

    /** The URI for retrieving a summary of the user's accounts receivable invoices and received payments {@value}*/
    public static final String GET_AR_SUMMARY_URL = "/GetARSummary.json";

    /** The URI for paying a vendor through the BDC API {@value} */
    public static final String PAY_BILLS_URL = "/PayBills.json";

    /** The URI for paying a vendor through the BDC API {@value} */
    public static final String RECORD_AR_PAYMENT_URL = "/RecordAPPayment.json";

    /** The URI for retrieving a summary of the user's accounts receivable invoices and received payments {@value}*/
    public static final String GET_AP_SUMMARY_URL = "/GetAPSummary.json";

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
            return create(CHARGE_CUSTOMER_URL, chargeCustomerRequestParams, ReceivedPay.class);
    }

    /**
     * This returns a summary of accounts receivable invoices and received payments. Use this as a review of current outstanding receivables and received payments.
     *
     * @return              an AccountsReceivableSummary object
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException  when an I/O exception occurs on the underlying request
     */
    public static AccountsReceivableSummary getAccountsReceivableSummary() throws IOException, BDCException {
        return create(GET_AR_SUMMARY_URL, AccountsReceivableSummary.class);
    }

    /**
     * Use this API to issue Bill.com payments (one or more bills and one or more bill credits) to a designated vendor. These are paid from a specified bank account.
     * <p>
     * The user that uses this API MUST be verified ("pay bills" function enabled in the assigned user role - Administrator, Payer, customized). If not, an error is returned.
     *
     * @param payBillsRequestParams data required to make the request
     * @return                      a list of SentPay records
     * @throws BDCException         when the response from the API is unsuccessful
     * @throws IOException          when an I/O exception occurs on the underlying request
     */
    public static List<SentPay> payBills(PayBillsRequestParams payBillsRequestParams) throws IOException, BDCException {
        if(payBillsRequestParams == null) {
            throw new NullPointerException("PayBillsRequestParams required.");
        }
        SentPay.SentPays sentPays = create(PAY_BILLS_URL, payBillsRequestParams, SentPay.SentPays.class);
        return sentPays.getSentPays();
    }

    /**
     * Use this API to issue Bill.com payments (one or more bills and one or more bill credits) to a designated vendor. These are paid from a specified bank account.
     * <p>
     * The user that uses this API MUST be verified ("pay bills" function enabled in the assigned user role - Administrator, Payer, customized). If not, an error is returned.
     *
     * @param recordARPaymentRequestParams data required to make the request
     * @return                             a SentPay record
     * @throws BDCException                when the response from the API is unsuccessful
     * @throws IOException                 when an I/O exception occurs on the underlying request
     */
    public static SentPay recordArPayment(RecordAPPaymentRequestParams recordARPaymentRequestParams) throws IOException, BDCException {
        if(recordARPaymentRequestParams == null) {
            throw new NullPointerException("RecordAPPaymentRequestParams required.");
        }
        return create(RECORD_AR_PAYMENT_URL, recordARPaymentRequestParams, SentPay.class);
    }

    /**
     * This returns a summary of all Accounts Payable bills and approvals for your Bill.com account.
     *
     * @return              an AccountsPayableSummary object
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException  when an I/O exception occurs on the underlying request
     */
    public static AccountsPayableSummary getAccountsPayableSummary() throws IOException, BDCException {
        return create(GET_AR_SUMMARY_URL, AccountsPayableSummary.class);
    }
}
