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

/**
 * <p>Represents products and/or services purchased by a {@link com.bill.java.api.models.Customer Customer} from your organization.
 * The nested {@link #invoiceLineItems invoiceLineItems} array records products or services.
 */
@Getter
@Setter
public class Invoice extends ApiResource {
    /* Resource endpoints for everything vendor related */
    /** The URI for creating an Invoice through the BDC API {@value} */
    public static final String CREATE_URL = "/Crud/Create/Invoice.json";

    /** The URI for retrieving an Invoice through the BDC API {@value} */
    public static final String READ_URL = "/Crud/Read/Invoice.json";

    /** The URI for updating an Invoice through the BDC API {@value} */
    public static final String UPDATE_URL = "/Crud/Update/Invoice.json";

    /** The URI for disabling an Invoice through the BDC API {@value} */
    public static final String DELETE_URL = "/Crud/Delete/Invoice.json";

    /** The URI for undisabling an Invoice through the BDC API {@value} */
    public static final String UNDELETE_URL = "/Crud/Undelete/Invoice.json";

    /** The URI for Emailing an Invoice to customers through the BDC API {@value} */
    public static final String SEND_INVOICE_URL = "/SendInvoice.json";

    /** The URI for sending an Invoice via mail to customers through the BDC API {@value} */
    public static final String MAIL_INVOICE_URL = "/MailInvoice.json";

    /* All retrievable attributes of an Invoice */
    /** "Invoice" */
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
     * 	Denotes if object is active or inactive. Inactive objects are hidden by default and are only visible in UI when user clicks
     * 	<p>
     * 	"1" - Active
     * 	"2" - Inactive
     */
    @SerializedName("isActive")
    private String isActive;

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
     * ID of Customer this invoice is assigned to.
     */
    @SerializedName("customerId")
    private String customerId;

    /**
     * User defined unique identifier for the bill. Usually, provided on the bill. If not, users typically enter the bill's date or billing period. You can filter by this field on the List call.
     */
    @SerializedName("invoiceNumber")
    private String invoiceNumber;

    /**
     * Date invoice is issued to customer. You can filter by this field on the List call.
     */
    @SerializedName("invoiceDate")
    private String invoiceDate;

    /**
     * Date payment is due for this invoice. You can filter by this field on the List call.
     */
    @SerializedName("dueDate")
    private String dueDate;

    /**
     * Date the invoice is posted to user's third-party system, if supported. You can filter by this field on the List call.
     */
    @SerializedName("glPostingDate")
    private String glPostingDate;

    /**
     * Total amount of this invoice.
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("amount")
    private BigDecimal amount;

    /**
     * Amount remaining before this invoice is fully paid.
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("amountDue")
    private BigDecimal amountDue;

    /**
     * Denotes the invoice as paid, partially paid, scheduled or unpaid. You can filter by this field on the List call.
     * <p>
     * 1. Open
     * 4. Scheduled
     * 0. PaidInFull
     * 2. PartialPayment
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("paymentStatus")
    private String paymentStatus;

    /**
     * User-defined message to customer; visible to Users and Customers.
     */
    @SerializedName("description")
    private String description;

    /**
     * Identifies the Purchase Order associated to this invoice.
     */
    @SerializedName("poNumber")
    private String poNumber;

    /**
     * Flags invoice to be printed / mailed from Print/Mail queue.
     */
    @SerializedName("isToBePrinted")
    private Boolean isToBePrinted;

    /**
     * Flags invoice to be emailed from Email queue.
     */
    @SerializedName("isToBeEmailed")
    private Boolean isToBeEmailed;

    /**
     *
     */
    @SerializedName("lastSentTime")
    private String lastSentTime;

    /**
     * Id of the Sales Tax item that is applied to all taxable line items on the invoice.
     */
    @SerializedName("itemSalesTax")
    private String itemSalesTax;

    /**
     * Read only. Rate (percentage) value of the Sales Tax item that is applied to all taxable line items on this invoice.
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("salesTaxPercentage")
    private Integer salesTaxPercentage;

    /**
     * Read only. Total amount of sales tax applied to this invoice (sales tax percentage times the taxable line items amounts)
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("salesTaxTotal")
    private BigDecimal salesTaxTotal;

    /**
     * Payment terms chosen for this invoice.
     */
    @SerializedName("terms")
    private String terms;

