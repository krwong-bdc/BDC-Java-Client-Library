package com.bill.java.api.models;

import com.bill.java.api.param.ListRequestParams;
import com.bill.java.api.param.SentPayGetRequestParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.BDDTests;
import resources.TestEnv;

import static org.junit.jupiter.api.Assertions.*;

class SentPayTest extends BDDTests {
    @BeforeEach
    void setup() throws Exception {
        login();
    }

    @Interface
    class get {
        @FunctionalTest
        void should_get_the_specified_obj() throws Exception {


            SentPayGetRequestParams params = SentPayGetRequestParams.builder()
                    .with($ -> {
                        $.id = TestEnv.testSentPayId;
                    }).build();
            SentPay sentPay = SentPay.get(params);

            assertEquals(TestEnv.testSentPayId, sentPay.getId());
        }
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
                SentPay.list(params);
            });
        }
    }
}