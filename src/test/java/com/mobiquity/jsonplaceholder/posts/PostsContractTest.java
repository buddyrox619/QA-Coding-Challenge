package com.mobiquity.jsonplaceholder.posts;

import com.mobiquity.jsonplaceholder.BaseAPI;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostsContractTest extends BaseAPI {

    @Test
    public void getPostsSimulation(){
        when().
                get("https://jsonplaceholder.typicode.com/posts").
                then().
                body(matchesJsonSchemaInClasspath("schemas/posts_simulation.json"));
    }

    @Test
    public void getPostCommentsSimulation(){
        when().
                get("https://jsonplaceholder.typicode.com/posts/99/comments").
                then().
                body(matchesJsonSchemaInClasspath("schemas/posts_comments_simulation.json"));
    }

}
