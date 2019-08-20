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

    public HttpResponse request(String url) throws Exception{
        return request(url, new ApiResourceParams() {});
    }

    public HttpResponse request(String url, ApiResourceParams params) throws Exception{
        return request(url, params, new AuthenticationParams(){});
    }

    public HttpResponse request(String url, AuthenticationParams params) throws Exception{
        return execute(BDC.getApiBase()+ url, "", params.toFormURLEncodedString());
    }

    /**
     * Converts parameters and data to String form and executes the Http Request
     *
     * @param url The BDC API endpoint
     * @param params object wrapping the request data
     * @param auth Object wrapping the credentials to be passed along with the request
     * @return
     * @throws Exception
     */
    public HttpResponse request(String url, ApiResourceParams params, AuthenticationParams auth) throws Exception{
        return execute(BDC.getApiBase() + url, params.toFormURLEncodedString(), auth.toFormURLEncodedString());
    }

    /**
     * Executes the request to the given url with the specified data.
     *
     * @param url The BDC Api endpoint
     * @param data Request data that corresponds to the data passed in on a BDC API resource call
     * @param auth Credentials to be passed along with the request
     * @return An HttpResponse object wrapping the request's input stream
     * @throws IOException if an I/O error occurs while creating the output stream or input stream
     */
    private HttpResponse execute(String url, String data, String auth) throws IOException {
        HttpsURLConnection connection = openConnection(url);
        String requestParameters = auth;
        if (data != "") {
            requestParameters += "&" + data;
        }

        /** Sends the post request data to the URL, output stream auto-closed upon exiting try-with-resource block */
        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = requestParameters.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        return new HttpResponse(connection.getInputStream());
    }

    /**
     * Opens a Https connection to the BDC API endpoint with properly configured headers
     *
     * @param httpsUrl A url of the BDC API endpoint
     * @return the configured HttpsURLConnection object
     * @throws IOException if an I/O exception occurs.
     */
    private HttpsURLConnection openConnection(String httpsUrl) throws IOException {
        URL url = new URL(httpsUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty(
                "Content-Type",
                "application/x-www-form-urlencoded");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Cookie", createAuthCookie());
        conn.setConnectTimeout(connectTimeout);
        conn.setReadTimeout(readTimeout);

        return conn;
    }

    /**
     * Creates a cookie with the last sessionId to be passed in as a header on each API request
     *
     * @return Key-value pair as a String
     */
    private String createAuthCookie() {
        StringBuilder builder = new StringBuilder();
        if(BDC.sessionId != null) {
            builder.append(String.format("sid=%s;", BDC.sessionId));
        }
        return builder.toString();
    }


}
