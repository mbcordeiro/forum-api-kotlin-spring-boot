create table users(
    id bigint not null auto_increment,
    name varchar(50) not null,
    email varchar(50) not null,
    primary key(id)
);

insert into users values(1, 'Matheus Cordeiro', 'matheus.cordeiro@email.com');