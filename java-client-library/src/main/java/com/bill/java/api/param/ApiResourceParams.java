package com.bill.java.api.param;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * @author      Keith Wong <krwong@hq.bill.com>
 * @since       0.0.1
 */
public abstract class ApiResourceParams {
    /**
     * Map that stores BDC Api POST body data
     */
    protected Map<String, String> params = new HashMap<String, String>();

    /**
     * @see
     * @return String representation of BDC Api POST body data
     */
    public String toJsonString() {
        Gson GSON = new Gson();
        return GSON.toJson(params);
    }
}
