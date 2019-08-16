package com.bill.java.api.net;

import interfaces.BDDTests;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("@BDCClient")
class BDCHttpClientTest extends BDDTests {


    @InitialBehaviors
    class On_Start {

        @Condition
        class When_stuff_goes_wrong {

            @Test
            void should_start_with_0() {
                assertTrue(true);
            }

        }
    }

    @Interface
    class request {

        @Condition
        class When_things_go_right {

            @ParameterizedTest
            @ValueSource(strings = {"Hello", "Hi", "Goodbye", "Sayonara"})
            void should_return_an_object(String thing) {
                assertTrue(true);
            }
        }
    }
}