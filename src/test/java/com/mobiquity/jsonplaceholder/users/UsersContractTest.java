package com.mobiquity.jsonplaceholder.users;

import com.mobiquity.jsonplaceholder.BaseAPI;
import org.testng.annotations.Test;

import static com.mobiquity.jsonplaceholder.config.RelativeURI.GET_USER_ALBUMS;
import static com.mobiquity.jsonplaceholder.config.RelativeURI.GET_USER_TODOS;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UsersContractTest extends BaseAPI{


    @Test
    public void getUserAlbumsModel(){
        when().
                get(GET_USER_ALBUMS.replace("{UserId}","1")).
                then().
                body(matchesJsonSchemaInClasspath("schemas/user_albums_simulation.json"));
    }

    @Test
    public void getUserTodosModel(){
        when().
                get(GET_USER_TODOS.replace("{UserId}","1")).
                then().
                body(matchesJsonSchemaInClasspath("schemas/user_todos_simulation.json"));
    }

}
