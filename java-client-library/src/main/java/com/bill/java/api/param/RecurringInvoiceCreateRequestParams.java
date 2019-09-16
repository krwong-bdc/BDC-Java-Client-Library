package com.bill.java.api.param;

import com.bill.java.api.models.RecurringInvoice;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.function.Consumer;

/**
 * Parameters for creating a RecurringInvoice through the BDC API
 */
public class RecurringInvoiceCreateRequestParams extends ApiResourceParams {
    /* Holds the actual api resource variables for creation */
    @SerializedName("obj")
    protected final Params params;

    private RecurringInvoiceCreateRequestParams(Params params) { this.params = params; }

    /**
     * Makes a new Builder for RecurringInvoiceCreateRequestParams
     *
     * @return a builder for RecurringInvoiceCreateRequestParams
     */
    public static Builder builder() { return new Builder(); }

    /**
     * Builds an RecurringInvoiceCreateRequestParams instance
     */
    public static class Builder {
        /**
         * Denotes if object is active or inactive. Inactive objects are hidden by default.
         * <p>
         * "1" - Active
         * "2" - Inactive
         */
        public String isActive;

        /**
         * ID of the customer that is used for generated invoices.
         */
        public String customerId;

        /**
         * 	Identifies the Purchase Order associated to the generated invoices.
         */
        public String poNumber;

        /**
         * Name of the Sales Representative associated with generated invoices. Read-only for users and visible only if populated.
         */
        public String salesRep;

        /**
         * Department for the generated invoices. Normally used to set the default department for the line items and depending on the accounting system it can have different values than the line item department. You can filter by this field on the List call.
         */
        public String departmentId;

        /**
         * 	Location for the generated invoices. Normally used to set the default location for the line items and depending on the accounting system it can have different values than the line item location. You can filter by this field on the List call.
         */
        public String locationId;

        /**
         * Accounting Class for the generated invoices. Normally used to set the default actgClass for the line items and depending on the accounting system it can have different values than the line item actgClass. You can filter by this field on the List call.
         */
        public String actgClassId;

        /**
         * Job for the generated invoices. Normally used to set the default job for the line items and depending on the accounting system it can have different values than the line item job. You can filter by this field on the List call.
         */
        public String jobId;

        /**
         * 	ID of the Sales Tax item that is applied to all taxable line items on generated invoices.
         */
        public String itemSalesTax;

        /**
         * User-defined message to customer; visible to Users and Customers on generated invoices.
         */
        public String description;

        /**
         * Flags invoice to be printed / mailed from Print/Mail queue.
         */
        public Boolean isToBePrinted;

        /**
         * Flags invoice to be emailed from Email queue.
         */
        public Boolean isToBeEmailed;

        /**
         * Flags generated invoices to be emailed automatically after being generated. Emailed invoices will use the default invoice email template and will be sent to the default recipients (all unique email addresses on the Customer and its Customer Contacts).
         */
        public Boolean isToBeAutoEmailed;

        /**
         * 	Flags generated invoices to be sent out via USPS automatically. Sent invoices.
         */
        public Boolean isToBeAutoMailed;

        /**
         * 	Utilized for generated invoices that are automatically emailed. Denotes the user whose email address will appear as the sender of the email.
         */
        public String fromUserId;

        /**
         * "9" - none
         * "0" - Day
         * "1" - Week
         * "2" - Month
         * "3" - Year
         */
        public String timePeriod;

        /**
         *
         */
        public Integer frequencyPerTimePeriod;

        /**
         * 	Sets the Due Date of the next invoice to be.
         */
        public String nextDueDate;

        /**
         * Date after which this Recurring Invoice profile will no longer generate invoices.
         */
        public String endDate;

        /**
         * Number of days prior to nextDueDate that the next invoice is generated. If the resulting date has already passed for one or more invoices, those invoices will be generated within a few minutes of creating the Recurring Invoice profile.
         */
        public Integer daysInAdvance;

