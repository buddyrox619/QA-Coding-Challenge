package com.mobiquity.jsonplaceholder.comments;

import com.mobiquity.jsonplaceholder.BaseAPI;
import org.testng.annotations.Test;

import static com.mobiquity.jsonplaceholder.config.RelativeURI.GET_ALL_COMMENTS;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CommentsContractTest extends BaseAPI {


    @Test
    public void getPostCommentsSimulation(){

            when().
                    get(GET_ALL_COMMENTS).
                    then().
                    body(matchesJsonSchemaInClasspath("schemas/posts_comments_simulation.json"));

    }

}
