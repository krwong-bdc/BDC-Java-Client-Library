package com.bill.java.api.param;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


/*
 * Gives params classes ability to encode themselves into properly formatted URLEncoded params.
 * Subject to change as BDC API changes
 *
 * @since       0.0.1
 */
public abstract class ApiResourceParams implements BDCParams {
    /*
     * Transforms the instanced ApiResourceParams object into a JSON representation
     *
     * @return String of the JSON representation of the instanced ApiResourceParams object
     */
    public String toJsonString() {
        return new Gson().toJson(this);
    }

    /*
     * URL encodes passed in string
     *
     * @param resourceParams data required by the calling method to make a request to a BDC API endpoint
     * @return url-encoded data
     * @throws UnsupportedEncodingException when unable to encode given string with the supplied encoding type
     */
    public String encodeValue(String resourceParams) throws UnsupportedEncodingException {
        return URLEncoder.encode(resourceParams, StandardCharsets.UTF_8.toString());
    }

    /*
     * Transforms the instanced ApiResourceParams object into a string to be appended onto a Http request
     *
     * @return string representation of the request data
     * @throws UnsupportedEncodingException when an UnsupportedEncoding exception occurs in the underlying request
     */
    public String toFormURLEncodedString() throws UnsupportedEncodingException {
        return "data="+ encodeValue(this.toJsonString());
    }

    @Getter
    @Setter
    public static class Filter {
        @SerializedName("field")
        private Integer field;

        @SerializedName("op")
        private Integer op;

        @SerializedName("value")
        private Integer value;
    }

    @Getter
    @Setter
    public static class Sort {
        @SerializedName("field")
        private Integer field;

        @SerializedName("asc")
        private Integer asc;
    }
}
