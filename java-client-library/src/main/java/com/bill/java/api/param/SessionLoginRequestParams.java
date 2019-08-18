package com.bill.java.api.param;


/**
 * Request Parameters for the login enpdpoint to obtain the Session Id
 */
public class SessionLoginRequestParams extends ApiResourceParams {
//    devKey taken from BDC in super
    private SessionLoginRequestParams(String orgId){
        super();
        params.put("orgId", orgId);
    }

    public static Builder builder() {
        return new SessionLoginRequestParams.Builder();
    }

    public static class Builder {
        private String orgId;

        public SessionLoginRequestParams build() {
            return new SessionLoginRequestParams(this.orgId);
        }

        public Builder setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }
    }

}
