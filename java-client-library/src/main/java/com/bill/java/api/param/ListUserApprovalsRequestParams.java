package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;

public class ListUserApprovalsRequestParams extends ApiResourceParams {
    @SerializedName("usersId")
    private String usersId;

    @Setter(AccessLevel.PUBLIC)
    @SerializedName("entity")
    private String entity;

    @SerializedName("approvalType")
    private String approvalType;

    @SerializedName("marker")
    private String marker;

    @SerializedName("max")
    private Integer max;

    @SerializedName("nested")
    private Boolean nested;

    @SerializedName("sort")
    private List<SortField> sort;

    @SerializedName("filters")
    private List<FilterField> filters;

    private ListUserApprovalsRequestParams(String usersId,
                                           String approvalType,
                                           String marker,
                                           Integer max,
                                           Boolean nested,
                                           List<SortField> sort,
                                           List<FilterField> filters) {
        this.usersId = usersId;
        this.approvalType = approvalType;
        this.marker = marker;
        this.max = max;
        this.nested = nested;
        this.sort = sort;
        this.filters = filters;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        /**
         * The id of the user who is the approver.
         */
        public String usersId;

        /**
         * approvalType - The type of the approvals to retrieve.
         * ["0" = NotYetApproved - Not yet approved]
         * ["1" = Approved]
         * ["2" = Denied]
         * ["3" = Coming]
         */
        public String approvalType;

        /**
         * A unique value returned in the response of the previous call or null if this is the first call to this API to retrieve the first set of objects.
         */
        public String marker;

        /**
         * Maximum number of objects to retrieve. The limit is 999.
         */
        public Integer max;

        /**
         * Include nested related data, i.e. billLineItems in a Bill.
         */
        public Boolean nested;

        /**
         * Sort based on a specific field.
         */
        public List<SortField> sort;

        /**
         * Filter based on a specific field.
         */
        public List<FilterField> filters;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public ListUserApprovalsRequestParams build() {
            return new ListUserApprovalsRequestParams(
                    usersId,
                    approvalType,
                    marker,
                    max,
                    nested,
                    sort,
                    filters
            );
        }
    }

    public static class SortField {
        @SerializedName("field")
        private String field;

        @SerializedName("asc")
        private String asc;


        private SortField(String field, String asc){
            this.field = field;
            this.asc = asc;
        }

        public static Builder builder() { return new Builder(); }

        public static class Builder {
            public String field;
            public String asc;

            public Builder with(Consumer<Builder> builderFunction) {
                builderFunction.accept(this);
                return this;
            }

            public SortField build() {
                return new SortField(field, asc);
            }
        }
    }

    public static class FilterField {
        @SerializedName("field")
        private String field;

        @SerializedName("op")
        private String op;

        @SerializedName("value")
        private String value;

        private FilterField(String field, String op, String value){
            this.field = field;
            this.op = op;
            this.value = value;
        }

        public static Builder builder() { return new Builder(); }

        public static class Builder {
            public String field;
            public String op;
            public String value;

            public Builder with(Consumer<Builder> builderFunction) {
                builderFunction.accept(this);
                return this;
            }

            public FilterField build() {
                return new FilterField(field, op, value);
            }
        }
    }
}
