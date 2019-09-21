package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.*;
import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Represents an amount owed for goods or services provided by a Vendor. Nested BillLineItem objects record expenses to be paid. Each line item can be assigned to either a Chart Of Account or a product/service Item along with additional Account Tracking.
 * <p>
 * If a bill requires review for approval a Bill Approver is associated through Approval APIs. The amount owed on a bill can be reduced by application of a Vendor Credit. Remaining amount owed is recorded or charged via SentPay.
 */
@Getter
@Setter
public class Bill extends ApiResource {
    /* Resource endpoints for everything vendor related */
    /** The URI for creating an Bill through the BDC API {@value} */
    public static final String CREATE_URL = "/Crud/Create/Bill.json";

    /** The URI for retrieving an Bill through the BDC API {@value} */
    public static final String READ_URL = "/Crud/Read/Bill.json";

    /** The URI for updating an Bill through the BDC API {@value} */
    public static final String UPDATE_URL = "/Crud/Update/Bill.json";

    /** The URI for disabling an Bill through the BDC API {@value} */
    public static final String DELETE_URL = "/Crud/Delete/Bill.json";

    /** The URI for undisabling an Bill through the BDC API {@value} */
    public static final String UNDELETE_URL = "/Crud/Undelete/Bill.json";

    /** The URI for retrieving a list of all approvers for a Bill through the BDC API {@value} */
    public static final String LIST_APPROVERS_URL = "/ListApprovers.json";

    /** The URI for retrieving a list of approvals for a given user through the BDC API {@value} */
    public static final String LIST_USER_APPROVALS_URL = "/ListUserApprovals.json";

    /** The URI for setting approvers for a given Bill through the BDC API {@value} */
    public static final String SET_APPROVERS_URL = "/SetApprovers.json";

    /** The URI for approving a bill */
    public static final String APPROVE_URL = "/Approve.json";

    /** The URI for denying a bill */
    public static final String DENY_URL = "/Deny.json";

    /* All retrievable attributes of a Bill */
    /** "Bill" */
    @Setter(AccessLevel.NONE)
    @SerializedName("entity")
    private String entity;

    /**
     * System generated Unique Identifier. It is used to retrieve and refer the object in subsequent API calls. You can filter by this field on the List call.
     */
    @SerializedName("id")
    private String id;

    /**
     * Denotes if object is active or inactive. Inactive objects are hidden by default and are only visible in UI when user clicks
     * <p>
     * "1" - Active
     * "2" - Inactive
     */
    @SerializedName("isActive")
    private String isActive;

    /**
     * Id of the vendor that the bill is associated with. You can filter by this field on the List call.
     */
    @SerializedName("vendorId")
    private String vendorId;

    /**
     * 	User defined unique identifier for the bill. Usually, provided on the bill. If not, users typically enter the bill's date or billing period. You can filter by this field on the List call.
     */
    @SerializedName("invoiceNumber")
    private String invoiceNumber;

    /**
     * Approval Status of the Bill. You can filter by this field on the List call.
     * <p>
     * "0" - Unassigned
     * "1" - Assigned
     * "4" - Approving
     * "3" - Approved
     * "5" - Denied
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("approvalStatus")
    private String approvalStatus;

    /**
     * The date on which the bill is sent. You can filter by this field on the List call.
     */
    @SerializedName("invoiceDate")
    private String invoiceDate;

    /**
     * The date on which the bill is due. You can filter by this field on the List call.
     */
    @SerializedName("dueDate")
    private String dueDate;

    /**
     * Date the Bill is posted to user's third-party system, if supported. You can filter by this field on the List call.
     */
    @SerializedName("glPostingDate")
    private String glPostingDate;

    /**
     * Total amount due for the bill
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("amount")
    private BigDecimal amount;

    /**
     * Total amount of the bill that is scheduled to be paid
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("scheduledAmount")
    private BigDecimal scheduledAmount;

    /**
     * Total amount fo the bill that has been paid
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("paidAmount")
    private String paidAmount;

    /**
     * Amount remaining to be paid for the bill
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("dueAmount")
    private BigDecimal dueAmount;

    /**
     * Denotes the bill as paid, partially paid, scheduled or unpaid. You can filter by this field on the List call.
     * "1" - Open
     * "4" - Scheduled
     * "0" - PaidInFull
     * "2" - PartialPayment
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("paymentStatus")
    private String paymentStatus;

    /**
     * Description of object
     */
    @SerializedName("description")
    private String description;

    /**
     * Purchase order number associated with the Bill
     */
    @SerializedName("poNumber")
    private String poNumber;

