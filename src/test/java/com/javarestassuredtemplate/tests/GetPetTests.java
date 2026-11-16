package com.javarestassuredtemplate.tests;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.GetPetRequest;
import com.javarestassuredtemplate.requests.GetPetStatusRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class GetPetTests extends TestBase {

    GetPetRequest getPetRequest;
    GetPetStatusRequest getPetStatusRequest;
    PostPetTests petCreationTests = new PostPetTests();
    String availablePetId;
    String pendingPetId;
    String soldPetId;

    @Test
    public void getAvailablePet(){
        SoftAssert softAssert = new SoftAssert();

////////Create an available pet

        // Parameters
        int expectedStatusCode = HttpStatus.SC_OK;

        // Flow
        petCreationTests.createAvailablePet();
        int availableResponseCode = petCreationTests.code;
        availablePetId = petCreationTests.id;

////////

        //Parameters
        String petId = availablePetId;
        String categoryId = "10";
        String categoryName = "cats";
        String name = "Figaro";
        String photoUrl = "https://example.com/pet.png";
        String tagId = "10";
        String tagName = "male";
        String status = "available";

        //Flow
        getPetRequest = new GetPetRequest(petId);
        Response response = getPetRequest.executeRequest();

        //Assertions
        Assert.assertEquals(availableResponseCode, expectedStatusCode);
        Assert.assertEquals(response.statusCode(), expectedStatusCode);
        softAssert.assertEquals(response.body().jsonPath().get("id").toString(), petId, "Validate ID");
        softAssert.assertEquals(response.body().jsonPath().get("category.id").toString(), categoryId, "Validate category ID");
        softAssert.assertEquals(response.body().jsonPath().get("category.name").toString(), categoryName, "Validate category name");
        softAssert.assertEquals(response.body().jsonPath().get("name").toString(), name, "Validate name");
        softAssert.assertEquals(response.body().jsonPath().get("photoUrls[0]").toString(), photoUrl, "Validate photo URL");
        softAssert.assertEquals(response.body().jsonPath().get("tags[0].id").toString(), tagId, "Validate tag ID");
        softAssert.assertEquals(response.body().jsonPath().get("tags[0].name").toString(), tagName, "Validate tag name");
        softAssert.assertEquals(response.body().jsonPath().get("status").toString(), status, "Validate status");
        softAssert.assertAll();
    }

    @Test
    public void getPendingPet(){
        SoftAssert softAssert = new SoftAssert();

////////Create a pending pet

        //Parameters
        int expectedStatusCode = HttpStatus.SC_OK;

        // Flow
        petCreationTests.createPendingPet();
        int pendingResponseCode = petCreationTests.code;
        pendingPetId = petCreationTests.id;


////////

        //Parameters
        String petId = pendingPetId;
        String categoryId = "10";
        String categoryName = "cats";
        String name = "Matilda";
        String photoUrl = "https://example.com/pet.png";
        String tagId = "10";
        String tagName = "female";
        String status = "pending";

        //Flow
        getPetRequest = new GetPetRequest(petId);
        Response response = getPetRequest.executeRequest();

        //Assertions
        Assert.assertEquals(pendingResponseCode, expectedStatusCode);
        Assert.assertEquals(response.statusCode(), expectedStatusCode);
        softAssert.assertEquals(response.body().jsonPath().get("id").toString(), petId, "Validate ID");
        softAssert.assertEquals(response.body().jsonPath().get("category.id").toString(), categoryId, "Validate category ID");
        softAssert.assertEquals(response.body().jsonPath().get("category.name").toString(), categoryName, "Validate category name");
        softAssert.assertEquals(response.body().jsonPath().get("name").toString(), name, "Validate name");
        softAssert.assertEquals(response.body().jsonPath().get("photoUrls[0]").toString(), photoUrl, "Validate photo URL");
        softAssert.assertEquals(response.body().jsonPath().get("tags[0].id").toString(), tagId, "Validate tag ID");
        softAssert.assertEquals(response.body().jsonPath().get("tags[0].name").toString(), tagName, "Validate tag name");
        softAssert.assertEquals(response.body().jsonPath().get("status").toString(), status, "Validate status");
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void getSoldPet(){
        SoftAssert softAssert = new SoftAssert();

/////// Create a sold pet

        // Parameters
        int expectedStatusCode = HttpStatus.SC_OK;

        // Flow
        petCreationTests.createSoldPet();
        int soldResponseCode = petCreationTests.code;
        soldPetId = petCreationTests.id;

////////

        //Parameters
        String petId = soldPetId;
        String categoryId = "10";
        String categoryName = "cats";
        String name = "Peanut";
        String photoUrl = "https://example.com/pet.png";
        String tagId = "10";
        String tagName = "male";
        String status = "sold";

        //Flow
        getPetRequest = new GetPetRequest(petId);
        Response response = getPetRequest.executeRequest();

        //Assertions
        Assert.assertEquals(soldResponseCode, expectedStatusCode);
        Assert.assertEquals(response.statusCode(), expectedStatusCode);
        softAssert.assertEquals(response.body().jsonPath().get("id").toString(), petId, "Validate ID");
        softAssert.assertEquals(response.body().jsonPath().get("category.id").toString(), categoryId, "Validate category ID");
        softAssert.assertEquals(response.body().jsonPath().get("category.name").toString(), categoryName, "Validate category name");
        softAssert.assertEquals(response.body().jsonPath().get("name").toString(), name, "Validate name");
        softAssert.assertEquals(response.body().jsonPath().get("photoUrls[0]").toString(), photoUrl, "Validate photo URL");
        softAssert.assertEquals(response.body().jsonPath().get("tags[0].id").toString(), tagId, "Validate tag ID");
        softAssert.assertEquals(response.body().jsonPath().get("tags[0].name").toString(), tagName, "Validate tag name");
        softAssert.assertEquals(response.body().jsonPath().get("status").toString(), status, "Validate status");
        softAssert.assertAll();
    }

////////Find pets by status

    @Test
    public void findPetsByAvailableStatus(){
        SoftAssert softAssert = new SoftAssert();

        //Parameters
        int expectedStatusCode = HttpStatus.SC_OK;
        String petStatus = "findByStatus?status=";
        String status = "available";

        //Flow
        getPetStatusRequest = new GetPetStatusRequest(petStatus+status);
        Response response = getPetStatusRequest.executeRequest();

        //Assertions
        Assert.assertEquals(response.statusCode(), expectedStatusCode);
        Assert.assertTrue(response.body().jsonPath().getString("status").contains(status), "Validate status: " + status);
        softAssert.assertAll();
    }

    @Test
    public void findPetsByPendingStatus(){
        SoftAssert softAssert = new SoftAssert();

        //Parameters
        int expectedStatusCode = HttpStatus.SC_OK;
        String petStatus = "findByStatus?status=";
        String status = "pending";

        //Flow
        getPetStatusRequest = new GetPetStatusRequest(petStatus+status);
        Response response = getPetStatusRequest.executeRequest();

        //Assertions
        Assert.assertEquals(response.statusCode(), expectedStatusCode);
        Assert.assertTrue(response.body().jsonPath().getString("status").contains(status), "Validate status: " + status);
        softAssert.assertAll();
    }

    @Test
    public void findPetsBySoldStatus(){
        SoftAssert softAssert = new SoftAssert();

        //Parameters
        int expectedStatusCode = HttpStatus.SC_OK;
        String petStatus = "findByStatus?status=";
        String status = "sold";

        //Flow
        getPetStatusRequest = new GetPetStatusRequest(petStatus+status);
        Response response = getPetStatusRequest.executeRequest();

        //Assertions
        Assert.assertEquals(response.statusCode(), expectedStatusCode);
        Assert.assertTrue(response.body().jsonPath().getString("status").contains(status), "Validate status: " + status);
        softAssert.assertAll();
    }
}
