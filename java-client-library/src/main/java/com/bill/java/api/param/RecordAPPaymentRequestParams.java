package com.bill.java.api.param;

import com.bill.java.api.models.BillCredit;
import com.bill.java.api.models.BillPay;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.function.Consumer;

public class RecordAPPaymentRequestParams extends ApiResourceParams {
    @SerializedName("vendorId")
    private String vendorId;

    @SerializedName("processDate")
    private String processDate;

    @SerializedName("toPrintCheck")
    private Boolean toPrintCheck;

    @SerializedName("chartOfAccountId")
    private String chartOfAccountId;

    @SerializedName("description")
    private String description;

    @SerializedName("syncReference")
    private String syncReference;

    @SerializedName("billPays")
    private List<BillPay> billPays;

    @SerializedName("billCredits")
    private List<BillCredit> billCredits;

    private RecordAPPaymentRequestParams(String vendorId,
                                         String processDate,
                                         Boolean toPrintCheck,
                                         String chartOfAccountId,
                                         String description,
                                         String syncReference,
                                         List<BillPay> billPays,
                                         List<BillCredit> billCredits){
        this.vendorId = vendorId;
        this.processDate = processDate;
        this.toPrintCheck = toPrintCheck;
        this.chartOfAccountId = chartOfAccountId;
        this.description = description;
        this.syncReference = syncReference;
        this.billPays = billPays;
        this.billCredits = billCredits;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        public String vendorId;
        public String processDate;
        public Boolean toPrintCheck;
        public String chartOfAccountId;
        public String description;
        public String syncReference;
        public List<BillPay> billPays;
        public List<BillCredit> billCredits;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public RecordAPPaymentRequestParams build() {
            return new RecordAPPaymentRequestParams(
                    vendorId,
                    processDate,
                    toPrintCheck,
                    chartOfAccountId,
                    description,
                    syncReference,
                    billPays,
                    billCredits
            );
        }
    }
}
