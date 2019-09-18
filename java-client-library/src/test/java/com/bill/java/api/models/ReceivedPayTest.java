package com.bill.java.api.models;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.param.ListRequestParams;
import com.bill.java.api.param.ReceivedPayGetRequestParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.BDDTests;
import resources.TestEnv;

import static org.junit.jupiter.api.Assertions.*;

class ReceivedPayTest extends BDDTests {
    @BeforeEach
    void setup() throws Exception {
        login();
    }

    @Interface
    class list {
        @FunctionalTest
        void should_fetch_a_list() {
            assertDoesNotThrow(() -> {
                ListRequestParams params = ListRequestParams.builder()
                        .with($ -> {
                            $.start = 0;
                            $.max = 10;
                        }).build();
                ReceivedPay.list(params);
            });
        }
    }


    @Interface
    class get{
        @FunctionalTest
        void should_retrieve_the_sepcified_vendor() throws Exception {
            ReceivedPayGetRequestParams params = ReceivedPayGetRequestParams.builder()
                    .with($ -> {
                        $.id = TestEnv.testReceivedPay;
                    }).build();
            ReceivedPay receivePay = ReceivedPay.get(params);
            assertAll(() -> assertEquals(TestEnv.testReceivedPay, receivePay.getId()));
        }

        @Condition
        class When_given_bad_input{
            @FunctionalTest
            void should_throw_BDCException() {
                assertThrows(BDCException.class, () -> {
                    ReceivedPay.get(ReceivedPayGetRequestParams.builder().build());
                });
            }
        }
    }
}