package gorm.demo

class OneToManyOwner {
	String wn
	
	//List<OneToManySlave> slaves
	SortedSet<OneToManySlave> slaves

/*
 * http://stackoverflow.com/questions/6014484/save-a-model-with-a-relation-onetomany	
 * https://www.altamiracorp.com/blog/employee-posts/let-s-play-who-owns
	
	SortedSet<OneToManySlave> getSlaves() {
		if (this.slaves==null) 
			this.slaves=new TreeSet<OneToManySlave>()
		return this.slaves
	}
	void setSlaves(SortedSet<OneToManySlave> s) {
		getSlaves().clear()
		this.slaves.addAll(s)
	}

 * 
 */
		static hasMany = [slaves : OneToManySlave]
	
	static mapping = {
		slaves column:'OWNER_ID', joinTable: false, lazy: false, cascade: 'all-delete-orphan', nullable: false
		//slaves lazy: false, cascade: 'all-delete-orphan', nullable: false
	}
	
    static constraints = {
    }
}
