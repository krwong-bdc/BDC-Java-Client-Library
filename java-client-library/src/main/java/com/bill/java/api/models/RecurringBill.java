package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.RecurringBillCreateRequestParams;
import com.bill.java.api.param.RecurringBillGetRequestParams;
import com.bill.java.api.param.RecurringBillUpdateRequestParams;
import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;


/**
 * A Recurring Bill represents an identical Bill created periodically for a Vendor. A recurring a bill becomes a template used to automatically generate bills into the future. If a bill requires review for approval, a Bill Approver is associated through Approval APIs.
 */
@Getter
@Setter
public class RecurringBill extends ApiResource {
    /* Resource endpoints for everything vendor related */
    /** The URI for creating a RecurringBill through the BDC API {@value} */
    public static final String CREATE_URL = "/Crud/Create/RecurringInvoice.json";

    /** The URI for retrieving a RecurringBill through the BDC API {@value} */
    public static final String READ_URL = "/Crud/Read/RecurringBill.json";

    /** The URI for updating a RecurringBill through the BDC API {@value} */
    public static final String UPDATE_URL = "/Crud/Update/RecurringBill.json";

    /** The URI for disabling a RecurringBill through the BDC API {@value} */
    public static final String DELETE_URL = "/Crud/Delete/RecurringBill.json";

    /** The URI for undisabling a RecurringBill through the BDC API {@value} */
    public static final String UNDELETE_URL = "/Crud/Undelete/RecurringBill.json";

    /* All retrievable attributes of a RecurringBill */
    @Setter(AccessLevel.NONE)
    @SerializedName("entity")
    private String entity;

    /**
     * System generated Unique Identifier. It is used to retrieve and refer the object in subsequent API calls.
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("id")
    private String id;

    /**
     * Denotes if object is active or inactive. Inactive objects are hidden by default and are only visible in UI when user clicks.
     * <p>
     * "1" - Active
     * "2" - Inactive
     */
    @SerializedName("isActive")
    private String isActive;

    /**
     * 	Id of the vendor that is used for generated bills.
     */
    @SerializedName("vendorId")
    private String vendorId;

    /**
     * "9" - none
     * "0" - Day
     * "1" - Week
     * "2" - Month
     * "3" - Year
     */
    @SerializedName("timePeriod")
    private String timePeriod;

    @SerializedName("frequencyPerTimePeriod")
    private Integer frequencyPerTimePeriod;

    /**
     * The Due Date of the next bill to be generated by this Recurring Bill profile
     */
    @SerializedName("nextDueDate")
    private String nextDueDate;

    /**
     * Date after which this Recurring Bill Profile will no longer generate bills.
     */
    @SerializedName("endDate")
    private String endDate;

    /**
     * Number of days prior to nextDueDate that the next bill is generated. If this date has already occurred for one or more bills, those bills will be generated.
     */
    @SerializedName("daysInAdvance")
    private Integer daysInAdvance;

    /**
     * 	Description used for generated bills.
     */
    @SerializedName("description")
    private String description;

    /**
     * Timestamp when this record was created in Bill.com. You can filter by this field on the List call.
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("createdTime")
    private String createdTime;

    /**
     * 	Timestamp when this record was last updated in Bill.com. You can filter by this field on the List call.
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("updatedTime")
    private String updatedTime;

    /**
     * List of line items belonging to the Bill
     */
    @SerializedName("recurringBillLineItems")
    private List<RecurringBillLineItem> recurringBillLineItems;

    /**
     * Creates an recurringBill in BDC
     *
     * @param recurringBillCreateRequestParams data for RecurringBill creation
     * @return                                 the RecurringBill that has been created through the BDC API
     * @throws BDCException                    when the response from the API is unsuccessful
     * @throws IOException                     when an I/O exception occurs on the underlying request
     */
    public static RecurringBill create(RecurringBillCreateRequestParams recurringBillCreateRequestParams) throws BDCException, IOException {
        if(recurringBillCreateRequestParams == null) {
            throw new NullPointerException("RecurringBillCreateRequestParams required");
        }
        return create(CREATE_URL, recurringBillCreateRequestParams, RecurringBill.class);
    }

    /**
     * Retrieves an recurringBill from the BDC database
     *
     * @param recurringBillGetRequestParams data for RecurringBill read request
     * @return                              the RecurringBill specified in the request
     * @throws BDCException                 when the response from the API is unsuccessful
     * @throws IOException                  when an I/O exception occurs on the underlying request
     */
    public static RecurringBill get(RecurringBillGetRequestParams recurringBillGetRequestParams) throws BDCException, IOException {
        if(recurringBillGetRequestParams == null) {
            throw new NullPointerException("RecurringBillGetRequestParams required");
        }
        return create(READ_URL, recurringBillGetRequestParams, RecurringBill.class);
    }

