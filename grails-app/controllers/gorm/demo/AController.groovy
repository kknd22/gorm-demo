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
	/*
	

		def p = new OneToManyParent(otmp: "parent 1")
		def k1 = new OneToManyChild(otmc: "kid 1")
		def k2 = new OneToManyChild(otmc: "kid 2")
		p.kids = new HashSet()
		p.kids.add(k1)
		p.kids.add(k2)
		
		p.save(flush : true)
	*/	
		response.contentType = "application/json"
		render o as GSON 
	}

	def owners() {
		def o = OneToManyOwner.list().get(0)
		
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



		