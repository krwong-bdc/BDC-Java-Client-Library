package com.bill.java.api;

/**
 * @author      Keith Wong <krwong@hq.bill.com>
 * @since       0.0.1
 */
public abstract class BDC {
    public static final String VERSION = "0.0.1";
    public static final String SANDBOX_BASE = "https://api-sandbox.bill.com/api/v2";
    public static final String ALT_SANDBOX_BASE = "https://api-stage.bill.com/api/v2";
    public static final String PRODUCTION_BASE = "https://api.bill.com/api/v2";

    public static volatile String devKey;
    public static volatile String username;
    public static volatile String password;
    public static volatile String sessionId;

    public static volatile String apiBase = SANDBOX_BASE;

    public static String getApiBase() {
        return apiBase;
    }

    public static void setApiBase(String apiBase) {
        BDC.apiBase = apiBase;
    }


}
