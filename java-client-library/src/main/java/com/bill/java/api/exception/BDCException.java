package com.bill.java.api.exception;

/**
 * @author      Keith Wong <krwong@hq.bill.com>
 * @since       0.0.1          (the version of the package this class was first added to)
 *
 * TODO: Extend BDCException to encapsulate different BDC Error Code categories (e.g. AuthorizationException, SystemException).
 * TODO: Implement active error handling (i.e. check for and throw exceptions before making HTTP request)
 */

/**
 * A wrapper around the error code returned on an unsuccessful call to the Bill.com API
 */
public class BDCException extends Exception {
    /**
     * URL of resource containing reference of all possible errors returned from the Bill.com API
     */
    public static final String REFERENCE_URL = "https://developer.bill.com/hc/en-us/articles/208762056";

    private final String errorCode;

    /**
     * BDCException Constructor
     *
     * @param errorCode code set on the HTTP response; Reference available: https://developer.bill.com/hc/en-us/articles/208762056
     * @param message description of error set on the HTTP response
     */
    public BDCException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * Returns a description of the exception, including the HTTP status code and a reference of all status codes
     *
     * @return a string representation of the exception
     */
    @Override
    public String getMessage() {
        String code = String.format("ErrorCode: %s (", this.errorCode);
        String additionalInfo = String.format(")\nReference: %s", BDCException.REFERENCE_URL);

        return code + super.getMessage() + additionalInfo;
    }

    /** Getter method for BDCException member variable*/
    public String getErrorCode() {
        return errorCode;
    }
}
