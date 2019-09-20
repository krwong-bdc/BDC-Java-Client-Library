package com.bill.java.api;

/**
 * This class contains the parameters required for user authentication and the method to validate the
 * API base URL.
 */
public abstract class BDC {

    /**
    * the enum that contains the sandbox, production, and alternate sandbox constants
    */
    public enum Env { SANDBOX, PRODUCTION, ALT }

    /**
     * the current version of the Java Client Library: {@value #VERSION}
     */
    public static final String VERSION = "0.0.1";

    /**
     * the base URL of the sandbox environment: {@value #SANDBOX_BASE}
     * <p>
     *    The sandbox environment is very similar to the production environment. Money movement is disabled within the environment.
     *    Therefore, actions done through the library while set to Sandbox does not incur real-world transactions.
     * </p>
     */
    public static final String SANDBOX_BASE = "https://api-sandbox.bill.com/api/v2";

    /**
     * the base URL of the alternate sandbox environment: {@value #ALT_SANDBOX_BASE}
     * <p>Users should use {@value #SANDBOX_BASE} unless instructed otherwise.</p>
     */
    public static final String ALT_SANDBOX_BASE = "https://api-stage.bill.com/api/v2";

    /**
     * the base URL of the production environment: {@value #PRODUCTION_BASE}
     * <p>
     *     The production environment is used for real-world deployments. Money movement is enabled within the environment.
     *     Therefore, actions taken through the library affects real-world accounts.
     * </p>
     */
    public static final String PRODUCTION_BASE = "https://api.bill.com/api/v2";

    /* User-set Credentials */
    /**
     * the developer key that is shared when the sandbox account is provisioned.
     * It is required to authorize API usage. Therefore, it needs to be set before making any calls through the library.
     */
    public static volatile String devKey;

    /**
     * email associated with user's Bill.com account.
     * It needs to be set before making any calls through the library.
     */
    public static volatile String userName;

    /**
     * password associated with the user's Bill.com account.
     * It needs to be set before making any calls through the library.
     */
    public static volatile String password;

    /**
     * the session ID obtained from logging in.
     * It is automatically set upon logging in. Modification is discouraged.
     */
    public static volatile String sessionId;

    /*
     * TODO: Remove after changing login to use params
     */
    public static volatile String orgId;

    /**
     * the system generated ID of the user that logged in.
     * It is automatically set upon logging in. Modification is discouraged.
     */
    public static volatile String userId;

    /**
     * base URL used for all requests.
     * By default, it is set to the sandbox environment: {@value #SANDBOX_BASE}
     */
    public static volatile String apiBase = SANDBOX_BASE;


    /**
    * Gets the API base URL.
    *
    * @return   returns the sandbox, production, or the alternative sandbox API base URL
    */
    public static String getApiBase() {
        return apiBase;
    }

    /**
    * Sets the API base URL.
    *
    * @param env  the environment URL that was defined when using the client library
    *
    */
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
