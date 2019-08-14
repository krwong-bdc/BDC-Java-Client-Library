package com.bill.java.api.models;

import com.bill.java.api.BDC;
import com.bill.java.api.net.ApiResource;
import com.bill.java.api.param.InvoiceCreateParams;


public class Invoice extends ApiResource {

    /**
     * Creates an instance of the Invoice class
     *
     * <p>
     * Delegates work to ApiResource.create()
     * </p>
     *
     * @param params
     * @return Returns an instance of the Invoice class
     */
    public static Invoice create(InvoiceCreateParams params) throws Exception {
        String resourceUrl = BDC.getApiBase() + "/CRUD/create";
        return create(resourceUrl, params, Invoice.class);
    }

}
