package com.bill.java.api.models;

import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.ApiResourceParams;
import com.bill.java.api.param.ListOrgsRequestParams;
import com.bill.java.api.param.SessionLoginRequestParams;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * The Session class represents a user's session credentials
 *
 * @author      Keith Wong <krwong@hq.bill.com>
 * @since       0.0.1
 */
public class Session extends ApiResource {
    public static final String LOGIN_URL = "/Login.json";
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
        return create(LOGIN_URL, params, Session.class);
    }

//    TODO
    public static List<OrgInfo> ListOrgs() throws Exception {
        return createList(LIST_ORGS_URL, OrgInfo.class);
    }
//    //    TODO
//    public static Session logout() {}
//    //    TODO
//    public static Session getSessionInfo() {}

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
