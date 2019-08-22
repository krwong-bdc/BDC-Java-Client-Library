package com.bill.java.api.models;

import com.bill.java.api.BDC;
import com.bill.java.api.exception.BDCException;
import com.bill.java.api.param.MFAChallengeRequestParams;
import com.bill.java.api.param.MFAStatusRequestParams;
import org.junit.jupiter.api.DisplayName;
import resources.BDDTests;
import org.junit.jupiter.api.BeforeEach;
import resources.TestEnv;


import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("@Session")
class SessionTest extends BDDTests {
    @BeforeEach
    void setup() {
        BDC.userName = TestEnv.userName;
        BDC.password = TestEnv.password;
        BDC.devKey = TestEnv.devKey;
    }

    @Condition
    class When_credentials_are_properly_set_on_BDC {
        @Interface
        class login {

            @Condition
            class and_orgId_is_valid {
                @DisabledTest
                void should_create_a_session_object() {}

                @DisabledTest
                void should_set_credentials_on_BDC_class() {}

                @FunctionalTest
                void should_log_in_the_user() throws IOException {
                    try {
                        Session session = Session.login(TestEnv.orgId);
                        assertEquals(BDC.sessionId, session.getSessionId());
                        assertEquals(BDC.userId, session.getUserId());
                        assertEquals(session.getOrgId(), TestEnv.orgId);
                    } catch (BDCException e) {
                        fail();
                    }
                }

            }

            @Condition
            class and_org_id_is_invalid {
                @FunctionalTest
                void should_throw_a_BDCException() {
                    assertThrows(BDCException.class, () -> Session.login("nope"));
                }
            }

            @Condition
            class and_mfaId_and_deviceId_are_set {
                @DisabledFunctionalTest
                void should_enable_access_to_protected_endpoints_without_explicit_authentication() {}
            }
        }

        @Interface
        class listOrgs {
            @DisabledTest
            void should_create_a_collection_of_OrgInfo_objects() {}

            @FunctionalTest
            void should_fetch_a_list_of_orgs_user_belongs_to() {
                try {
                    List<OrgInfo> orgs = Session.ListOrgs();
                    assertEquals(orgs.get(0).getOrgId(), TestEnv.orgId);
                } catch (Exception e ) {
                    fail();
                }
            }
        }

        @Interface
        class logout {
            @FunctionalTest
            void should_clear_credentials() throws Exception {
                Session.login(TestEnv.orgId);
                assertTrue(BDC.sessionId.length() > 1);
                Session.logout();
                assertNull(BDC.sessionId);
            }

            @DisabledTest
            void should_request_logout() throws Exception {
//                BDCHttpClient mClient = mock(BDCHttpClient.class);
//                HttpResponse mResponse = mock(HttpResponse.class);
//                Session.httpClient = mClient;
//                ApiResource.httpClient = mClient;
//
//                when(mClient.request(Session.LOGOUT_URL)).thenReturn(mResponse);
//                verify(mClient).request(Session.LOGOUT_URL);
//                assertNull(BDC.sessionId);
            }

        }

        @Interface
        class getSessionInfo {
            @DisabledTest
            void should_create_a_SessionInfo_object() {}

            @FunctionalTest
            void should_return_users_session_info() throws Exception {
                Session session = Session.login(TestEnv.orgId);
                String orgId = session.getOrgId();
                String userId = session.getUserId();
                SessionInfo info = Session.getSessionInfo();
                assertAll(
                        () -> assertEquals(info.getOrganizationId(), orgId),
                        () -> assertEquals(info.getUserId(), userId)
                );
            }
        }

        @Interface
        class requestMFAChallenge {
            @DisabledTest
            void should_call_create_with_given_params() {}

            @FunctionalTest
            void should_return_the_challenge_id() throws Exception {
                Session session = Session.login(TestEnv.orgId);
                assertTrue(Session.requestMFAChallenge(MFAChallengeRequestParams.builder()
                        .with($ -> {
                            $.useBackup = true;
                        }).build()).getId().length() > 1);
            }
        }

        @Interface
        class MFAAuthenticate {
            @DisabledTest
            void should_call_create_with_given_params() {}
        }

        @Interface
        class getMFAStatus {
            @DisabledTest
            void should_call_create_with_given_parms() {}

            @FunctionalTest
            void should_return_an_MFA_object() throws Exception {
                Session.login(TestEnv.orgId);
                MFAStatus obj = Session.getMFAStatus(MFAStatusRequestParams.builder()
                        .with($ -> {
                            $.deviceId = TestEnv.deviceId;
                            $.mfaId = "!b3UAgDbfvmjxBoYyYNRzflSyEcr2dFzV_QTTpYNtN0ZIE0NV61YftWjE8on5WrmBe";
                        }).build());
                assertFalse(obj.getStatus());
            }
        }

        @Interface
        class getSessionId {

        }

        @Interface
        class getOrgId {

        }

        @Interface
        class getApiEndPoint {

        }

        @Interface
        class getUsersId {

        }
    }

    @Condition
    class When_username_is_invalid {
        @BeforeEach
        void setup() {
            BDC.userName = "";
        }

        @Interface
        class login {
            @FunctionalTest
            void should_throw_a_BDCException() {
                assertThrows(BDCException.class, () -> Session.login(TestEnv.orgId));
            }
        }
        @Interface
        class listOrgs {

        }

        @Interface
        class logout {

        }

        @Interface
        class getSessionInfo {

        }

        @Interface
        class requestMFAChallenge {

        }

        @Interface
        class MFAAuthenticate {

        }

        @Interface
        class getMFAStatus {

        }

        @Interface
        class getSessionId {

        }

        @Interface
        class getOrgId {

        }

        @Interface
        class getApiEndPoint {

        }

        @Interface
        class getUsersId {

        }
    }

    @Condition
    class When_password_is_invalid {
        @BeforeEach
        void setup() {
            BDC.password = "";
        }
        @Interface
        class login {
            @FunctionalTest
            void should_throw_a_BDCException() {
                assertThrows(BDCException.class, () -> Session.login(TestEnv.orgId));
            }
        }
        @Interface
        class listOrgs {

        }

        @Interface
        class logout {

        }

        @Interface
        class getSessionInfo {

        }

        @Interface
        class requestMFAChallenge {

        }

        @Interface
        class MFAAuthenticate {

        }

        @Interface
        class getMFAStatus {

        }

        @Interface
        class getSessionId {

        }

        @Interface
        class getOrgId {

        }

        @Interface
        class getApiEndPoint {

        }

        @Interface
        class getUsersId {

        }
    }

    @Condition
    class When_devKey_is_invalid {
        @BeforeEach
        void setup() {
            BDC.devKey = "";
        }
        @Interface
        class login {
            @FunctionalTest
            void should_throw_a_BDCException() {
                assertThrows(BDCException.class, () -> Session.login(TestEnv.orgId));
            }
        }
        @Interface
        class listOrgs {

        }

        @Interface
        class logout {

        }

        @Interface
        class getSessionInfo {

        }

        @Interface
        class requestMFAChallenge {

        }

        @Interface
        class MFAAuthenticate {

        }

        @Interface
        class getMFAStatus {

        }

        @Interface
        class getSessionId {

        }

        @Interface
        class getOrgId {

        }

        @Interface
        class getApiEndPoint {

        }

        @Interface
        class getUsersId {

        }
    }

}