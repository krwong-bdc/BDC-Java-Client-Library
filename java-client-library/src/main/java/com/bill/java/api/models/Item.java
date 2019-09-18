package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.ItemCreateRequestParams;
import com.bill.java.api.param.ItemGetRequestParams;
import com.bill.java.api.param.ItemUpdateRequestParams;
import com.bill.java.api.param.ListRequestParams;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * For customers, an Item defines products or services provided by the organization.
 * For vendors, this describes the products or services provided to the organization.
 * Items can be used in both bills and invoices.
 */
public class Item extends ApiResource {
    /* Resource endpoints for everything vendor related */
    /** The URI for creating a Item through the BDC API {@value #CREATE_URL} */
    public static final String CREATE_URL = "/Crud/Create/Item.json";

    /** The URI for retrieving a Item through the BDC API {@value #READ_URL} */
    public static final String READ_URL = "/Crud/Read/Item.json";

    /** The URI for updating a Item through the BDC API {@value #UPDATE_URL} */
    public static final String UPDATE_URL = "/Crud/Update/Item.json";

    /** The URI for disabling a Item through the BDC API {@value #DELETE_URL} */
    public static final String DELETE_URL = "/Crud/Delete/Item.json";

    /** The URI for undisabling a Item through the BDC API {@value #UNDELETE_URL} */
    public static final String UNDELETE_URL = "/Crud/Undelete/Item.json";

    /** The URI for getting a list of items */
    public static final String LIST_ITEMS_URL = "/List/Item.json";

    /* All retrievable attributes of a Item */
    /** Item. */
    @Getter
    @SerializedName("entity")
    private String entity;

    /**	System generated Unique Identifier. It is used to retrieve and refer the object in subsequent API calls. */
    @Getter
    @SerializedName("id")
    private String id;

    /** Denotes if object is active or inactive. Inactive objects are hidden by default and are only visible in UI when user clicks
     * <p>
     * "1" - Active
     * "2" - Inactive
     */
    @Getter
    @Setter
    @SerializedName("isActive")
    private String isActive;

    /**
     * Timestamp when this record was created in Bill.com. You can filter by this field on the List call.
     */
    @Getter
    @SerializedName("createdTime")
    private String createdTime;

    /**
     * Timestamp when this record was last updated in Bill.com. You can filter by this field on the List call.
     */
    @Getter
    @SerializedName("updatedTime")
    private String updatedTime;

    /**
     * Name of object; displayed in lists. You can filter by this field on the List call.
     */
    @Getter
    @Setter
    @SerializedName("name")
    private String name;

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
    @Getter
    @Setter
    @SerializedName("type")
    private String type;

    /** Description of item. */
    @Getter
    @Setter
    @SerializedName("description")
    private String description;

    /**
     * Price of the Item. An Item can have either a price or a percentage rate.
     */
    @Getter
    @Setter
    @SerializedName("price")
    private BigDecimal price;

    /**
     * Default percentage of the item (usually discounts or sales tax). The percentage is calculate based on the amount of the line item above it in the invoice.
     */
    @Getter
    @Setter
    @SerializedName("percentage")
    private Integer percentage;

    /**
     * 	ID of parent object (denotes this object as child object). You can filter by this field on the List call.
     */
    @Getter
    @Setter
    @SerializedName("parentItemId")
    private String parentItemId;

    /**
     * Read-only field. It is true if the item is also used for purchased / payable (has expense account)
     */
    @Getter
    @Setter
    @SerializedName("hasPurInfo")
    private Boolean hasPurInfo;

    /**
     * 	Chart of account that this item is coded to when associated to a bill / purchase.
     */
    @Getter
    @Setter
    @SerializedName("expenseAccount")
    private String expenseAccount;

    /**
     * Default description for the item when associated to a bill / purchase (typically used by accounting systems)
     */
    @Getter
    @Setter
    @SerializedName("purDescription")
    private String purDescription;

    /**
     * Default cost of purchasing the item.
     */
    @Getter
    @Setter
    @SerializedName("purCost")
    private BigDecimal purCost;

    /**
     * Chart of account that sales of item are coded to.
     */
    @Getter
    @Setter
    @SerializedName("chartOfAccountId")
    private String chartOfAccountId;

    /**
     * Denotes if this item is taxable by default.
     */
    @Getter
    @Setter
    @SerializedName("taxable")
    private Boolean taxable;

    /**
     * User-friendly identifer defined by user and/or third-party system. Usually visible to user.
     */
    @Getter
    @Setter
    @SerializedName("shortName")
    private String shortName;

    /**
     * This id contains the id of the parent that this object got merged into.
     */
    @Getter
    @Setter
    @SerializedName("mergedIntoId")
    private String mergedIntoId;

    /**
     * Creates an item in BDC.
     *
     * @param  itemCreateRequestParams data for Vendor creation
     * @return                         the Customer that has been created through the BDC API
     * @throws BDCException            when the response from the API is unsuccessful
     * @throws IOException             when an I/O exception occurs on the underlying request
     */
    public static Item create(ItemCreateRequestParams itemCreateRequestParams) throws BDCException, IOException {
        if(itemCreateRequestParams == null) {
            throw new NullPointerException("CustomerCreateRequestParams required");
        }
        return create(CREATE_URL, itemCreateRequestParams, Item.class);
    }

    /**
     * Retrieves an item from the BDC database.
     *
     * @param  itemGetRequestParams data for Customer read request
     * @return                      the Customer specified in the request
     * @throws BDCException         when the response from the API is unsuccessful
     * @throws IOException          when an I/O exception occurs on the underlying request
     */
    public static Item get(ItemGetRequestParams itemGetRequestParams) throws BDCException, IOException {
        if(itemGetRequestParams == null) {
            throw new NullPointerException("CustomerGetRequestParams required");
        }
        return create(READ_URL, itemGetRequestParams, Item.class);
    }

    /**
     * Updates a item in the BDC database.
     *
     * @param  itemUpdateRequestparams data for Item update request
     * @return                         the Item specified in the request
     * @throws BDCException            when the response from the API is unsuccessful
     * @throws IOException             when an I/O exception occurs on the underlying request
     */
    public static Item update(ItemUpdateRequestParams itemUpdateRequestparams) throws BDCException, IOException {
        if(itemUpdateRequestparams == null) {
            throw new NullPointerException("ItemUpdateRequestParams required");
        }
        return create(UPDATE_URL, itemUpdateRequestparams, Item.class);
    }

    /**
     * Updates a item in the BDC database.
     *
     * @param  item         Item object to be updated to the BDC database
     * @return the          Item specified in the request
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException  when an I/O exception occurs on the underlying request
     */
    public static Item update(Item item) throws BDCException, IOException {
        if(item == null) {
            throw new NullPointerException("Item required");
        }
        return create(UPDATE_URL, item, Item.class);
    }

    /**
     * Get a list of items
     *
     * @param itemListRequestParams data for request to set authorization
     * @return                          a list of items belonging to the account
     * @throws BDCException             when the response from the API is unsuccessful
     * @throws IOException              when an I/O exception occurs on the underlying request
     */
    public static List<Item> list(ListRequestParams itemListRequestParams) throws BDCException, IOException {
        if(itemListRequestParams == null) {
            throw new NullPointerException("ItemListRequestParams required");
        }
        return createCollection(LIST_ITEMS_URL, itemListRequestParams, Item.class);
    }
}
