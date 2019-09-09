package com.bill.java.api.models;

import com.bill.java.api.BDC;
import com.bill.java.api.exception.BDCException;
import com.bill.java.api.param.InvoiceCreateRequestParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import resources.BDDTests;
import resources.TestEnv;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

        login();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        isActive = genNumAsString(1, 2);
        customerId = TestEnv.testCustomerId;
        invoiceNumber = genNumAsString(5);
        invoiceDate = format.format(new Date());
        dueDate = genFutureDate();
        glPostingDate = format.format(new Date());
        amount = BigDecimal.valueOf(new Random().nextInt(400));
        amountDue = amount;
        paymentStatus = "1";
        description = genDescription();
        poNumber = genNumAsString(7);
        isToBePrinted = genBool();
        isToBeEmailed = genBool();
        lastSentTime = null;
        itemSalesTax = null;
        salesTaxPercentage = new Random().nextInt(10);
        salesTaxTotal = null;
        terms = null;
        salesRep = genFName();
        FOB= genNumAsString(10);
        shipDate = genFutureDate();
        shipMethod = null;
        departmentId = null;
        locationId = null;
//        actgClassId = ;
//        jobId = ;
//        payToBankAccountId = ;
//        payToChartOfAccountId = ;

        itemId = null;
        quantity = new Random().nextInt(10);
        itemAmount = BigDecimal.valueOf(new Random().nextInt(400));
        price = BigDecimal.valueOf(amount.intValue() / quantity);
        ratePercent = new Random().nextInt(5);
//        itemChartOfAccountId = null;
//        itemDepartmentId = ;
//        itemLocationId = ;
//        itemActgClassId = ;
//        itemJobId = ;
        itemDescription = genDescription();
        taxable = genBool();
        taxCode = null;
    }

    @Interface
    class create{

        @FunctionalTest
        void should_create_a_customer_with_passed_params() throws Exception {
            Invoice.InvoiceLineItem item1 = Invoice.InvoiceLineItem.builder()
                    .with($ -> {
                        $.itemId = itemId;
                        $.quantity = quantity;
                        $.amount = itemAmount;
                        $.price = price;
                        $.ratePercent = ratePercent;
                        $.description = itemDescription;
                        $.taxable = taxable;
                        $.taxCode = taxCode;
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
                        $.itemSalesTax = itemSalesTax;
                        $.salesTaxTotal = salesTaxTotal;
                        $.terms = terms;
                        $.salesRep = salesRep;
                        $.FOB = FOB;
                        $.shipDate = shipDate;
                        $.shipMethod = shipMethod;
                        $.departmentId = departmentId;
                        $.locationId = locationId;
                        $.actgClassId = actgClassId;
                        $.jobId = jobId;
                        $.payToBankAccountId = payToBankAccountId;
                        $.payToChartOfAccountId = payToChartOfAccountId;
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
    }

    @Interface
    class update{
    }

    @Interface
    class update1{
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
            assertEquals(amount, invoice.getAmount());
            assertEquals(amountDue, invoice.getAmountDue());
            assertEquals(paymentStatus, invoice.getPaymentStatus());
            assertEquals(description, invoice.getDescription());
            assertEquals(poNumber, invoice.getPoNumber());
            assertEquals(isToBePrinted, invoice.getIsToBePrinted());
            assertEquals(isToBeEmailed, invoice.getIsToBeEmailed());
            assertEquals(lastSentTime, invoice.getLastSentTime());
            assertEquals(itemSalesTax, invoice.getItemSalesTax());
            assertEquals(salesTaxPercentage, invoice.getSalesTaxPercentage());
            assertEquals(salesTaxTotal, invoice.getSalesTaxTotal());
            assertEquals(terms, invoice.getTerms());
            assertEquals(salesRep, invoice.getSalesRep());
            assertEquals(FOB, invoice.getFOB());
            assertEquals(shipDate, invoice.getShipDate());
            assertEquals(shipMethod, invoice.getShipMethod());
            assertEquals(departmentId, invoice.getDepartmentId());
            assertEquals(locationId, invoice.getLocationId());
            assertEquals(actgClassId, invoice.getActgClassId());
            assertEquals(jobId, invoice.getJobId());
            assertEquals(payToBankAccountId, invoice.getPayToBankAccountId());
            assertEquals(payToChartOfAccountId, invoice.getPayToChartOfAccountId());
        });

    }

    void checkItemValues(Invoice.InvoiceLineItem invoiceLineItem) {
        assertAll(() -> {
            assertEquals(entity, invoiceLineItem.getEntity());
            assertEquals(jobId, invoiceLineItem.getJobId());
            assertEquals(itemId, invoiceLineItem.getItemId());
            assertEquals(quantity, invoiceLineItem.getQuantity());
            assertEquals(itemAmount, invoiceLineItem.getAmount());
            assertEquals(price, invoiceLineItem.getPrice());
            assertEquals(ratePercent, invoiceLineItem.getRatePercent());
            assertEquals(itemDescription, invoiceLineItem.getDescription());
            assertEquals(taxable, invoiceLineItem.getTaxable());
            assertEquals(taxCode, invoiceLineItem.getTaxCode());
        });

    }
}