    /**
     * Name of the Sales Representative associated with this invoice. Read-only for users and visible only if populated.
     */
    @SerializedName("salesRep")
    private String salesRep;

    /**
     * Shipping information for this invoice. Read-only for users and visible only if populated.
     */
    @SerializedName("FOB")
    private String FOB;

    /**
     * Date product(s) were shipped to this customer. Read-only for users and visible only if populated and related customer has shipping address. You can filter by this field on the List call.
     */
    @SerializedName("shipDate")
    private String shipDate;

    /**
     * Method by which product(s) were shipped to this customer. Read-only for users and visible only if populated.
     */
    @SerializedName("shipMethod")
    private String shipMethod;

    /**
     * Department for the invoice. Normally used to set the default department for the line items and depending on the accounting system it can have different values than the line item department. You can filter by this field on the List call.
     */
    @SerializedName("departmentId")
    private String departmentId;

    /**
     * 	Location for the invoice. Normally used to set the default location for the line items and depending on the accounting system it can have different values than the line item location. You can filter by this field on the List call.
     */
    @SerializedName("locationId")
    private String locationId;

    /**
     * Accounting Class for the invoice. Normally used to set the default actgClass for the line items and depending on the accounting system it can have different values than the line item actgClass. You can filter by this field on the List call.
     */
    @SerializedName("actgClassId")
    private String actgClassId;

    /**
     * Job for the invoice. Normally used to set the default job for the line items and depending on the accounting system it can have different values than the line item job. You can filter by this field on the List call.
     */
    @SerializedName("jobId")
    private String jobId;

    /**
     * Bank account expected to receive this invoice's payment. Currently, only used by selected partners. You can filter by this field on the List call.
     */
    @SerializedName("payToBankAccountId")
    private String payToBankAccountId;

    /**
     * Chart of account you expect to post this invoice's payment to. Currently, only used by selected partners. You can filter by this field on the List call.
     */
    @SerializedName("payToChartOfAccountId")
    private String payToChartOfAccountId;

    /**
     * List of items applied to the Invoice
     */
    @SerializedName("invoiceLineItems")
    private List<InvoiceLineItem> invoiceLineItems;

    /**
     * Creates an invoice in BDC
     *
     * @param invoiceCreateRequestParams data for Invoice creation
     * @return                           the Invoice that has been created through the BDC API
     * @throws BDCException              when the response from the API is unsuccessful
     * @throws IOException               when an I/O exception occurs on the underlying request
     */
    public static Invoice create(InvoiceCreateRequestParams invoiceCreateRequestParams) throws BDCException, IOException {
        if(invoiceCreateRequestParams == null) {
            throw new NullPointerException("InvoiceCreateRequestParams required");
        }
        return create(CREATE_URL, invoiceCreateRequestParams, Invoice.class);
    }

    /**
     * Retrieves an invoice from the BDC database
     *
     * @param invoiceGetRequestParams data for Invoice read request
     * @return                        the Invoice specified in the request
     * @throws BDCException           when the response from the API is unsuccessful
     * @throws IOException            when an I/O exception occurs on the underlying request
     */
    public static Invoice get(InvoiceGetRequestParams invoiceGetRequestParams) throws BDCException, IOException {
        if(invoiceGetRequestParams == null) {
            throw new NullPointerException("InvoiceGetRequestParams required");
        }
        return create(READ_URL, invoiceGetRequestParams, Invoice.class);
    }

    /**
     * Updates an invoice in the BDC database
     *
     * @param invoiceUpdateRequestParams data for Invoice update request
     * @return                           the Invoice specified in the request
     * @throws BDCException              when the response from the API is unsuccessful
     * @throws IOException               when an I/O exception occurs on the underlying request
     */
    public static Invoice update(InvoiceUpdateRequestParams invoiceUpdateRequestParams) throws BDCException, IOException {
        if(invoiceUpdateRequestParams == null) {
            throw new NullPointerException("InvoiceUpdateRequestParams required");
        }
        return create(UPDATE_URL, invoiceUpdateRequestParams, Invoice.class);
    }

