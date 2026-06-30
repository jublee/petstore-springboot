package org.petstore.demo.util

import io.restassured.RestAssured
import org.petstore.demo.Application
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import spock.lang.Specification

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, useMainMethod = SpringBootTest.UseMainMethod.ALWAYS)
class BaseComponentTest extends Specification {

    @LocalServerPort
    public int port

    def client() {
        return RestAssured.given().baseUri("http://localhost:${port}")
    }
}
