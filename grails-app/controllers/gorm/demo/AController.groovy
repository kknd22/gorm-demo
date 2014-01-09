package gorm.demo

import grails.transaction.Transactional
@Transactional
class AController {

    def index() {
	/*
			def o = new OneToManyOwner(otmoName: "owner 1")
		def s1 = new OneToManySlave(otmsName: "slave 1")
		def s2 = new OneToManySlave(otmsName: "slave 2")
		o.slaves = new HashSet()
		o.slaves.add(s1)
		o.slaves.add(s2)
		
		o.save(flush : true)
	*/	

		def p = new OneToManyParent(otmp: "parent 1")
		def k1 = new OneToManyChild(otmc: "kid 1")
		def k2 = new OneToManyChild(otmc: "kid 2")
		p.kids = new HashSet()
		p.kids.add(k1)
		p.kids.add(k2)
		
		p.save(flush : true)
		
		render (contentType:"text/json") {
			//owner : o 
			parent : p
		}
	}
}

