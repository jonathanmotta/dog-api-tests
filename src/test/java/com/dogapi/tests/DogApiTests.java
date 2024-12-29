package com.dogapi.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class DogApiTests {

    private static final String BASE_URL = "https://dog.ceo/api";

    /*
     * Endpoint 1:
     * GET /breeds/list/all
     */
    @Test
    public void testListAllBreedsPositive() {
        RestAssured.given()
                .when()
                .get(BASE_URL + "/breeds/list/all")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", notNullValue())
                .body("message.size()", greaterThan(0));
    }

    @Test
    public void testListAllBreedsInvalidEndpointNegative() {
        RestAssured.given()
                .when()
                .get(BASE_URL + "/breeds/list/all-invalid")
                .then()
                .statusCode(404)
                .body("status", equalTo("error"))
                .body("message", notNullValue());
    }

    /*
     * Endpoint 2:
     * GET /breed/{breed}/images
     */
    @Test
    public void testAllImagesByBreedPositive() {
        String breed = "bulldog";

        RestAssured.given()
                .when()
                .get(BASE_URL + "/breed/" + breed + "/images")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", notNullValue())
                .body("message", everyItem(containsString("https://")));
    }

    @Test
    public void testAllImagesByInvalidBreedNegative() {
        String invalidBreed = "invalid-breed";

        RestAssured.given()
                .when()
                .get(BASE_URL + "/breed/" + invalidBreed + "/images")
                .then()
                .statusCode(404)
                .body("status", equalTo("error"))
                .body("message", containsString("Breed not found"));
    }

    /*
     * Endpoint 3:
     * GET /breeds/image/random
     */
    @Test
    public void testRandomImagePositive() {
        RestAssured.given()
                .when()
                .get(BASE_URL + "/breeds/image/random")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", containsString("https://"));
    }

    @Test
    public void testRandomImageInvalidEndpointNegative() {
        RestAssured.given()
                .when()
                .get(BASE_URL + "/breeds/image/random-invalid")
                .then()
                .statusCode(404)
                .body("status", equalTo("error"))
                .body("message", notNullValue());
    }
}
