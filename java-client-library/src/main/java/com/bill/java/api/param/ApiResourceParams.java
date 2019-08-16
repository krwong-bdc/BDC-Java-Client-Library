package com.bill.java.api.param;

import com.bill.java.api.BDC;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
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
    protected Map<String, String> params = new HashMap<String, String>();

    protected ApiResourceParams() {
        params.put("devKey", BDC.devKey);
        params.put("sessionId", BDC.sessionId);
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

    public String toFormURLEncodedString() throws Exception {
        String encodedURL = params.keySet()
                .stream()
                .map(key -> {
                    try {
                        return key + "=" + encodeValue(params.get(key));
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    return "";
                })
                .collect(joining("&", "", ""));

        return encodedURL;
    }

}
