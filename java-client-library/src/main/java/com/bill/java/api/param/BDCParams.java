package com.bill.java.api.param;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

interface BDCParams {
    String encodeValue(String value) throws UnsupportedEncodingException;
    String toFormURLEncodedString() throws UnsupportedEncodingException;
}
