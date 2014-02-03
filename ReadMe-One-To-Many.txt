Hibernate one to many unidirection (from one to many) mapping gotcha notes:

O --- if use foreign key, then
    1. when use list mapping, index won't be populated. So when loading from db, it will have null index exeption
    2. have to save parent first before save child or create parent and child at same time then save parent
    3. won't work for all-delete-orphan
    3. "all" will not at all if delete from one side

O --- if use join table
    1. all-delete-orphan will only work only if use list. e.g. will fail if use Set or SortedSet
    2. if use list, foreign key contrains from the join table to the one side table will be missing. The work around is to add
    the containt manually and the GORM will still function
