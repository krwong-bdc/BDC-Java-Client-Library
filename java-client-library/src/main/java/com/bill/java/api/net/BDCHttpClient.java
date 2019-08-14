package com.bill.java.api.net;


//import com.bill.java.api.Auth;
import com.bill.java.api.BDC;
import com.bill.java.api.param.ApiResourceParams;

import javax.net.ssl.HttpsURLConnection;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpCookie;
import java.net.URL;

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

//STRIPE LIVE STRIPE RESPONSE GETTER IS A WRAPPER AROUND APIRESOURCE.GSON.FROMJSON() (Which is a Serialized object of the resource model being requested (probably))
//LSRG is kind of like a factory at that point?
public class BDCHttpClient {
//TODO: implement authClient
//    public static AuthClient authClient = Auth.getClient();

    public static int connectTimeout = 5000;
    public static int readTimeout = 5000;
    public static HttpCookie authCookie;

    public HttpResponse request(String url, ApiResourceParams params) throws IOException{
//        create cookies with authentication
//        create url encoded body

        return execute(url, params.toJsonString());
    }

    private HttpResponse execute(String url, String params) throws IOException {
        HttpsURLConnection connection = openConnection(url);

        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = params.getBytes("utf-8");
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
        conn.setRequestProperty("Cookie", String.format("sessionId=%s", BDC.sessionId));
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
