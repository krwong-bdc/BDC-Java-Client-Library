package com.bill.java.api.net;

import com.bill.java.api.param.ApiResourceParams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
     * Factory for producing instances of type ApiResource
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

    //TODO: implement requestCollection(url, map params, clazz)


    // TODO: read, update, and delete should take class T (or an ID)

}
