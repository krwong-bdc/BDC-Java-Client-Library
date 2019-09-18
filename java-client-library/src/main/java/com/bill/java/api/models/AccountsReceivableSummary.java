package com.bill.java.api.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class AccountsReceivableSummary {
    @SerializedName("invoices")
    private Invoices invoices;

    @SerializedName("payments")
    private Payments payments;

    @Getter
    public static class Invoices {
        @SerializedName("overdueCount")
        private Integer overdueCount;

        @SerializedName("overdueTotal")
        private String overdueTotal;

        @SerializedName("dueTodayCount")
        private Integer dueTodayCount;

        @SerializedName("dueTodayTotal")
        private String dueTodayTotal;

        @SerializedName("due7DaysCount")
        private Integer due7DaysCount;

        @SerializedName("due7DaysTotal")
        private String due7DaysTotal;

        @SerializedName("due7PlusDaysCount")
        private Integer due7PlusDaysCount;

        @SerializedName("due7PlusDaysTotal")
        private String due7PlusDaysTotal;

        @SerializedName("allCount")
        private Integer allCount;

        @SerializedName("allTotal")
        private String allTotal;
    }

    @Getter
    public static class Payments {
        @SerializedName("lastMonthCount")
        private Integer lastMonthCount;

        @SerializedName("lastMonthTotal")
        private String lastMonthTotal;

        @SerializedName("currentMonthCount")
        private Integer currentMonthCount;

        @SerializedName("currentMonthTotal")
        private String currentMonthTotal;

        @SerializedName("last7DaysCount")
        private Integer last7DaysCount;

        @SerializedName("last7DaysTotal")
        private String last7DaysTotal;

        @SerializedName("todayCount")
        private Integer todayCount;

        @SerializedName("todayTotal")
        private String todayTotal;

        @SerializedName("next7DaysCount")
        private Integer next7DaysCount;

        @SerializedName("next7DaysTotal")
        private String next7DaysTotal;

        @SerializedName("futureCount")
        private Integer futureCount;

        @SerializedName("futureTotal")
        private String futureTotal;
    }
}
