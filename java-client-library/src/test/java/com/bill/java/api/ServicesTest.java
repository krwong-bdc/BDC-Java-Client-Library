package com.bill.java.api;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.models.*;
import com.bill.java.api.param.GetDisbursementDataRequestParams;
import com.bill.java.api.param.ListPaymentsRequestParams;
import com.bill.java.api.param.PayBillsRequestParams;
import com.bill.java.api.param.RecordAPPaymentRequestParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.BDDTests;
import resources.TestEnv;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServicesTest extends BDDTests {


    @Interface
    class payBills {
        @FunctionalTest
        void should_charge_a_customer() throws Exception {
            login();

            BillPay billPay = BillPay.builder()
                    .with($ -> {
                        $.amount = BigDecimal.valueOf(1, 2);
                        $.billId = TestEnv.billId2;
                    }).build();

            List<BillPay> items = new ArrayList<BillPay>();
            items.add(billPay);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            PayBillsRequestParams params = PayBillsRequestParams.builder()
                    .with($ -> {
                        $.vendorId = TestEnv.vendorId2;
                        $.billPays = items;
                    }).build();

            List<SentPay> sentPays = Services.payBills(params);
            SentPay sentPay = sentPays.get(0);

            assertAll(() -> {
                assertEquals("SentPay", sentPay.getEntity());
                assertEquals(BigDecimal.valueOf(1, 2), sentPay.getAmount());
            });
        }

        @Condition
        class When_given_bad_input {
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Services.payBills(PayBillsRequestParams.builder().build());
                });
            }
        }

    }

    @Interface
    class recordAPPayment {
        @FunctionalTest
        void should_charge_a_customer() throws Exception {
            login();

            BillPay billPay = BillPay.builder()
                    .with($ -> {
                        $.amount = BigDecimal.valueOf(1, 2);
                        $.billId = TestEnv.billId2;
                    }).build();

            List<BillPay> items = new ArrayList<BillPay>();
            items.add(billPay);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            RecordAPPaymentRequestParams params = RecordAPPaymentRequestParams.builder()
                    .with($ -> {
                        $.vendorId = TestEnv.vendorId2;
                        $.processDate = format.format(new Date());
                        $.toPrintCheck = genBool();
                        $.billPays = items;
                    }).build();

            SentPay sentPay = Services.recordAPPayment(params);

            assertAll(() -> {
                assertEquals("SentPay", sentPay.getEntity());
                assertEquals(BigDecimal.valueOf(1, 2), sentPay.getAmount());
            });
        }

        @Condition
        class When_given_bad_input {
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Services.recordAPPayment(RecordAPPaymentRequestParams.builder().build());
                });
            }
        }

    }

    @Interface
    class getAccountsPayableSummary {
        @FunctionalTest
        void should_not_throw_BDCException() throws Exception {
            login();
            assertDoesNotThrow(() -> {
                AccountsPayableSummary summary = Services.getAccountsPayableSummary();
            });
        }
    }

    @Interface
    class getDisbursementData {
        @FunctionalTest
        void should_not_throw_BDCException() throws Exception {
            login();
            assertDoesNotThrow(() -> {
                GetDisbursementDataRequestParams params = GetDisbursementDataRequestParams.builder()
                        .with($ -> {
                            $.sentPayId = TestEnv.sentPayId;
                        }).build();
                DisbursementData data = Services.getDisbursementData(params);

//                assertNotNull(data.getPaymentType());
//                assertNotNull(data.getDisbursementStatus());
            });
        }
    }

    @Interface
    class listPayments {
        @FunctionalTest
        void should_not_throw_BDCException() throws Exception {
            login();
            assertDoesNotThrow(() -> {
                ListPaymentsRequestParams params = ListPaymentsRequestParams.builder()
                        .with($ -> {
                            $.disbursementStatus = "0";
                            $.max = 100;
                            $.start = 0;
                        }).build();
                List<SentPay> payments = Services.listPayments(params);
            });
        }

    }
}