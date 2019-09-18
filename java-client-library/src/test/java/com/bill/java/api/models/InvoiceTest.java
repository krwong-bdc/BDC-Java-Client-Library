package com.bill.java.api.models;

import com.bill.java.api.BDC;
import com.bill.java.api.exception.BDCException;
import com.bill.java.api.param.InvoiceCreateRequestParams;
import com.bill.java.api.param.InvoiceGetRequestParams;
import com.bill.java.api.param.InvoiceUpdateRequestParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import resources.BDDTests;
import resources.TestEnv;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("@Invoice")
class InvoiceTest extends BDDTests {
    private String entity = "Invoice";
    private String isActive;
    private String customerId;
    private String invoiceNumber;
    private String invoiceDate;
    private String dueDate;
    private String glPostingDate;
    private BigDecimal amount;
    private BigDecimal amountDue;
    private String paymentStatus;
    private String description;
    private String poNumber;
    private Boolean isToBePrinted;
    private Boolean isToBeEmailed;
    private String lastSentTime;
    private String itemSalesTax;
    private Integer salesTaxPercentage;
    private BigDecimal salesTaxTotal;
    private String terms;
    private String salesRep;
    private String FOB;
    private String shipDate;
    private String shipMethod;
    private String departmentId;
    private String locationId;
    private String actgClassId;
    private String jobId;
    private String payToBankAccountId;
    private String payToChartOfAccountId;


    private String itemEntity = "InvoiceLineItem";
    private String itemId;
    private Integer quantity;
    private BigDecimal itemAmount;
    private BigDecimal price;
    private Integer ratePercent;
    private String chartOfAccountId;
    private String itemdDpartmentId;
    private String itemLocationId;
    private String itemActgClassId;
    private String itemJobId;
    private String itemDescription;
    private Boolean taxable;
    private String taxCode;

