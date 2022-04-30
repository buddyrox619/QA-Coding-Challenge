package com.mobiquity.jsonplaceholder.comments;

import com.mobiquity.jsonplaceholder.BaseAPI;
import com.mobiquity.jsonplaceholder.models.CommentsReqestDTO;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static com.mobiquity.jsonplaceholder.config.RelativeURI.*;
import static com.mobiquity.jsonplaceholder.config.RelativeURI.GET_POST_COMMENTS;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class CommentsFunctionalTest extends BaseAPI {

    private String commentId;
    private String postID = "99";

    @Test
    public void commentOnExistingPost() {

        CommentsReqestDTO commentsReqestDTO = CommentsReqestDTO.builder().name("Test Name").
                email("validemail@gmail.com").
                body("Lorem Ipsum is simply dummy text of the printing and typesetting industry").build();



        commentId =  given().body(commentsReqestDTO).contentType(ContentType.JSON).
                when().
                post(GET_POST_COMMENTS.replace("{PostID}",postID)).
                then().
                statusCode(201).extract().response().jsonPath().getString("id");


    }

    @Test
    public void updateCommentonExistingPost() {

        CommentsReqestDTO commentsReqestDTO = CommentsReqestDTO.builder().name("Test Name_Updated").
                email("validemail@gmail.com").
                body("Lorem Ipsum is simply dummy text of the printing and typesetting industry").build();

        given().body(commentsReqestDTO).contentType(ContentType.JSON).
                when().
                patch(UPDATE_COMMENT.replace("{CommentID}",commentId)).
                then().
                statusCode(200);


    }

    @Test
    public void deleteAnExistingComment() {

        when().
                delete(DELETE_COMMENT.replace("{CommentID}",commentId)).
                then().
                statusCode(200);


    }


    @Test
    public void InvalidCommentOnExistingPost() {


        CommentsReqestDTO commentsReqestDTO = CommentsReqestDTO.builder().name("Test Name").
                email("validemailgmail.com").
                body("Lorem Ipsum is simply dummy text of the printing and typesetting industry").build();

        given().body(commentsReqestDTO).contentType(ContentType.JSON).
                when().
                post(GET_POST_COMMENTS.replace("{PostID}",postID)).
                then().
                statusCode(400);
    }



    @Test
    public void commentOnNonExistingPost() {

        CommentsReqestDTO commentsReqestDTO = CommentsReqestDTO.builder().name("Test Name").
                email("validemail@gmail.com").
                body("Lorem Ipsum is simply dummy text of the printing and typesetting industry").build();

        given().body(commentsReqestDTO).contentType(ContentType.JSON).
                when().
                post(GET_POST_COMMENTS.replace("{PostID}","1050")).
                then().
                statusCode(400);


    }






}
