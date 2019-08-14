package com.enterprise.sib.api.login;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginRespMdl {

    private String UserId;
    private String SessionId;
    private String UserName;
    private String DisplayName;
    private ResponseStatus ResponseStatus;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getSessionId() {
        return SessionId;
    }

    public void setSessionId(String sessionId) {
        SessionId = sessionId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public com.enterprise.sib.api.login.ResponseStatus getResponseStatus() {
        return ResponseStatus;
    }

    public void setResponseStatus(com.enterprise.sib.api.login.ResponseStatus responseStatus) {
        ResponseStatus = responseStatus;
    }

}