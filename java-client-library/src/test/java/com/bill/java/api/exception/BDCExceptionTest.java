package com.bill.java.api.exception;

import resources.BDDTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("@BDCException")
class BDCExceptionTest extends BDDTests {

    @InitialBehaviors
    class On_instantiation {

        @Test
        void should_set_the_error_code_and_message() {
            BDCException ex = new BDCException("1111", "Example msg");
            assertAll("properties",
                    () -> assertTrue(ex.getErrorCode() == "1111"),
                    () -> assertTrue(ex.getMessage().contains("Example msg")));
        }
    }
}