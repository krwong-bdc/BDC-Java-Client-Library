package com.bill.java.api.param;


/**
 * Request Parameters for the login enpdpoint to obtain the Session Id
 */
public class SessionLoginRequestParams extends ApiResourceParams {
//    devKey taken from BDC in super
    private SessionLoginRequestParams(String orgId){
        super();
        params.put("orgId", new Param<String>(orgId));
//        params.put("mfaId", new Param<String>(mfaId));
//        params.put("deviceId", new Param<String>(deviceId));
    }

    @Override
    public String toFormURLEncodedString() {
        return urlEncodeParams();
    }

    public static Builder builder() {
        return new SessionLoginRequestParams.Builder();
    }

    public static class Builder {
        private String orgId;
        private String mfaId;
        private String deviceId;

        public SessionLoginRequestParams build() {
//            return new SessionLoginRequestParams(this.orgId, this.mfaId, this.deviceId);
            return new SessionLoginRequestParams(this.orgId);
        }

        public Builder setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }



//        public Builder Builder.setMfaId(String mfaId) {
//            this.mfaId = mfaId;
//            return this;
//        }
//
//        public Builder Buidler.setDeviceId(String deviceId) {
//            this.deviceId = deviceId;
//            return this;
//        }
    }

}
