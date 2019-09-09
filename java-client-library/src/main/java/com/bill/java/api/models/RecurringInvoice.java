package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.RecurringInvoiceCreateRequestParams;
import com.bill.java.api.param.RecurringInvoiceGetRequestParams;
import com.bill.java.api.param.RecurringInvoiceUpdateRequestParams;
import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

/**
 * This is a template to generate Invoice objects that creates individual invoices based on specified criteria.
 * <p>
 * Any edits/deletions of recurring invoices only impact future invoices. Already created recurring invoices are not affected.
 * The nested {@link #recurringInvoiceLineItems recurringInvoiceLineItems} array records more details.
 */
@Getter
@Setter
public class RecurringInvoice extends ApiResource {
    /* Resource endpoints for everything vendor related */
    /** The URI for creating a Customer through the BDC API {@value} */
    public static final String CREATE_URL = "/Crud/Create/RecurringInvoice.json";

    /** The URI for retrieving a RecurringInvoice through the BDC API {@value} */
    public static final String READ_URL = "/Crud/Read/RecurringInvoice.json";

    /** The URI for updating a RecurringInvoice through the BDC API {@value} */
    public static final String UPDATE_URL = "/Crud/Update/RecurringInvoice.json";

    /** The URI for disabling a RecurringInvoice through the BDC API {@value} */
    public static final String DELETE_URL = "/Crud/Delete/RecurringInvoice.json";

    /** The URI for undisabling a RecurringInvoice through the BDC API {@value} */
    public static final String UNDELETE_URL = "/Crud/Undelete/RecurringInvoice.json";

    /* All retrievable attributes of a RecurringInvoice */
    /** "RecurringInvoice" */
    @Setter(AccessLevel.NONE)
    @SerializedName("entity")
    private String entity;

    /**
     * System generated Unique Identifier. It is used to retrieve and refer the object in subsequent API calls. You can filter by this field on the List call.
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("id")
    private String id;

    /**
     * Denotes if object is active or inactive. Inactive objects are hidden by default.
     * <p>
     * "1" - Active
     * "2" - Inactive
     */
    @SerializedName("isActive")
    private String isActive;

    /**
     * ID of the customer that is used for generated invoices.
     */
    @SerializedName("customerId")
    private String customerId;

    /**
     * Identifies the Purchase Order associated to the generated invoices.
     */
    @SerializedName("poNumber")
    private String poNumber;

    /**
     * Name of the Sales Representative associated with generated invoices. Read-only for users and visible only if populated.
     */
    @SerializedName("salesRep")
    private String salesRep;

    /**
     * Department for the generated invoices. Normally used to set the default department for the line items and depending on the accounting system it can have different values than the line item department. You can filter by this field on the List call.
     */
    @SerializedName("departmentId")
    private String departmentId;

    /**
     * Location for the generated invoices. Normally used to set the default location for the line items and depending on the accounting system it can have different values than the line item location. You can filter by this field on the List call.
     */
    @SerializedName("locationId")
    private String locationId;

    /**
     * 	Accounting Class for the generated invoices. Normally used to set the default actgClass for the line items and depending on the accounting system it can have different values than the line item actgClass. You can filter by this field on the List call.
     */
    @SerializedName("actgClassId")
    private String actgClassId;

    /**
     * Job for the generated invoices. Normally used to set the default job for the line items and depending on the accounting system it can have different values than the line item job. You can filter by this field on the List call.
     */
    @SerializedName("jobId")
    private String jobId;

    /**
     * ID of the Sales Tax item that is applied to all taxable line items on generated invoices.
     */
    @SerializedName("itemSalesTax")
    private String itemSalesTax;

    /**
     * User-defined message to customer; visible to Users and Customers on generated invoices.
     */
    @SerializedName("description")
    private String description;

    /**
     * 	Flags invoice to be printed / mailed from Print/Mail queue.
     */
    @SerializedName("isToBePrinted")
    private Boolean isToBePrinted;

    /**
     * Flags invoice to be emailed from Email queue.
     */
    @SerializedName("isToBeEmailed")
    private Boolean isToBeEmailed;

    /**
     * Flags generated invoices to be emailed automatically after being generated. Emailed invoices will use the default invoice email template and will be sent to the default recipients (all unique email addresses on the Customer and its Customer Contacts).
     */
    @SerializedName("isToBeAutoEmailed")
    private Boolean isToBeAutoEmailed;

    /**
     * Flags generated invoices to be sent out via USPS automatically. Sent invoices.
     */
    @SerializedName("isToBeAutoMailed")
    private Boolean isToBeAutoMailed;

