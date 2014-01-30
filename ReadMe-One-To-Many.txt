Hibernate one to many mapping gotcha notes:

O --- if use foreign key, then
    1. when use list mapping, index won't be populated. So when load from db, it will have null index exeption
    2. have to save parent first before save child or create parent and child at same time then save parent
    3. won't work for all-delete-orphan

O --- if use join table
    1. all-delete-orphan will only work if use list
