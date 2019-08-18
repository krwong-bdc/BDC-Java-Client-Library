package com.bill.java.api.param;

import com.bill.java.api.net.ApiResource;
import javafx.util.Builder;

public class ListOrgsRequestParams extends ApiResourceParams {

    private ListOrgsRequestParams() {
        super();
    }

    public static Builder builder() {
        return new ListOrgsRequestParams.Builder();
    }

    public static class Builder {
        public ListOrgsRequestParams build() {
            return new ListOrgsRequestParams();
        }
    }
}
