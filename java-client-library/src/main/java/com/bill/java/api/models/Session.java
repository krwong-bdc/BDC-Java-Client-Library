package com.bill.java.api.models;

import com.bill.java.api.BDC;
import com.bill.java.api.net.ApiResource;
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

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("orgId")
    private String orgId;

    @SerializedName("apiEndPoint")
    private String apiEndPoint;

    @SerializedName("usersId")
    private String usersId;

    public static Session login(SessionLoginRequestParams params) throws Exception {
        Session session = create(LOGIN_URL, params, Session.class);
        BDC.sessionId = session.getSessionId();
        return session;
    }

//    TODO
    public static List<OrgInfo> ListOrgs() throws Exception {
        return createCollection(LIST_ORGS_URL, OrgInfo.class);
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
     *
     * @return
     * @throws Exception
     * @throws com.bill.java.api.exception.BDCException when session invalid
     */
    public static SessionInfo getSessionInfo() throws Exception {
        return create(GET_SESSION_INFO_URL, SessionInfo.class);
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
