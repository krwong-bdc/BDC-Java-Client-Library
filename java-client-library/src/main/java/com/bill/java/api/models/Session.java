package com.bill.java.api.models;

import com.bill.java.api.BDC;
import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.ApiResourceParams;
import com.bill.java.api.param.AuthenticationParams;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.List;


/**
 * The Session class represents a user's session credentials and includes all methods for Authentication
 *
 * @author      Keith Wong <krwong@hq.bill.com>
 * @since       0.0.1
 */
public class Session extends ApiResource {
    /** Resource Endpoints for everything Authentication related */
    public static final String LOGIN_URL = "/Login.json";
    public static final String LOGOUT_URL = "/Logout.json";
    public static final String GET_SESSION_INFO_URL = "/GetSessionInfo.json";
    public static final String LIST_ORGS_URL = "/ListOrgs.json";
    public static final String MFA_CHALLENGE_URL = "/MFAChallenge.json";
    public static final String MFA_AUTHENTICATE_URL = "/MFAAuthenticate.json";
    public static final String MFA_STATUS_URL = "/MFAStatus.json";

    /** The id of the current session */
    @SerializedName("sessionId")
    private String sessionId;

    /** The id of the organization currently associated with the session */
    @SerializedName("orgId")
    private String orgId;

    /** The current environment the session belongs to */
    @SerializedName("apiEndPoint")
    private String apiEndPoint;

    /** The id of the user currently associated with the session */
    @SerializedName("usersId")
    private String usersId;

    /**
     * Logs in and creates a session for further API usage
     *
     * @param orgId id of the organization to be associated with the session, user must be associated with the organization
     * @return a Session object containing the response values from the API
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static Session login(String orgId) throws BDCException, IOException {
        /** Handles passing in the credentials instead of the user */
        AuthenticationParams authParams = new AuthenticationParams();
        authParams.setParam("userName", BDC.userName);
        authParams.setParam("password", BDC.password);
        authParams.setParam("orgId", orgId);

        Session session = create(LOGIN_URL, authParams, Session.class);

        /** Sets the returned credentials onto the BDC class for further API calls */
        BDC.sessionId = session.getSessionId();
        BDC.orgId = session.getOrgId();
        BDC.usersId = session.getUsersId();

