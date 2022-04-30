package com.mobiquity.jsonplaceholder.users;

import com.mobiquity.jsonplaceholder.BaseAPI;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UsersContractTest extends BaseAPI{


    @Test
    public void getUserAlbumsModel(){
        when().
                get("https://jsonplaceholder.typicode.com/users/1/albums").
                then().
                body(matchesJsonSchemaInClasspath("schemas/user_albums_simulation.json"));
    }

    @Test
    public void getUserTodosModel(){
        when().
                get("https://jsonplaceholder.typicode.com/users/1/todos").
                then().
                body(matchesJsonSchemaInClasspath("schemas/user_todos_simulation.json"));
    }

}
