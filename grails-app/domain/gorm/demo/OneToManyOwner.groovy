package gorm.demo

class OneToManyOwner {
	String wn
	
	List<OneToManySlave> slaves
	
	/*
	 * http://stackoverflow.com/questions/6014484/save-a-model-with-a-relation-onetomany	
	 * https://www.altamiracorp.com/blog/employee-posts/let-s-play-who-owns
	 * if not use list, but use this then: ibernateException occurred when processing request: [POST] /gorm-demo/a/update
	 * A collection with cascade="all-delete-orphan" was no longer referenced by the owning entity instance: gorm.demo.OneToManyOwner.slaves. Stacktrace follows:
	 * Message: A collection with cascade="all-delete-orphan" was no longer referenced by the owning entity instance: gorm.demo.OneToManyOwner.slaves
	 */
	//SortedSet<OneToManySlave> slaves

	static hasMany = [slaves : OneToManySlave]
	static mapping = {
		/**
		 * you will see this this mapping is used
		 * when processing request: [POST] /gorm-demo/a/update null index column for collection: gorm.demo.OneToManyOwner.slaves.
		 */
		//slaves column:'OWNER_ID', joinTable: false, lazy: false, cascade: 'all-delete-orphan'
		slaves lazy: false, cascade: 'all-delete-orphan'
	}
	
    static constraints = {
    }
}
