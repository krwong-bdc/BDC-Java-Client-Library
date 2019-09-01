package com.bill.java.api.param;

import com.bill.java.api.BDC;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static java.util.stream.Collectors.joining;

/**
 * Wrapper around the credentials passed in on each BDC API call
 */
public class AuthenticationParams implements BDCParams {
    /* Authentication parameters to be included on the POST request to the BDC API */
    protected Map<String, Param> params = new HashMap<String, Param>();

    /*
     * Developer key must be included on every request. SessionId will be passed on cookies
     * @see com.bill.java.api.net.BDCHttpClient #createAuthCookie
     */
    private AuthenticationParams(String orgId, String mfaId, String deviceId) {
        setParam("userName", BDC.userName);
        setParam("password", BDC.password);
        setParam("devKey", BDC.devKey);

        /* TODO: If included in params the nulls get printed to console because of the way parameters are encoded onto the URL. Figure out how to mitigate */
        if(orgId != null){
            setParam("orgId", orgId);
        }

        if(mfaId != null) {
            setParam("mfaId", mfaId);
        }

        if(deviceId != null) {
            setParam("deviceId", deviceId);
        }
    }

    /*
     * URL encodes passed in string
     *
     * @param authParam data required by the calling method to make a request to a BDC API endpoint
     * @return url-encoded data
     * @throws UnsupportedEncodingException when unable to encode given string with the supplied encoding type
     */
    public String encodeValue(String authParam) throws UnsupportedEncodingException {
        return URLEncoder.encode(authParam, StandardCharsets.UTF_8.toString());
    }

    /*
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

    /*
     * Transforms the instanced AuthenticationParams object into a string to be appended onto a Http request
     * @return string representation of the request credentials
     */
    public String toFormURLEncodedString() {
        return urlEncodeParams();
    }

    /*
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

    /**
     * Returns a builder for the AuthenticationParams class
     *
     * @return A builder for the AuthenticationParams class
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds an instance of the AuthenticationParams class
     */
    public static class Builder {
        public String orgId;
        public String mfaId;
        public String deviceId;

        public Builder with(Consumer<Builder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public AuthenticationParams build() {
            return new AuthenticationParams(orgId, mfaId, deviceId);
        }
    }
}
