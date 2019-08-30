package com.bill.java.api.models;

import com.bill.java.api.param.CustomerContactCreateRequestParams;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerContactTest {
    @Test
    void create() throws Exception {
        CustomerContact contact = CustomerContact.create(CustomerContactCreateRequestParams.builder()
                .with($ -> {
                    $.customerId = "";
                }).build());
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
}