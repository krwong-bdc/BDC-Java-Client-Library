package com.bill.java.api;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.models.Invoice;
import com.bill.java.api.models.InvoicePay;
import com.bill.java.api.models.ReceivedPay;
import com.bill.java.api.param.ChargeCustomerRequestParams;
import com.bill.java.api.param.RecordARPaymentRequestParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.BDDTests;
import resources.TestEnv;

import java.math.BigDecimal;
import java.util.ArrayList;
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

        login(2);
    }

    @Interface
    class chargeCustomer{
        @FunctionalTest
        void should_charge_a_customer() throws Exception {
            InvoicePay invoicePay = InvoicePay.builder()
                    .with($ -> {
                        $.amount = amount;
                        $.invoiceId = TestEnv.invoiceId2;
                    }).build();

            List<InvoicePay> items = new ArrayList<InvoicePay>();
            items.add(invoicePay);

            ChargeCustomerRequestParams params = ChargeCustomerRequestParams.builder()
                    .with($ -> {
                        $.customerId = TestEnv.customerId2;
                        $.memo = description;
                        $.paymentType = "3";
                        $.paymentAccountId = TestEnv.customerBankAccountId2;
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
    class getARSummary{
        @FunctionalTest
        void should_throw_BDCException() {
            assertDoesNotThrow(() -> {
                Services.getARSummary();
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
                        $.invoiceId = TestEnv.invoiceId2;
                    }).build();

            List<InvoicePay> items = new ArrayList<InvoicePay>();
            items.add(invoicePay);

            RecordARPaymentRequestParams params = RecordARPaymentRequestParams.builder()
                    .with($ -> {
                        $.customerId = TestEnv.customerId2;
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

        @Condition
        class When_given_bad_input {
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Services.recordARPayment(RecordARPaymentRequestParams.builder().build());
                });
            }
        }
    }
}