package com.bill.java.api;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.models.Invoice;
import com.bill.java.api.models.InvoicePay;
import com.bill.java.api.models.ReceivedPay;
import com.bill.java.api.param.ChargeCustomerRequestParams;
import com.bill.java.api.param.RecordARPaymentRequestParams;
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
    private String description;
    private BigDecimal amount;
    private String date;


    @BeforeEach
    void setup() throws Exception {
        description = genDescription();
        amount = BigDecimal.valueOf(1, 2);
        date = "2019-09-12";

        login();
    }

    @Interface
    class chargeCustomer {
        @FunctionalTest
        void should_charge_a_customer() throws Exception {
            InvoicePay invoicePay = InvoicePay.builder()
                    .with($ -> {
                        $.amount = amount;
                        $.invoiceId = TestEnv.testInvoiceId;
                    }).build();

            List<InvoicePay> items = new ArrayList<InvoicePay>();
            items.add(invoicePay);

            ChargeCustomerRequestParams params = ChargeCustomerRequestParams.builder()
                    .with($ -> {
                        $.customerId = TestEnv.testCustomerId;
                        $.memo = description;
                        $.paymentType = "3";
                        $.paymentAccountId = TestEnv.testCustomerBankAccountId;
                        $.invoicePays = items;
                    }).build();

            ReceivedPay receivedPay = Services.chargeCustomer(params);
            InvoicePay invoicePay2 = receivedPay.getInvoicePays().get(0);

            assertAll(() -> {
                assertEquals("ReceivedPay", receivedPay.getEntity());
                assertEquals("3", receivedPay.getPaymentType());
                assertEquals(description, receivedPay.getDescription());
                assertEquals(amount, invoicePay2.getAmount());
            });
        }

        @Condition
        class When_given_bad_input {
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Services.chargeCustomer(ChargeCustomerRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class payBills {
        @FunctionalTest
        void should_charge_a_customer() throws Exception {

            BillPay billPay = BillPay.builder()
                    .with($ -> {
                        $.amount = BigDecimal.valueOf(1, 2);
                        $.billId = TestEnv.testBillId;
                    }).build();

            List<BillPay> items = new ArrayList<BillPay>();
            items.add(billPay);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            PayBillsRequestParams params = PayBillsRequestParams.builder()
                    .with($ -> {
                        $.vendorId = TestEnv.testVendorId;
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
    class getAccountsReceivableSummary{
        @FunctionalTest
        void should_throw_BDCException() {
            assertDoesNotThrow(() -> {
                Services.getAccountsReceivableSummary();
            });
        }
    }

    @Interface
    class recordARPayment{
        @FunctionalTest
        void should_charge_a_customer() throws Exception {
            InvoicePay invoicePay = InvoicePay.builder()
                    .with($ -> {
                        $.amount = amount;
                        $.invoiceId = TestEnv.testInvoiceId;
                    }).build();

            List<InvoicePay> items = new ArrayList<InvoicePay>();
            items.add(invoicePay);

            RecordARPaymentRequestParams params = RecordARPaymentRequestParams.builder()
                    .with($ -> {
                        $.customerId = TestEnv.testCustomerId;
                        $.paymentType = "3";
                        $.paymentDate = date;
                        $.amount = amount;
                        $.invoicePays = items;
                    }).build();

            ReceivedPay receivedPay = Services.recordARPayment(params);
            InvoicePay invoicePay2 = receivedPay.getInvoicePays().get(0);

            assertAll(() -> {
                assertEquals("ReceivedPay", receivedPay.getEntity());
                assertEquals("3", receivedPay.getPaymentType());
                assertEquals(date, receivedPay.getPaymentDate());
                assertEquals(amount, invoicePay2.getAmount());
            });
        }
    }

    @Interface
    class recordAPPayment {
        @FunctionalTest
        void should_charge_a_customer() throws Exception {

            BillPay billPay = BillPay.builder()
                    .with($ -> {
                        $.amount = BigDecimal.valueOf(1, 2);
                        $.billId = TestEnv.testBillId;
                    }).build();

            List<BillPay> items = new ArrayList<BillPay>();
            items.add(billPay);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            RecordAPPaymentRequestParams params = RecordAPPaymentRequestParams.builder()
                    .with($ -> {
                        $.vendorId = TestEnv.testVendorId;
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
            assertDoesNotThrow(() -> {
                AccountsPayableSummary summary = Services.getAccountsPayableSummary();
            });
        }
    }

    @Interface
    class getDisbursementData {
        @FunctionalTest
        void should_not_throw_BDCException() throws Exception {
            assertDoesNotThrow(() -> {
                GetDisbursementDataRequestParams params = GetDisbursementDataRequestParams.builder()
                        .with($ -> {
                            $.sentPayId = TestEnv.testSentPayId;
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