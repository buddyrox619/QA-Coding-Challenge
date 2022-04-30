package com.mobiquity.jsonplaceholder.users;

import com.mobiquity.jsonplaceholder.BaseAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.mobiquity.jsonplaceholder.config.RelativeURI.GET_ALL_USERS;
import static io.restassured.RestAssured.when;

public class UsersFunctionalTest extends BaseAPI {

    @Test (description = "Check User Exist",groups = "functional")
    void verifyUserExists() {

        Response response =  when().get(GET_ALL_USERS).
                then().statusCode(200).extract().response();

        Assert.assertNotEquals("", JsonPath.with(response.asString()).
                getString("findAll{it.username == 'Delphine' }.name"));


    }
}
