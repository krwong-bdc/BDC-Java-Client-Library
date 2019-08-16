package com.bill.java.api.param;

public class SessionLoginRequestParams extends ApiResourceParams {
//    devKey taken from BDC in super
    private SessionLoginRequestParams(String userName, String password, String orgId){
        super();
        params.put("userName", userName);
        params.put("password", password);
        params.put("orgId", orgId);
    }

    public static Builder builder() {
        return new SessionLoginRequestParams.Builder();
    }

    public static class Builder {
        private String userName;
        private String password;
        private String orgId;

        public SessionLoginRequestParams build() {
            return new SessionLoginRequestParams(this.userName, this.password, this.orgId);
        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setOrgId(String orgId) {
            this.orgId = orgId;
            return this;
        }
    }

}
