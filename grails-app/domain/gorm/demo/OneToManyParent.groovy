package gorm.demo

class OneToManyParent {
	String otmp
	
	static hasMany = [kids : OneToManyChild]
	
	static mapping = {
		kids column:'PARENT_ID', joinTable: false
	}
	
    static constraints = {
    }
}
