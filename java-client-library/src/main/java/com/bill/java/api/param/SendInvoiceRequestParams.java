package com.bill.java.api.param;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.function.Consumer;

/**
 * Parameters for sending an Invoice through the BDC API
 */
public class SendInvoiceRequestParams extends ApiResourceParams {
    @SerializedName("invoiceId")
    private final String invoiceId;

    @SerializedName("headers")
    private final Headers headers;

    @SerializedName("content")
    private final Content content;

    private SendInvoiceRequestParams(String invoiceId, Headers headers, Content content) {
        this.invoiceId = invoiceId;
        this.headers = headers;
        this.content = content;
    }

    /**
     * Makes a new Builder for SendInvoiceRequestParams
     *
     * @return a builder for SendInvoiceRequestParams
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builds a SendInvoiceRequestParams object
     */
    public static class Builder {
        /**
         * Invoice ID to send
         */
        public String invoiceId;

        /**
         * User ID sending invoice. Will be user's email from login. If not provided, user in Default Email Template is used.
         */
        public String fromUserId;

        /**
         * Array of email addresses to send invoice. If provided, invoice goes to these addresses. If not provided, invoice sent to customer contact email(s).
         */
        public List<String> toEmailAddresses;

        /**
         * CC to sender. User receives CC (not user in fromUserId.
         */
        public Boolean ccMe;

        /**
         * 	Subject line. Tokens not allowed.
         */
        public String subject;

        /**
         * 	Body. Must be single String. Can use tokens. For forced line break, use \n
         */
        public String body;

        public Builder with(Consumer<Builder> builderfunction) {
            builderfunction.accept(this);
            return this;
        }

        /**
         * Builds a SendInvoiceRequestParams instance with the set parameters
         *
         * @return SendInvoiceRequestParams
         */
        public SendInvoiceRequestParams build() {
            return new SendInvoiceRequestParams(
                    invoiceId,
                    new Headers(fromUserId, toEmailAddresses, ccMe, subject),
                    new Content(body));
        }
    }

    /* Holds request data, will be nested in <tt>headers</tt>*/
    private static class Headers {
        @SerializedName("fromUserId")
        private String fromUserId;

        @SerializedName("toEmailAddresses")
        private List<String> toEmailAddresses;

        @SerializedName("ccMe")
        private Boolean ccMe;

        @SerializedName("subject")
        private String subject;

        Headers(String fromUserId,
                List<String> toEmailAddresses,
                Boolean ccMe,
                String subject) {
            this.fromUserId = fromUserId;
            this.toEmailAddresses = toEmailAddresses;
            this.ccMe = ccMe;
            this.subject = subject;
        }
    }

    /* Holds request data, will be nested in <tt>content</tt>*/
    private static class Content {
        @SerializedName("body")
        private String body;

        Content(String body) {
            this.body = body;
        }
    }
}