    /**
     * Updates an recurringBill in the BDC database
     *
     * @param recurringBillUpdateRequestParams data for RecurringBill update request
     * @return                                 the RecurringBill specified in the request
     * @throws BDCException                    when the response from the API is unsuccessful
     * @throws IOException                     when an I/O exception occurs on the underlying request
     */
    public static RecurringBill update(RecurringBillUpdateRequestParams recurringBillUpdateRequestParams) throws BDCException, IOException {
        if(recurringBillUpdateRequestParams == null) {
            throw new NullPointerException("RecurringBillUpdateRequestParams required");
        }
        return create(UPDATE_URL, recurringBillUpdateRequestParams, RecurringBill.class);
    }

    /**
     * Updates an recurringBill in the BDC database
     *
     * @param recurringBill       RecurringBill object to be updated to the BDC database
     * @return                    the RecurringBill specified in the request
     * @throws BDCException       when the response from the API is unsuccessful
     * @throws IOException        when an I/O exception occurs on the underlying request
     */
    public static RecurringBill update(RecurringBill recurringBill) throws BDCException, IOException {
        if(recurringBill == null) {
            throw new NullPointerException("RecurringBill required");
        }
        return create(UPDATE_URL, recurringBill, RecurringBill.class);
    }

    @Getter
    @Setter
    public static class RecurringBillLineItem {
        /** "RecurringBillLineItem" */
        @Setter(AccessLevel.NONE)
        @SerializedName("entity")
        private String entity;

        /**
         * System generated Unique Identifier. It is used to retrieve and refer the object in subsequent API calls.
         */
        @SerializedName("id")
        private String id;

        /**
         * ID of the Recurring Bill this lineitem belongs to
         */
        @SerializedName("recurringBillId")
        private String recurringBillId;

        /**
         * 	Amount of this line item on generated bills.
         */
        @SerializedName("amount")
        private BigDecimal amount;

        /**
         * Id of the account that this line item is coded to on generated bills.
         */
        @SerializedName("chartOfAccountId")
        private String chartOfAccountId;

        /**
         * 	Id of the department that this line item is coded to on generated bills.
         */
        @SerializedName("departmentId")
        private String departmentId;

        /**
         * Id of the location that this line item is coded to on generated bills.
         */
        @SerializedName("locationId")
        private String locationId;

        /**
         * Description of this line item on generated bills.
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

        private RecurringBillLineItem(String id,
                                      String recurringBillId,
                                      BigDecimal amount,
                                      String chartOfAccountId,
                                      String departmentId,
                                      String locationId,
                                      String description){
            this.entity = "BillLineItem";
            this.id = id;
            this.recurringBillId = recurringBillId;
            this.amount = amount;
            this.chartOfAccountId = chartOfAccountId;
            this.departmentId = departmentId;
            this.locationId = locationId;
            this.description = description;
        }

        /**
         * Makes a new Builder for RecurringBillLineItem
         *
         * @return a builder for RecurringBillLineItem
         */
        public static Builder builder() { return new Builder(); }

        /**
         * Builds a RecurringBillLineItem instance to be passed in when making an Invoice
         */
        public static class Builder {
            /**
             * System generated Unique Identifier. It is used to retrieve and refer the object in subsequent API calls.
             */
            public String id;

            /**
             * Id of the Recurring Bill this lineitem belongs to
             */
            public String recurringBillId;

            /**
             * Amount of this line item on generated bills.
             */
            public BigDecimal amount;

            /**
             * Id of the account that this line item is coded to on generated bills.
             */
            public String chartOfAccountId;

            /**
             * Id of the department that this line item is coded to on generated bills.
             */
            public String departmentId;

            /**
             * Id of the location that this line item is coded to on generated bills.
             */
            public String locationId;

            /**
             * Description of this line item on generated bills.
             */
            public String description;

            public Builder with(Consumer<Builder> builderFunction) {
                builderFunction.accept(this);
                return this;
            }

            /**
             * Builds a RecurringBillLineItem instance
             *
             * @return an RecurringBillLineItem
             */
            public RecurringBillLineItem build() {
                return new RecurringBillLineItem(
                        id,
                        recurringBillId,
                        amount,
                        chartOfAccountId,
                        departmentId,
                        locationId,
                        description
                );
            }
        }
    }
}