    /**
     * Timestamp when this record was created in Bill.com. You can filter by this field on the List call.
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("createdTime")
    private String createdTime;

    /**
     * Timestamp when this record was last updated in Bill.com. You can filter by this field on the List call.
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("updatedTime")
    private String updatedTime;

    /**
     * 	Bank account from which you expect to pay the bill. Currently, only used by selected partners. You can filter by this field on the List call.
     */
    @SerializedName("payFromBankAccountId")
    private String payFromBankAccountId;

    /**
     * Chart of account from which you expect to pay the bill. Currently, only used by selected partners. You can filter by this field on the List call.
     */
    @SerializedName("payFromChartOfAccountId")
    private String payFromChartOfAccountId;

    /**
     * List of BillLineItems associated with the Bill
     */
    @SerializedName("billLineItems")
    private List<BillLineItem> billLineItems;

    /**
     * Creates an bill in BDC
     *
     * @param billCreateRequestParams data for Bill creation
     * @return                           the Bill that has been created through the BDC API
     * @throws BDCException              when the response from the API is unsuccessful
     * @throws IOException               when an I/O exception occurs on the underlying request
     */
    public static Bill create(BillCreateRequestParams billCreateRequestParams) throws BDCException, IOException {
        if(billCreateRequestParams == null) {
            throw new NullPointerException("BillCreateRequestParams required");
        }
        return create(CREATE_URL, billCreateRequestParams, Bill.class);
    }

    /**
     * Retrieves an bill from the BDC database
     *
     * @param billGetRequestParams data for Bill read request
     * @return                        the Bill specified in the request
     * @throws BDCException           when the response from the API is unsuccessful
     * @throws IOException            when an I/O exception occurs on the underlying request
     */
    public static Bill get(BillGetRequestParams billGetRequestParams) throws BDCException, IOException {
        if(billGetRequestParams == null) {
            throw new NullPointerException("BillGetRequestParams required");
        }
        return create(READ_URL, billGetRequestParams, Bill.class);
    }

    /**
     * Updates an bill in the BDC database
     *
     * @param billUpdateRequestParams data for Bill update request
     * @return                           the Bill specified in the request
     * @throws BDCException              when the response from the API is unsuccessful
     * @throws IOException               when an I/O exception occurs on the underlying request
     */
    public static Bill update(BillUpdateRequestParams billUpdateRequestParams) throws BDCException, IOException {
        if(billUpdateRequestParams == null) {
            throw new NullPointerException("BillUpdateRequestParams required");
        }
        return create(UPDATE_URL, billUpdateRequestParams, Bill.class);
    }

    /**
     * Updates an bill in the BDC database
     *
     * @param bill          Bill object to be updated to the BDC database
     * @return              the Bill specified in the request
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException  when an I/O exception occurs on the underlying request
     */
    public static Bill update(Bill bill) throws BDCException, IOException {
        if (bill == null) {
            throw new NullPointerException("Bill required");
        }
        return create(UPDATE_URL, bill, Bill.class);
    }

    /**
     * Returns a list of all approvers and status of approval for a specified bill or vendor credit.
     *
     * @param listApproversRequestParams data required to make the request
     * @return                           list of users set as approvers for the Bill
     * @throws BDCException              when the response from the API is unsuccessful
     * @throws IOException               when an I/O exception occurs on the underlying request
     */
    public static List<BillApprover> listApprovers(ListApproversRequestParams listApproversRequestParams) throws BDCException, IOException {
        if (listApproversRequestParams == null) {
            throw new NullPointerException("ListApproversRequestParams required");
        }
        List<BillApprover> billApprovers = createCollection(LIST_APPROVERS_URL, listApproversRequestParams, BillApprover.class);

        return billApprovers.stream()
                .map(billApprover -> billApprover.getBillApprover())
                .collect(Collectors.toList());
    }

    /**
     * Returns a list of all approvers and status of approval for a specified bill or vendor credit.
     *
     * @param bill          the Bill which data is being requested for
     * @return              list of users set as approvers for the Bill
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException  when an I/O exception occurs on the underlying request
     */
    public static List<BillApprover> listApprovers(Bill bill) throws BDCException, IOException {
        if (bill == null) {
            throw new NullPointerException("Bill required");
        }

        ListApproversRequestParams params = ListApproversRequestParams.builder()
                .with($ -> {
                    $.billId = bill.getId();
                }).build();

        return listApprovers(params);
    }

    /* TODO: This should probably move to be under the Users model once made */
    /**
     * Returns a Bill or VendCredit list that the specified user is assigned to review and approve/deny as part of an approval process.
     *
     * @param listUserApprovalsRequestParams data required to make the request
     * @return                               UserApprovals object listing which approvals are assigned to a user
     * @throws BDCException                  when the response from the API is unsuccessful
     * @throws IOException                   when an I/O exception occurs on the underlying request
     */
    public static UserApprovals listUserApprovals(ListUserApprovalsRequestParams listUserApprovalsRequestParams) throws BDCException, IOException {
        if(listUserApprovalsRequestParams == null) {
            throw new NullPointerException("ListUserApprovalsRequestParams required");
        }

        listUserApprovalsRequestParams.setEntity("Bill");

        return create(LIST_USER_APPROVALS_URL, listUserApprovalsRequestParams, UserApprovals.class);
    }

