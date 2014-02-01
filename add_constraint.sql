alter table one_to_many_owner_one_to_many_slave add constraint FK8B48EB23443FECF foreign key (ONE_TO_MANY_OWNER_SLAVES_ID) references ONE_TO_MANY_OWNER;

mysql:
alter table one_to_many_owner_one_to_many_slave add index FK8BONE_MANY (one_to_many_slave_id), add constraint FK8X_TO_MANY foreign key (one_to_many_owner_slaves_id) references one_to_many_owner (id);
