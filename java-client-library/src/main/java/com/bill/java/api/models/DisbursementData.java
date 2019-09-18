package com.bill.java.api.models;

import com.bill.java.api.param.GetDisbursementDataRequestParams;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Disbursement data returned from a call to {@link com.bill.java.api.Services#getDisbursementData(GetDisbursementDataRequestParams) getDisbursementData() }
 */
@Getter
public class DisbursementData {
    /**
     * 0 = Check
     * 2 = ACH
     * 3 = LargeBiller
     * 4 = PayPal
     */
    @SerializedName("paymentType")
    private String paymentType;

    /**
     * 	0 = Scheduled, 3 = Done, 4 = Failed, 5 = Void
     */
    @SerializedName("disbursementStatus")
    private String disbursementStatus;

    @SerializedName("checkData")
    private CheckData checkData;

    @SerializedName("achData")
    private AchData achData;

    @SerializedName("rppsData")
    private RppsData rppsData;

    @SerializedName("payPalData")
    private PayPalData payPalData;

    @Getter
    public static class CheckData {
        /**
         * Number on check sent to vendor.
         */
        @SerializedName("checkNumber")
        private BigInteger checkNumber;

        /**
         * Date printed on check.
         */
        @SerializedName("checkDate")
        private String checkDate;

        /**
         * Estimated date check should arrive to vendor.
         */
        @SerializedName("arrivesByDate")
        private String arrivesByDate;

        /**
         * Date check cashed by vendor and cleared.
         */
        @SerializedName("clearedDate")
        private String clearedDate;

        /**
         * 	Amount on check.
         */
        @SerializedName("amount")
        private BigDecimal amount;

        /**
         * 	Memo to vendor with payment description.
         */
        @SerializedName("memo")
        private String memo;

        /**
         * Check expiration date. After date, check is auto voided. Funds return to bank account.
         */
        @SerializedName("expirationDate")
        private String expirationDate;

        /**
         * If paid faster (i.e., overnight checks), contains tracking info.
         */
        @SerializedName("trackingInfo")
        private String trackingInfo;

        /**
         * Error code if check returned or other issues on check delivery.
         */
        @SerializedName("errorCode")
        private String errorCode;

    }

    @Getter
    public static class AchData {
        /**
         * 	Date ACH arrived to vendor's bank account.
         */
        @SerializedName("depositDate")
        private String depositDate;

        /**
         * Vendor's routing number (always encrypted so full number not visible).
         */
        @SerializedName("routingNumber")
        private String routingNumber;

        /**
         * Vendor's bank account (always encrypted so full number not visible).
         */
        @SerializedName("accountNumber")
        private String accountNumber;

        /**
         * Date ACH sent to vendor's bank account
         */
        @SerializedName("sentDate")
        private String sentDate;

        /**
         * 	NACHA error codes - if ACH returned
         */
        @SerializedName("errorCode")
        private String errorCode;

        /**
         * Date ACH returned (if error happened)
         */
        @SerializedName("returnedDate")
        private String returnedDate;

        /**
         * ACH unique ID
         */
        @SerializedName("uniqueId")
        private String uniqueId;

    }

    @Getter
    public static class RppsData {
        /**
         * Date ACH arrived to vendor's bank account.
         */
        @SerializedName("arrivesByDate")
        private String arrivesByDate;

        /**
         * Date ACH sent to vendor's bank account
         */
        @SerializedName("sentDate")
        private String sentDate;

        /**
         * Error code if payment disbursement failed
         */
        @SerializedName("errorCode")
        private String errorCode;

        /**
         * 	ID of Biller in Large Biller network.
         */
        @SerializedName("largeBillerId")
        private BigInteger largeBillerId;

        /**
         * Date payment returned (if error happened)
         */
        @SerializedName("returnedDate")
        private String returnedDate;

        /**
         * 	Number to track payment (in case of error)
         */
        @SerializedName("traceNumber")
        private BigInteger traceNumber;
    }

    @Getter
    public static class PayPalData {
        /**
         * Email on PayPal account of payment sender
         */
        @SerializedName("senderEmail")
        private String senderEmail;

        /**
         * Email on PayPal account of vendor (payment recipient)
         */
        @SerializedName("receiverEmail")
        private String receiverEmail;

        /**
         * 	Status of payment
         */
        @SerializedName("txnStatus")
        private String txnStatus;

        /**
         * If payment pending in PayPal, display reason
         */
        @SerializedName("pendingReason")
        private String pendingReason;

        /**
         * 	If voided, shows void reason
         */
        @SerializedName("voidReason")
        private String voidReason;

        /**
         * 	If voided, shows explanation of void.
         */
        @SerializedName("voidMessage")
        private String voidMessage;
    }

}
