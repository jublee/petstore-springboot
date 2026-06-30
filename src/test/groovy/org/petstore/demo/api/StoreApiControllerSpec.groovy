package org.petstore.demo.api

import org.petstore.demo.service.OrderService
import spock.lang.Specification
import spock.lang.Subject

class StoreApiControllerSpec extends Specification {

    def orderService = Mock(OrderService)

    @Subject
    def api = new StoreApiController(orderService)

    def "should delete order"() {
        given:
        def order = 1L

        when:
        def res = api.deleteOrder(order)

        then:
        res.statusCode.value() == 200
        interaction {
            1 * orderService.delete(1L)
        }

    }
}
