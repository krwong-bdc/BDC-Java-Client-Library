package com.bill.java.api.param;

import com.bill.java.api.BDC;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationParams extends BDCParams{

    public AuthenticationParams() {
        if(BDC.devKey != null){
            params.put("devKey", new Param<String>(BDC.devKey));
        }
    }

    public <T> void setParam(String key, T value) {
        params.put(key, new Param<T>(value));
    }

    @Override
    public String toFormURLEncodedString() {
        return urlEncodeParams();
    }
}
