package com.bill.java.api.param;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


/**
 * @author      Keith Wong <krwong@hq.bill.com>
 * @since       0.0.1
 */
public abstract class ApiResourceParams implements BDCParams {
/*    TODO: change all api resource params to not have params and to instead put all options on class
    Todo: remove params from base BDCParams to Authenticationparams
 */

    /**
     * @see
     * @return String representation of BDC Api POST body data
     */

    public String encodeValue(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }

    public String toFormURLEncodedString() throws UnsupportedEncodingException {
        return "data="+ encodeValue(this.toJsonString());
    }

    public String toJsonString() {
        return new Gson().toJson(this);
    }
}
