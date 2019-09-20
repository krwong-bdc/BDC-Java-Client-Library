package com.bill.java.api.models;

import com.bill.java.api.BDC;
import com.bill.java.api.exception.BDCException;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.*;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.List;


/**
 * The Session class represents a user's session credentials and includes all methods for user
 * authentication and fetching session information.
 */
public class Session extends ApiResource {
    /** the resource endpoint to login to the system */
    public static final String LOGIN_URL = "/Login.json";
    /** the resource endpoint to log out of the system */
    public static final String LOGOUT_URL = "/Logout.json";
    /** the resource endpoint to get the session information */
    public static final String GET_SESSION_INFO_URL = "/GetSessionInfo.json";
    /** the resource endpoint to get the list of organizations that the current user has permission to access */
    public static final String LIST_ORGS_URL = "/ListOrgs.json";
    /** the resource endpoint to generate thechallenge ID, and sends a token to the user’s registered mobile device*/
    public static final String MFA_CHALLENGE_URL = "/MFAChallenge.json";
    /** the resource endpoint to validates the challenge ID, token that was sent to the users mobile device, device ID, and
    * the name that was given to the machine at the time of generating the challenge ID
    */
    public static final String MFA_AUTHENTICATE_URL = "/MFAAuthenticate.json";
    /** the resource endpoint to check the Multi Factor Authentication (MFA) session status of the current user */
    public static final String MFA_STATUS_URL = "/MFAStatus.json";

    /** the current session ID */
    @SerializedName("sessionId")
    private String sessionId;

    /** the system generated ID of the organization that the user has logged into */
    @SerializedName("orgId")
    private String orgId;

    /** the current environment the session belongs to */
    @SerializedName("apiEndPoint")
    private String apiEndPoint;

    /** the system generated ID of the user who is logged into the system */
    @SerializedName("usersId")
    private String userId;

    /**
     * Validates the user credentials for a user to log in to the system. Upon success, the user is able to log in and the session information is stored for future API usage.
     * If the response from the request is unsuccessful, the BDCException is thrown and if an I/O exception occurs,
     * the IOException is thrown.
     * <p> For information on calling the method and to check out a sample request and response, see
     * <a href="https://developer.bill.com/hc/en-us/articles/208197226-Login" target="_blank">Login</a>.</p>
     *
     * @param   sessionLoginRequestParams   parameters required to make the request. For more information, see
                                            {@link SessionLoginRequestParams SessionLoginRequestParams}.
     * @return                              a Session object containing the response values from the API
     * @throws  BDCException                is thrown when the response from the API is unsuccessful
     * @throws  IOException                 is thrown when an I/O exception occurs on the underlying request
     */
    public static Session login(SessionLoginRequestParams sessionLoginRequestParams) throws BDCException, IOException {
        /** Handles passing in the credentials instead of the user */
        AuthenticationParams authParams = AuthenticationParams.builder()
                .with($ -> {
                    $.orgId = sessionLoginRequestParams.getOrgId();
                    $.mfaId = sessionLoginRequestParams.getMfaId();
                    $.deviceId = sessionLoginRequestParams.getDeviceId();
                }).build();

        Session session = create(LOGIN_URL, authParams, Session.class);

        /** Sets the returned credentials onto the BDC class for further API calls */
        BDC.sessionId = session.getSessionId();
        BDC.orgId = session.getOrgId();
        BDC.userId = session.getUserId();

        return session;
    }

    /**
     * Lists the organizations that the current user has permission to access.
     * <p> For information on calling the method and to check out a sample request and response, see
     * <a href="https://developer.bill.com/hc/en-us/articles/211163843-ListOrgs" target="_blank">List Organizations</a>.
     *
     * @return              an {@link OrgInfo} object which lists the ID and name of the organizations the user has access to login to.
     * @throws BDCException is thrown when the response from the API is unsuccessful
     * @throws IOException  is thrown when an I/O exception occurs on the underlying request
     * @see                 OrgInfo
     */
    public static List<OrgInfo> ListOrgs() throws BDCException, IOException {
        /* Handles passing in the credentials instead of the user */
        AuthenticationParams authParams = AuthenticationParams.builder()
                .build();

        return createCollection(LIST_ORGS_URL, authParams, OrgInfo.class);
    }

    /**
     * Logs out the user that is currently signed in. Upon success, deletes the session information that was stored.
     * If the response from the request is unsuccessful, the BDCException is thrown and if an I/O exception occurs,
     * the IOException is thrown.
     *
     * <p> For information on calling the method and to check out a sample request and response, see
     * <a href="https://developer.bill.com/hc/en-us/articles/215407283-Logout" target="_blank">Logout</a>.
     *
     * @return                true if the user successfully logged out
     * @throws  BDCException  is thrown when the response from the API is unsuccessful
     * @throws  IOException   is thrown when an I/O exception occurs on the underlying request
     */
    public static Boolean logout() throws BDCException, IOException {
        httpClient.request(LOGOUT_URL).getJsonData();
        BDC.sessionId = null;
        return true;
    }

