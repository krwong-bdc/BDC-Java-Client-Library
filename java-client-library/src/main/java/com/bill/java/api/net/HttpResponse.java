package com.bill.java.api.net;

import com.bill.java.api.exception.BDCException;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.*;


public class HttpResponse {
    private String response;

    /**
     * Constructs an instance of HttpResponse
     * @param connection
     * @throws IOException
     */
    public HttpResponse(InputStream connection) throws IOException {
        String inputLine;
        StringBuilder body;
        try (BufferedReader in = new BufferedReader((new InputStreamReader(connection)))) {
            body = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                body.append(inputLine);
            }
            this.response = body.toString();
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
}
