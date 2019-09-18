package com.bill.java.api.models;

import com.bill.java.api.BDC;
import com.bill.java.api.exception.BDCException;
import com.bill.java.api.param.InvoiceUpdateRequestParams;
import com.bill.java.api.param.RecurringInvoiceCreateRequestParams;
import com.bill.java.api.param.RecurringInvoiceGetRequestParams;
import com.bill.java.api.param.RecurringInvoiceUpdateRequestParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.BDDTests;
import resources.TestEnv;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RecurringInvoiceTest extends BDDTests {
    private String entity = "RecurringInvoice";
    private String isActive;
    private String customerId;
    private String poNumber;
    private String salesRep;
    private String departmentId;
    private String locationId;
    private String actgClassId;
    private String jobId;
    private String itemSalesTax;
    private String description;
    private Boolean isToBePrinted;
    private Boolean isToBeEmailed;
    private Boolean isToBeAutoEmailed;
    private Boolean isToBeAutoMailed;
    private String fromUserId;
    private String timePeriod;
    private Integer frequencyPerTimePeriod;
    private String nextDueDate;
    private String endDate;
    private Integer daysInAdvance;
    private BigDecimal taxableAmount;
    private BigDecimal subtotal;

    private String itemEntity = "RecurringInvoiceLineItem";
    private String itemDescription;
    private BigDecimal itemAmount;
    private Integer itemQuantity;
    private BigDecimal itemPrice;

    private String recurringInvoiceId;

    @BeforeEach
    void setup() throws Exception {
        BDC.userName = TestEnv.userName;
        BDC.password = TestEnv.password;
        BDC.devKey = TestEnv.devKey;

        login();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        itemDescription = genDescription();
        itemQuantity = new Random().nextInt(10) + 1;
        itemPrice = BigDecimal.valueOf(new Random().nextInt(400), 2);

        isActive = genNumAsString(1, 2);
        customerId = TestEnv.testCustomerId;
        description = genDescription();
        poNumber = genNumAsString(7);
        isToBePrinted = genBool();
        isToBeEmailed = genBool();
        salesRep = genFName();
        timePeriod = genNumAsString(1, 3);
        frequencyPerTimePeriod = new Random().nextInt(2) + 1;
        nextDueDate = genFutureDate();
        daysInAdvance = new Random().nextInt(5) + 1;

        RecurringInvoice.RecurringInvoiceLineItem item1 = RecurringInvoice.RecurringInvoiceLineItem.builder()
                .with($ -> {
                    $.quantity = itemQuantity;
                    $.price = itemPrice;
                    $.description = itemDescription;
                }).build();

        List<RecurringInvoice.RecurringInvoiceLineItem> items = new ArrayList<RecurringInvoice.RecurringInvoiceLineItem>();
        items.add(item1);

        RecurringInvoice recurringInvoice = RecurringInvoice.create(RecurringInvoiceCreateRequestParams.builder()
                .with($ -> {
                    $.isActive = isActive;
                    $.customerId = customerId;
                    $.description = description;
                    $.poNumber = poNumber;
                    $.isToBePrinted = isToBePrinted;
                    $.isToBeEmailed = isToBeEmailed;
                    $.salesRep = salesRep;
                    $.timePeriod = timePeriod;
                    $.frequencyPerTimePeriod = frequencyPerTimePeriod;
                    $.nextDueDate = nextDueDate;
                    $.daysInAdvance = daysInAdvance;
                    $.recurringInvoiceLineItems = items;
                }).build());

        recurringInvoiceId = recurringInvoice.getId();
    }


    @Interface
    class create {
        @FunctionalTest
        void should_create_a_customer_with_passed_params() throws Exception {
            RecurringInvoice.RecurringInvoiceLineItem item1 = RecurringInvoice.RecurringInvoiceLineItem.builder()
                    .with($ -> {
                        $.quantity = itemQuantity;
                        $.price = itemPrice;
                        $.description = itemDescription;
                    }).build();

            List<RecurringInvoice.RecurringInvoiceLineItem> items = new ArrayList<RecurringInvoice.RecurringInvoiceLineItem>();
            items.add(item1);

            RecurringInvoice recurringInvoice = RecurringInvoice.create(RecurringInvoiceCreateRequestParams.builder()
                    .with($ -> {
                        $.isActive = isActive;
                        $.customerId = customerId;
                        $.description = description;
                        $.poNumber = poNumber;
                        $.isToBePrinted = isToBePrinted;
                        $.isToBeEmailed = isToBeEmailed;
                        $.salesRep = salesRep;
                        $.timePeriod = timePeriod;
                        $.frequencyPerTimePeriod = frequencyPerTimePeriod;
                        $.nextDueDate = nextDueDate;
                        $.daysInAdvance = daysInAdvance;
                        $.recurringInvoiceLineItems = items;
                    }).build());

            checkValues(recurringInvoice);
            checkItemValues(recurringInvoice.getRecurringInvoiceLineItems().get(0));
        }

        @Condition
        class When_given_bad_input {
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    RecurringInvoice.create(RecurringInvoiceCreateRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class get {
        @FunctionalTest
        void should_retrieve_the_sepcified_vendor() throws Exception {
            RecurringInvoiceGetRequestParams params = RecurringInvoiceGetRequestParams.builder()
                    .with($ -> {
                        $.id = recurringInvoiceId;
                    }).build();
            RecurringInvoice recurringInvoice = RecurringInvoice.get(params);
            assertAll(() -> assertEquals(recurringInvoiceId, recurringInvoice.getId()));
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    RecurringInvoice.get(RecurringInvoiceGetRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class update {
        @FunctionalTest
        void should_update_recurring_invoice_with_given_params() throws Exception {
            RecurringInvoice.RecurringInvoiceLineItem item1 = RecurringInvoice.RecurringInvoiceLineItem.builder()
                    .with($ -> {
                        $.quantity = itemQuantity;
                        $.price = itemPrice;
                        $.description = itemDescription;
                    }).build();

            List<RecurringInvoice.RecurringInvoiceLineItem> items = new ArrayList<RecurringInvoice.RecurringInvoiceLineItem>();
            items.add(item1);

            RecurringInvoice recurringInvoice = RecurringInvoice.update(RecurringInvoiceUpdateRequestParams.builder()
                    .with($ -> {
                        $.id = recurringInvoiceId;
                        $.isActive = isActive;
                        $.customerId = customerId;
                        $.description = description;
                        $.poNumber = poNumber;
                        $.isToBePrinted = isToBePrinted;
                        $.isToBeEmailed = isToBeEmailed;
                        $.salesRep = salesRep;
                        $.timePeriod = timePeriod;
                        $.frequencyPerTimePeriod = frequencyPerTimePeriod;
                        $.nextDueDate = nextDueDate;
                        $.daysInAdvance = daysInAdvance;
                        $.recurringInvoiceLineItems = items;
                    }).build());

            checkValues(recurringInvoice);
            checkItemValues(recurringInvoice.getRecurringInvoiceLineItems().get(0));
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    RecurringInvoice.update(RecurringInvoiceUpdateRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class update1 {
        @FunctionalTest
        void should_update_the_given_resource() throws Exception {
            RecurringInvoiceGetRequestParams params = RecurringInvoiceGetRequestParams.builder()
                    .with($ -> {
                        $.id = recurringInvoiceId;
                    }).build();
            RecurringInvoice recurringInvoice = RecurringInvoice.get(params);
            RecurringInvoice.RecurringInvoiceLineItem item = recurringInvoice.getRecurringInvoiceLineItems().get(0);

            item.setQuantity(itemQuantity);
            item.setPrice(itemPrice);
            item.setDescription(itemDescription);


            recurringInvoice.setIsActive(isActive);
            recurringInvoice.setCustomerId(customerId);
            recurringInvoice.setDescription(description);
            recurringInvoice.setPoNumber(poNumber);
            recurringInvoice.setIsToBePrinted(isToBePrinted);
            recurringInvoice.setIsToBeEmailed(isToBeEmailed);
            recurringInvoice.setSalesRep(salesRep);
            recurringInvoice.setTimePeriod(timePeriod);
            recurringInvoice.setFrequencyPerTimePeriod(frequencyPerTimePeriod);
            recurringInvoice.setNextDueDate(nextDueDate);
            recurringInvoice.setDaysInAdvance(daysInAdvance);

            recurringInvoice = RecurringInvoice.update(recurringInvoice);

            checkValues(recurringInvoice);
            checkItemValues(recurringInvoice.getRecurringInvoiceLineItems().get(0));
        }
    }

    void checkValues(RecurringInvoice invoice) {
        assertAll(() -> {
            assertEquals(isActive, invoice.getIsActive());
            assertEquals(customerId, invoice.getCustomerId());
            assertEquals(description, invoice.getDescription());
            assertEquals(poNumber, invoice.getPoNumber());
            assertEquals(isToBePrinted, invoice.getIsToBePrinted());
            assertEquals(isToBeEmailed, invoice.getIsToBeEmailed());
            assertEquals(salesRep, invoice.getSalesRep());
            assertEquals(timePeriod, invoice.getTimePeriod());
            assertEquals(frequencyPerTimePeriod, invoice.getFrequencyPerTimePeriod());
            assertEquals(nextDueDate, invoice.getNextDueDate());
            assertEquals(daysInAdvance, invoice.getDaysInAdvance());
        });

    }

    void checkItemValues(RecurringInvoice.RecurringInvoiceLineItem recurringInvoiceLineItem) {
        assertAll(() -> {
            assertEquals(itemEntity, recurringInvoiceLineItem.getEntity());
            assertEquals(itemQuantity, recurringInvoiceLineItem.getQuantity());
            assertEquals(itemPrice, recurringInvoiceLineItem.getPrice());
            assertEquals(itemDescription, recurringInvoiceLineItem.getDescription());
        });

    }
}