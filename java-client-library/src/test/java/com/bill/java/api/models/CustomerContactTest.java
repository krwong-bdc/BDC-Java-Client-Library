package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.param.CustomerContactCreateRequestParams;
import com.bill.java.api.param.CustomerContactGetRequestParams;
import com.bill.java.api.param.CustomerContactUpdateRequestParams;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.BDDTests;
import resources.TestEnv;

import static org.junit.jupiter.api.Assertions.*;

class CustomerContactTest extends BDDTests {
    private String entity = "CustomerContact";
    private String isActive;
    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String altPhone;
    private String fax;
    private String timezoneId;

    @BeforeEach
    void setup() throws Exception {
        login();

        isActive = "1";
        customerId = TestEnv.testCustomerId;
        firstName = genFName();
        lastName = genLName();
        email = genEmail();
        phone = genPhone();
        altPhone = genPhone();
        fax = genPhone();
        timezoneId = genNumAsString(3, 6);
    }

    @Interface
    class create {
        @FunctionalTest
        void should_create_a_customer_with_passed_params() throws Exception {
            CustomerContact customerContact = CustomerContact.create(CustomerContactCreateRequestParams.builder()
                    .with($ -> {
                        $.isActive = isActive;
                        $.customerId = customerId;
                        $.firstName = firstName;
                        $.lastName = lastName;
                        $.email = email;
                        $.phone = phone;
                        $.altPhone = altPhone;
                        $.fax = fax;
                        $.timezoneId = timezoneId;
                    }).build());

            checkValues(customerContact);
        }

        @Condition
        class When_given_bad_input {
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    CustomerContact.create(CustomerContactCreateRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class get{
        @FunctionalTest
        void should_retrieve_the_sepcified_customerContact() throws Exception {
            CustomerContactGetRequestParams params = CustomerContactGetRequestParams.builder()
                    .with($ -> {
                        $.id = TestEnv.testCustomerContactId;
                    }).build();
            CustomerContact customerContact = CustomerContact.get(params);
            assertAll(() -> assertEquals(TestEnv.testCustomerContactId, customerContact.getId()));
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    CustomerContact.get(CustomerContactGetRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class update{
        @FunctionalTest
        void should_update_customer_with_given_params() throws Exception {
            CustomerContact customerContact = CustomerContact.update(CustomerContactUpdateRequestParams.builder()
                    .with($ -> {
                        $.id = TestEnv.testCustomerContactId;
                        $.isActive = isActive;
                        $.firstName = firstName;
                        $.lastName = lastName;
                        $.email = email;
                        $.phone = phone;
                        $.altPhone = altPhone;
                        $.fax = fax;
                        $.timezoneId = timezoneId;
                    }).build());

            checkValues(customerContact);
        }

        @Condition
        class When_given_bad_input {
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    CustomerContact.update(CustomerContactUpdateRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class update1 {
        @FunctionalTest
        void should_update_the_given_resource() throws Exception {
            CustomerContactGetRequestParams params = CustomerContactGetRequestParams.builder()
                    .with($ -> {
                        $.id = TestEnv.testCustomerContactId;
                    }).build();
            CustomerContact customerContact = CustomerContact.get(params);

            customerContact.setIsActive(isActive);
            customerContact.setCustomerId(customerId);
            customerContact.setFirstName(firstName);
            customerContact.setLastName(lastName);
            customerContact.setEmail(email);
            customerContact.setPhone(phone);
            customerContact.setAltPhone(altPhone);
            customerContact.setFax(fax);
            customerContact.setTimezoneId(timezoneId);

            customerContact = CustomerContact.update(customerContact);

            checkValues(customerContact);
        }
    }

    void checkValues(CustomerContact customerContact) {
        assertAll(() -> {
            assertEquals(entity, customerContact.getEntity());
            assertEquals(isActive, customerContact.getIsActive());
            assertEquals(customerId, customerContact.getCustomerId());
            assertEquals(firstName, customerContact.getFirstName());
            assertEquals(lastName, customerContact.getLastName());
            assertEquals(email, customerContact.getEmail());
            assertEquals(phone, customerContact.getPhone());
            assertEquals(altPhone, customerContact.getAltPhone());
            assertEquals(fax, customerContact.getFax());
            assertEquals(timezoneId, customerContact.getTimezoneId());
        });

    }
}