package com.bill.java.api.net;

import com.bill.java.api.BDC;
import com.bill.java.api.param.ApiResourceParams;

import javax.net.ssl.HttpsURLConnection;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpCookie;
import java.net.URL;


public class BDCHttpClient {
    public static int connectTimeout = 10000;
    public static int readTimeout = 10000;
    public static HttpCookie authCookie;

    /**
     *
     * @param url
     * @return
     * @throws Exception
     */
    public HttpResponse request(String url) throws Exception{
        return execute(BDC.getApiBase() + url, new ApiResourceParams() {}.toFormURLEncodedString());
    }

    public HttpResponse request(String url, ApiResourceParams params) throws Exception{
        return execute(BDC.getApiBase() + url, params.toFormURLEncodedString());
    }

    private HttpResponse execute(String url, String data) throws IOException {
        HttpsURLConnection connection = openConnection(url);
//        data = "data=" + data;

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
        conn.setRequestProperty("Cookie", createAuthCookie());
        conn.setConnectTimeout(connectTimeout);
        conn.setReadTimeout(readTimeout);

        return conn;
    }

    private String createAuthCookie() {
        StringBuilder builder = new StringBuilder();
        if(BDC.devKey != null){
            builder.append(BDC.devKey);
        }
        if(BDC.sessionId != null) {
            builder.append(BDC.sessionId);
        }
        if(BDC.userName != null) {
            builder.append(BDC.userName);
        }
        if(BDC.password != null) {
            builder.append(BDC.password);
        }
        if(BDC.mfaId != null) {
            builder.append(BDC.mfaId);
        }
        if(BDC.deviceId != null) {
            builder.append(BDC.deviceId);
        }
        return builder.toString();
    }


}
