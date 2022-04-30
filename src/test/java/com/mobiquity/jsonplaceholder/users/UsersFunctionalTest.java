package com.mobiquity.jsonplaceholder.users;

import com.mobiquity.jsonplaceholder.BaseAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.when;

public class UsersFunctionalTest extends BaseAPI {

    @Test
    void verifyUserExists() {

     Response response =  when().get("https://jsonplaceholder.typicode.com/users").
                then().statusCode(200).extract().response();

        Assert.assertNotEquals("", JsonPath.with(response.asString()).
                getString("findAll{it.username == 'Delphine' }.name"));


    }
}
