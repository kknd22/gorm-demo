package gorm.demo

class ManyToManyB {
	String mmb
	
	//static hasMany = [ManyToManyA]
	static belongsTo = ManyToManyA
	
	static constraints = {
    }

	//static mapping = {aas lazy: false}
    
}
