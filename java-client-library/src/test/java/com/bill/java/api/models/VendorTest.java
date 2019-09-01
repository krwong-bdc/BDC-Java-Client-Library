package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.param.VendorBankAccountCreateRequestParams;
import com.bill.java.api.param.VendorCreateRequestParams;
import com.bill.java.api.param.VendorGetRequestParams;
import com.bill.java.api.param.VendorUpdateRequestParams;
import jdk.nashorn.internal.objects.annotations.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import resources.BDDTests;
import resources.TestEnv;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("@Vendor")
class VendorTest extends BDDTests {
    private String entity = "Vendor";
    private String isActive;
    private String name;
    private String shortName;
    private String nameOnCheck;
    private String companyName;
    private String accNumber;
    private String taxId;
    private Boolean track1099;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String addressCity;
    private String addressState;
    private String addressZip;
    private String addressCountry;
    private String email;
    private String fax;
    private String phone;
    private String paymentEmail;
    private String paymentPhone;
    private String description;
    private String contactFirstName;
    private String contactLastName;
    private String accountType;

    @BeforeEach
    void setup() throws Exception {
        login();

        isActive = genNumAsString(1, 2);
        name = genFullName() ;
        shortName = genFName();
        nameOnCheck = genFullName();
        companyName = genCompanyName();
        accNumber = genNumAsString(10);
        taxId = genNumAsString(12);
        track1099 = genBool();
        address1 = genAddress1();
        address2 = genAddress2();
        address3 = genAddress3();
        address4 = genAddress4();
        addressCity = genCity();
        addressState = genState();
        addressZip = genZip();
        addressCountry = genCountry();
        email = genEmail();
        fax = genPhone();
        phone = genPhone();
        paymentEmail = genEmail();
        paymentPhone = genPhone();
        description = genDescription();
        contactFirstName = genFName();
        contactLastName = genLName();
        accountType = genNumAsString(0, 2);
    }

    @Interface
    class create {
        @FunctionalTest
        void should_create_a_Vendor_with_passed_set_params() throws Exception {
            VendorCreateRequestParams params = VendorCreateRequestParams.builder()
                    .with($ -> {
                        $.isActive = isActive;
                        $.name = name;
                        $.shortName = shortName;
                        $.nameOnCheck = nameOnCheck;
                        $.companyName = companyName;
                        $.accNumber = accNumber;
                        $.taxId = taxId;
                        $.track1099 = track1099;
                        $.address1 = address1;
                        $.address2 = address2;
                        $.address3 = address3;
                        $.address4 = address4;
                        $.addressCity = addressCity;
                        $.addressState = addressState;
                        $.addressZip = addressZip;
                        $.addressCountry = addressCountry;
                        $.email = email;
                        $.fax = fax;
                        $.phone = phone;
                        $.paymentEmail = paymentEmail;
                        $.paymentPhone = paymentPhone;
                        $.description = description;
                        $.contactFirstName = contactFirstName;
                        $.contactLastName = contactLastName;
                        $.accountType = accountType;
                    }).build();
            Vendor vendor = Vendor.create(params);
            assertAll(() -> {
                assertEquals(entity, vendor.getEntity());
                assertEquals(isActive, vendor.getIsActive());
                assertEquals(name, vendor.getName());
                assertEquals(shortName, vendor.getShortName());
                assertEquals(nameOnCheck, vendor.getNameOnCheck());
                assertEquals(companyName, vendor.getCompanyName());
                assertEquals(accNumber, vendor.getAccNumber());
                assertEquals(taxId, vendor.getTaxId());
                assertEquals(track1099, vendor.isTrack1099());
                assertEquals(address1, vendor.getAddress1());
                assertEquals(address2, vendor.getAddress2());
                assertEquals(address3, vendor.getAddress3());
                assertEquals(address4, vendor.getAddress4());
                assertEquals(addressCity, vendor.getAddressCity());
                assertEquals(addressState, vendor.getAddressState());
                assertEquals(addressZip, vendor.getAddressZip());
                assertEquals(addressCountry, vendor.getAddressCountry());
                assertEquals(email, vendor.getEmail());
                assertEquals(fax, vendor.getFax());
                assertEquals(phone, vendor.getPhone());
                assertEquals(paymentEmail, vendor.getPaymentEmail());
                assertEquals(paymentPhone, vendor.getPaymentPhone());
                assertEquals(description, vendor.getDescription());
                assertEquals(contactFirstName, vendor.getContactFirstName());
                assertEquals(contactLastName, vendor.getContactLastName());
                assertEquals(accountType, vendor.getAccountType());
            });
        }