    /**
     * This specifies users (one or more) to be assigned as approvers to review and approve a bill or vendor credit. Each assigned user must have the necessary user permissions to approve.
     *
     * @param setApproversRequestParams the data required to make the request
     * @return                          true if the request succeeds
     * @throws BDCException             when the response from the API is unsuccessful
     * @throws IOException              when an I/O exception occurs on the underlying request
     */
    public static Boolean setApprovers(SetApproversRequestParams setApproversRequestParams) throws BDCException, IOException{
        if(setApproversRequestParams == null) {
            throw new NullPointerException("SetApproversRequestParams required");
        }

        setApproversRequestParams.setEntity("Bill");
        httpClient.request(SET_APPROVERS_URL, setApproversRequestParams).getJsonData();

        return true;
    }

    /**
     * When a user with approver permissions is assigned to review a bill or vendor credit. This call is made when the bill or vendor credit is approved. If another approver is required, the Bill.com system emails a notification to the next approver.
     *
     * @param approveRequestParams the data required to make the request
     * @return                     true if the request succeeds
     * @throws BDCException        when the response from the API is unsuccessful
     * @throws IOException         when an I/O exception occurs on the underlying request
     */
    public static Boolean approve(ApproveRequestParams approveRequestParams) throws BDCException, IOException{
        if(approveRequestParams == null) {
            throw new NullPointerException("ApproveRequestParams required");
        }

        approveRequestParams.setEntity("Bill");
        httpClient.request(APPROVE_URL, approveRequestParams).getJsonData();

        return true;
    }

    /**
     * This is called when an Approver (user with approval permissions and assigned to a bill) rejects the bill or vendor credit for some reason (incorrect amounts, wrong details, etc.). The comment field can describe the approver's reason for rejection.
     *
     * @param denyRequestParams the data required to make the request
     * @return                  true if the request succeeds
     * @throws BDCException     when the response from the API is unsuccessful
     * @throws IOException      when an I/O exception occurs on the underlying request
     */
    public static Boolean deny(DenyRequestParams denyRequestParams) throws BDCException, IOException{
        if(denyRequestParams == null) {
            throw new NullPointerException("DenyRequestParams required");
        }

        denyRequestParams.setEntity("Bill");
        httpClient.request(DENY_URL, denyRequestParams).getJsonData();

        return true;
    }

    /**
     * Represents a good or service provided by a vendor
     */
    @Getter
    @Setter
    public static class BillLineItem {
        /** "Bill" */
        @Setter(AccessLevel.NONE)
        @SerializedName("entity")
        private String entity;

        /**
         * System generated Unique Identifier. It is used to retrieve and refer the object in subsequent API calls. You can filter by this field on the List call.
         */
        @SerializedName("id")
        private String id;

        /**
         * 	Read-only. Refers to the Id of the bill that this line item is associated with
         */
        @SerializedName("billId")
        private String billId;

        /**
         * Total amount due for the bill
         */
        @SerializedName("amount")
        private BigDecimal amount;

        /**
         * Id of the account that the bill line item is coded to.
         */
        @SerializedName("chartOfAccountId")
        private String chartOfAccountId;

        /**
         * Id of the department that the bill line item is coded to.
         */
        @SerializedName("departmentId")
        private String departmentId;

        /**
         * Id of the location that the bill line item is coded to.
         */
        @SerializedName("locationId")
        private String locationId;

        /**
         * 	Id of the department that the bill line item is coded to.
         */
        @SerializedName("jobId")
        private String jobId;

        /**
         * Id of the customer that the bill line item is coded to.
         */
        @SerializedName("customerId")
        private String customerId;

        /**
         * Id of the job / project that the bill line item is coded to. Depending on the accounting system, job may be specified in addition to the customer record. For Bill.com accounts syncing with QuickBooks this field is not used because jobs are sub-customers.
         */
        @SerializedName("jobBillable")
        private Boolean jobBillable;

        /**
         * 	Line item description / memo
         */
        @SerializedName("description")
        private String description;

        /**
         * Timestamp when this record was created in Bill.com.
         */
        @Setter(AccessLevel.NONE)
        @SerializedName("createdTime")
        private String createdTime;

        /**
         * Timestamp when this record was last updated in Bill.com.
         */
        @Setter(AccessLevel.NONE)
        @SerializedName("updatedTime")
        private String updatedTime;

