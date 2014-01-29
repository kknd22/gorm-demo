package gorm.demo

class OneToManySlave implements Comparable {
	String sn
	int displayOrder

	
	static belongsTo = [OneToManyOwner]
    
	static constraints = {
    }
	


	/* if TreeSet in owner
	*/
	@Override
	int compareTo(Object other) {
		displayOrder - ((OneToManySlave)other).displayOrder 
	}	
}
