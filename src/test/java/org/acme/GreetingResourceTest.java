package org.acme;

import io.qameta.allure.Story;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.qameta.allure.Feature;
import io.qameta.allure.Epic;


@QuarkusTest
@Epic("CoolService")
@Feature("BusinessFunction")
public class GreetingResourceTest {

    @Test
    @DisplayName("Testing the Hello HTTP call")
    @Story("TestsHello endpoint and validates it against a staic string")
    public void testHelloEndpoint() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello from RESTEasy Reactive"));
    }

    @Test
    @DisplayName("Testing the Greetings HTTP call")
    @Story("Tests Greeting endpoint and validates that passed name is returned in the response")
    public void testGreetingEndpoint() {
        String uuid = UUID.randomUUID().toString();
        given()
                .pathParam("name", uuid)
                .when().get("/hello/greeting/{name}")
                .then()
                .statusCode(400)
                .body(is("hello " + uuid));
    }

}