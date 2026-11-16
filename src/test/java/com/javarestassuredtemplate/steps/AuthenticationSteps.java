package com.javarestassuredtemplate.steps;

import com.javarestassuredtemplate.GlobalParameters;
import com.javarestassuredtemplate.requests.GetTokenRequest;
import io.restassured.response.Response;

public class AuthenticationSteps {
    public static void generateToken(String username, String password){
        GetTokenRequest tokenRequest = new GetTokenRequest(username, password);
        Response response = tokenRequest.executeRequest();
        GlobalParameters.setToken(response.body().jsonPath().get("token").toString());
    }
}
