package com.mobiquity.jsonplaceholder.posts;

import com.mobiquity.jsonplaceholder.BaseAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class PostsFunctionalTest extends BaseAPI {

    @Test
    public void getAllPosts(){

        Response response =  when().get("https://jsonplaceholder.typicode.com/posts").
                then().statusCode(200).extract().response();
        int count = response.jsonPath().getInt("Search.size()");
        Assert.assertEquals(count, 100);

    }

}
