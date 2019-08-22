package com.bill.java.api.net;

import com.bill.java.api.exception.BDCException;
import com.bill.java.api.param.ApiResourceParams;
import com.bill.java.api.param.AuthenticationParams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for converting API responses into resource model instances
 */
public abstract class ApiResource {
    /** Underlying Httpclient, handles making the connection to the API and fetching responses */
    public static  BDCHttpClient httpClient = new BDCHttpClient();

    /** Transforms models to JSON and vice versa. Used to map Http Response to useable models */
    public static final Gson GSON = createGson();
    private static Gson createGson() {
        return new GsonBuilder().create();
    }

    /**
     * Executes a request to the specified URL and transforms the response into a List of instance of the specified type
     *
     * @param resourceUrl the full URL  of the target endpoint. Should only ever be for a list of resources
     * @see #create(String, Class)
     * @param clazz the mapping class of the resources being requested
     * @return A list of the specified type
     * @throws BDCException When the response from the API is not a success
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static <T> List<T> createCollection(String resourceUrl, Class<T> clazz) throws BDCException, IOException {
        HttpResponse response = ApiResource.httpClient.request(resourceUrl);
        return convertToList(response, clazz);
    }

    /**
     * Executes a request to the specified URL and transforms the response into a List of instance of the specified type
     *
     * @param resourceUrl the full URL  of the target endpoint. Should only ever be for a list of resources
     * @see #create(String, ApiResourceParams, Class)
     * @param resourceParams credentials needed for the request
     * @param clazz the mapping class of the resources being requested
     * @return A list of the specified type
     * @throws BDCException When the response from the API is not a success
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static <T> List<T> createCollection(String resourceUrl, ApiResourceParams resourceParams, Class<T> clazz) throws BDCException, IOException {
        HttpResponse response = ApiResource.httpClient.request(resourceUrl, resourceParams);
        return convertToList(response, clazz);
    }

    /**
     * Executes a request to the specified URL and transforms the response into a List of instance of the specified type
     *
     * @param resourceUrl the full URL  of the target endpoint. Should only ever be for a list of resources
     * @see #create(String, AuthenticationParams, Class)
     * @param authParams credentials required to make the request
     * @param clazz the mapping class of the resources being requested
     * @return A list of the specified type
     * @throws BDCException When the response from the API is not a success
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static <T> List<T> createCollection(String resourceUrl, AuthenticationParams authParams, Class<T> clazz) throws BDCException, IOException {
        HttpResponse response = ApiResource.httpClient.request(resourceUrl, authParams);
        return convertToList(response, clazz);
    }

    /**
     * Maps the HttpResponse data into a list of instances of the specified type
     *
     * @param response from the Http request
     * @param clazz the mapping class of the resources being requested
     * @return A list of the specified type
     * @throws BDCException when the response from the API is not a success
     */
    public static <T> List<T> convertToList(HttpResponse response, Class<T> clazz) throws BDCException {
        JsonArray jsonArray = response.getJsonDataList();
        Type listType = new TypeToken<List<JsonObject>>() {}.getType();
        List<JsonObject> dataList = GSON.fromJson(jsonArray, listType);

        List<T> convertedDataList = new ArrayList<T>();

        for(JsonObject obj: dataList) {
            convertedDataList.add(GSON.fromJson(obj, clazz));
        }

        return convertedDataList;
    }

    /** Executes a request to the specified URL and transforms the response into an instance of the specified type
     *
     * @param resourceUrl The full URL of the target endpoint. Should only ever be for a single resource
     * @see #createCollection(String, Class) createCollection
     * @param clazz the mapping class of the resource being requested
     * @return an instance of the type passed in as clazz
     * @throws BDCException when the response from the API is not a success
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static <T> T create(String resourceUrl, Class<T> clazz) throws BDCException, IOException {
        HttpResponse response = httpClient.request(resourceUrl);
        return GSON.fromJson(response.getJsonData(), clazz);
    }

    /**
     * Executes a request to the specified URL and transforms the response into an instance of the specified Type
     *
     * @param resourceUrl The full URL of the target endpoint. Should only ever be for a single resource
     * @see #createCollection(String, ApiResourceParams, Class) createCollection
     * @param resourceParams data required to be passed on the body of the Http request
     * @param clazz the mapping class of resource being requested
     * @return an instance of the type passed in as clazz
     * @throws BDCException when the response from the API is not a success
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static <T> T create(String resourceUrl, ApiResourceParams resourceParams, Class<T> clazz) throws BDCException, IOException {
        HttpResponse response = httpClient.request(resourceUrl, resourceParams);
        return GSON.fromJson(response.getJsonData(), clazz);
    }

    /**
     * Executes a request to the specified URL and transforms the response into instances of the specified type
     *
     * @param resourceUrl The full URL of the target endpoint. Should only ever be for a single resource
     * @see #createCollection(String, AuthenticationParams, Class) createCollection
     * @param authParams credentials required to to make the request
     * @param clazz the mapping class of resource being requested
     * @return an instance of the type passed in as clazz
     * @throws BDCException when the response from the API is not a success
     * @throws IOException when an I/O exception occurs on the underlying request
     */
    public static <T> T create(String resourceUrl, AuthenticationParams authParams, Class<T> clazz) throws BDCException, IOException {
        HttpResponse response = httpClient.request(resourceUrl, authParams);
        return GSON.fromJson(response.getJsonData(), clazz);
    }

    // TODO: read, update, and delete should take class T (or an ID)

}
