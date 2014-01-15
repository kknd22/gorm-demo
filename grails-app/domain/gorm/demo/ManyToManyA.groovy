package gorm.demo

class ManyToManyA {
	String mma
	
	static hasMany = [bs: ManyToManyB]
    static constraints = {
    }
	static mapping = {bs lazy: false}
}
