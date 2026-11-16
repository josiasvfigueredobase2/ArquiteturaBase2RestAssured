package com.javarestassuredtemplate.requests;

import com.javarestassuredtemplate.GlobalParameters;
import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetTokenRequest extends RequestRestBase {
    public GetTokenRequest(String username, String password){
        url= GlobalParameters.URL_TOKEN;
        requestService = "token/"+username+"/"+password;
        method = Method.GET;
    }
}
