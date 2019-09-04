package com.bill.java.api.param;

import com.bill.java.api.models.Invoice;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.function.Consumer;

public class InvoiceUpdateRequestParams extends ApiResourceParams {
    /* Holds the actual api resource variables for creation */
    @SerializedName("obj")
    protected final Params params;

    private InvoiceUpdateRequestParams(Params params) { this.params = params; }

    /**
     * Makes a new Builder for InvoiceUpdateRequestParams
     *
     * @return a builder for InvoiceUpdateRequestParams
     */
    public static Builder builder() { return new Builder(); }

    /**
     * Builds an InvoiceUpdateRequestParams instance
     */
    public static class Builder {
        /**
         * 	System generated Unique Identifier. It is used to retrieve and refer the object in subsequent API calls. You can filter by this field on the List call.
         */
        public String id;

        /**
         * 	Denotes if object is active or inactive. Inactive objects are hidden by default and are only visible in UI when user clicks
         * 	<p>
         * 	"1" - Active
         * 	"2" - Inactive
         */
        public String isActive;

        /**
         * ID of Customer this invoice is assigned to.
         */
        public String customerId;

        /**
         * User defined unique identifier for the bill. Usually, provided on the bill. If not, users typically enter the bill's date or billing period. You can filter by this field on the List call.
         */
        public String invoiceNumber;

        /**
         * Date invoice is issued to customer. You can filter by this field on the List call.
         */
        public String invoiceDate;

        /**
         * Date payment is due for this invoice. You can filter by this field on the List call.
         */
        public String dueDate;

        /**
         * Date the invoice is posted to user's third-party system, if supported. You can filter by this field on the List call.
         */
        public String glPostingDate;

        /**
         * User-defined message to customer; visible to Users and Customers.
         */
        public String description;

        /**
         * Identifies the Purchase Order associated to this invoice.
         */
        public String poNumber;

        /**
         * Flags invoice to be printed / mailed from Print/Mail queue.
         */
        public Boolean isToBePrinted;

        /**
         * Flags invoice to be emailed from Email queue.
         */
        public Boolean isToBeEmailed;

        /**
         *
         */
        public String lastSentTime;

        /**
         * Id of the Sales Tax item that is applied to all taxable line items on the invoice.
         */
        public String itemSalesTax;

        /**
         * Read only. Total amount of sales tax applied to this invoice (sales tax percentage times the taxable line items amounts)
         */
        public Integer salesTaxTotal;

        /**
         * Payment terms chosen for this invoice.
         */
        public String terms;

        /**
         * Name of the Sales Representative associated with this invoice. Read-only for users and visible only if populated.
         */
        public String salesRep;

        /**
         * Shipping information for this invoice. Read-only for users and visible only if populated.
         */
        public String FOB;

        /**
         * Date product(s) were shipped to this customer. Read-only for users and visible only if populated and related customer has shipping address. You can filter by this field on the List call.
         */
        public String shipDate;

        /**
         * Method by which product(s) were shipped to this customer. Read-only for users and visible only if populated.
         */
        public String shipMethod;

        /**
         * Department for the invoice. Normally used to set the default department for the line items and depending on the accounting system it can have different values than the line item department. You can filter by this field on the List call.
         */
        public String departmentId;

        /**
         * 	Location for the invoice. Normally used to set the default location for the line items and depending on the accounting system it can have different values than the line item location. You can filter by this field on the List call.
         */
        public String locationId;

        /**
         * Accounting Class for the invoice. Normally used to set the default actgClass for the line items and depending on the accounting system it can have different values than the line item actgClass. You can filter by this field on the List call.
         */
        public String actgClassId;

        /**
         * Job for the invoice. Normally used to set the default job for the line items and depending on the accounting system it can have different values than the line item job. You can filter by this field on the List call.
         */
        public String jobId;

        /**
         * Bank account expected to receive this invoice's payment. Currently, only used by selected partners. You can filter by this field on the List call.
         */
        public String payToBankAccountId;

        /**
         * Chart of account you expect to post this invoice's payment to. Currently, only used by selected partners. You can filter by this field on the List call.
         */
        public String payToChartOfAccountId;

