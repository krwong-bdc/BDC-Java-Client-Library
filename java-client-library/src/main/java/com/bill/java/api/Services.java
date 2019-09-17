package com.bill.java.api;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.models.*;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.*;

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

    /** The URI for recording a payment made outside of Bill.com to a Vendor through the BDC API {@value} */
    public static final String RECORD_AP_PAYMENT_URL = "/RecordAPPayment.json";

    /** The URI for retrieving a summary of the user's accounts receivable invoices and received payments {@value}*/
    public static final String GET_AP_SUMMARY_URL = "/GetAPSummary.json";

    /** The URI for retrieving a payment and applied vendor credit details for any SentPay issued via PayBills request to a vendor {@value}*/
    public static final String GET_DISBURSMENT_DATA_URL = "/GetDisbursementData.json";

    /** the URI for retrieving a list of payments based on a SentPay's specified disbursementStatus value {@value}*/
    public static final String LIST_PAYMENTS_URL = "/ListPayments.json";

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
     * @param recordAPPaymentRequestParams data required to make the request
     * @return                             a SentPay record
     * @throws BDCException                when the response from the API is unsuccessful
     * @throws IOException                 when an I/O exception occurs on the underlying request
     */
    public static SentPay recordAPPayment(RecordAPPaymentRequestParams recordAPPaymentRequestParams) throws IOException, BDCException {
        if(recordAPPaymentRequestParams == null) {
            throw new NullPointerException("RecordAPPaymentRequestParams required.");
        }
        return create(RECORD_AP_PAYMENT_URL, recordAPPaymentRequestParams, SentPay.class);
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

    /**
     * This request provides payment and applied vendor credit details for any SentPay issued via PayBills request to a vendor.  The parameter disbursementStatus is empty until MoneyMovement for the SentPay is debited to be paid to the vendor
     * <p>
     * Response depends on how payment was sent to vendor: check, ePayment via ACH, ePayment to Large Billers, or via PayPal.
     *
     * @param getDisbursementDataRequestParams data required to make the request
     * @return                                 data about the status of outgoing payments
     * @throws BDCException                    when the response from the API is unsuccessful
     * @throws IOException                     when an I/O exception occurs on the underlying request
     */
    public static DisbursementData getDisbursementData(GetDisbursementDataRequestParams getDisbursementDataRequestParams) throws IOException, BDCException {
        if(getDisbursementDataRequestParams == null) {
            throw new NullPointerException("GetDisbursementDataRequestParams required.");
        }
        return create(GET_DISBURSMENT_DATA_URL, getDisbursementDataRequestParams, DisbursementData.class);
    }

    /**
     * This returns list of payments based on a SentPay's specified disbursementStatus value.
     *
     * @param listPaymentsRequestParams data required to make the request
     * @return                          List of sentPays with a disbursement status specified in the params
     * @throws BDCException             when the response from the API is unsuccessful
     * @throws IOException              when an I/O exception occurs on the underlying request
     */
    public static List<SentPay> listPayments(ListPaymentsRequestParams listPaymentsRequestParams) throws IOException, BDCException {
        if(listPaymentsRequestParams == null) {
            throw new NullPointerException("ListPaymentsRequestParams required.");
        }
        SentPay.Payments payments = create(LIST_PAYMENTS_URL, listPaymentsRequestParams, SentPay.Payments.class);
        return payments.getSentPays();
    }
}
