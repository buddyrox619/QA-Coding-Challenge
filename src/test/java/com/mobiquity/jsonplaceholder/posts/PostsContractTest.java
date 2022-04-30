package com.mobiquity.jsonplaceholder.posts;

import com.mobiquity.jsonplaceholder.BaseAPI;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.mobiquity.jsonplaceholder.config.RelativeURI.GET_POST_COMMENTS;
import static com.mobiquity.jsonplaceholder.config.RelativeURI.GET_POST_DETAILS;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostsContractTest extends BaseAPI {

    @Test (description = "Validate Posts Model ",groups = "contract")
    public void getPostsSimulation(){
        when().
                get(GET_POST_DETAILS).
                then().
                body(matchesJsonSchemaInClasspath("schemas/posts_simulation.json"));
    }

    @Test (description = "Validate Posts-Comment Model ",groups = "contract")
    @Parameters({"postId"})
    public void getPostCommentsSimulation(String postId){
        when().
                get(GET_POST_COMMENTS.replace("{PostID}",postId)).
                then().
                body(matchesJsonSchemaInClasspath("schemas/posts_comments_simulation.json"));
    }

}
