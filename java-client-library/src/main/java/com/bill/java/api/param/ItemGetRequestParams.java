package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Parameters for retrieving an Item through the BDC API.
 */
public class ItemGetRequestParams extends ApiResourceParams {
    @SerializedName("id")
    private final String id;

    private ItemGetRequestParams(String id) {
        this.id = id;
    }

    /**
     * Makes a new Builder for ItemGetRequestParams.
     *
     * @return a builder for ItemGetRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an ItemGetRequestParams object.
     */
    public static class Builder {
        /**
         * System generated Unique Identifier
         * <p>
         * It is used to retrieve and refer the object in subsequent API calls. You can filter by this field on the List call
         */
        public String id;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a ItemGetRequestParams instance with the set parameters.
         *
         * @return ItemGetRequestParams
         */
        public ItemGetRequestParams build() {
            return new ItemGetRequestParams(id);
        }
    }
}