        /**
         * List of recurringInvoiceLineItems
         */
        public List<RecurringInvoice.RecurringInvoiceLineItem> recurringInvoiceLineItems;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds an RecurringInvoiceCreateRequestParams instance with the set parameters.
         *
         * @return RecurringInvoiceCreateRequestParams
         */
        public RecurringInvoiceCreateRequestParams build() {
            return new RecurringInvoiceCreateRequestParams(
                    new Params(
                            isActive,
                            customerId,
                            poNumber,
                            salesRep,
                            departmentId,
                            locationId,
                            actgClassId,
                            jobId,
                            itemSalesTax,
                            description,
                            isToBePrinted,
                            isToBeEmailed,
                            isToBeAutoEmailed,
                            isToBeAutoMailed,
                            fromUserId,
                            timePeriod,
                            frequencyPerTimePeriod,
                            nextDueDate,
                            endDate,
                            daysInAdvance,
                            recurringInvoiceLineItems
                    )
            );
        }
    }

    /* Holds request data. Will be nested in <tt>obj</tt> */
    private static class Params {
        @SerializedName("entity")
        private String entity = "RecurringInvoice";

        @SerializedName("isActive")
        private String isActive;

        @SerializedName("customerId")
        private String customerId;

        @SerializedName("poNumber")
        private String poNumber;

        @SerializedName("salesRep")
        private String salesRep;

        @SerializedName("departmentId")
        private String departmentId;

        @SerializedName("locationId")
        private String locationId;

        @SerializedName("actgClassId")
        private String actgClassId;

        @SerializedName("jobId")
        private String jobId;

        @SerializedName("itemSalesTax")
        private String itemSalesTax;

        @SerializedName("description")
        private String description;

        @SerializedName("isToBePrinted")
        private Boolean isToBePrinted;

        @SerializedName("isToBeEmailed")
        private Boolean isToBeEmailed;

        @SerializedName("isToBeAutoEmailed")
        private Boolean isToBeAutoEmailed;

        @SerializedName("isToBeAutoMailed")
        private Boolean isToBeAutoMailed;

        @SerializedName("fromUserId")
        private String fromUserId;

        @SerializedName("timePeriod")
        private String timePeriod;

        @SerializedName("frequencyPerTimePeriod")
        private Integer frequencyPerTimePeriod;

        @SerializedName("nextDueDate")
        private String nextDueDate;

        @SerializedName("endDate")
        private String endDate;

        @SerializedName("daysInAdvance")
        private Integer daysInAdvance;

        @SerializedName("recurringInvoiceLineItems")
        private List<RecurringInvoice.RecurringInvoiceLineItem> recurringInvoiceLineItems;

        Params(String isActive,
               String customerId,
               String poNumber,
               String salesRep,
               String departmentId,
               String locationId,
               String actgClassId,
               String jobId,
               String itemSalesTax,
               String description,
               Boolean isToBePrinted,
               Boolean isToBeEmailed,
               Boolean isToBeAutoEmailed,
               Boolean isToBeAutoMailed,
               String fromUserId,
               String timePeriod,
               Integer frequencyPerTimePeriod,
               String nextDueDate,
               String endDate,
               Integer daysInAdvance,
               List<RecurringInvoice.RecurringInvoiceLineItem> recurringInvoiceLineItems) {
            this.isActive = isActive;
            this.customerId = customerId;
            this.poNumber = poNumber;
            this.salesRep = salesRep;
            this.departmentId = departmentId;
            this.locationId = locationId;
            this.actgClassId = actgClassId;
            this.jobId = jobId;
            this.itemSalesTax = itemSalesTax;
            this.description = description;
            this.isToBePrinted = isToBePrinted;
            this.isToBeEmailed = isToBeEmailed;
            this.isToBeAutoEmailed = isToBeAutoEmailed;
            this.isToBeAutoMailed = isToBeAutoMailed;
            this.fromUserId = fromUserId;
            this.timePeriod = timePeriod;
            this.frequencyPerTimePeriod = frequencyPerTimePeriod;
            this.nextDueDate = nextDueDate;
            this.endDate = endDate;
            this.daysInAdvance = daysInAdvance;
            this.recurringInvoiceLineItems = recurringInvoiceLineItems;
        }
    }
}
