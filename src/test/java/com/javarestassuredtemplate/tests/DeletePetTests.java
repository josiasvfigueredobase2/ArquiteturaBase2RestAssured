package com.javarestassuredtemplate.tests;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.DeletePetRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DeletePetTests extends TestBase {
    DeletePetRequest deletePetRequest;
    PostPetTests petCreationTests = new PostPetTests();
    String availablePetId;

    @Test
    public void deleteCreatedPet(){
        SoftAssert softAssert = new SoftAssert();

////////Create a pet

        // Parameters
        int expectedStatusCode = HttpStatus.SC_OK;

        // Flow
        petCreationTests.createAvailablePet();
        int createResponseCode = petCreationTests.code;
        availablePetId = petCreationTests.id;

////////

        //Parameters
        int petId = Integer.parseInt(availablePetId);

        //Flow
        deletePetRequest = new DeletePetRequest(petId);
        Response response = deletePetRequest.executeRequest();

        //Assertions
        Assert.assertEquals(createResponseCode, expectedStatusCode);
        Assert.assertEquals(response.statusCode(), expectedStatusCode);
        softAssert.assertEquals(response.body().jsonPath().getInt("code"), 200, "Validate code");
        softAssert.assertEquals(response.body().jsonPath().get("type").toString(), "unknown", "Validate type");
        softAssert.assertEquals(response.body().jsonPath().get("message"), Integer.toString(petId), "Validate message");
        softAssert.assertAll();
    }
}