package com.bill.java.api.param;

import com.bill.java.api.models.BillCredit;
import com.bill.java.api.models.BillPay;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.function.Consumer;

public class PayBillsRequestParams extends ApiResourceParams {
    @SerializedName("vendorId")
    private String vendorId;

    @SerializedName("processDate")
    private String processDate;

    @SerializedName("billPays")
    private List<BillPay> billPays;

    @SerializedName("billCredits")
    private List<BillCredit> billCredits;

    private PayBillsRequestParams(String vendorId,
                                  String processDate,
                                  List<BillPay> billPays,
                                  List<BillCredit> billCredits) {
        this.vendorId = vendorId;
        this.processDate = processDate;
        this.billPays = billPays;
        this.billCredits = billCredits;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public String vendorId;
        public String processDate;
        public List<BillPay> billPays;
        public List<BillCredit> billCredits;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public PayBillsRequestParams build() {
            return new PayBillsRequestParams(
                    vendorId,
                    processDate,
                    billPays,
                    billCredits);
        }
    }
}
