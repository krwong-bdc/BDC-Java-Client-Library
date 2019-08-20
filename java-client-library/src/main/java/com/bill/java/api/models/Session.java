package com.bill.java.api.models;

import com.bill.java.api.BDC;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.ApiResourceParams;
import com.bill.java.api.param.AuthenticationParams;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.List;


/**
 * The Session class represents a user's session credentials
 *
 * @author      Keith Wong <krwong@hq.bill.com>
 * @since       0.0.1
 */
public class Session extends ApiResource {
    public static final String LOGIN_URL = "/Login.json";
    public static final String LOGOUT_URL = "/Logout.json";
    public static final String GET_SESSION_INFO_URL = "/GetSessionInfo.json";
    public static final String LIST_ORGS_URL = "/ListOrgs.json";
    public static final String MFA_CHALLENGE_URL = "/MFAChallenge.json";
    public static final String MFA_AUTHENTICATE_URL = "/MFAAuthenticate.json";

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("orgId")
    private String orgId;

    @SerializedName("apiEndPoint")
    private String apiEndPoint;

    @SerializedName("usersId")
    private String usersId;


    public static Session login(String orgId) throws Exception {
        AuthenticationParams authParams = new AuthenticationParams();
        authParams.setParam("userName", BDC.userName);
        authParams.setParam("password", BDC.password);
        authParams.setParam("orgId", orgId);

        Session session = create(LOGIN_URL, authParams, Session.class);

        BDC.sessionId = session.getSessionId();
        BDC.orgId = session.getOrgId();
        BDC.usersId = session.getUsersId();
//        return BDC.getSession();
        return session;
    }

//    TODO
    public static List<OrgInfo> ListOrgs() throws Exception {
        AuthenticationParams authParams = new AuthenticationParams();
        authParams.setParam("userName", BDC.userName);
        authParams.setParam("password", BDC.password);
        return createCollection(LIST_ORGS_URL, authParams, OrgInfo.class);
    }

    /**
     * Logs the user out of the current session
     *
     * @return True unless an unsuccessful response was received
     * @throws IOException
     * @throws com.bill.java.api.exception.BDCException
     */
    public static Boolean logout() throws Exception {
        httpClient.request(LOGOUT_URL).getJsonData();
        BDC.sessionId = null;
        return true;
    }

    /**
     * Returns the current ids of the user and organization associated with the session
     *
     * @return
     * @throws Exception
     * @throws com.bill.java.api.exception.BDCException when session invalid
     */
    public static SessionInfo getSessionInfo() throws Exception {
        // Must override toFormURLEncodedString, because endpoint requires it not to be nested in data={}
        return create(GET_SESSION_INFO_URL, SessionInfo.class);
    }

    public static MFAChallenge requestMFAChallenge(Boolean useBackup) throws Exception {
        MFAChallengeRequestParams params = new MFAChallengeRequestParams(useBackup);
        return create(MFA_CHALLENGE_URL, params, MFAChallenge.class);
    }

    public static MFA MFAAuthenticate(String challengeId,
                                      String token,
                                      String deviceId,
                                      String machineName,
                                      Boolean rememberMe) throws Exception {
        MFAAuthenticationRequestParams params =
                new MFAAuthenticationRequestParams(challengeId, token, deviceId, machineName, rememberMe);
        return create(MFA_AUTHENTICATE_URL, params, MFA.class);
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getOrgId() {
        return orgId;
    }

    public String getApiEndPoint() {
        return apiEndPoint;
    }

    public String getUsersId() {
        return usersId;
    }

    private static class MFAChallengeRequestParams extends ApiResourceParams {
        @SerializedName("useBackup")
        public Boolean useBackup;

        public MFAChallengeRequestParams(Boolean useBackup) {
            this.useBackup = useBackup;
        }
    }

    private static class MFAAuthenticationRequestParams extends ApiResourceParams {
        @SerializedName("challengeId")
        public String challengeId;

        @SerializedName("token")
        public String token;

        @SerializedName("deviceId")
        public String deviceId;

        @SerializedName("machineName")
        public String machineName;

        @SerializedName("rememberMe")
        public Boolean rememberMe;

        public MFAAuthenticationRequestParams(String challengeId, String token, String deviceId, String machineName, Boolean rememberMe) {
            this.challengeId = challengeId;
            this.token = token;
            this.deviceId = deviceId;
            this.machineName = machineName;
            this.rememberMe = rememberMe;

        }
    }
}
