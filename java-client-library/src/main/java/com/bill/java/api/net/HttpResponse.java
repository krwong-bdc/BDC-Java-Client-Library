package com.bill.java.api.net;

import com.bill.java.api.exception.BDCException;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.util.List;

/*
HttpResponse response = request.execute()
must deconstruct data into class variables
 */
public class HttpResponse {
    private String response;

    /**
     * Constructs an instance of HttpResponse
     * @param connection
     * @throws IOException
     */
    public HttpResponse(InputStream connection) throws IOException{
//        Read response and throw BDC error
        BufferedReader in = null;
        String inputLine;
        StringBuilder body;
        try {
            in = new BufferedReader(new InputStreamReader(connection));

            body = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                body.append(inputLine);
            }
            in.close();

            this.response = body.toString();
        } catch(IOException e) {
            throw e;
        } finally {
            this.closeQuietly(in);
        }
    }

    /**
     *
     * @return
     * @throws BDCException
     */
    public JsonArray getJsonDataList() throws BDCException {
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(response).getAsJsonObject();

        // Throws a BDC Exception if the response status is not 0
        if(obj.getAsJsonPrimitive("response_status").getAsInt() == 1) {
            JsonObject responseData = obj.getAsJsonObject("response_data");
            String errorCode = responseData.get("error_code").getAsString();
            String errorMessage = responseData.get("error_message").getAsString();
            throw new BDCException(errorCode, errorMessage);
        }

        return obj.getAsJsonArray("response_data");
    }

    public JsonObject getJsonData() throws BDCException {
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(response).getAsJsonObject();

        // Throws a BDC Exception if the response status is not 0
        if(obj.getAsJsonPrimitive("response_status").getAsInt() == 1) {
            JsonObject responseData = obj.getAsJsonObject("response_data");
            String errorCode = responseData.get("error_code").getAsString();
            String errorMessage = responseData.get("error_message").getAsString();
            throw new BDCException(errorCode, errorMessage);
        }

        return obj.getAsJsonObject("response_data");
    }

    protected void closeQuietly(Closeable closeable) {
        try {
            if( closeable != null ) {
                closeable.close();
            }
        } catch(IOException e) {

        }
    }

}
