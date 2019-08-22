package com.bill.java.api.net;

import resources.BDDTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@DisplayName("@ExampleTest")
class ExampleTest extends BDDTests {

//    @BeforeAll
//    void setup() {
//        BDC mockedBDC = mock(BDC.class);
//    }

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
    class SomeMethod {

        @Condition
        class When_dependency_is_set_to_something {

            @ParameterizedTest
            @ValueSource(strings = {"Hello", "Hi", "Goodbye", "Sayonara"})
            void should_return_an_object(String thing) {
                assertTrue(true);
            }
        }
    }
}