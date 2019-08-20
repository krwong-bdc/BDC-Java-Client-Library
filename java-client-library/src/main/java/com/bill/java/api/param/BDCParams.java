package com.bill.java.api.param;

import java.io.UnsupportedEncodingException;

/**
 * Base interface for different types of parameters required on POST requests to the BDC API
 */
interface BDCParams {

    /** Implementing classes must be able to URL encode themselves */
    String encodeValue(String value) throws UnsupportedEncodingException;

    /** Implementing classes must be able to format themselves as needed for POST requests to the BDC API */
    String toFormURLEncodedString() throws UnsupportedEncodingException;
}
