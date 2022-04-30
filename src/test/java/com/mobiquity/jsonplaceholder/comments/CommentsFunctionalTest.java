package com.mobiquity.jsonplaceholder.comments;

import com.mobiquity.jsonplaceholder.BaseAPI;
import com.mobiquity.jsonplaceholder.models.CommentsReqestDTO;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class CommentsFunctionalTest extends BaseAPI {

    private String commentId;
    private String postID = "99";

    @Test
    public void updateCommentonExistingPost() {

            CommentsReqestDTO commentsReqestDTO = CommentsReqestDTO.builder().name("Test Name_Updated").
                    email("validemail@gmail.com").
                    body("Lorem Ipsum is simply dummy text of the printing and typesetting industry").build();

            given().body(commentsReqestDTO).contentType(ContentType.JSON).
                    when().
                    patch("https://jsonplaceholder.typicode.com/comments/99").
                    then().
                    statusCode(200);


    }






}
