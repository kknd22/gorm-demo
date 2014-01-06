package gorm.demo

class OneToManyOwner {
	String otmoName
	
	static hasMany = [slaves : OneToManySlave]
    static constraints = {
    }
}
