package com.bill.java.api.models;

import com.bill.java.api.BDC;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.ApiResourceParams;
import com.bill.java.api.param.SessionLoginRequestParams;
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

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("orgId")
    private String orgId;

    @SerializedName("apiEndPoint")
    private String apiEndPoint;

    @SerializedName("usersId")
    private String usersId;

//    private String devKey;
//    private String password;
//    private String mfaId;
//    private String deviceId;
//
//    public Session(String devKey, String userName, String password, String sessionId, String mfaId, String deviceId) {
//
//    }

    public static Session login(SessionLoginRequestParams params) throws Exception {
        Session session = create(LOGIN_URL, params, Session.class);
        BDC.sessionId = session.getSessionId();
        BDC.orgId = session.getOrgId();
        BDC.usersId = session.getUsersId();
//        return BDC.getSession();
        return session;
    }

//    TODO
    public static List<OrgInfo> ListOrgs() throws Exception {
        // Must override toFormURLEncodedString, because endpoint requires it not to be nested in data={}
        return createCollection(LIST_ORGS_URL, new ApiResourceParams(){
            @Override
            public String toFormURLEncodedString() {
                return urlEncodeParams();
            }
        }, OrgInfo.class);
    }

    /**
     * Logs the user out of the current session
     *
     * @return True unless an unsuccessful response was received
     * @throws IOException
     * @throws com.bill.java.api.exception.BDCException
     */
    public static Boolean logout() throws Exception {
        httpClient.request(LOGOUT_URL, new ApiResourceParams() {
            @Override
            public String toFormURLEncodedString() {
                return urlEncodeParams();
            }
        }).getJsonData();
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
        return create(GET_SESSION_INFO_URL,new ApiResourceParams(){
            @Override
            public String toFormURLEncodedString() {
                return urlEncodeParams();
            }
        }, SessionInfo.class);
    }

    public static MFAChallenge requestMFAChallenge(Boolean useBackup) throws Exception {
        BDC.useBackup = useBackup;
        return create(MFA_CHALLENGE_URL, MFAChallenge.class);
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
}