        return session;
    }

    /**
     * Fetches the list of orgs associated with the user's credentials
     *
     * @return list of OrgInfo objects
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     * @see OrgInfo
     */
    public static List<OrgInfo> ListOrgs() throws BDCException, IOException {
        /** Handles passing in the credentials instead of the user */
        AuthenticationParams authParams = new AuthenticationParams();
        authParams.setParam("userName", BDC.userName);
        authParams.setParam("password", BDC.password);

        return createCollection(LIST_ORGS_URL, authParams, OrgInfo.class);
    }

    /**
     * Logs the user out of the current session
     *
     * @return true if user successfully logged out
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static Boolean logout() throws BDCException, IOException {
        httpClient.request(LOGOUT_URL).getJsonData();
        BDC.sessionId = null;
        return true;
    }

    /**
     * Returns the current ids of the user and organization associated with the session
     *
     * @return instance of SessionInfo with values set from the Http response
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static SessionInfo getSessionInfo() throws BDCException, IOException {
        return create(GET_SESSION_INFO_URL, SessionInfo.class);
    }

    /**
     * Initiates the MFA flow and returns the challengeId to be used on subsequent call to {@link #MFAAuthenticate(String, String, String, String, Boolean)}
     *
     * @param useBackup if set to true, authentication text will be sent to the user's backup phone
     * @return instance of MFAChallenge with values set from the Http response
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     * @see <a href="https://developer.bill.com/hc/en-us/articles/212471546">MFA Workflow</a>
     */
    public static MFAChallenge requestMFAChallenge(Boolean useBackup) throws BDCException, IOException {
        MFAChallengeRequestParams params = new MFAChallengeRequestParams(useBackup);
        return create(MFA_CHALLENGE_URL, params, MFAChallenge.class);
    }

    /**
     * Multi-factor authenticates the session, allowing for calls to MFA protected endpoints
     *
     * @param challengeId obtained from {@link #requestMFAChallenge(Boolean)}
     * @param token token sent to users phone after call to {@link #requestMFAChallenge(Boolean)}
     * @param deviceId string representation of the users device. Arbitrary value, but must be consistent in all call associated with the returned mfaId
     * @param machineName string representation of the users device. Arbitrary value
     * @param rememberMe if set to true, sessions will be MFA-authenticated for the next 30 days
     * @return instance of MFA with values set from the Http response
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     * @see <a href="https://developer.bill.com/hc/en-us/articles/212471546">MFA Workflow</a>
     */
    public static MFA MFAAuthenticate(String challengeId,
                                      String token,
                                      String deviceId,
                                      String machineName,
                                      Boolean rememberMe) throws BDCException, IOException {
        MFAAuthenticationRequestParams params =
                new MFAAuthenticationRequestParams(challengeId, token, deviceId, machineName, rememberMe);
        return create(MFA_AUTHENTICATE_URL, params, MFA.class);
    }

    /**
     * Queries the validity of the specified mfaId
     *
     * @param mfaId id of the session being verified
     * @param deviceId device associated with the mfaId
     * @return instance of MFAStatus with values set from the Http response
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     * @see <a href="https://developer.bill.com/hc/en-us/articles/212471546">MFA Workflow</a>
     */
    public static MFAStatus getMFAStatus(String mfaId, String deviceId) throws BDCException, IOException {
        MFAStatusRequestParams mfaStatusRequestParams = new MFAStatusRequestParams(mfaId, deviceId);
        return create(MFA_STATUS_URL, mfaStatusRequestParams, MFAStatus.class);
    }

    /** Getter methods for Session member variables */
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

    /**
     * Wrapper around data required for the MFAChallenge endpoint
     *
     * TODO: may require user to make instance to keep consistent with rest of library usage
     */
    private static class MFAChallengeRequestParams extends ApiResourceParams {
        /** Specifies whether the MFA token will be sent to the primary/backup phone of the user */
        @SerializedName("useBackup")
        public Boolean useBackup;

        public MFAChallengeRequestParams(Boolean useBackup) {
            this.useBackup = useBackup;
        }
    }

    /**
     * Wrapper around data required for the MFAChallenge endpoint
     *
     * TODO: may require user to make instance to keep consistent with rest of library usage
     */
    private static class MFAAuthenticationRequestParams extends ApiResourceParams {
        /** Id acquired from the preceding call to {@link #requestMFAChallenge(Boolean)} */
        @SerializedName("challengeId")
        public String challengeId;

        /** Token acquired from the users phone as a result of the preceding call to {@link #requestMFAChallenge(Boolean)} */
        @SerializedName("token")
        public String token;

        /** String representation of the users device associated with the MFA challenge. Arbitrary value, but must stay consistent once MFA-authenticated */
        @SerializedName("deviceId")
        public String deviceId;

        /** The machine asoociated with the deviceId. Arbitrary value */
        @SerializedName("machineName")
        public String machineName;

        /** If set to true, MFA-authentication will not be asked for again for 30 days */
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

    /**
     * Wrapper around data required for the MFAStatus endpoint
     *
     * TODO: May require user to make instance to keep consistent with rest of library usage
     */
    private static class MFAStatusRequestParams extends ApiResourceParams {
        /** Id acquired from a previous call to {@link #MFAAuthenticate(String, String, String, String, Boolean)} */
        @SerializedName("mfaId")
        private String mfaId;

        /** Id of device used to make previous call to {@link #MFAAuthenticate(String, String, String, String, Boolean)} */
        @SerializedName("deviceId")
        private String deviceId;

        public MFAStatusRequestParams(String mfaId, String deviceId) {
            this.mfaId = mfaId;
            this.deviceId = deviceId;
        }
    }
}
