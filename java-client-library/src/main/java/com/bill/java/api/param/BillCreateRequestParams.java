package com.bill.java.api.param;

import com.bill.java.api.models.Bill;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.function.Consumer;

public class BillCreateRequestParams extends ApiResourceParams {
    /* Holds the actual api resource variables for creation */
    @SerializedName("obj")
    protected final Params params;

    private BillCreateRequestParams(Params params) { this.params = params; }

    /**
     * Makes a new Builder for BillCreateRequestParams
     *
     * @return a builder for BillCreateRequestParams
     */
    public static Builder builder() { return new Builder(); }

    /**
     * Builds a BillCreateRequestParams object
     */
    public static class Builder {
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
         * list of Line Items associated with the Bill
         */
        public List<Bill.BillLineItem> billLineItems;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public BillCreateRequestParams build() {
            return new BillCreateRequestParams(
                    new Params(
                            isActive,
                            vendorId,
                            invoiceNumber,
                            invoiceDate,
                            dueDate,
                            glPostingDate,
                            description,
                            poNumber,
                            billLineItems
                    )
            );
        }
    }

    private static class Params {
        @SerializedName("entity")
        private String entity = "Bill";

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

        @SerializedName("billLineItems")
        private List<Bill.BillLineItem> billLineItems;

        Params(String isActive,
               String vendorId,
               String invoiceNumber,
               String invoiceDate,
               String dueDate,
               String glPostingDate,
               String description,
               String poNumber,
               List<Bill.BillLineItem> billLineItems){
            this.isActive = isActive;
            this.vendorId = vendorId;
            this.invoiceNumber = invoiceNumber;
            this.invoiceDate = invoiceDate;
            this.dueDate = dueDate;
            this.glPostingDate = glPostingDate;
            this.description = description;
            this.poNumber = poNumber;
            this.billLineItems = billLineItems;
        }
    }

}
