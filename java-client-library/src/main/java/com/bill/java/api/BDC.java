package com.bill.java.api;

/**
 * @author      Keith Wong <krwong@hq.bill.com>
 * @since       0.0.1
 */
public abstract class BDC {
    public enum Env { SANDBOX, PRODUCTION, ALT }

    public static final String VERSION = "0.0.1";
    public static final String SANDBOX_BASE = "https://api-sandbox.bill.com/api/v2";
    public static final String ALT_SANDBOX_BASE = "https://api-stage.bill.com/api/v2";
    public static final String PRODUCTION_BASE = "https://api.bill.com/api/v2";

    public static volatile String devKey;
    public static volatile String userName;
    public static volatile String password;
    public static volatile String sessionId;
    public static volatile Boolean useBackup;
    public static volatile String mfaId;
    public static volatile String deviceId;
    public static volatile String orgId;
    public static volatile String usersId;

    public static volatile String apiBase = SANDBOX_BASE;

    public static String getApiBase() {
        return apiBase;
    }

    public static void setApiBase(Env env) {
        switch (env) {
            case PRODUCTION:
                BDC.apiBase = PRODUCTION_BASE;
                break;
            case ALT:
                BDC.apiBase = ALT_SANDBOX_BASE;
                break;
            default:
                BDC.apiBase = SANDBOX_BASE;
                break;
        }

    }
}
