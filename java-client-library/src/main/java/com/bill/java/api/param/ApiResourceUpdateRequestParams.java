package com.bill.java.api.param;

import com.bill.java.api.net.ApiResource;
import com.google.gson.annotations.SerializedName;

/* Used to pass an ApiResource into a request instead of a request parameters object */
public class ApiResourceUpdateRequestParams extends ApiResourceParams{
    /** Holds the actual api resource variables for creation */
    @SerializedName("obj")
    protected ApiResource apiResource;

    public ApiResourceUpdateRequestParams(ApiResource apiResource) {
        this.apiResource = apiResource;
    }
}