    /**
     * Utilized for generated invoices that are automatically emailed. Denotes the user whose email address will appear as the sender of the email.
     */
    @SerializedName("fromUserId")
    private String fromUserId;

    /**
     * "9" - none
     * "0" - Day
     * "1" - Week
     * "2" - Month
     * "3" - Year
     */
    @SerializedName("timePeriod")
    private String timePeriod;

    /**
     *
     */
    @SerializedName("frequencyPerTimePeriod")
    private Integer frequencyPerTimePeriod;

    /**
     * 	Sets the Due Date of the next invoice to be.
     */
    @SerializedName("nextDueDate")
    private String nextDueDate;

    /**
     * Date after which this Recurring Invoice profile will no longer generate invoices.
     */
    @SerializedName("endDate")
    private String endDate;

    /**
     * Number of days prior to nextDueDate that the next invoice is generated. If the resulting date has already passed for one or more invoices, those invoices will be generated within a few minutes of creating the Recurring Invoice profile.
     */
    @SerializedName("daysInAdvance")
    private Integer daysInAdvance;

    /**
     * Read only. Total amount that sales tax will be applied to.
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("taxableAmount")
    private BigDecimal taxableAmount;

    /**
     * Read only. Total amount of line items without taxes.
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("subtotal")
    private BigDecimal subtotal;

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

    @SerializedName("recurringInvoiceLineItems")
    private List<RecurringInvoiceLineItem> recurringInvoiceLineItems;

    /**
     * Creates an recurringInvoice in BDC
     *
     * @param recurringInvoiceCreateRequestParams data for RecurringInvoice creation
     * @return                           the RecurringInvoice that has been created through the BDC API
     * @throws BDCException              when the response from the API is unsuccessful
     * @throws IOException               when an I/O exception occurs on the underlying request
     */
    public static RecurringInvoice create(RecurringInvoiceCreateRequestParams recurringInvoiceCreateRequestParams) throws BDCException, IOException {
        if(recurringInvoiceCreateRequestParams == null) {
            throw new NullPointerException("RecurringInvoiceCreateRequestParams required");
        }
        return create(CREATE_URL, recurringInvoiceCreateRequestParams, RecurringInvoice.class);
    }

    /**
     * Retrieves an recurringInvoice from the BDC database
     *
     * @param recurringInvoiceGetRequestParams data for RecurringInvoice read request
     * @return                        the RecurringInvoice specified in the request
     * @throws BDCException           when the response from the API is unsuccessful
     * @throws IOException            when an I/O exception occurs on the underlying request
     */
    public static RecurringInvoice get(RecurringInvoiceGetRequestParams recurringInvoiceGetRequestParams) throws BDCException, IOException {
        if(recurringInvoiceGetRequestParams == null) {
            throw new NullPointerException("RecurringInvoiceGetRequestParams required");
        }
        return create(READ_URL, recurringInvoiceGetRequestParams, RecurringInvoice.class);
    }

    /**
     * Updates an recurringInvoice in the BDC database
     *
     * @param recurringInvoiceUpdateRequestparams data for RecurringInvoice update request
     * @return                           the RecurringInvoice specified in the request
     * @throws BDCException              when the response from the API is unsuccessful
     * @throws IOException               when an I/O exception occurs on the underlying request
     */
    public static RecurringInvoice update(RecurringInvoiceUpdateRequestParams recurringInvoiceUpdateRequestparams) throws BDCException, IOException {
        if(recurringInvoiceUpdateRequestparams == null) {
            throw new NullPointerException("RecurringInvoiceUpdateRequestParams required");
        }
        return create(UPDATE_URL, recurringInvoiceUpdateRequestparams, RecurringInvoice.class);
    }

    /**
     * Updates an recurringInvoice in the BDC database
     *
     * @param recurringInvoice       RecurringInvoice object to be updated to the BDC database
     * @return              the RecurringInvoice specified in the request
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException  when an I/O exception occurs on the underlying request
     */
    public static RecurringInvoice update(RecurringInvoice recurringInvoice) throws BDCException, IOException {
        if(recurringInvoice == null) {
            throw new NullPointerException("RecurringInvoice required");
        }
        return create(UPDATE_URL, recurringInvoice, RecurringInvoice.class);
    }


    /**
     *
     */
    @Getter
    @Setter
    public static class RecurringInvoiceLineItem {
        /**
         * RecurringInvoiceLineItem
         */
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
         * Id of the department that the recurring invoice line item is coded to.
         */
        @SerializedName("departmentId")
        private String departmentId;

        /**
         * Id of the location that the recurring invoice line item is coded to.
         */
        @SerializedName("locationId")
        private String locationId;

