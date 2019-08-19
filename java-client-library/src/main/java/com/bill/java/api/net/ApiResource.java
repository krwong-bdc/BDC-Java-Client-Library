package com.bill.java.api.net;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.param.ApiResourceParams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for converting API responses into resource model instances
 */
public abstract class ApiResource {
    /**
     * Underlying client
     *
     * TODO: allow for customization for things like timeout length
     */
    public static  BDCHttpClient httpClient = new BDCHttpClient();

    public static final Gson GSON = createGson();

    private static Gson createGson() {
        return new GsonBuilder().create();
    }

    /**
     *Factory for producing a collection of instances of the specified ApiResource type
     */
    public static <T> List<T> createCollection(String resourceUrl, Class<T> clazz) throws Exception {
        HttpResponse response = ApiResource.httpClient.request(resourceUrl);
        return createCollection(response, clazz);
    }

    public static <T> List<T> createCollection(String resourceUrl, ApiResourceParams params, Class<T> clazz) throws Exception {
        HttpResponse response = ApiResource.httpClient.request(resourceUrl, params);
        return createCollection(response, clazz);
    }

    private static <T> List<T> createCollection(HttpResponse response, Class<T> clazz) throws BDCException {
        JsonArray jsonArray = response.getJsonDataList();
        Type listType = new TypeToken<List<JsonObject>>() {}.getType();
        List<JsonObject> dataList = GSON.fromJson(jsonArray, listType);

        List<T> convertedDataList = new ArrayList<T>();

        for(JsonObject obj: dataList) {
            convertedDataList.add(GSON.fromJson(obj, clazz));
        }

        return convertedDataList;
    }

    public static <T> T create(String resourceUrl, Class<T> clazz) throws Exception {
        HttpResponse response = ApiResource.httpClient.request(resourceUrl);
        return GSON.fromJson(response.getJsonData(), clazz);
    }

    /**
     * Factory for producing instances of the specified ApiResource type
     *
     * @param resourceUrl The full URL of the target endpoint. Should only ever be for a single resource
     * @param params As required, parameters for HTTP POST request are x-www-form-urlencoded
     * @param clazz Class of resource being requested
     * @return Return instance of class T
     */
    public static <T> T create(String resourceUrl, ApiResourceParams params, Class<T> clazz) throws Exception {
        HttpResponse response = ApiResource.httpClient.request(resourceUrl, params);
        return GSON.fromJson(response.getJsonData(), clazz);
    }

    // TODO: read, update, and delete should take class T (or an ID)

}
