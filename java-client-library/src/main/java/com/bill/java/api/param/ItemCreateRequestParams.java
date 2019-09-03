package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class ItemCreateRequestParams extends ApiResourceParams {
    /* Holds the actual api resource variables for creation */
    @SerializedName("obj")
    protected final Params params;

    private ItemCreateRequestParams(Params params) { this.params = params; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        /**
         * Name of object; displayed in lists.
         */
        public String name;

        /**
         * Denotes if the item is a product, service or other categories typically set by the accounting system.
         *<p>
         * "1" - service
         * "0" - unknown
         * "2" - inventory
         * "3" - nonInventory
         * "4" - payment
         * "5" - discount
         * "6" - salesTax
         * "7" - subtotal
         * "8" - otherCharge
         * "9" - inventoryAssembly
         * "10" - group
         * "11" - salesTaxGroup
         * "12" - fixedAsset
         * "13" - category
         */
        public String type;

        /**
         * Description of item.
         */
        public String description;

        /**
         * Price of the Item. An Item can have either a price or a percentage rate.
         */
        public BigDecimal price;

        /**
         * Default percentage of the item (usually discounts or sales tax). The percentage is calculate based on the amount of the line item above it in the invoice.
         */
        public Integer percentage;

        /**
         * ID of parent object (denotes this object as child object). You can filter by this field on the List call.
         */
        public String parentItemId;

        /**
         * Read-only field. It is true if the item is also used for purchased / payable (has expense account).
         */
        public Boolean hasPurInfo;

        /**
         * Chart of account that this item is coded to when associated to a bill / purchase.
         */
        public String expenseAccount;

        /**
         * Default description for the item when associated to a bill / purchase (typically used by accounting systems)
         */
        public String purDescription;

        /**
         * Default cost of purchasing the item.
         */
        public BigDecimal purCost;

        /**
         * Chart of account that sales of item are coded to.
         */
        public String chartOfAccountId;

        /**
         * Denotes if this item is taxable by default.
         */
        public Boolean taxable;

        /**
         * User-friendly identifer defined by user and/or third-party system. Usually visible to user.
         */
        public String shortName;

        /**
         * This id contains the id of the parent that this object got merged into
         */
        public String mergedIntoId;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public ItemCreateRequestParams build() {
            return new ItemCreateRequestParams(
                    new Params(
                            name,
                            type,
                            description,
                            price,
                            percentage,
                            parentItemId,
                            hasPurInfo,
                            expenseAccount,
                            purDescription,
                            purCost,
                            chartOfAccountId,
                            taxable,
                            shortName,
                            mergedIntoId
                    )
            );
        }
    }

    private static class Params {
        @SerializedName("entity")
        public String entity = "Item";

        @SerializedName("name")
        public String name;

        @SerializedName("type")
        public String type;

        @SerializedName("description")
        public String description;

        @SerializedName("price")
        public BigDecimal price;

        @SerializedName("percentage")
        public Integer percentage;

        @SerializedName("parentItemId")
        public String parentItemId;

        @SerializedName("hasPurInfo")
        public Boolean hasPurInfo;

        @SerializedName("expenseAccount")
        public String expenseAccount;

        @SerializedName("purDescription")
        public String purDescription;

        @SerializedName("purCost")
        public BigDecimal purCost;

        @SerializedName("chartOfAccountId")
        public String chartOfAccountId;

        @SerializedName("taxable")
        public Boolean taxable;

        @SerializedName("shortName")
        public String shortName;

        @SerializedName("mergedIntoId")
        public String mergedIntoId;

        Params(String name,
               String type,
               String description,
               BigDecimal price,
               Integer percentage,
               String parentItemId,
               Boolean hasPurInfo,
               String expenseAccount,
               String purDescription,
               BigDecimal purCost,
               String chartOfAccountId,
               Boolean taxable,
               String shortName,
               String mergedIntoId) {
            this.name = name;
            this.type = type;
            this.description = description;
            this.price = price;
            this.percentage = percentage;
            this.parentItemId = parentItemId;
            this.hasPurInfo = hasPurInfo;
            this.expenseAccount = expenseAccount;
            this.purDescription = purDescription;
            this.purCost = purCost;
            this.chartOfAccountId = chartOfAccountId;
            this.taxable = taxable;
            this.shortName = shortName;
            this.mergedIntoId = mergedIntoId;
        }
    }
}
