package gorm.demo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(JunkController)
class JunkControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
		def p = new OneToManyOwner(otmoName : "Owner name 1")
		println p.otmoName
    }
}