    /**
     * Gets the organization ID and user ID of the user that is currently logged in.
     *
     * <p> For information on calling the method and to check out a sample request and response, see
     * <a href="https://developer.bill.com/hc/en-us/articles/213911126-GetSessionInfo" target="_blank">Get Session Information</a>.
     *
     * @return                the {@link SessionInfo} object which includes the organization ID and user ID
     * @throws  BDCException  is thrown when the response from the API is unsuccessful
     * @throws  IOException   is thrown when an I/O exception occurs on the underlying request
     */
    public static SessionInfo getSessionInfo() throws BDCException, IOException {
        return create(GET_SESSION_INFO_URL, SessionInfo.class);
    }

    /**
     * Generates and returns a challenge ID, and sends a token to the user’s registered mobile device in order to
     * Multi Factor Authenticate (MFA) the user. The session needs to be MFA trusted to call the methods that pay bills, send network invitations,
     * send vendor invitations, and manage vendor bank accounts.
     *
     * <p> For information on calling the method and to check out a sample request and response, see
     * <a href="https://developer.bill.com/hc/en-us/articles/115000169503-MFAChallenge" target="_blank">Create MFA Challenge ID</a>.</p>
     *
     * @param   mfaChallengeRequestparams   the {@link MFAChallengeRequestParams}, which contains an argument to determine whether
     *                                      the token needs to be sent to the primary mobile device [value = false] or back up mobile device [value = true]
     * @return                              an {@link MFAChallenge} object which includes a challenge ID
     * @throws BDCException                 is thrown when the response from the API is unsuccessful
     * @throws IOException                  is thrown when an I/O exception occurs on the underlying request
     * @see                                 <a href="https://developer.bill.com/hc/en-us/articles/212471546" target="_blank">MFA Workflow</a>
     */
    public static MFAChallenge requestMFAChallenge(MFAChallengeRequestParams mfaChallengeRequestparams) throws BDCException, IOException {
        return create(MFA_CHALLENGE_URL, mfaChallengeRequestparams, MFAChallenge.class);
    }

    /**
     * Multi Factor Authentication (MFA) is used to validate the token sent to the user’s mobile device via the mfaChallenge method.
     * This method validates the challenge ID, token that was sent to the users mobile device, device ID, and the name that was given
     * to the machine at the time of generating the challenge ID. Upon success, the user’s session is marked as a trusted.
     * If the rememberMe parameter is set to true, the trusted session expires in 30 days. Else, it expires when the user logs out.
     *
     * <p> For information on calling the method and to check out a sample request and response, see
     * <a href="https://developer.bill.com/hc/en-us/articles/115000169443-MFAAuthenticate" target="_blank">Multi Factor Authentication</a>.</p>
     *
     * @param   mfaAuthenticationRequestParams  the {@link MFAAuthenticateRequestParams}, which contains the MFA challenge ID, the token that was sent to the user's mobile device,
                                                the device ID defined by the user to identify the MFA device, the machine name defined by the user to describe the MFA device,
                                                and the rememberMe argument, which determines if the MFA ID needs to be trusted after the session is over.
     * @return                                  an {@link MFA} object which includes an MFA ID
     * @throws  BDCException                    is thrown when the response from the API is unsuccessful
     * @throws  IOException                     is thrown when an I/O exception occurs on the underlying request
     * @see                                     <a href="https://developer.bill.com/hc/en-us/articles/212471546" target="_blank">MFA Workflow</a>
     */
    public static MFA MFAAuthenticate(MFAAuthenticateRequestParams mfaAuthenticationRequestParams) throws BDCException, IOException {
        return create(MFA_AUTHENTICATE_URL, mfaAuthenticationRequestParams, MFA.class);
    }

    /**
     * Checks the Multi Factor Authentication (MFA) session status of the current user.
     *
     * <p> For information on calling the method and to check out a sample request and response, see
     * <a href="https://developer.bill.com/hc/en-us/articles/115000169463-MFAStatus" target="_blank">MFA Status</a>.</p>
     *
     * @param   mfaStatusRequestParams  the {@link MFAStatusRequestParams}, which contains the MFA ID that is returned after successfully calling the MFAAuthenticate method, and
                                        the device ID defined by the user to identify the MFA device
     * @return                          an {@link MFAStatus} object which includes the isTrusted boolean field describing if the session trusted or not
     * @throws  BDCException            is thrown when the response from the API is unsuccessful
     * @throws  IOException             is thrown when an I/O exception occurs on the underlying request
     * @see                             <a href="https://developer.bill.com/hc/en-us/articles/212471546" target="_blank">MFA Workflow</a>
     */
    public static MFAStatus getMFAStatus(MFAStatusRequestParams mfaStatusRequestParams) throws BDCException, IOException {
        return create(MFA_STATUS_URL, mfaStatusRequestParams, MFAStatus.class);
    }

    /**
    * Gets the session ID.
    *
    * @return  the current session ID
    */
    public String getSessionId() {
        return sessionId;
    }

    /**
    * Gets the organization ID.
    *
    * @return  the system generated ID of the organization that the user has logged into
    */
    public String getOrgId() {
        return orgId;
    }

    /**
    * The method which gets the the current environment the session belongs to.
    *
    * @return  the current environment the session belongs to
    */
    public String getApiEndPoint() {
        return apiEndPoint;
    }

    /**
    * The method which gets the ID of the user.
    *
    * @return  the ID of the user who is currently logged into the system
    */
    public String getUserId() {
        return userId;
    }
}
