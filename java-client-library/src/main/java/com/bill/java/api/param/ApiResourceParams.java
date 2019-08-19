package com.bill.java.api.param;

import com.bill.java.api.BDC;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import static java.util.stream.Collectors.joining;

/**
 * @author      Keith Wong <krwong@hq.bill.com>
 * @since       0.0.1
 */
public abstract class ApiResourceParams {
    /**
     * Map that stores BDC Api POST body data
     */
    protected Map<String, Param> params = new HashMap<String, Param>();

    protected ApiResourceParams() {
        if(BDC.devKey != null){
            params.put("devKey", new Param<String>(BDC.devKey));
        }
        if(BDC.sessionId != null) {
            params.put("sessionId", new Param<String>(BDC.sessionId));
        }
        if(BDC.userName != null) {
            params.put("userName", new Param<String>(BDC.userName));
        }
        if(BDC.password != null) {
            params.put("password", new Param<String>(BDC.password));
        }
        if(BDC.useBackup != null) {
            params.put("password", new Param<Boolean>(BDC.useBackup));
        }
    }

    /**
     * @see
     * @return String representation of BDC Api POST body data
     */
    public String toJsonString() {
        Gson GSON = new Gson();
        return GSON.toJson(params);
    }

    private String encodeValue(String value) throws UnsupportedEncodingException{
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }

    public String toFormURLEncodedString() {
//        String encodedURL = params.keySet()
//                .stream()
//                .map(key -> {
//                    try {
//                        return key + "=" + encodeValue(params.get(key).getStringValue());
//                    } catch (Exception e) {
//                        System.err.println(e.getMessage());
//                        return "";
//                    }
//                })
//                .collect(joining("&"));
//        return encodedURL;
        return "data=" + urlEncodeParams();
    }

    protected String urlEncodeParams(){
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

    class Param<T> {
        private T value;

        public Param(T value) {
            this.value = value;
        }

        public String getStringValue() throws UnsupportedOperationException {
            return value.toString();
        }
    }

}
