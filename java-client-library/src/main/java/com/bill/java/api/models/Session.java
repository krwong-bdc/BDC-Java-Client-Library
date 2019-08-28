package com.bill.java.api.models;

import com.bill.java.api.BDC;
import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.*;
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
    private String userId;

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
        AuthenticationParams authParams = AuthenticationParams.builder()
                .withOrgId(orgId)
                .build();

        Session session = create(LOGIN_URL, authParams, Session.class);

        /** Sets the returned credentials onto the BDC class for further API calls */
        BDC.sessionId = session.getSessionId();
        BDC.orgId = session.getOrgId();
        BDC.userId = session.getUserId();

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
        AuthenticationParams authParams = AuthenticationParams.builder()
                .build();

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
     * Initiates the MFA flow and returns the challengeId to be used on subsequent call to {@link #MFAAuthenticate(MFAAuthenticateRequestParams)}
     *
     * @param mfaChallengeRequestparams {@link MFAChallengeRequestParams}
     * @return instance of MFAChallenge with values set from the Http response
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     * @see <a href="https://developer.bill.com/hc/en-us/articles/212471546">MFA Workflow</a>
     */
    public static MFAChallenge requestMFAChallenge(MFAChallengeRequestParams mfaChallengeRequestparams) throws BDCException, IOException {
        return create(MFA_CHALLENGE_URL, mfaChallengeRequestparams, MFAChallenge.class);
    }

    /**
     * Multi-factor authenticates the session, allowing for calls to MFA protected endpoints
     *
     * @param mfaAuthenticationRequestParams {@link MFAAuthenticateRequestParams}
     * @return instance of MFA with values set from the Http response
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     * @see <a href="https://developer.bill.com/hc/en-us/articles/212471546">MFA Workflow</a>
     */
    public static MFA MFAAuthenticate(MFAAuthenticateRequestParams mfaAuthenticationRequestParams) throws BDCException, IOException {
        return create(MFA_AUTHENTICATE_URL, mfaAuthenticationRequestParams, MFA.class);
    }

    /**
     * Queries the validity of the specified mfaId
     *
     * @param mfaStatusRequestParams {@link MFAStatusRequestParams}
     * @return instance of MFAStatus with values set from the Http response
     * @throws BDCException when the response from the API is unsuccessful
     * @throws IOException when an I/O exception occurs on the underlying request
     * @see <a href="https://developer.bill.com/hc/en-us/articles/212471546">MFA Workflow</a>
     */
    public static MFAStatus getMFAStatus(MFAStatusRequestParams mfaStatusRequestParams) throws BDCException, IOException {
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

    public String getUserId() {
        return userId;
    }
}
