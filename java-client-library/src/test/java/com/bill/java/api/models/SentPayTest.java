package com.bill.java.api.models;

import com.bill.java.api.param.SentPayGetRequestParams;
import org.junit.jupiter.api.Test;
import resources.BDDTests;
import resources.TestEnv;

import static org.junit.jupiter.api.Assertions.*;

class SentPayTest extends BDDTests {
    @Interface
    class get {
        @FunctionalTest
        void should_get_the_specified_obj() throws Exception {
            login();

            SentPayGetRequestParams params = SentPayGetRequestParams.builder()
                    .with($ -> {
                        $.id = TestEnv.testSentPayId;
                    }).build();
            SentPay sentPay = SentPay.get(params);

            assertEquals(TestEnv.testSentPayId, sentPay.getId());
        }
    }
}