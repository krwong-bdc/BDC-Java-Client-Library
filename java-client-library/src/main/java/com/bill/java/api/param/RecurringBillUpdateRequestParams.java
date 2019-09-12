package com.bill.java.api.param;

import com.bill.java.api.models.RecurringBill;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.function.Consumer;

/**
 * Parameters for updating a RecurringBill through the BDC API
 */
public class RecurringBillUpdateRequestParams extends ApiResourceParams {
    /* Holds the actual api resource variables for creation */
    @SerializedName("obj")
    protected final Params params;

    private RecurringBillUpdateRequestParams(Params params) { this.params = params; }

    /**
     * Makes a new Builder for RecurringBillUpdateRequestParams
     *
     * @return a builder for RecurringBillUpdateRequestParams
     */
    public static Builder builder() { return new Builder(); }

    /**
     * Builds an RecurringBillUpdateRequestParams instance
     */
    public static class Builder {
        /**
         * System generated Unique Identifier. It is used to retrieve and refer the object in subsequent API calls.
         */
        public String id;

        /**
         * Denotes if object is active or inactive. Inactive objects are hidden by default and are only visible in UI when user clicks.
         * <p>
         * "1" - Active
         * "2" - Inactive
         */
        public String isActive;

        /**
         * 	Id of the vendor that is used for generated bills.
         */
        public String vendorId;

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
         * User-defined message to customer; visible to Users and Customers on generated invoices.
         */
        public String description;

        /**
         * List of recurringInvoiceLineItems
         */
        public List<RecurringBill.RecurringBillLineItem> recurringBillLineItems;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds an RecurringBillUpdateRequestParams instance with the set parameters.
         *
         * @return RecurringBillUpdateRequestParams
         */
        public RecurringBillUpdateRequestParams build() {
            return new RecurringBillUpdateRequestParams(
                    new Params(
                            id,
                            isActive,
                            vendorId,
                            timePeriod,
                            frequencyPerTimePeriod,
                            nextDueDate,
                            endDate,
                            daysInAdvance,
                            description,
                            recurringBillLineItems)
            );
        }
    }

    private static class Params {
        @SerializedName("entity")
        private String entity = "RecurringBill";

        @SerializedName("id")
        private String id;

        @SerializedName("isActive")
        private String isActive;

        @SerializedName("vendorId")
        private String vendorId;

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

        @SerializedName("description")
        private String description;

        @SerializedName("recurringBillLineItems")
        private List<RecurringBill.RecurringBillLineItem> recurringBillLineItems;

        Params(String id,
               String isActive,
               String vendorId,
               String timePeriod,
               Integer frequencyPerTimePeriod,
               String nextDueDate,
               String endDate,
               Integer daysInAdvance,
               String description,
               List<RecurringBill.RecurringBillLineItem> recurringBillLineItems) {
            this.id = id;
            this.isActive = isActive;
            this.vendorId = vendorId;
            this.timePeriod = timePeriod;
            this.frequencyPerTimePeriod = frequencyPerTimePeriod;
            this.nextDueDate = nextDueDate;
            this.endDate = endDate;
            this.daysInAdvance = daysInAdvance;
            this.description = description;
            this.recurringBillLineItems = recurringBillLineItems;
        }
    }
}
