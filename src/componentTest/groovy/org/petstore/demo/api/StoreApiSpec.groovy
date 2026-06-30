package org.petstore.demo.api

import org.hamcrest.Matchers
import org.petstore.demo.util.BaseComponentTest

class StoreApiSpec extends BaseComponentTest {


    def "DELETE /store/order/{id} should return 200 OK"() {
        expect:
        client()
                .when()
                .delete("/store/order/1")
                .then()
                .log().all()
                .statusCode(200)
    }

    def "DELETE /store/order/{id} should return 404 Not Found"() {
        expect:
        client()
                .when()
                .delete("/store/order/0")
                .then()
                .log().all()
                .statusCode(404)
                .header("Content-Type", Matchers.is("application/problem+json"))
                .body("detail", Matchers.is("order resource not found"))
    }

}
