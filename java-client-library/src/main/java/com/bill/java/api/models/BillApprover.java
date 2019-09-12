package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.BillApproverGetRequestParams;
import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Getter;

import java.io.IOException;

@Getter
public class BillApprover extends ApiResource {
    /* Resource endpoints for everything vendor related */
    /** The URI for retrieving a Bill Approver through the BDC API {@value} */
    public static final String READ_URL = "/Crud/Read/BillApprover.json";

    /* Due to the way this object is nested on response, must have an obj field. Will un-nest before returning to User*/
    @Getter(AccessLevel.PROTECTED)
    @SerializedName("obj")
    private BillApprover billApprover;

    /** "BillApprover" */
    @SerializedName("entity")
    private String entity;

    /**
     * System generated Unique Identifier of the BillApprover object
     */
    @SerializedName("id")
    private String id;

    /**
     * System generated Unique Identifier of the bill being approved/denied.
     */
    @SerializedName("billId")
    private String billId;

    /**
     * 	System generated Unique Identifier of the user who is approving/denying.
     */
    @SerializedName("usersId")
    private String usersId;

    /**
     * The place of this approver in the order of approvers, starting at 0.
     */
    @SerializedName("sortOrder")
    private Integer sortOrder;

    /**
     * The status of this approval
     * <p>
     * "5" - Upcoming
     * "0" - Waiting
     * "1" - Viewed
     * "2" - Rerouted
     * "3" - Denied
     * "4" - Approved
     * "6" - Stale
     */
    @SerializedName("status")
    private String status;

    /**
     * Timestamp of when this approval changed its status.
     */
    @SerializedName("statusChangedDate")
    private String statusChangedDate;

    /**
     * Timestamp of the last reminder that was sent to this approver. If no reminder has been sent, this field is null.
     */
    @SerializedName("lastReminderDate")
    private String lastReminderDate;

    /**
     * "1" - Active
     * "2" - Inactive
     */
    @SerializedName("isActive")
    private String isActive;

    /**
     * Retrieves an invoice from the BDC database
     *
     * @param billApproverGetRequestParams data for BillApprover read request
     * @return                             the BillApprover specified in the request
     * @throws BDCException                when the response from the API is unsuccessful
     * @throws IOException                 when an I/O exception occurs on the underlying request
     */
    public static BillApprover get(BillApproverGetRequestParams billApproverGetRequestParams) throws BDCException, IOException {
        if(billApproverGetRequestParams == null) {
            throw new NullPointerException("BillApproverGetRequestParams required");
        }
        BillApprover billApprover = create(READ_URL, billApproverGetRequestParams, BillApprover.class);
        return billApprover.billApprover;
    }

}
