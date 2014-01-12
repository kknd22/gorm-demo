package gorm.demo

class OneToManySlave implements Comparable {
	String otmsName
	int displayOrder
	
	static belongsTo = [OneToManyOwner]
    
	static constraints = {
    }

	@Override
	int compareTo(Object other) {
		displayOrder - ((OneToManySlave)other).displayOrder 
	}	
	
}