        /**
         * Read only field. Enum indicating the type of the bill line item, i.e., it is type expense if there is not associated with an item or type item otherwise.
         * <p>
         * "1" - expense
         * "2" - item
         */
        @SerializedName("lineType")
        private String lineType;

        /**
         * Id of the item that the bill line item is coded to.
         */
        @SerializedName("itemId")
        private String itemId;

        /**
         * Quantity of the item(s) purchased. Only used if line item type is item. If you don't use this field, either don't send this field or use value
         */
        @SerializedName("quantity")
        private Integer quantity;

        /**
         * Unit price of the item purchased. Only used if line item type is item.
         */
        @SerializedName("unitPrice")
        private BigDecimal unitPrice;

        /**
         * 	Id of the employee that the bill line item is coded to.
         */
        @SerializedName("employeeId")
        private String employeeId;

        /**
         * Id of the accounting class that the bill line item is coded to.
         */
        @SerializedName("actgClassId")
        private String actgClassId;

        private BillLineItem(String id,
                             String billId,
                             BigDecimal amount,
                             String chartOfAccountId,
                             String departmentId,
                             String locationId,
                             String jobId,
                             String customerId,
                             Boolean jobBillable,
                             String description,
                             String lineType,
                             String itemId,
                             Integer quantity,
                             BigDecimal unitPrice,
                             String employeeId,
                             String actgClassId){
            this.entity = "BillLineItem";
            this.id = id;
            this.billId = billId;
            this.amount = amount;
            this.chartOfAccountId = chartOfAccountId;
            this.departmentId = departmentId;
            this.locationId = locationId;
            this.jobId = jobId;
            this.customerId = customerId;
            this.jobBillable = jobBillable;
            this.description = description;
            this.lineType = lineType;
            this.itemId = itemId;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.employeeId = employeeId;
            this.actgClassId = actgClassId;
        }

        /**
         * Makes a new Builder for BillLineItem
         *
         * @return a builder for BillLineItem
         */
        public static Builder builder() { return new Builder(); }


        /**
         * Builds a BillLineItem instance to be passed in when making a Bill
         */
        public static class Builder {
            /**
             * System generated Unique Identifier. It is used to retrieve and refer the object in subsequent API calls. You can filter by this field on the List call.
             */
            public String id;

            /**
             * 	Read-only. Refers to the Id of the bill that this line item is associated with
             */
            public String billId;

            /**
             * Total amount due for the bill
             */
            public BigDecimal amount;

            /**
             * Id of the account that the bill line item is coded to.
             */
            public String chartOfAccountId;

            /**
             * Id of the department that the bill line item is coded to.
             */
            public String departmentId;

            /**
             * Id of the location that the bill line item is coded to.
             */
            public String locationId;

            /**
             * 	Id of the department that the bill line item is coded to.
             */
            public String jobId;

            /**
             * Id of the customer that the bill line item is coded to.
             */
            public String customerId;

            /**
             * Id of the job / project that the bill line item is coded to. Depending on the accounting system, job may be specified in addition to the customer record. For Bill.com accounts syncing with QuickBooks this field is not used because jobs are sub-customers.
             */
            public Boolean jobBillable;

            /**
             * 	Line item description / memo
             */
            public String description;
            /**
             * Read only field. Enum indicating the type of the bill line item, i.e., it is type expense if there is not associated with an item or type item otherwise.
             * <p>
             * "1" - expense
             * "2" - item
             */
            public String lineType;

            /**
             * Id of the item that the bill line item is coded to.
             */
            public String itemId;

            /**
             * Quantity of the item(s) purchased. Only used if line item type is item. If you don't use this field, either don't send this field or use value
             */
            public Integer quantity;

            /**
             * Unit price of the item purchased. Only used if line item type is item.
             */
            public BigDecimal unitPrice;

            /**
             * 	Id of the employee that the bill line item is coded to.
             */
            public String employeeId;

            /**
             * Id of the accounting class that the bill line item is coded to.
             */
            public String actgClassId;

            public Builder with(Consumer<Builder> builderFunction) {
                builderFunction.accept(this);
                return this;
            }

            /**
             * Builds a BillLineItem instance
             *
             * @return an BillLineItem
             */
            public BillLineItem build() {
                return new BillLineItem(
                        id,
                        billId,
                        amount,
                        chartOfAccountId,
                        departmentId,
                        locationId,
                        jobId,
                        customerId,
                        jobBillable,
                        description,
                        lineType,
                        itemId,
                        quantity,
                        unitPrice,
                        employeeId,
                        actgClassId
                );
            }
        }
    }

    @Getter
    public static class UserApprovals {
        @SerializedName("marker")
        private String marker;

        @SerializedName("approvals")
        private List<Bill> bills;
    }
}
