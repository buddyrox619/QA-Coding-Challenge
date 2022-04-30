package com.mobiquity.jsonplaceholder.posts;

import com.mobiquity.jsonplaceholder.BaseAPI;
import com.mobiquity.jsonplaceholder.models.PostsRequestDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.mobiquity.jsonplaceholder.config.RelativeURI.GET_POST_DETAILS;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PostsFunctionalTest extends BaseAPI {

    @Test
    public void getAllPosts(){

        Response response =  when().get(GET_POST_DETAILS).
                then().statusCode(200).extract().response();
        int count = response.jsonPath().getInt("Search.size()");
        Assert.assertEquals(count, 100);

    }

    @Test
    public void createPost() {

        PostsRequestDTO postsRequestDTO = PostsRequestDTO.builder().userId(1).title("This is a Test Post").
                body("Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                             "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s").build();

        given().body(postsRequestDTO).contentType(ContentType.JSON).
                when().
                post(GET_POST_DETAILS).
                then().
                statusCode(201);

    }

}
