package org.petstore.demo.api

import org.hamcrest.Matchers
import org.petstore.demo.util.BaseComponentTest

class PetApiSpec extends BaseComponentTest {

    def "GET /pet/{id} should return 200 OK"() {
        expect:
        client()
                .when()
                .get("/pet/{id}", "1")
                .then()
                .log().all()
                .statusCode(200)
    }

    def "GET /pet/{id} should return 404 Not Found"() {
        expect:
        client()
                .when()
                .get("/pet/{id}", "0")
                .then()
                .log().all()
                .statusCode(404)
                .header("Content-Type", Matchers.is("application/problem+json"))
                .body("detail", Matchers.is("pet resource not found"))
    }

    def "POST /pet should return 400 Bad Request"() {
        expect:
        client()
                .contentType("application/json")
                .accept("application/json")
                .body([:])
                .when()
                .post("/pet")
                .then()
                .log().all()
                .statusCode(400)
                .body("invalid_fields", Matchers.aMapWithSize(2))
                .body("invalid_fields.photoUrls", Matchers.is("must not be null"))
                .body("invalid_fields.name", Matchers.is("must not be null"))
    }

}