        @Condition
        class When_given_bad_input {
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Vendor.create(VendorCreateRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class get {
        @FunctionalTest
        void should_retrieve_the_sepcified_vendor() throws Exception {
            VendorGetRequestParams params = VendorGetRequestParams.builder()
                    .with($ -> {
                        $.id = TestEnv.testVendorId;
                    }).build();
            Vendor vendor = Vendor.get(params);
            assertAll(() -> assertEquals(TestEnv.testVendorId, vendor.getId()));
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Vendor.get(VendorGetRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class update {
        @FunctionalTest
        void should_update_a_vendor_with_given_params() throws Exception {
            VendorUpdateRequestParams params = VendorUpdateRequestParams.builder()
                    .with($ -> {
                        $.id = TestEnv.testVendorId;
                        $.isActive = isActive;
                        $.name = name;
                        $.shortName = shortName;
                        $.nameOnCheck = nameOnCheck;
                        $.companyName = companyName;
                        $.accNumber = accNumber;
                        $.taxId = taxId;
                        $.track1099 = track1099;
                        $.address1 = address1;
                        $.address2 = address2;
                        $.address3 = address3;
                        $.address4 = address4;
                        $.addressCity = addressCity;
                        $.addressState = addressState;
                        $.addressZip = addressZip;
                        $.addressCountry = addressCountry;
                        $.email = email;
                        $.fax = fax;
                        $.phone = phone;
                        $.paymentEmail = paymentEmail;
                        $.paymentPhone = paymentPhone;
                        $.description = description;
                        $.contactFirstName = contactFirstName;
                        $.contactLastName = contactLastName;
                        $.accountType = accountType;
                    }).build();
            Vendor vendor = Vendor.update(params);
            assertAll(() -> {
                assertEquals(TestEnv.testVendorId, vendor.getId());
                assertEquals(entity, vendor.getEntity());
                assertEquals(isActive, vendor.getIsActive());
                assertEquals(name, vendor.getName());
                assertEquals(shortName, vendor.getShortName());
                assertEquals(nameOnCheck, vendor.getNameOnCheck());
                assertEquals(companyName, vendor.getCompanyName());
                assertEquals(accNumber, vendor.getAccNumber());
                assertEquals(taxId, vendor.getTaxId());
                assertEquals(track1099, vendor.isTrack1099());
                assertEquals(address1, vendor.getAddress1());
                assertEquals(address2, vendor.getAddress2());
                assertEquals(address3, vendor.getAddress3());
                assertEquals(address4, vendor.getAddress4());
                assertEquals(addressCity, vendor.getAddressCity());
                assertEquals(addressState, vendor.getAddressState());
                assertEquals(addressZip, vendor.getAddressZip());
                assertEquals(addressCountry, vendor.getAddressCountry());
                assertEquals(email, vendor.getEmail());
                assertEquals(fax, vendor.getFax());
                assertEquals(phone, vendor.getPhone());
                assertEquals(paymentEmail, vendor.getPaymentEmail());
                assertEquals(paymentPhone, vendor.getPaymentPhone());
                assertEquals(description, vendor.getDescription());
                assertEquals(contactFirstName, vendor.getContactFirstName());
                assertEquals(contactLastName, vendor.getContactLastName());
                assertEquals(accountType, vendor.getAccountType());
            });
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    Vendor.update(VendorUpdateRequestParams.builder().build());
                });
            }
        }
    }

    @Interface
    class updateWithApiResource {
        @FunctionalTest
        void should_update_the_given_resource() throws Exception {
            VendorGetRequestParams getRequestParams = VendorGetRequestParams.builder()
                    .with($ -> {
                        $.id = TestEnv.testVendorId;
                    }).build();

            Vendor vendor = Vendor.get(getRequestParams);
            vendor.setIsActive(isActive);
            vendor.setName(name);
            vendor.setShortName(shortName);
            vendor.setNameOnCheck(nameOnCheck);
            vendor.setCompanyName(companyName);
            vendor.setAccNumber(accNumber);
            vendor.setTaxId(taxId);
            vendor.setTrack1099(track1099);
            vendor.setAddress1(address1);
            vendor.setAddress2(address2);
            vendor.setAddress3(address3);
            vendor.setAddress4(address4);
            vendor.setAddressCity(addressCity);
            vendor.setAddressState(addressState);
            vendor.setAddressZip(addressZip);
            vendor.setAddressCountry(addressCountry);
            vendor.setEmail(email);
            vendor.setFax(fax);
            vendor.setPhone(phone);
            vendor.setPaymentEmail(paymentEmail);
            vendor.setPaymentPhone(paymentPhone);
            vendor.setDescription(description);
            vendor.setContactFirstName(contactFirstName);
            vendor.setContactLastName(contactLastName);
            vendor.setAccountType(accountType);

            Vendor updatedVendor = Vendor.update(vendor);

            assertAll(() -> {
                assertEquals(TestEnv.testVendorId, updatedVendor.getId());
                assertEquals(entity, updatedVendor.getEntity());
                assertEquals(isActive, updatedVendor.getIsActive());
                assertEquals(name, updatedVendor.getName());
                assertEquals(shortName, updatedVendor.getShortName());
                assertEquals(nameOnCheck, updatedVendor.getNameOnCheck());
                assertEquals(companyName, updatedVendor.getCompanyName());
                assertEquals(accNumber, updatedVendor.getAccNumber());
                assertEquals(taxId, updatedVendor.getTaxId());
                assertEquals(track1099, updatedVendor.isTrack1099());
                assertEquals(address1, updatedVendor.getAddress1());
                assertEquals(address2, updatedVendor.getAddress2());
                assertEquals(address3, updatedVendor.getAddress3());
                assertEquals(address4, updatedVendor.getAddress4());
                assertEquals(addressCity, updatedVendor.getAddressCity());
                assertEquals(addressState, updatedVendor.getAddressState());
                assertEquals(addressZip, updatedVendor.getAddressZip());
                assertEquals(addressCountry, updatedVendor.getAddressCountry());
                assertEquals(email, updatedVendor.getEmail());
                assertEquals(fax, updatedVendor.getFax());
                assertEquals(phone, updatedVendor.getPhone());
                assertEquals(paymentEmail, updatedVendor.getPaymentEmail());
                assertEquals(paymentPhone, updatedVendor.getPaymentPhone());
                assertEquals(description, updatedVendor.getDescription());
                assertEquals(contactFirstName, updatedVendor.getContactFirstName());
                assertEquals(contactLastName, updatedVendor.getContactLastName());
                assertEquals(accountType, updatedVendor.getAccountType());
            });
        }
    }
}