        /**
         * List of items applied to the Invoice
         */
        public List<Invoice.InvoiceLineItem> invoiceLineItems;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public InvoiceUpdateRequestParams build() {
            return new InvoiceUpdateRequestParams(
                    new Params(
                            id,
                            isActive,
                            customerId,
                            invoiceNumber,
                            invoiceDate,
                            dueDate,
                            glPostingDate,
                            description,
                            poNumber,
                            isToBePrinted,
                            isToBeEmailed,
                            lastSentTime,
                            itemSalesTax,
                            salesTaxTotal,
                            terms,
                            salesRep,
                            FOB,
                            shipDate,
                            shipMethod,
                            departmentId,
                            locationId,
                            actgClassId,
                            jobId,
                            payToBankAccountId,
                            payToChartOfAccountId,
                            invoiceLineItems)
            );
        }
    }

    public static class Params {
        @SerializedName("entity")
        private String entity = "Invoice";

        @SerializedName("id")
        private String id;

        @SerializedName("isActive")
        private String isActive;

        @SerializedName("customerId")
        private String customerId;

        @SerializedName("invoiceNumber")
        private String invoiceNumber;

        @SerializedName("invoiceDate")
        private String invoiceDate;

        @SerializedName("dueDate")
        private String dueDate;

        @SerializedName("glPostingDate")
        private String glPostingDate;

        @SerializedName("description")
        private String description;

        @SerializedName("poNumber")
        private String poNumber;

        @SerializedName("isToBePrinted")
        private Boolean isToBePrinted;

        @SerializedName("isToBeEmailed")
        private Boolean isToBeEmailed;

        @SerializedName("lastSentTime")
        private String lastSentTime;

        @SerializedName("itemSalesTax")
        private String itemSalesTax;

        @SerializedName("salesTaxTotal")
        private Integer salesTaxTotal;

        @SerializedName("terms")
        private String terms;

        @SerializedName("salesRep")
        private String salesRep;

        @SerializedName("FOB")
        private String FOB;

        @SerializedName("shipDate")
        private String shipDate;

        @SerializedName("shipMethod")
        private String shipMethod;

        @SerializedName("departmentId")
        private String departmentId;

        @SerializedName("locationId")
        private String locationId;

        @SerializedName("actgClassId")
        private String actgClassId;

        @SerializedName("jobId")
        private String jobId;

        @SerializedName("payToBankAccountId")
        private String payToBankAccountId;

        @SerializedName("payToChartOfAccountId")
        private String payToChartOfAccountId;

        @SerializedName("invoiceLineItems")
        private List<Invoice.InvoiceLineItem> invoiceLineItems;

        Params(String id,
               String isActive,
               String customerId,
               String invoiceNumber,
               String invoiceDate,
               String dueDate,
               String glPostingDate,
               String description,
               String poNumber,
               Boolean isToBePrinted,
               Boolean isToBeEmailed,
               String lastSentTime,
               String itemSalesTax,
               Integer salesTaxTotal,
               String terms,
               String salesRep,
               String FOB,
               String shipDate,
               String shipMethod,
               String departmentId,
               String locationId,
               String actgClassId,
               String jobId,
               String payToBankAccountId,
               String payToChartOfAccountId,
               List<Invoice.InvoiceLineItem> invoiceLineItems) {
            this.id = id;
            this.isActive = isActive;
            this.customerId = customerId;
            this.invoiceNumber = invoiceNumber;
            this.invoiceDate = invoiceDate;
            this.dueDate = dueDate;
            this.glPostingDate = glPostingDate;
            this.description = description;
            this.poNumber = poNumber;
            this.isToBePrinted = isToBePrinted;
            this.isToBeEmailed = isToBeEmailed;
            this.lastSentTime = lastSentTime;
            this.itemSalesTax = itemSalesTax;
            this.salesTaxTotal = salesTaxTotal;
            this.terms = terms;
            this.salesRep = salesRep;
            this.FOB = FOB;
            this.shipDate = shipDate;
            this.shipMethod = shipMethod;
            this.departmentId = departmentId;
            this.locationId = locationId;
            this.actgClassId = actgClassId;
            this.jobId = jobId;
            this.payToBankAccountId = payToBankAccountId;
            this.payToChartOfAccountId = payToChartOfAccountId;
            this.invoiceLineItems = invoiceLineItems;
        }
    }
}
