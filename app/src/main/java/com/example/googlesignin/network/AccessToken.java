package com.example.googlesignin.network;

/**
 * Created by smart04 on 6/2/17.
 */

public class AccessToken {
    private String tokenType;
    private String accessToken;

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
