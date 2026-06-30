package org.petstore.demo.wiremock

import io.restassured.RestAssured
import spock.lang.Specification

class WiremockSpec extends Specification {

    def "DELETE /api/v1/orders/{id} should return 200 OK"() {
        expect:
        RestAssured.given()
                .baseUri(System.getProperty("wiremock.host"))
                .log().all()
                .when()
                .delete("/api/v1/orders/1")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
    }
}
