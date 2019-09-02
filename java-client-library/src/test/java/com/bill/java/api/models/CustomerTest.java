package com.bill.java.api.models;

import com.bill.java.api.BDC;
import com.bill.java.api.exception.BDCException;
import com.bill.java.api.param.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.BDDTests;
import resources.TestEnv;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest extends BDDTests {
    private String entity = "Customer";
    private String isActive;
    private String name;
    private String shortName;
    private String companyName;
    private String contactFirstName;
    private String contactLastName;
    private String accNumber;
    private String billAddress1;
    private String billAddress2;
    private String billAddress3;
    private String billAddress4;
    private String billAddressCity;
    private String billAddressState;
    private String billAddressCountry;
    private String billAddressZip;
    private String shipAddress1;
    private String shipAddress2;
    private String shipAddress3;
    private String shipAddress4;
    private String shipAddressCity;
    private String shipAddressState;
    private String shipAddressCountry;
    private String shipAddressZip;
    private String email;
    private String phone;
    private String altPhone;
    private String fax;
    private String description;
    private String printAs;
    private String accountType;

    @BeforeEach
    void setup() throws Exception {
        BDC.userName = TestEnv.userName;
        BDC.password = TestEnv.password;
        BDC.devKey = TestEnv.devKey;

        login();

        isActive = genNumAsString(1, 2);
        name = genFullName();
        shortName = genFName();
        companyName = genCompanyName();
        contactFirstName = genFName();
        contactLastName = genLName();
        accNumber = genNumAsString(10);
        billAddress1 = genAddress1();
        billAddress2 = genAddress2();
        billAddress3 = genAddress3();
        billAddress4 = genAddress4();
        billAddressCity = genCity();
        billAddressState = genState();
        billAddressCountry = genCountry();
        billAddressZip = genZip();
        shipAddress1 = genAddress1();
        shipAddress2 = genAddress2();
        shipAddress3 = genAddress3();
        shipAddress4 = genAddress4();
        shipAddressCity = genCity();
        shipAddressState = genState();
        shipAddressCountry = genCountry();
        shipAddressZip = genZip();
        email = genEmail();
        phone = genPhone();
        altPhone = genPhone();
        fax = genPhone();
        description = genDescription();
        accountType = genNumAsString(0, 2);

    }

    @Interface
    class create {

        @FunctionalTest
        void should_create_a_customer_with_passed_params() throws Exception {
            Customer customer = Customer.create(CustomerCreateRequestParams.builder()
                    .with($ -> {
                        $.isActive = isActive;
                        $.name = name;
                        $.shortName = shortName;
                        $.companyName = companyName;
                        $.contactFirstName = contactFirstName;
                        $.contactLastName = contactLastName;
                        $.accNumber = accNumber;
                        $.billAddress1 = billAddress1;
                        $.billAddress2 = billAddress2;
                        $.billAddress3 = billAddress3;
                        $.billAddress4 = billAddress4;
                        $.billAddressCity = billAddressCity;
                        $.billAddressState = billAddressState;
                        $.billAddressCountry = billAddressCountry;
                        $.billAddressZip = billAddressZip;
                        $.shipAddress1 = shipAddress1;
                        $.shipAddress2 = shipAddress2;
                        $.shipAddress3 = shipAddress3;
                        $.shipAddress4 = shipAddress4;
                        $.shipAddressCity = shipAddressCity;
                        $.shipAddressState = shipAddressState;
                        $.shipAddressCountry = shipAddressCountry;
                        $.shipAddressZip = shipAddressZip;
                        $.email = email;
                        $.phone = phone;
                        $.altPhone = altPhone;
                        $.fax = fax;
                        $.description = description;
                        $.printAs = printAs;
                        $.accountType = accountType;
                    }).build());

            checkValues(customer);
        }

        @Condition
        class When_given_bad_input {
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Customer.create(CustomerCreateRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class get {
        @FunctionalTest
        void should_retrieve_the_sepcified_vendor() throws Exception {
            CustomerGetRequestParams params = CustomerGetRequestParams.builder()
                    .with($ -> {
                        $.id = TestEnv.testCustomerId;
                    }).build();
            Customer customer = Customer.get(params);
            assertAll(() -> assertEquals(TestEnv.testCustomerId, customer.getId()));
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Customer.get(CustomerGetRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class update {
        @FunctionalTest
        void should_update_customer_with_given_params() throws Exception {
            Customer customer = Customer.update(CustomerUpdateRequestParams.builder()
                    .with($ -> {
                        $.isActive = isActive;
                        $.id = TestEnv.testCustomerId;
                        $.name = name;
                        $.shortName = shortName;
                        $.companyName = companyName;
                        $.contactFirstName = contactFirstName;
                        $.contactLastName = contactLastName;
                        $.accNumber = accNumber;
                        $.billAddress1 = billAddress1;
                        $.billAddress2 = billAddress2;
                        $.billAddress3 = billAddress3;
                        $.billAddress4 = billAddress4;
                        $.billAddressCity = billAddressCity;
                        $.billAddressState = billAddressState;
                        $.billAddressCountry = billAddressCountry;
                        $.billAddressZip = billAddressZip;
                        $.shipAddress1 = shipAddress1;
                        $.shipAddress2 = shipAddress2;
                        $.shipAddress3 = shipAddress3;
                        $.shipAddress4 = shipAddress4;
                        $.shipAddressCity = shipAddressCity;
                        $.shipAddressState = shipAddressState;
                        $.shipAddressCountry = shipAddressCountry;
                        $.shipAddressZip = shipAddressZip;
                        $.email = email;
                        $.phone = phone;
                        $.altPhone = altPhone;
                        $.fax = fax;
                        $.description = description;
                        $.printAs = printAs;
                        $.accountType = accountType;
                    }).build());

            checkValues(customer);
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Customer.update(CustomerUpdateRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class update2 {
        @FunctionalTest
        void should_update_the_given_resource() throws Exception {
            CustomerGetRequestParams params = CustomerGetRequestParams.builder()
                    .with($ -> {
                        $.id = TestEnv.testCustomerId;
                    }).build();
            Customer customer = Customer.get(params);

            customer.setIsActive(isActive);
            customer.setName(name);
            customer.setShortName(shortName);
            customer.setCompanyName(companyName);
            customer.setContactFirstName(contactFirstName);
            customer.setContactLastName(contactLastName);
            customer.setAccNumber(accNumber);
            customer.setBillAddress1(billAddress1);
            customer.setBillAddress2(billAddress2);
            customer.setBillAddress3(billAddress3);
            customer.setBillAddress4(billAddress4);
            customer.setBillAddressCity(billAddressCity);
            customer.setBillAddressState(billAddressState);
            customer.setBillAddressCountry(billAddressCountry);
            customer.setBillAddressZip(billAddressZip);
            customer.setShipAddress1(shipAddress1);
            customer.setShipAddress2(shipAddress2);
            customer.setShipAddress3(shipAddress3);
            customer.setShipAddress4(shipAddress4);
            customer.setShipAddressCity(shipAddressCity);
            customer.setShipAddressState(shipAddressState);
            customer.setShipAddressCountry(shipAddressCountry);
            customer.setShipAddressZip(shipAddressZip);
            customer.setEmail(email);
            customer.setPhone(phone);
            customer.setAltPhone(altPhone);
            customer.setFax(fax);
            customer.setDescription(description);
            customer.setPrintAs(printAs);
            customer.setAccountType(accountType);

            customer = Customer.update(customer);

            checkValues(customer);
        }
    }

    @Interface
    class setAuthorization {
        @FunctionalTest
        void should_set_a_customers_authorization_to_charge() throws Exception {
            Customer customer = Customer.setAuthorization(CustomerSetAuthorizationRequestParams.builder()
                    .with($ -> {
                        $.hasAuthorized = true;
                        $.customerId = TestEnv.testCustomerId;
                    }).build());

            assertTrue(customer.getHasAuthorizedToCharge());

            customer = Customer.setAuthorization(CustomerSetAuthorizationRequestParams.builder()
                    .with($ -> {
                        $.hasAuthorized = false;
                        $.customerId = TestEnv.testCustomerId;
                    }).build());

            assertFalse(customer.getHasAuthorizedToCharge());

            customer = Customer.setAuthorization(CustomerSetAuthorizationRequestParams.builder()
                    .with($ -> {
                        $.hasAuthorized = true;
                        $.customerId = TestEnv.testCustomerId;
                    }).build());

            assertTrue(customer.getHasAuthorizedToCharge());
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Customer.setAuthorization(CustomerSetAuthorizationRequestParams.builder().build());
                });
            }
        }
    }

    void checkValues(Customer customer) {
        assertAll(() -> {
            assertEquals(entity, customer.getEntity());
            assertEquals(isActive, customer.getIsActive());
            assertEquals(name, customer.getName());
            assertEquals(shortName, customer.getShortName());
            assertEquals(companyName, customer.getCompanyName());
            assertEquals(contactFirstName, customer.getContactFirstName());
            assertEquals(contactLastName, customer.getContactLastName());
            assertEquals(accNumber, customer.getAccNumber());
            assertEquals(billAddress1, customer.getBillAddress1());
            assertEquals(billAddress2, customer.getBillAddress2());
            assertEquals(billAddress3, customer.getBillAddress3());
            assertEquals(billAddress4, customer.getBillAddress4());
            assertEquals(billAddressCity, customer.getBillAddressCity());
            assertEquals(billAddressState, customer.getBillAddressState());
            assertEquals(billAddressCountry, customer.getBillAddressCountry());
            assertEquals(billAddressZip, customer.getBillAddressZip());
            assertEquals(shipAddress1, customer.getShipAddress1());
            assertEquals(shipAddress2, customer.getShipAddress2());
            assertEquals(shipAddress3, customer.getShipAddress3());
            assertEquals(shipAddress4, customer.getShipAddress4());
            assertEquals(shipAddressCity, customer.getShipAddressCity());
            assertEquals(shipAddressState, customer.getShipAddressState());
            assertEquals(shipAddressCountry, customer.getShipAddressCountry());
            assertEquals(shipAddressZip, customer.getShipAddressZip());
            assertEquals(email, customer.getEmail());
            assertEquals(phone, customer.getPhone());
            assertEquals(altPhone, customer.getAltPhone());
            assertEquals(fax, customer.getFax());
            assertEquals(description, customer.getDescription());
            assertEquals(accountType, customer.getAccountType());
        });

    }
}