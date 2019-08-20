package com.bill.java.api.param;

import com.bill.java.api.BDC;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class AuthenticationParams implements BDCParams {
    protected Map<String, Param> params = new HashMap<String, Param>();

    public AuthenticationParams() {
        if(BDC.devKey != null){
            params.put("devKey", new Param<String>(BDC.devKey));
        }
    }

    @Override
    public String encodeValue(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }

    private String urlEncodeParams(){
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

    public String toFormURLEncodedString() {
        return urlEncodeParams();
    }

    public <T> void setParam(String key, T value) {
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
}
