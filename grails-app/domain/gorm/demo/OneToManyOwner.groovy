package gorm.demo

class OneToManyOwner {
	String otmoName
	
	List<OneToManySlave> slaves
	//SortedSet<OneToManySlave> slaves
	
	static hasMany = [slaves : OneToManySlave]
	
	static mapping = {
		//slaves column:'OWNER_ID', joinTable: false
		slaves lazy: false, cascade: 'all-delete-orphan'
	}
	
    static constraints = {
    }
}
