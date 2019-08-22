package com.bill.java.api.net;

import com.bill.java.api.BDC;
import com.bill.java.api.models.Session;
import com.bill.java.api.param.ApiResourceParams;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import resources.BDDTests;
import resources.TestEnv;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class BDCHttpClientTest extends BDDTests {

    @Interface
    class execute {
//        Should look up how people test methods involving Http requests. Maybe point it to a local server?
        @FunctionalTest
        void should_make_a_POST_request_with_given_arguments() throws Exception {
            HttpResponse response = new BDCHttpClient()
                    .execute(
                            BDC.SANDBOX_BASE + "/Login.json",
                            "",
                            String.format(
                                    "userName=%s&password=%s&orgId=%s&devKey=%s",
                                    URLEncoder.encode(TestEnv.userName, StandardCharsets.UTF_8.toString()),
                                    TestEnv.password,
                                    TestEnv.orgId,
                                    TestEnv.devKey));
            JsonObject obj = response.getJsonData();
            Gson GSON = new Gson();
            Session session = GSON.fromJson(obj, Session.class);
            assertAll(
                    () -> assertTrue(session.getSessionId().length() > 0),
                    () -> assertEquals(session.getOrgId(), TestEnv.orgId),
                    () -> assertEquals(session.getApiEndPoint(), BDC.getApiBase()),
                    () -> assertEquals(session.getUserId(), TestEnv.userId)
            );
        }
    }
}