        /**
         * Id of the class that the recurring invoice line item is coded to.
         */
        @SerializedName("actgClassId")
        private String actgClassId;

        /**
         * Id of the job that the recurring invoice line item is coded to.
         */
        @SerializedName("jobId")
        private String jobId;

        /**
         * 	Recurring invoice line item description / memo.
         */
        @SerializedName("description")
        private String description;

        /**
         * Read-only. Refers to the Id of the recurring invoice that this line item is associated with
         */
        @Setter(AccessLevel.NONE)
        @SerializedName("recurringInvoiceId")
        private String recurringInvoiceId;

        /**
         * 	Id of the item being billed on the invoice line item.
         */
        @SerializedName("itemId")
        private String itemId;

        /**
         * Total amount for the line item (quantity * price OR ratePercent * amount of the line item above)
         */
        @SerializedName("amount")
        private BigDecimal amount;

        /**
         * Quantity of items sold OR hours / days spent providing the service.
         */
        @SerializedName("quantity")
        private Integer quantity;

        /**
         * Price / rate of the product or service invoiced.
         */
        @SerializedName("price")
        private BigDecimal price;

        /**
         * Percentage of the amount of the line item above to be added (if positive) or discounted (if negative). Only used if price is empty.
         */
        @SerializedName("ratePercent")
        private Integer ratePercent;

        /**
         * True if the recurring invoice line item is taxable (line item amount is included in the sales tax calculation).
         */
        @SerializedName("taxable")
        private Boolean taxable;


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

        private RecurringInvoiceLineItem(String departmentId,
                                         String locationId,
                                         String actgClassId,
                                         String jobId,
                                         String description,
                                         String itemId,
                                         BigDecimal amount,
                                         Integer quantity,
                                         BigDecimal price,
                                         Integer ratePercent,
                                         Boolean taxable){
            this.entity = "RecurringInvoiceLineItem";
            this.departmentId = departmentId;
            this.locationId = locationId;
            this.actgClassId = actgClassId;
            this.jobId = jobId;
            this.description = description;
            this.itemId = itemId;
            this.amount = amount;
            this.quantity = quantity;
            this.price = price;
            this.ratePercent = ratePercent;
            this.taxable = taxable;
        }

        /**
         * Makes a new Builder for RecurringInvoiceLineItem
         *
         * @return a builder for RecurringInvoiceLineItem
         */
        public static Builder builder() { return new Builder(); }

        /**
         * Builds a RecurringInvoiceLineItem instance to be passed in when making an Invoice
         */
        public static class Builder {
            /**
             * Department for the generated invoices. Normally used to set the default department for the line items and depending on the accounting system it can have different values than the line item department. You can filter by this field on the List call.
             */
            public String departmentId;

            /**
             * Location for the generated invoices. Normally used to set the default location for the line items and depending on the accounting system it can have different values than the line item location. You can filter by this field on the List call.
             */
            public String locationId;

            /**
             * 	Accounting Class for the generated invoices. Normally used to set the default actgClass for the line items and depending on the accounting system it can have different values than the line item actgClass. You can filter by this field on the List call.
             */
            public String actgClassId;

            /**
             * Job for the generated invoices. Normally used to set the default job for the line items and depending on the accounting system it can have different values than the line item job. You can filter by this field on the List call.
             */
            public String jobId;

            /**
             * User-defined message to customer; visible to Users and Customers on generated invoices.
             */
            public String description;

            /**
             * 	Id of the item being billed on the invoice line item.
             */
            public String itemId;

            /**
             * Total amount for the line item (quantity * price OR ratePercent * amount of the line item above)
             */
            public BigDecimal amount;

            /**
             * Quantity of items sold OR hours / days spent providing the service.
             */
            public Integer quantity;

            /**
             * Price / rate of the product or service invoiced.
             */
            public BigDecimal price;

            /**
             * Percentage of the amount of the line item above to be added (if positive) or discounted (if negative). Only used if price is empty.
             */
            public Integer ratePercent;

            /**
             * True if the recurring invoice line item is taxable (line item amount is included in the sales tax calculation).
             */
            public Boolean taxable;

            public Builder with(Consumer<Builder> builderFunction) {
                builderFunction.accept(this);
                return this;
            }

            /**
             * Builds a RecurringInvoiceLineItem instance
             *
             * @return an RecurringInvoiceLineItem
             */
            public RecurringInvoiceLineItem build() {
                return new RecurringInvoiceLineItem(
                        departmentId,
                        locationId,
                        actgClassId,
                        jobId,
                        description,
                        itemId,
                        amount,
                        quantity,
                        price,
                        ratePercent,
                        taxable
                );
            }
        }
    }
}
