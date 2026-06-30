package org.petstore.demo.api

import org.petstore.demo.util.BaseComponentTest

class GETHealthSpec extends BaseComponentTest {

    def "GET /actuator/health should return 200 OK"() {
        expect:
        client().when().get("/actuator/health").then().log().all().statusCode(200)
    }

    def "GET /actuator/health/liveness should return 200 OK"() {
        expect:
        client().when().get("/actuator/health/liveness").then().log().all().statusCode(200)
    }


    def "GET /actuator/health/readiness should return 200 OK"() {
        expect:
        client().when().get("/actuator/health/readiness").then().log().all().statusCode(200)
    }

}
