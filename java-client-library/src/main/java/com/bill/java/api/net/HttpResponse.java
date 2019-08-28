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
     *
     * @param connection InputStream gotten from the Http request
     * @throws IOException when an I/O exception occurs while opening a buffer
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
     * Formats the response data as a list of JSON objects
     *
     * @return the response_data field included on the Http Response as a JsonArray of objects
     * @throws BDCException when the response from the API is not a success
     */
    public JsonArray getJsonDataList() throws BDCException {
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(response).getAsJsonObject();

        /** Throws a BDC Exception if the response status is not 0 */
        if(obj.getAsJsonPrimitive("response_status").getAsInt() == 1) {
            JsonObject responseData = obj.getAsJsonObject("response_data");
            String errorCode = responseData.get("error_code").getAsString();
            String errorMessage = responseData.get("error_message").getAsString();
            throw new BDCException(errorCode, errorMessage);
        }

        return obj.getAsJsonArray("response_data");
    }

    /**
     * Formats the response data as a JsonObject
     *
     * @return the response_data field included on the Http Response as a JsonObject
     * @throws BDCException when the response from the API is not a success
     */
    public JsonObject getJsonData() throws BDCException {
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(response).getAsJsonObject();

        /** Throws a BDC Exception if the response status is not 0 */
        if(obj.getAsJsonPrimitive("response_status").getAsInt() == 1) {
            JsonObject responseData = obj.getAsJsonObject("response_data");
            String errorCode = responseData.get("error_code").getAsString();
            String errorMessage = responseData.get("error_message").getAsString();
            throw new BDCException(errorCode, errorMessage);
        }

        return obj.getAsJsonObject("response_data");
    }
}
