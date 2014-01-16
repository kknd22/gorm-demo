package gorm.demo

import grails.converters.JSON
import grails.plugin.gson.converters.GSON
import grails.transaction.Transactional

@Transactional
class AController {

    def index() {
		def o = new OneToManyOwner(otmoName: "owner 1")
		def s1 = new OneToManySlave(otmsName: "slave 1", displayOrder: 1)
		def s2 = new OneToManySlave(otmsName: "slave 2", displayOrder: 0)
		//o.slaves = new TreeSet()
		o.slaves = []
		o.slaves << s1
		o.slaves << s2
		
		o.save(flush : true)
		
		def o2 = new OneToManyOwner(otmoName: "owner 2")
		def s21 = new OneToManySlave(otmsName: "slave 2", displayOrder: 1)
		def s22 = new OneToManySlave(otmsName: "slave 2", displayOrder: 0)
		//o.slaves = new TreeSet()
		o2.slaves = []
		o2.slaves << s21
		o2.slaves << s22
		o2.save(flush : true)
		
		def ma1 = new ManyToManyA(mma: "mma 1")
		def ma2 = new ManyToManyA(mma: "mma 2")
		def mb1 = new ManyToManyB(mmb: "mmb 1")
		def mb2 = new ManyToManyB(mmb: "mmb 2")
		
		ma1.addToBs(mb1).addToBs(mb2)
		ma2.addToBs(mb1)
		
		ma1.save(flush: true)
		ma2.save(flush: true)
		def pma1 = ManyToManyA.list().get(0)
		//def pma2 = ManyToManyA.list().get(1)
		
		//def pmb1 = ManyToManyB.list().get(0)
		//def pmb2 = ManyToManyB.list().get(1)
		
		response.contentType = "application/json"
		//render ([] << pma1 << pma2 as GSON) 
		render pma1 as GSON 
		//render ([] << pmb1 << pmb2 as GSON) 
	}

	def dispmm() {
		def pma1 = ManyToManyA.list().get(0)
		response.contentType = "application/json"
		render pma1 as JSON
	}
	
	def owners() {
		def o = OneToManyOwner.list().get(1)
		
		response.contentType = "application/json"
		render o as GSON
		
	}

	def save() {
		def o = new OneToManyOwner(request.GSON)
		o.save()
		response.contentType = "application/json"
		render o as GSON
	}		

	def update() {
		def list = OneToManyOwner.list()
		println "------------->"
		println list.get(0).dump()
		println "<<<-------------"
		
	    println "params.id is ${request.GSON.id}" 

		def o = new OneToManyOwner(request.GSON)
		//o.properties = request.GSON
		o.save()
		
		
		response.contentType = "application/json"
		render o as GSON
	}

}



		