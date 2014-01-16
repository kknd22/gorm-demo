import grails.converters.JSON
import grails.plugin.gson.converters.GSON

class BootStrap {

    def init = { servletContext ->
		/*JSON.registerObjectMarshaller(gorm.demo.ManyToManyA) {
			def map =[:]
			map << [a: "aaaa --- ${it.mma}"]
			map << [b: "bbb"]
			return map
		}*/
    }
    def destroy = {
    }
}
