package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;

public class ListRequestParams extends ApiResourceParams {
    @SerializedName("nested")
    private Boolean nested;

    @SerializedName("start")
    private Integer start;

    @SerializedName("max")
    private Integer max;

    @SerializedName("filters")
    private List<Filter> filters;

    @SerializedName("sort")
    private List<Sort> sort;

    private ListRequestParams(Boolean nested, Integer start, Integer max, List<Filter> filters, List<Sort> sort) {
        this.nested = nested;
        this.start = start;
        this.max = max;
        this.filters = filters;
        this.sort = sort;
    }

    /**
     * Makes a new Builder for ListRequestParams.
     *
     * @return a builder for ListRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an ListRequestParams object.
     */
    public static class Builder {
        public Boolean nested;
        public Integer start;
        public Integer max;
        public List<Filter> filters;
        public List<Sort> sort;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        /**
         * Builds a ListRequestParams instance with the set parameters.
         *
         * @return ListRequestParams
         */
        public ListRequestParams build() {
            return new ListRequestParams(nested, start, max, filters, sort);
        }
    }
}
