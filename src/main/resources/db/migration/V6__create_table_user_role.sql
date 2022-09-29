create table user_role(
    id bigint not null autoincrement,
    user_id bigint not null,
    role_id bigint not null,
    primary key(id),
    foreign key(user_id) references users (id),
    foreign key(role_id) references role (id)
);

INSERT INTO user_role(id, user_id, role_id) values(1, 1, 1);