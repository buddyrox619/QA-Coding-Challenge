package com.mobiquity.jsonplaceholder.users;

import com.mobiquity.jsonplaceholder.BaseAPI;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.mobiquity.jsonplaceholder.config.RelativeURI.GET_USER_ALBUMS;
import static com.mobiquity.jsonplaceholder.config.RelativeURI.GET_USER_TODOS;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UsersContractTest extends BaseAPI{


    @Test(description = "Check User Album Model",groups = "contract")
    @Parameters({"userId"})
    public void getUserAlbumsModel(String userId){
        when().
                get(GET_USER_ALBUMS.replace("{UserId}",userId)).
                then().
                body(matchesJsonSchemaInClasspath("schemas/user_albums_simulation.json"));
    }

    @Test(description = "check User-Todo Model",groups = "contract")
    @Parameters({"userId"})
    public void getUserTodosModel(String userId){
        when().
                get(GET_USER_TODOS.replace("{UserId}",userId)).
                then().
                body(matchesJsonSchemaInClasspath("schemas/user_todos_simulation.json"));
    }

}
