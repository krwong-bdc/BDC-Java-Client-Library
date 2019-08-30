package com.bill.java.api.models;

import com.bill.java.api.BDC;
import com.bill.java.api.param.CustomerCreateRequestParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.BDDTests;
import resources.TestEnv;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest extends BDDTests {
    @BeforeEach
    void setup() {
        BDC.userName = TestEnv.userName;
        BDC.password = TestEnv.password;
        BDC.devKey = TestEnv.devKey;
    }

    @Test
    void create() throws Exception {
        Session.login(TestEnv.orgId);
        Customer customer = Customer.create(CustomerCreateRequestParams.builder()
                .with($ -> {
                    $.name = "Charles";
                }).build());
        System.out.println(customer.getName());
    }

    @Test
    void get() {
    }

    @Test
    void update() {
    }

    @Test
    void update1() {
    }

    @Test
    void setAuthorization() {
    }
}