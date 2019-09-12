package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Data required to make the listApprovers call
 */
public class ListApproversRequestParams extends ApiResourceParams {
    @SerializedName("objectId")
    private final String billId;

    @SerializedName("entity")
    private final String entity = "Bill";

    private ListApproversRequestParams(String billId) {
        this.billId = billId;
    }

    /**
     * Makes a new Builder for ListApproversRequestParams.
     *
     * @return a builder for ListApproversRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an ListApproversRequestParams object.
     */
    public static class Builder {
        /**
         * Id of the SentPay whose disbursement data is being requested
         * <p>
         * It is used to retrieve and refer the object in subsequent API calls. You can filter by this field on the List call
         */
        public String billId;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a ListApproversRequestParams instance with the set parameters.
         *
         * @return ListApproversRequestParams
         */
        public ListApproversRequestParams build() {
            return new ListApproversRequestParams(billId);
        }
    }
}
