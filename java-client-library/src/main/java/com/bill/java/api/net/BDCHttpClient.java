package com.bill.java.api.net;


//import com.bill.java.api.Auth;
import com.bill.java.api.BDC;
import com.bill.java.api.param.ApiResourceParams;

import javax.net.ssl.HttpsURLConnection;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/*
Method will always be POST, so does anything need to change? Probably not for this first iteration
Things that should be customizable?
        - Timeouts
        - Headers? - No
Things that should be set?
        - URL, can open up one connection because Base URL does not change
        - Headers
        - Method
        - Data format (another class?)
 */
public class BDCHttpClient {
    public static int connectTimeout = 5000;
    public static int readTimeout = 5000;
    public static HttpCookie authCookie;

    public HttpResponse request(String url) throws IOException, Exception{
//        create cookies with authentication
//        create url encoded body

        return execute(BDC.getApiBase() + url, new ApiResourceParams() {}.toFormURLEncodedString());
    }

    public HttpResponse request(String url, ApiResourceParams params) throws IOException, Exception{
//        create cookies with authentication
//        create url encoded body

        return execute(BDC.getApiBase() + url, params.toFormURLEncodedString());
    }

    private HttpResponse execute(String url, String data) throws IOException {
        HttpsURLConnection connection = openConnection(url);

        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = data.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        return new HttpResponse(connection.getInputStream());
    }

    private HttpsURLConnection openConnection(String httpsUrl) throws IOException {
        return buildConnection(new URL(httpsUrl));
    }

    private HttpsURLConnection buildConnection(URL url) throws IOException {
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
//            set headers
//            If no cookie currently, create cookie

        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty(
                "Content-Type",
                "application/x-www-form-urlencoded");
        conn.setRequestProperty("Accept", "application/json");
//        TODO: Set the cookie on subsequent requests
//        conn.setRequestProperty("Cookie", String.format("sessionId=%s", BDC.sessionId));
        conn.setConnectTimeout(connectTimeout);
        conn.setReadTimeout(readTimeout);

        return conn;
    }

    private HttpCookie getAuthCookie() {
        if(authCookie == null || BDC.sessionId == null) {
//            throw
        }
        return authCookie;
    }


}
