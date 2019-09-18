package com.bill.java.api.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AccountsPayableSummary {
    @SerializedName("bills")
    private Bills bills;

    @SerializedName("approvals")
    private Approvals approvals;

    @Getter
    public static class Bills {
        @SerializedName("overdueCount")
        private Integer overdueCount;

        @SerializedName("overdueTotal")
        private BigDecimal overdueTotal;

        @SerializedName("dueTodayCount")
        private Integer dueTodayCount;

        @SerializedName("dueTodayTotal")
        private BigDecimal dueTodayTotal;

        @SerializedName("due7DaysCount")
        private Integer due7DaysCount;

        @SerializedName("due7DaysTotal")
        private BigDecimal due7DaysTotal;

        @SerializedName("due7PlusDaysCount")
        private Integer due7PlusDaysCount;

        @SerializedName("due7PlusDaysTotal")
        private BigDecimal due7PlusDaysTotal;

        @SerializedName("allCount")
        private Integer allCount;

        @SerializedName("allTotal")
        private BigDecimal allTotal;
    }

    @Getter
    public static class Approvals {
        @SerializedName("overdueCount")
        private Integer overdueCount;

        @SerializedName("overdueTotal")
        private BigDecimal overdueTotal;

        @SerializedName("dueTodayCount")
        private Integer dueTodayCount;

        @SerializedName("dueTodayTotal")
        private BigDecimal dueTodayTotal;

        @SerializedName("due7DaysCount")
        private Integer due7DaysCount;

        @SerializedName("due7DaysTotal")
        private BigDecimal due7DaysTotal;

        @SerializedName("due7PlusDaysCount")
        private Integer due7PlusDaysCount;

        @SerializedName("due7PlusDaysTotal")
        private BigDecimal due7PlusDaysTotal;

        @SerializedName("allCount")
        private Integer allCount;

        @SerializedName("allTotal")
        private BigDecimal allTotal;
    }
}