    @BeforeEach
    void setup() throws Exception {
        BDC.userName = TestEnv.userName;
        BDC.password = TestEnv.password;
        BDC.devKey = TestEnv.devKey;

        login(1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        quantity = new Random().nextInt(10) + 1;
        price = BigDecimal.valueOf(new Random().nextInt(400), 2);
        ratePercent = new Random().nextInt(5);
        itemDescription = genDescription();
        taxable = genBool();

        isActive = genNumAsString(1, 2);
        customerId = TestEnv.testCustomerId;
        invoiceNumber = genNumAsString(5);
        invoiceDate = format.format(new Date());
        dueDate = genFutureDate();
        glPostingDate = format.format(new Date());
        amount = BigDecimal.valueOf(quantity * price.intValue(), 2);
        amountDue = amount;
        paymentStatus = "1";
        description = genDescription();
        poNumber = genNumAsString(7);
        isToBePrinted = genBool();
        isToBeEmailed = genBool();
        salesTaxPercentage = new Random().nextInt(10);
        salesRep = genFName();
        FOB = genNumAsString(10);
        shipDate = genFutureDate();
    }

    @Interface
    class create{

        @FunctionalTest
        void should_create_a_customer_with_passed_params() throws Exception {
            Invoice.InvoiceLineItem item1 = Invoice.InvoiceLineItem.builder()
                    .with($ -> {
                        $.quantity = quantity;
                        $.price = price;
                        $.description = itemDescription;
                    }).build();

            List<Invoice.InvoiceLineItem> items = new ArrayList<Invoice.InvoiceLineItem>();
            items.add(item1);

            Invoice invoice = Invoice.create(InvoiceCreateRequestParams.builder()
                    .with($ -> {
                        $.isActive = isActive;
                        $.customerId = customerId;
                        $.invoiceNumber = invoiceNumber;
                        $.invoiceDate = invoiceDate;
                        $.dueDate = dueDate;
                        $.glPostingDate = glPostingDate;
                        $.description = description;
                        $.poNumber = poNumber;
                        $.isToBePrinted = isToBePrinted;
                        $.isToBeEmailed = isToBeEmailed;
                        $.terms = terms;
                        $.salesRep = salesRep;
                        $.FOB = FOB;
                        $.shipDate = shipDate;
                        $.shipMethod = shipMethod;
                        $.invoiceLineItems = items;
                    }).build());

            checkValues(invoice);
            checkItemValues(invoice.getInvoiceLineItems().get(0));
        }

        @Condition
        class When_given_bad_input {
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Invoice.create(InvoiceCreateRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class get{
        @FunctionalTest
        void should_retrieve_the_sepcified_vendor() throws Exception {
            InvoiceGetRequestParams params = InvoiceGetRequestParams.builder()
                    .with($ -> {
                        $.id = TestEnv.testInvoiceId;
                    }).build();
            Invoice invoice = Invoice.get(params);
            assertAll(() -> assertEquals(TestEnv.testInvoiceId, invoice.getId()));
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Invoice.get(InvoiceGetRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class update{
        @FunctionalTest
        void should_update_invoice_with_given_params() throws Exception {
            Invoice.InvoiceLineItem item1 = Invoice.InvoiceLineItem.builder()
                    .with($ -> {
                        $.quantity = quantity;
                        $.price = price;
                        $.description = itemDescription;
                    }).build();

            List<Invoice.InvoiceLineItem> items = new ArrayList<Invoice.InvoiceLineItem>();
            items.add(item1);

            Invoice invoice = Invoice.update(InvoiceUpdateRequestParams.builder()
                    .with($ -> {
                        $.isActive = isActive;
                        $.id = TestEnv.testInvoiceId;
                        $.isActive = isActive;
                        $.customerId = customerId;
                        $.invoiceNumber = invoiceNumber;
                        $.invoiceDate = invoiceDate;
                        $.dueDate = dueDate;
                        $.glPostingDate = glPostingDate;
                        $.description = description;
                        $.poNumber = poNumber;
                        $.isToBePrinted = isToBePrinted;
                        $.isToBeEmailed = isToBeEmailed;
                        $.terms = terms;
                        $.salesRep = salesRep;
                        $.FOB = FOB;
                        $.shipDate = shipDate;
                        $.shipMethod = shipMethod;
                        $.invoiceLineItems = items;
                        $.description = description;
                    }).build());

            checkValues(invoice);
            checkItemValues(invoice.getInvoiceLineItems().get(0));
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Invoice.update(InvoiceUpdateRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class update2 {
        @FunctionalTest
        void should_update_the_given_resource() throws Exception {
            InvoiceGetRequestParams params = InvoiceGetRequestParams.builder()
                    .with($ -> {
                        $.id = TestEnv.testInvoiceId;
                    }).build();
            Invoice invoice = Invoice.get(params);
            Invoice.InvoiceLineItem item = invoice.getInvoiceLineItems().get(0);

            item.setQuantity(quantity);
            item.setPrice(price);
            item.setDescription(itemDescription);


            invoice.setIsActive(isActive);
            invoice.setCustomerId(customerId);
            invoice.setInvoiceNumber(invoiceNumber);
            invoice.setInvoiceDate(invoiceDate);
            invoice.setDueDate(dueDate);
            invoice.setGlPostingDate(glPostingDate);
            invoice.setDescription(description);
            invoice.setPoNumber(poNumber);
            invoice.setIsToBePrinted(isToBePrinted);
            invoice.setIsToBeEmailed(isToBeEmailed);
            invoice.setTerms(terms);
            invoice.setSalesRep(salesRep);
            invoice.setFOB(FOB);
            invoice.setShipDate(shipDate);
            invoice.setShipMethod(shipMethod);
            invoice.setInvoiceLineItems(new ArrayList<Invoice.InvoiceLineItem>(Arrays.asList(item)));
            invoice.setDescription(description);

            invoice = Invoice.update(invoice);

            checkValues(invoice);
            checkItemValues(invoice.getInvoiceLineItems().get(0));
        }
    }

    void checkValues(Invoice invoice) {
        assertAll(() -> {
            assertEquals(entity, invoice.getEntity());
            assertEquals(isActive, invoice.getIsActive());
            assertEquals(customerId, invoice.getCustomerId());
            assertEquals(invoiceNumber, invoice.getInvoiceNumber());
            assertEquals(invoiceDate, invoice.getInvoiceDate());
            assertEquals(dueDate, invoice.getDueDate());
            assertEquals(glPostingDate, invoice.getGlPostingDate());
            assertEquals(description, invoice.getDescription());
            assertEquals(poNumber, invoice.getPoNumber());
            assertEquals(isToBePrinted, invoice.getIsToBePrinted());
            assertEquals(isToBeEmailed, invoice.getIsToBeEmailed());
            assertEquals(terms, invoice.getTerms());
            assertEquals(salesRep, invoice.getSalesRep());
            assertEquals(FOB, invoice.getFOB());
            assertEquals(shipDate, invoice.getShipDate());
            assertEquals(shipMethod, invoice.getShipMethod());
        });

    }

    void checkItemValues(Invoice.InvoiceLineItem invoiceLineItem) {
        assertAll(() -> {
            assertEquals(itemEntity, invoiceLineItem.getEntity());
            assertEquals(quantity, invoiceLineItem.getQuantity());
            assertEquals(price, invoiceLineItem.getPrice());
            assertEquals(itemDescription, invoiceLineItem.getDescription());
        });

    }
}