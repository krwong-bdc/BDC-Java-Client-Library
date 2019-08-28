package com.bill.java.api.net;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import org.junit.jupiter.api.DisplayName;
import resources.BDDTests;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("@ApiResource")
class ApiResourceTest extends BDDTests {
    @Interface
    class convertToList {
        private class MockClass {
            @SerializedName("name")
            private String surname;

            public String getSurname() {
                return surname;
            }
        }

        @FunctionalTest
        void should_convert_response_data_to_list() throws Exception {
            HttpResponse mHttpResponse = mock(HttpResponse.class);
            JsonObject mObj1 = new JsonObject();
            mObj1.addProperty("name", "John");
            JsonObject mObj2 = new JsonObject();
            mObj2.addProperty("name", "Jane");
            JsonArray mArray = new JsonArray();
            mArray.add(mObj1);
            mArray.add(mObj2);

            when(mHttpResponse.getJsonDataList()).thenReturn(mArray);

            List<MockClass> mList = ApiResource.convertToList(mHttpResponse, MockClass.class);
            assertAll(
                    () -> assertEquals(mList.size(), 2),
                    () -> assertEquals(mList.get(0).getSurname(), "John"),
                    () -> assertEquals(mList.get(1).getSurname(), "Jane")
            );
        }
    }
}