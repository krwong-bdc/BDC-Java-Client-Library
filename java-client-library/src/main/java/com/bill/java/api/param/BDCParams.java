package com.bill.java.api.param;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public abstract class BDCParams {
    protected Map<String, Param> params = new HashMap<String, Param>();
    /**
     * @see
     * @return String representation of BDC Api POST body data
     */
    public String toJsonString() {
        Gson GSON = new Gson();
        return GSON.toJson(params);
    }

    private String encodeValue(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }

    public abstract String toFormURLEncodedString();

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
