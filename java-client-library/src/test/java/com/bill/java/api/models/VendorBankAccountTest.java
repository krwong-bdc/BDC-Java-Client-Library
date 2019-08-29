package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.param.VendorBankAccountCreateRequestParams;
import com.bill.java.api.param.VendorBankAccountGetRequestParams;
import com.bill.java.api.param.VendorCreateRequestParams;
import jdk.nashorn.internal.objects.annotations.Function;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.BDDTests;
import resources.TestEnv;

import static org.junit.jupiter.api.Assertions.*;

class VendorBankAccountTest extends BDDTests {
    private String entity = "VendorBankAccount";
    private String id;
    private String isActive;
    private String createdTime;
    private String updatedTime;
    private String vendorId;
    private String accountNumber;
    private String routingNumber;
    private String usersId;
    private String status;
    private Boolean isSavings;
    private Boolean isPersonalAcct;

    @BeforeEach
    void setup() throws Exception {
        login();

        isActive = "1";
        vendorId = TestEnv.testVendorId;
        accountNumber = genNumAsString(7);
        routingNumber = "322271627";
        usersId = TestEnv.userId;
        isSavings = genBool();
        isPersonalAcct = genBool();
    }

    @Interface
    class create {
        @FunctionalTest
        void should_create_a_new_bank_account() throws Exception {
            Vendor newvendor = Vendor.create(VendorCreateRequestParams.builder()
                    .with($ -> {
                        $.name = "NewTestVendor";
                    }).build());

            VendorBankAccountCreateRequestParams params = VendorBankAccountCreateRequestParams.builder()
                    .with($ -> {
                        $.isActive = isActive;
                        $.vendorId = newvendor.getId();
                        $.accountNumber = accountNumber;
                        $.routingNumber = routingNumber;
                        $.usersId = usersId;
                        $.isSavings = isSavings;
                        $.isPersonalAcct = isPersonalAcct;
                    }).build();

            VendorBankAccount vendorBankAccount = VendorBankAccount.create(params);
            assertAll(() -> {
                 assertEquals(entity, vendorBankAccount.getEntity());
                 assertEquals("1", vendorBankAccount.getIsActive());
                 assertEquals(newvendor.getId(), vendorBankAccount.getVendorId());
                 assertEquals(accountNumber.substring(3), vendorBankAccount.getAccountNumber().substring(3));
                 assertEquals(routingNumber, vendorBankAccount.getRoutingNumber());
                 assertEquals(usersId, vendorBankAccount.getUsersId());
                 assertEquals(isSavings, vendorBankAccount.isSavings());
                 assertEquals(isPersonalAcct, vendorBankAccount.isPersonalAcct());
            });
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    VendorBankAccount.create(VendorBankAccountCreateRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class get {
        @FunctionalTest
        void should_retrieve_the_specified_bank_account() throws Exception {
            VendorBankAccountGetRequestParams.Builder builder;
            VendorBankAccountGetRequestParams params;

            builder = VendorBankAccountGetRequestParams.builder();
            params = builder.with($ -> {
                $.id = TestEnv.testVendorBankAccountId;
            }).build();

            VendorBankAccount account = VendorBankAccount.get(params);

            assertEquals(TestEnv.testVendorBankAccountId, account.getId());
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    VendorBankAccount.get(VendorBankAccountGetRequestParams.builder().build());
                });
            }
        }
    }
}