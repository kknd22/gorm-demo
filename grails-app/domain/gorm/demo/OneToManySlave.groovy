package gorm.demo

class OneToManySlave { // implements Comparable {
	String otmsName
	int displayOrder
	long owner_id
	
	static belongsTo = [OneToManyOwner]
    
	static constraints = {
    }
	
	static mapping = {
		owner_id column: "OWNER_ID"
	}

	/* if TreeSet in owner
	@Override
	int compareTo(Object other) {
		displayOrder - ((OneToManySlave)other).displayOrder 
	}	
	*/
}
