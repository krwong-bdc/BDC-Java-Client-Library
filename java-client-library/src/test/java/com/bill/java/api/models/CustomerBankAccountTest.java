package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.param.CustomerBankAccountCreateRequestParams;
import com.bill.java.api.param.CustomerBankAccountGetRequestParams;
import com.bill.java.api.param.CustomerCreateRequestParams;
import com.bill.java.api.param.CustomerSetAuthorizationRequestParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.BDDTests;
import resources.TestEnv;

import static org.junit.jupiter.api.Assertions.*;

class CustomerBankAccountTest extends BDDTests {
    private String entity = "CustomerBankAccount";
    private String isActive;
    private String customerId;
    private String nameOnAccount;
    private String nickname;
    private String routingNumber;
    private String accountNumber;
    private Boolean isLockedByOrg;
    private Boolean isSavings;
    private Boolean isPersonalAcct;
    private Boolean isWrittenAuth;
    private Boolean agreedWithTOS;

    @BeforeEach
    void setup() throws Exception {
        login();

        isActive = "1";
        customerId = TestEnv.testCustomerId;
        nameOnAccount = genFullName();
        nickname = genFName();
        routingNumber = "322271627";
        accountNumber = genNumAsString(7);
        isLockedByOrg = false;
        isSavings = genBool();
        isPersonalAcct = genBool();
        isWrittenAuth = genBool();
        agreedWithTOS = genBool();
    }

    @Interface
    class create{
        @DisabledFunctionalTest
        void should_create_a_new_bank_account() throws Exception {
            Customer newCustomer = Customer.create(
                    CustomerCreateRequestParams.builder()
                            .with($ -> $.name = nameOnAccount)
                            .build());

            CustomerBankAccountCreateRequestParams params = CustomerBankAccountCreateRequestParams.builder()
                    .with($ -> {
                        $.isActive = "1";
                        $.customerId = newCustomer.getId();
                        $.nameOnAccount = nameOnAccount;
                        $.nickname = nickname;
                        $.routingNumber = routingNumber;
                        $.accountNumber = accountNumber;
                        $.isLockedByOrg = isLockedByOrg;
                        $.isSavings = isSavings;
                        $.isPersonalAcct = isPersonalAcct;
                        $.isWrittenAuth = isWrittenAuth;
                        $.agreedWithTOS = agreedWithTOS;
                    }).build();

            CustomerBankAccount customerBankAccount = CustomerBankAccount.create(params);
            assertAll(() -> {
                assertEquals(entity, customerBankAccount.getEntity());
                assertEquals(isActive, customerBankAccount.getIsActive());
                assertEquals(nameOnAccount, customerBankAccount.getNameOnAccount());
                assertEquals(nickname, customerBankAccount.getNickname());
                assertEquals(routingNumber, customerBankAccount.getRoutingNumber());
                assertEquals(accountNumber, customerBankAccount.getAccountNumber());
                assertEquals(isLockedByOrg, customerBankAccount.getIsLockedByOrg());
                assertEquals(isSavings, customerBankAccount.getIsSavings());
                assertEquals(isPersonalAcct, customerBankAccount.getIsPersonalAcct());
                assertEquals(isWrittenAuth, customerBankAccount.getIsWrittenAuth());
            });
        }
        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    CustomerBankAccount.create(CustomerBankAccountCreateRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class get{
        @DisabledFunctionalTest
        void should_retrieve_the_specified_bank_account() throws Exception {
            CustomerBankAccountGetRequestParams.Builder builder;
            CustomerBankAccountGetRequestParams params;

            builder = CustomerBankAccountGetRequestParams.builder();
            params = builder.with($ -> {
                $.id = TestEnv.testCustomerBankAccountId;
            }).build();

            CustomerBankAccount account = CustomerBankAccount.get(params);

            assertEquals(TestEnv.testCustomerBankAccountId, account.getId());
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    CustomerBankAccount.get(CustomerBankAccountGetRequestParams.builder().build());
                });
            }
        }
    }
}