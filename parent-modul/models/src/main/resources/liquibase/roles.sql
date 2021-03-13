create sequence if NOT exists roles_id_sequence increment by 4;
CREATE TABLE IF NOT EXISTS roles (
    id BIGINT NOT NULL DEFAULT nextval('roles_id_sequence') PRIMARY KEY,
    role_name varchar (60) NOT NULL UNIQUE
    );

insert into roles(role_name) values ('ROLE_ANONYMOUS');
insert into roles(role_name) values ('ROLE_USER');
insert into roles(role_name) values ('ROLE_ADMIN');
insert into roles(role_name) values ('ROLE_EDITOR');

CREATE TABLE IF NOT EXISTS users_roles(
    id BIGSERIAL primary key,
    user_id bigint not null,
    role_id bigint not null,
    foreign key (user_id) REFERENCES users(id),
    foreign key (role_id) REFERENCES roles(id)
);