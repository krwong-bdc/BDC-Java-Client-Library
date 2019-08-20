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
public abstract class ApiResourceParams extends BDCParams{
//    protected ApiResourceParams() {
//        if(BDC.useBackup != null) {
//            params.put("password", new Param<Boolean>(BDC.useBackup));
//        }
//    }

    /**
     * @see
     * @return String representation of BDC Api POST body data
     */

    public String toFormURLEncodedString() {
        return "data=" + urlEncodeParams();
    }
}
