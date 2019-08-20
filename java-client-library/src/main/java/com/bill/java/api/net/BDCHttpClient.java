package com.bill.java.api.net;

import com.bill.java.api.BDC;
import com.bill.java.api.param.ApiResourceParams;
import com.bill.java.api.param.AuthenticationParams;

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
        return request(url, new ApiResourceParams() {});
//        return execute(BDC.getApiBase() + url, new ApiResourceParams() {}.toFormURLEncodedString());
    }

    public HttpResponse request(String url, ApiResourceParams params) throws Exception{
        return request(url, params, new AuthenticationParams(){});
//        return execute(BDC.getApiBase() + url, params.toFormURLEncodedString());
    }

    public HttpResponse request(String url, AuthenticationParams params) throws Exception{
        return execute(BDC.getApiBase()+ url, "", params.toFormURLEncodedString());
//        return execute(BDC.getApiBase() + url, params.toFormURLEncodedString());
    }

    public HttpResponse request(String url, ApiResourceParams params, AuthenticationParams auth) throws Exception{
        return execute(BDC.getApiBase() + url, params.toFormURLEncodedString(), auth.toFormURLEncodedString());
    }

    private HttpResponse execute(String url, String data, String auth) throws IOException {
        HttpsURLConnection connection = openConnection(url);
        String requestParameters = auth;
        if (data != "") {
            requestParameters += "&" + data;
        }

        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = requestParameters.getBytes("utf-8");
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
        if(BDC.sessionId != null) {
            builder.append(String.format("sid=%s;", BDC.sessionId));
        }
        return builder.toString();
    }


}
