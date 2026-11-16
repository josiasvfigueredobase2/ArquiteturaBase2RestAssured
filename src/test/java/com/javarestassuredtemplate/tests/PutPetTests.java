package com.javarestassuredtemplate.tests;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.PutPetRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PutPetTests extends TestBase {
    PutPetRequest putPetRequest;
    PostPetTests petCreationTests = new PostPetTests();
    String availablePetId;

    @Test
    public void updatePetToSoldStatus() {
        SoftAssert softAssert = new SoftAssert();

////////Create a pet with available status

        // Parameters
        int expectedStatusCode = HttpStatus.SC_OK;

        // Flow
        petCreationTests.createAvailablePet();
        int createResponseCode = petCreationTests.code;
        availablePetId = petCreationTests.id;

////////

        //Parameters
        String id = availablePetId;
        String categoryId = "10";
        String categoryName = "cats";
        String name = "Figaro";
        String photoUrl = "https://example.com/pet.png";
        String tagId = "10";
        String tagName = "male";
        String status = "sold";// Change the status from available to sold

        //Flow
        putPetRequest = new PutPetRequest();
        putPetRequest.setJsonBody(id, categoryId, categoryName, name, photoUrl, tagId, tagName, status);
        Response response = putPetRequest.executeRequest();

        //Assertions
        Assert.assertEquals(createResponseCode, expectedStatusCode);
        Assert.assertEquals(response.statusCode(), expectedStatusCode);
        softAssert.assertEquals(response.body().jsonPath().get("id").toString(), id, "Validate ID");
        softAssert.assertEquals(response.body().jsonPath().get("category.id").toString(), categoryId, "Validate category ID");
        softAssert.assertEquals(response.body().jsonPath().get("category.name").toString(), categoryName, "Validate category name");
        softAssert.assertEquals(response.body().jsonPath().get("name").toString(), name, "Validate name");
        softAssert.assertEquals(response.body().jsonPath().get("photoUrls[0]").toString(), photoUrl, "Validate photo URL");
        softAssert.assertEquals(response.body().jsonPath().get("tags[0].id").toString(), tagId, "Validate tag ID");
        softAssert.assertEquals(response.body().jsonPath().get("tags[0].name").toString(), tagName, "Validate tag name");
        softAssert.assertEquals(response.body().jsonPath().get("status").toString(), status, "Validate status");
        softAssert.assertAll();
    }
}
