package com.bill.java.api.dependencies;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import resources.BDDTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GsonTest extends BDDTests{
    @Condition
    class When_given_a_non_nested_JSON_object {

        @Test
        void should_map_primitives_to_given_serialized_names() {
            Gson GSON = new Gson();
            JsonObject responseData = new JsonObject();
            responseData.addProperty("name", "Keith");
            responseData.addProperty("amHuman", true);
            responseData.addProperty("amDoge", false);
            responseData.addProperty("wallet", 100);
            responseData.addProperty("gpa", 4.0);

            ExampleResource ex = GSON.fromJson(responseData, ExampleResource.class);

            assertAll(
                    () -> assertEquals(ex.getMyName(), "Keith"),
                    () -> assertEquals(ex.getGpa(), 4.0),
                    () -> assertEquals(ex.getMoney(), 100),
                    () -> assertTrue(ex.amHuman()),
                    () -> assertFalse(ex.amDoge())

            );
        }

//        @Test
//        void should_map_lists_of_objects_to_a_given_class() {
//            Gson GSON = new Gson();
//            JsonObject responseData = new JsonObject();
//        }
//
//        @Test
//        void should_assign_nested_objects_to_appropriate_class() {
//            Gson GSON = new Gson();
//            JsonObject responseData = new JsonObject();
//        }
    }

    private class ExampleResource {
        @SerializedName("name")
        private String myName;

        @SerializedName("amHuman")
        private Boolean human;

        @SerializedName("amDoge")
        private Boolean doge;

        @SerializedName("wallet")
        private int money;

        @SerializedName("gpa")
        private double gpa;

        public String getMyName() {
            return myName;
        }

        public Boolean amHuman() {
            return human;
        }

        public int getMoney() {
            return money;
        }

        public double getGpa() {
            return gpa;
        }

        public Boolean amDoge() {
            return doge;
        }
    }
}
