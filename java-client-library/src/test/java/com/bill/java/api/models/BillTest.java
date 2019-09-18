package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.param.BillCreateRequestParams;
import com.bill.java.api.param.BillGetRequestParams;
import com.bill.java.api.param.BillUpdateRequestParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.BDDTests;
import resources.TestEnv;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BillTest extends BDDTests {
    private String entity = "Bill";
    private String isActive;
    private String vendorId;
    private String invoiceNumber;
    private String invoiceDate;
    private String dueDate;
    private String glPostingDate;
    private String description;
    private String poNumber;

    private String itemEntity = "BillLineItem";
    private BigDecimal itemAmount;
    private String itemChartOfAccountId;
    private String itemDepartmentId;
    private String itemLocationId;
    private String itemJobId;
    private String itemCustomerId;
    private Boolean itemJobBillable;
    private String itemDescription;
    private String itemItemId;
    private Integer itemQuantity;
    private BigDecimal itemUnitPrice;
    private String itemEmployeeId;
    private String itemActgClassId;

    private String billId;

    @BeforeEach
    void setup() throws Exception {
        login();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        isActive = genNumAsString(1, 2);
        vendorId = TestEnv.testVendorId;
        invoiceNumber = genNumAsString(7);
        invoiceDate = format.format(new Date());
        dueDate = genFutureDate();
        glPostingDate = format.format(new Date());
        description = genDescription();

        itemAmount = BigDecimal.valueOf(new Random().nextInt(700), 2);
        itemCustomerId = TestEnv.testCustomerId;
        itemDescription = genDescription();

        Bill.BillLineItem item1 = Bill.BillLineItem.builder()
                .with($ -> {
                    $.amount = itemAmount;
                    $.customerId = itemCustomerId;
                    $.description = itemDescription;
                }).build();

        List<Bill.BillLineItem> items = new ArrayList<Bill.BillLineItem>();
        items.add(item1);

        Bill bill = Bill.create(BillCreateRequestParams.builder()
                .with($ -> {
                    $.isActive = isActive;
                    $.vendorId = vendorId;
                    $.invoiceNumber = invoiceNumber + "2";
                    $.invoiceDate = invoiceDate;
                    $.dueDate = dueDate;
                    $.glPostingDate = glPostingDate;
                    $.description = description;
                    $.billLineItems = items;
                }).build());

        billId = bill.getId();
    }

    @Interface
    class create {
        @FunctionalTest
        void should_create_a_customer_with_passed_params() throws Exception {
            Bill.BillLineItem item1 = Bill.BillLineItem.builder()
                    .with($ -> {
                        $.amount = itemAmount;
                        $.customerId = itemCustomerId;
                        $.description = itemDescription;
                    }).build();

            List<Bill.BillLineItem> items = new ArrayList<Bill.BillLineItem>();
            items.add(item1);

            Bill bill = Bill.create(BillCreateRequestParams.builder()
                    .with($ -> {
                        $.isActive = isActive;
                        $.vendorId = vendorId;
                        $.invoiceNumber = invoiceNumber;
                        $.invoiceDate = invoiceDate;
                        $.dueDate = dueDate;
                        $.glPostingDate = glPostingDate;
                        $.description = description;
                        $.billLineItems = items;
                    }).build());

            checkValues(bill);
            checkItemValues(bill.getBillLineItems().get(0));
        }

        @Condition
        class When_given_bad_input {
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Bill.create(BillCreateRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class get {
        @FunctionalTest
        void should_retrieve_the_sepcified_vendor() throws Exception {
            BillGetRequestParams params = BillGetRequestParams.builder()
                    .with($ -> {
                        $.id = billId;
                    }).build();
            Bill bill = Bill.get(params);
            assertAll(() -> assertEquals(billId, bill.getId()));
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Bill.get(BillGetRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class update {
        @FunctionalTest
        void should_update_customer_with_given_params() throws Exception {
            Bill.BillLineItem item1 = Bill.BillLineItem.builder()
                    .with($ -> {
                        $.amount = itemAmount;
                        $.customerId = itemCustomerId;
                        $.description = itemDescription;
                    }).build();

            List<Bill.BillLineItem> items = new ArrayList<Bill.BillLineItem>();
            items.add(item1);

            Bill bill = Bill.update(BillUpdateRequestParams.builder()
                    .with($ -> {
                        $.id = billId;
                        $.isActive = isActive;
                        $.vendorId = vendorId;
                        $.invoiceNumber = invoiceNumber;
                        $.invoiceDate = invoiceDate;
                        $.dueDate = dueDate;
                        $.glPostingDate = glPostingDate;
                        $.description = description;
                        $.billLineItems = items;
                    }).build());

            checkValues(bill);
            checkItemValues(bill.getBillLineItems().get(0));
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Bill.update(BillUpdateRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class update1 {
        @FunctionalTest
        void should_update_the_given_resource() throws Exception {
            BillGetRequestParams params = BillGetRequestParams.builder()
                    .with($ -> {
                        $.id = billId;
                    }).build();
            Bill bill = Bill.get(params);
            Bill.BillLineItem item = bill.getBillLineItems().get(0);

            item.setAmount(itemAmount);
            item.setCustomerId(itemCustomerId);
            item.setDescription(itemDescription);

            bill.setIsActive(isActive);
            bill.setVendorId(vendorId);
            bill.setInvoiceNumber(invoiceNumber);
            bill.setInvoiceDate(invoiceDate);
            bill.setDueDate(dueDate);
            bill.setGlPostingDate(glPostingDate);
            bill.setDescription(description);
            bill.setBillLineItems(new ArrayList<Bill.BillLineItem>(Arrays.asList(item)));

            bill = Bill.update(bill);

            checkValues(bill);
            checkItemValues(bill.getBillLineItems().get(0));
        }
    }

    void checkValues(Bill bill) {
        assertAll(() -> {
            assertEquals(entity, bill.getEntity());
            assertEquals(isActive, bill.getIsActive());
            assertEquals(vendorId, bill.getVendorId());
            assertEquals(invoiceNumber, bill.getInvoiceNumber());
            assertEquals(invoiceDate, bill.getInvoiceDate());
            assertEquals(dueDate, bill.getDueDate());
            assertEquals(glPostingDate, bill.getGlPostingDate());
            assertEquals(description, bill.getDescription());
        });
    }

    void checkItemValues(Bill.BillLineItem billLineItem) {
        assertAll(() -> {
            assertEquals(itemEntity, billLineItem.getEntity());
            assertEquals(itemAmount, billLineItem.getAmount());
            assertEquals(itemCustomerId, billLineItem.getCustomerId());
            assertEquals(itemDescription, billLineItem.getDescription());
        });

    }
}