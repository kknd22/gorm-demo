package gorm.demo

import grails.converters.JSON
import grails.plugin.gson.converters.GSON
import grails.transaction.Transactional

@Transactional
class AController {

    def index() {
		def o = new OneToManyOwner(wn: "owner 1")
		def s1 = new OneToManySlave(sn: "slave 1", displayOrder: 1)
		def s2 = new OneToManySlave(sn: "slave 2", displayOrder: 0)
		o.addToSlaves(s1)
		o.addToSlaves(s2)
		
		o.save(flush : true)
		
		def o2 = new OneToManyOwner(wn: "owner 2")
		def s21 = new OneToManySlave(sn: "slave 21", displayOrder: 1)
		def s22 = new OneToManySlave(sn: "slave 22", displayOrder: 0)
		o2.addToSlaves(s21)
		o2.addToSlaves(s22)
		o2.save(flush : true)

/*		
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
*/
		
		def po1 = OneToManyOwner.findByWn("owner 1") 
		response.contentType = "application/json"
		render po1 as GSON 
		//render ([] << pma1 << pma2 as GSON) 
		//render pma1 as GSON 
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
		o.save(flush:true)
		
		def po1 = OneToManyOwner.findByWn("owner 1UUU")
		response.contentType = "application/json"
		render po1 as GSON
	}
	
	/**
	 * add together
	 * @return
	 */
	def add1() {
		def s = new OneToManySlave(otmsName: "slave 1", displayOrder: 1)
		s.save()
		def o = new OneToManyOwner(otmoName: "owner 1")
		o.addToSlaves(OneToManySlave.findByOtmsName("slave 1"))
		o.save()
		
		def p = OneToManyOwner.findByOtmoName("owner 1")
		response.contentType = "application/json"
		render p as GSON
	}
	
	/**
	 * add slave first then owner
	 */
	def add2() {
		def s = new OneToManySlave(otmsName: "slave 2", displayOrder: 2)
		def o = new OneToManyOwner(otmoName: "owner 2")
		o.addToSlaves(s)
		o.save()
		def p = OneToManyOwner.findByOtmoName("owner 2")
		response.contentType = "application/json"
		render p as GSON
	}

	/**
	 * perist owner then slave first then owner
	 */
	def add3() {
		def o = new OneToManyOwner(otmoName: "owner 3")
		o.save()
		def s = new OneToManySlave(otmsName: "slave 3", displayOrder: 3)
		def p = OneToManyOwner.findByOtmoName("owner 3")
		o.addToSlaves(s)
		p.save()
		
		response.contentType = "application/json"
		render p as GSON
	}

		/**
	 * delete owner to cascade to slave
	 */
	def delete() {
		def p = OneToManyOwner.findByOtmoName("owner 1")
		p.delete()
		
		response.contentType = "application/json"
		render ([f: "owner 1 deleted"] as GSON)
	}
	
	/**
	 * xfer slave from ovwne 1 to owner 2
	 */
	def xfer() {
		def o1 = new OneToManyOwner(otmoName: "owner 10")
		o1.save()
		def s = new OneToManySlave(otmsName: "slave 33", displayOrder: 3)
		def p = OneToManyOwner.findByOtmoName("owner 10")
		o1.addToSlaves(s)
		p.save()
		
		p.removeFromSlaves(s)
		def o2 = new OneToManyOwner(otmoName: "owner 20")
		o2.save()
		o2.addToSlaves(s)
		o2.save()
		p.save()
		def p2 = OneToManyOwner.findByOtmoName("owner 20")
		println("p2.slaves.size: ${p2.slaves.size()}")
		response.contentType = "application/json"
		render p2 as GSON
	}

}



		