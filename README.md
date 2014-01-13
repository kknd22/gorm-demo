gorm-demo
=========

test some gorm features


Why unidirectional one-to-many association on a foreign key is an unusual case and is not recommended?

http://stackoverflow.com/questions/7916221/why-unidirectional-one-to-many-association-on-a-foreign-key-is-an-unusual-case-a

The reason is that your mapping declares that the many side of the relationship knows nothing about its parent. However in database terms that entity has the foreign key to the one side and does know about its parent. Therefore your mapping and database structure do not agree.

Having a join table eliminates that mismatch.
