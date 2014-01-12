package gorm.demo

class OneToManyOwner {
	String otmoName
	
	List slaves
	
	static hasMany = [slaves : OneToManySlave]
	
	static mapping = {
		//slaves column:'OWNER_ID', joinTable: false
		slaves cascade: 'all-delete-orphan'
	}
	
    static constraints = {
    }
}
