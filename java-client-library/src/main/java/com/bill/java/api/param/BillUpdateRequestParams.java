package com.bill.java.api.param;

import com.bill.java.api.models.Bill;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.function.Consumer;

public class BillUpdateRequestParams extends ApiResourceParams {
    /* Holds the actual api resource variables for creation */
    @SerializedName("obj")
    protected final Params params;

    private BillUpdateRequestParams(Params params) { this.params = params; }

    /**
     * Makes a new Builder for BillUpdateRequestParams
     *
     * @return a builder for BillUpdateRequestParams
     */
    public static Builder builder() { return new Builder(); }

    /**
     * Builds an BillUpdateRequestParams instance
     */
    public static class Builder {
        /**
         * System-generated unique identifier
         */
        public String id;

        /**
         * Denotes if object is active or inactive. Inactive objects are hidden by default and are only visible in UI when user clicks
         * <p>
         * "1" - Active
         * "2" - Inactive
         */
        public String isActive;

        /**
         * Id of the vendor that the bill is associated with. You can filter by this field on the List call.
         */
        public String vendorId;

        /**
         * User defined unique identifier for the bill. Usually, provided on the bill. If not, users typically enter the bill's date or billing period. You can filter by this field on the List call.
         */
        public String invoiceNumber;

        /**
         * The date on which the bill is sent. You can filter by this field on the List call.
         */
        public String invoiceDate;

        /**
         * The date on which the bill is due. You can filter by this field on the List call.
         */
        public String dueDate;

        /**
         * Date the Bill is posted to user's third-party system, if supported. You can filter by this field on the List call.
         */
        public String glPostingDate;

        /**
         * Description of object.
         */
        public String description;

        /**
         * purchase Order associated with the Bill
         */
        public String poNumber;

        /**
         * Bank account from which you expect to pay the bill. Currently, only used by selected partners. You can filter by this field on the List call.
         */
        public String payFromBankAccountId;

        /**
         * Chart of account from which you expect to pay the bill. Currently, only used by selected partners. You can filter by this field on the List call.
         */
        public String payFromChartOfAccountId;

        /**
         * list of Line Items associated with the Bill
         */
        public List<Bill.BillLineItem> billLineItems;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds an BillUpdateRequestParams instance with the set parameters.
         *
         * @return BillUpdateRequestParams
         */
        public BillUpdateRequestParams build() {
            return new BillUpdateRequestParams(
                    new Params(
                            id,
                            isActive,
                            vendorId,
                            invoiceNumber,
                            invoiceDate,
                            dueDate,
                            glPostingDate,
                            description,
                            poNumber,
                            payFromBankAccountId,
                            payFromChartOfAccountId,
                            billLineItems)
            );
        }
    }

    public static class Params {
        @SerializedName("entity")
        private String entity = "Bill";

        @SerializedName("id")
        private String id;

        @SerializedName("isActive")
        private String isActive;

        @SerializedName("vendorId")
        private String vendorId;

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

        @SerializedName("payFromBankAccountId")
        private String payFromBankAccountId;

        @SerializedName("payFromChartOfAccountId")
        private String payFromChartOfAccountId;

        @SerializedName("billLineItems")
        private List<Bill.BillLineItem> billLineItems;

        Params(String id,
               String isActive,
               String vendorId,
               String invoiceNumber,
               String invoiceDate,
               String dueDate,
               String glPostingDate,
               String description,
               String poNumber,
               String payFromBankAccountId,
               String payFromChartOfAccountId,
               List<Bill.BillLineItem> billLineItems) {
            this.id = id;
            this.isActive = isActive;
            this.vendorId = vendorId;
            this.invoiceNumber = invoiceNumber;
            this.invoiceDate = invoiceDate;
            this.dueDate = dueDate;
            this.glPostingDate = glPostingDate;
            this.description = description;
            this.poNumber = poNumber;
            this.payFromBankAccountId = payFromBankAccountId;
            this.payFromChartOfAccountId = payFromChartOfAccountId;
            this.billLineItems = billLineItems;
        }
    }
}
