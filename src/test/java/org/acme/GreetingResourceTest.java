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
@Epic("CustomerService")
@Feature("GreetingCustomer")
public class GreetingResourceTest {

    @Test
    @Story("Validate if the service say hello even before identifying the customer")
    public void testHelloEndpoint() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello from RESTEasy Reactive"));
    }

    @Test
    @Story("Validate if the service personlise the greetings after the customer login.")
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