    /**
     * Updates an invoice in the BDC database
     *
     * @param invoice       Invoice object to be updated to the BDC database
     * @return              the Invoice specified in the request
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException  when an I/O exception occurs on the underlying request
     */
    public static Invoice update(Invoice invoice) throws BDCException, IOException {
        if(invoice == null) {
            throw new NullPointerException("Invoice required");
        }
        return create(UPDATE_URL, invoice, Invoice.class);
    }

    /**
     *  Emails an invoice to emails specified in the request params. The email ("headers" and "content") are customized with template tokens. If tokens are not specified in the call, parameters are pulled from the Default Email Template.
     *  <p>
     *  NOTE: the API cannot change the Default Email Template. Edits to the template MUST be made on the Bill.com UI.
     *
     *  Use tokens (exactly as shown) to dynamically populate information in the email body. When sent, tokens are replaced with data.
     *
     * {:Customer.Name:} – customer for the invoice.
     *
     * {:Invoice.Number:} – invoice # for the invoice
     *
     * {:Invoice.AmountDue:} – amount due
     *
     * {:Invoice.DueDate:} – invoice due date
     *
     * {:Link_Pay_Invoice:} – URL of your company’s Bill.com Customer Portal.
     *
     * @param sendInvoiceRequestParams data for sending an Invoice
     * @return                         true if emails sent successfully
     * @throws BDCException            when the response from the API is unsuccessful
     * @throws IOException             when an I/O exception occurs on the underlying request
     */
    public static Boolean sendInvoice(SendInvoiceRequestParams sendInvoiceRequestParams) throws BDCException, IOException {
        if(sendInvoiceRequestParams == null) {
            throw new NullPointerException("SendInvoiceRequestParams required");
        }

        httpClient.request(SEND_INVOICE_URL, sendInvoiceRequestParams).getJsonData();

        return true;
    }

    /**
     * If your Customer is not part of the Bill.com network, use this call to send invoices via US mail.
     * <p>
     * The specified invoice will be printed and mailed from Bill.com to the Customer. On the Bill.com UI, this is applied on the Invoice option to "Send via US Mail".
     *
     * @param mailInvoiceRequestParams data for sending an Invoice via mail
     * @return                         true if emails sent successfully
     * @throws BDCException            when the response from the API is unsuccessful
     * @throws IOException             when an I/O exception occurs on the underlying request
     */
    public static Boolean mailInvoice(MailInvoiceRequestParams mailInvoiceRequestParams) throws BDCException, IOException {
        if(mailInvoiceRequestParams == null) {
            throw new NullPointerException("MailInvoiceRequestParams required");
        }

        httpClient.request(MAIL_INVOICE_URL, mailInvoiceRequestParams).getJsonData();

        return true;
    }

    /**
     * Represents a product or service
     */
    @Getter
    @Setter
    public static class InvoiceLineItem {
        /**
         * InvoiceLineItem
         */
        @Setter(AccessLevel.NONE)
        @SerializedName("entity")
        private String entity;

        /**
         * System generated Unique Identifier. It is used to retrieve and refer the object in subsequent API calls.
         */
        @SerializedName("id")
        private String id;

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
         * Read-only. Refers to the Id of the invoice that this line item is associated with
         */
        @Setter(AccessLevel.NONE)
        @SerializedName("invoiceId")
        private String invoiceId;

        /**
         * Id of the item being billed on the invoice line item.
         */
        @SerializedName("itemId")
        private String itemId;

        /**
         * Quantity of items sold OR hours / days spent providing the service.
         */
        @SerializedName("quantity")
        private Integer quantity;

        /**
         * Total amount for the line item (quantity * price OR ratePercent * amount of the line item above)
         */
        @SerializedName("amount")
        private BigDecimal amount;

        /**
         * Price / rate of the product or service invoiced.
         */
        @SerializedName("price")
        private BigDecimal price;

        /**
         * 	Date that the service was provided / product sold. Read-only for users and visible only if populated by QuickBooks for Windows sync.
         */
        @Setter(AccessLevel.NONE)
        @SerializedName("serviceDate")
        private String serviceDate;

        /**
         * Percentage of the amount of the line item above to be added (if positive) or discounted (if negative). Only used if price is empty.
         */
        @SerializedName("ratePercent")
        private Integer ratePercent;

