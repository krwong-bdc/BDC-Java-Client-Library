package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.function.Consumer;

/**
 * Data required to retrieve Payments from the {@link com.bill.java.api.Services#ListPayments(ListPaymentsRequestParams) ListPayments call }
 */
public class ListPaymentsRequestParams extends ApiResourceParams {
    @SerializedName("disbursementStatus")
    private String disbursementStatus;

    @SerializedName("start")
    private Integer start;

    @SerializedName("max")
    private Integer max;

    private ListPaymentsRequestParams(String disbursementStatus, Integer start, Integer max) {
        this.disbursementStatus = disbursementStatus;
        this.start = start;
        this.max = max;
    }

    /**
     * Makes a new Builder for ListPaymentsRequestParams.
     *
     * @return a builder for ListPaymentsRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an ListPaymentsRequestParams object.
     */
    public static class Builder {
        /**
         * Enum values are: ["0"=Scheduled], ["3"=Done], ["4"=Failed], ["5"=Void], ["6"=Hold].
         */
        public String disbursementStatus;

        /**
         * Start the list at the specified number
         */
        public Integer start;

        /**
         * 	Maximum number of bank accounts to return
         */
        public Integer max;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a ListPaymentsRequestParams instance with the set parameters.
         *
         * @return ListPaymentsRequestParams
         */
        public ListPaymentsRequestParams build() {
            return new ListPaymentsRequestParams(disbursementStatus, start, max);
        }
    }
}
