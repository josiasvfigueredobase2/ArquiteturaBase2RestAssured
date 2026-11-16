package com.javarestassuredtemplate.tests;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.PostPetRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Random;

public class PostPetTests extends TestBase {
    PostPetRequest postPetRequest;
    SoftAssert softAssert = new SoftAssert();

    String id;
    int code;
    @Test
    public void createAvailablePet() {

// Create a pet with available status
        Random random = new Random();
        int id1 = random.nextInt(99);
        String availablePetId = Integer.toString(id1);

        //Parameters
        id = availablePetId;
        int expectedStatusCode = HttpStatus.SC_OK;
        String categoryId = "10";
        String categoryName = "cats";
        String name = "Figaro";
        String photoUrl = "https://example.com/pet.png";
        String tagId = "10";
        String tagName = "male";
        String status = "available";

        //Flow
        postPetRequest = new PostPetRequest();
        postPetRequest.setJsonBody(id, categoryId, categoryName, name, photoUrl, tagId, tagName, status);
        Response response = postPetRequest.executeRequest();
        code = response.statusCode();

        //Assertions
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
        @Test
        public void createPendingPet() {

            // Create a pet with pending status
            Random random = new Random();
            int id2 = random.nextInt(99);
            String pendingPetId = Integer.toString(id2);


            //Parameters
            id = pendingPetId;
            int expectedStatusCode = HttpStatus.SC_OK;
            String categoryId = "10";
            String categoryName = "cats";
            String name = "Matilda";
            String photoUrl = "https://example.com/pet.png";
            String tagId = "10";
            String tagName = "female";
            String status = "pending";

            //Flow
            postPetRequest = new PostPetRequest();
            postPetRequest.setJsonBody(id, categoryId, categoryName, name, photoUrl, tagId, tagName, status);
            Response response = postPetRequest.executeRequest();
            code = response.statusCode();

            //Assertions
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

    @Test
    public void createSoldPet() {
// Create a pet with sold status

        Random random = new Random();
        int id3 = random.nextInt(99);
        String soldPetId = Integer.toString(id3);

        //Parameters
        id = soldPetId;
        int expectedStatusCode = HttpStatus.SC_OK;
        String categoryId = "10";
        String categoryName = "cats";
        String name = "Peanut";
        String photoUrl = "https://example.com/pet.png";
        String tagId = "10";
        String tagName = "male";
        String status = "sold";

        //Flow
        postPetRequest = new PostPetRequest();
        postPetRequest.setJsonBody(id, categoryId, categoryName, name, photoUrl, tagId, tagName, status);
        Response response = postPetRequest.executeRequest();
        code = response.statusCode();

        //Assertions
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

