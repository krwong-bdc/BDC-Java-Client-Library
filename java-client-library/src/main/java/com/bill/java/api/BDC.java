package com.bill.java.api;

/**
 * @since       0.0.1
 */
public abstract class BDC {
    public enum Env { SANDBOX, PRODUCTION, ALT }

    /**
     * The current version of the Java Client Library: {@value #VERSION}
     */
    public static final String VERSION = "0.0.1";

    /**
     * The base url of Bill.com's sandbox environment: {@value #SANDBOX_BASE}
     * <p>
     *     For use in development and testing.
     *     Actions done through the library while set to Sandbox will not incur real-world transactions.
     * </p>
     */
    public static final String SANDBOX_BASE = "https://api-sandbox.bill.com/api/v2";

    /**
     * The base url of Bill.com's alternate sandbox Environment: {@value #ALT_SANDBOX_BASE}
     * <p>
     *     Users should use {@value #SANDBOX_BASE} unless instructed otherwise
     * </p>
     */
    public static final String ALT_SANDBOX_BASE = "https://api-stage.bill.com/api/v2";

    /**
     * The base url of Bill.com's Production environment
     * <p>
     *     For live use. Actions taken through the library will affect real-world accounts.
     * </p>
     */
    public static final String PRODUCTION_BASE = "https://api.bill.com/api/v2";


    /* User-set Credentials */
    /**
     * Key obtained from Bill.com to authorize API usage
     * <p>Required to be set before making any calls through the library</p>
     */
    public static volatile String devKey;

    /**
     * Email associated with user's Bill.com account
     * <p>Required to be set before making any calls through the library</p>
     */
    public static volatile String userName;

    /**
     * Password associated with the user's Bill.com account
     * <p>Required to be set before making any calls through the library</p>
     */
    public static volatile String password;

    /**
     * SessionId obtained from logging in.
     * <p>Will be set automatically upon logging in. Modification is discouraged.</p>
     */
    public static volatile String sessionId;

    /*
     * TODO: Remove after changing login to use params
     */
    public static volatile String orgId;

    /**
     * Id of the user logged in
     * <p>Will be set automatically upon logging in. Modification is discouraged.</p>
     */
    public static volatile String userId;

    /**
     * Base url that will be used for all requests.
     * <p>
     *     By default set to Sandbox: {@value #SANDBOX_BASE}
     * </p>
     */
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
