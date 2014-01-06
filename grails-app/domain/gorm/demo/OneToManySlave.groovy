package gorm.demo

class OneToManySlave {
	String otmsName
	
	static belongsTo = [OneToManyOwner]
    static constraints = {
    }
}
