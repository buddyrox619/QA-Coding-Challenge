package com.mobiquity.jsonplaceholder.e2e;

import com.mobiquity.jsonplaceholder.BaseAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.when;

public class E2EWorkflows extends BaseAPI {

    @Test
    void validateCommentsForEachPosts() throws Exception {

        List<String> newList;
        List<String> emailsList;
        String userId;

        try {
            //1. First step would be to querry the given user name and get the userID
            userId = when().get("/users?username=Delphine").
                    then().statusCode(200).extract().response().jsonPath().getString("id[0]");

            //2. Second Step would be retrive all posts related to the user

            Response response = when().get("/posts?userId=" + userId).
                    then().statusCode(200).extract().response();

            List<Integer> postIds = JsonPath.with(response.asString()).getList("id");

            //3. Third Step would be to to iterate through each and every post and validate email in the comment section

            String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

            newList = new ArrayList<String>();
            for (Integer postId : postIds) {

                emailsList = when().get("/posts/" + postId + "/comments").
                        then().statusCode(200).extract().response().jsonPath().getList("email");
                newList.addAll(emailsList);

            }
            List<String> invalidEmails = patternMatches(newList, regexPattern);
            Assert.assertTrue(invalidEmails.isEmpty(), "Invalid Email/s found" + invalidEmails);

        } catch (Exception e) {
            throw e;
        }

    }


}
