package com.bill.java.api.param;

import com.bill.java.api.BDC;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

/**
 * Wrapper around the credentials passed in on each BDC API call
 */
public class AuthenticationParams implements BDCParams {
    /** Authentication parameters to be included on the POST request to the BDC API */
    protected Map<String, Param> params = new HashMap<String, Param>();

    /**
     * Developer key must be included on every request. SessionId will be passed on cookies
     * @see com.bill.java.api.net.BDCHttpClient #createAuthCookie
     * */
    public AuthenticationParams(String userName, String password, String orgId, String devKey) {
        setParam("userName", userName);
        setParam("password", password);
        setParam("orgId", orgId);
        setParam("devKey", devKey);
    }

    /**
     * URL encodes passed in string
     *
     * @param authParam data required by the calling method to make a request to a BDC API endpoint
     * @return url-encoded data
     * @throws UnsupportedEncodingException when unable to encode given string with the supplied encoding type
     */
    public String encodeValue(String authParam) throws UnsupportedEncodingException {
        return URLEncoder.encode(authParam, StandardCharsets.UTF_8.toString());
    }

    /**
     * URL-encodes the credentials required for a request to a BDC API endpoint
     *
     * @return String representation of credentials required for a request to a BDC API endpoint
     */
    private String urlEncodeParams(){
        /** Map over the instances params variable to produce key=value pairs joined with an ampersand */
        String encodedURL = params.keySet()
                .stream()
                .map(key -> {
                    try {
                        return key + "=" + encodeValue(params.get(key).getStringValue());
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        return "";
                    }
                })
                .collect(joining("&"));
        return encodedURL;
    }

    /**
     * Transforms the instanced AuthenticationParams object into a string to be appended onto a Http request
     * @return string representation of the request credentials
     */
    public String toFormURLEncodedString() {
        return urlEncodeParams();
    }

    /**
     * Sets a credential on the instanced AuthenticationParams object
     *
     * @param key name of credential
     * @param value value of credential
     * @param <T> Should be a String or Boolean
     */
    private <T> void setParam(String key, T value) {
        params.put(key, new Param<T>(value));
    }

    class Param<T> {
        private T value;

        public Param(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public String getStringValue() throws UnsupportedOperationException {
            return value.toString();
        }
    }

    public static AuthenticationParamsBuilder builder() {
        return new AuthenticationParamsBuilder();
    }

    public static class AuthenticationParamsBuilder {
        private String userName = "";
        private String password = "";
        private String orgId = "";
        private String devKey = "";

        public AuthenticationParams build() {
            if(devKey == "") {
                devKey = BDC.devKey;
            }
            if(userName == "") {
                userName = BDC.userName;
            }
            if(password == "") {
                password = BDC.password;
            }
            return new AuthenticationParams(userName, password, orgId, devKey);
        }

        public AuthenticationParamsBuilder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public AuthenticationParamsBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public AuthenticationParamsBuilder withOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public AuthenticationParamsBuilder withDevKey(String devKey) {
            this.devKey = devKey;
            return this;
        }
    }
}
