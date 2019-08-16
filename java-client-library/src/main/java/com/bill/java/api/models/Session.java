package com.bill.java.api.models;

import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.SessionLoginRequestParams;
import com.google.gson.annotations.SerializedName;

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
}