        /**
         *Id of the account that the invoice line item is coded to.
         */
        @SerializedName("chartOfAccountId")
        private String chartOfAccountId;

        /**
         * Id of the department that the invoice line item is coded to.
         */
        @SerializedName("departmentId")
        private String departmentId;

        /**
         * Id of the location that the invoice line item is coded to.
         */
        @SerializedName("locationId")
        private String locationId;

        /**
         * Id of the class that the invoice line item is coded to.
         */
        @SerializedName("actgClassId")
        private String actgClassId;

        /**
         * Id of the job that the invoice line item is coded to.
         */
        @SerializedName("jobId")
        private String jobId;

        /**
         * 	Invoice line item description / memo.
         */
        @SerializedName("description")
        private String description;

        /**
         * True if the invoice line item is taxable (line item amount is included in the sales tax calculation).
         */
        @SerializedName("taxable")
        private Boolean taxable;

        @SerializedName("taxCode")
        private String taxCode;

        private InvoiceLineItem(String id,
                                String itemId,
                                Integer quantity,
                                BigDecimal amount,
                                BigDecimal price,
                                String serviceDate,
                                Integer ratePercent,
                                String chartOfAccountId,
                                String departmentId,
                                String locationId,
                                String actgClassId,
                                String jobId,
                                String description,
                                Boolean taxable,
                                String taxCode){
            this.entity = "InvoiceLineItem";
            this.id = id;
            this.itemId = itemId;
            this.quantity = quantity;
            this.amount = amount;
            this.price = price;
            this.serviceDate = serviceDate;
            this.ratePercent = ratePercent;
            this.chartOfAccountId = chartOfAccountId;
            this.departmentId = departmentId;
            this.locationId = locationId;
            this.actgClassId = actgClassId;
            this.jobId = jobId;
            this.description = description;
            this.taxable = taxable;
            this.taxCode = taxCode;
        }

        /**
         * Makes a new Builder for InvoiceLineItem
         *
         * @return a builder for InvoiceLineItem
         */
        public static Builder builder() {
            return new Builder();
        }

        /**
         * Builds a InvoiceLineItem instance to be passed in when making an Invoice
         */
        public static class Builder {
            /**
             * System Generated unique Identifier for the BillLineItem
             */
            public String id;

            /**
             * 	Id of the item being billed on the invoice line item.
             */
            public String itemId;

            /**
             * Quantity of items sold OR hours / days spent providing the service.
             */
            public Integer quantity;

            /**
             * Total amount for the line item (quantity * price OR ratePercent * amount of the line item above).
             */
            public BigDecimal amount;

            /**
             * Price / rate of the product or service invoiced.
             */
            public BigDecimal price;

            /**
             * Date that the service was provided / product sold. Read-only for users and visible only if populated by QuickBooks for Windows sync.
             */
            public String serviceDate;

            /**
             * Percentage of the amount of the line item above to be added (if positive) or discounted (if negative). Only used if price is empty.
             */
            public Integer ratePercent;

            /**
             * 	Id of the account that the invoice line item is coded to.
             */
            public String chartOfAccountId;

            /**
             * Id of the department that the invoice line item is coded to.
             */
            public String departmentId;

            /**
             * Id of the location that the invoice line item is coded to.
             */
            public String locationId;

            /**
             * 	Id of the class that the invoice line item is coded to.
             */
            public String actgClassId;

            /**
             * Id of the job that the invoice line item is coded to.
             */
            public String jobId;

            /**
             * Invoice line item description / memo
             */
            public String description;

            /**
             * True if the invoice line item is taxable (line item amount is included in the sales tax calculation).
             */
            public Boolean taxable;

            /**
             *
             */
            public String taxCode;

            public Builder with(Consumer<Builder> builderFunction) {
                builderFunction.accept(this);
                return this;
            }

            /**
             * Builds a InvoiceLineItem instance
             *
             * @return an InvoiceLineItem
             */
            public InvoiceLineItem build() {
                return new InvoiceLineItem(
                        id,
                        itemId,
                        quantity,
                        amount,
                        price,
                        serviceDate,
                        ratePercent,
                        chartOfAccountId,
                        departmentId,
                        locationId,
                        actgClassId,
                        jobId,
                        description,
                        taxable,
                        taxCode
                );
            }
        }
    }
}
