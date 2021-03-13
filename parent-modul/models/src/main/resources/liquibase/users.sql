create sequence if NOT exists users_id_sequence increment by 20;
CREATE TABLE IF NOT EXISTS users (
    id BIGINT NOT NULL DEFAULT nextval('users_id_sequence') PRIMARY KEY,
    user_uuid uuid NOT NULL,
    created_by varchar (25) DEFAULT '-',
    created_date TIMESTAMP DEFAULT now(),
    last_modified_by varchar (25) DEFAULT '-',
    last_modified_date TIMESTAMP,
    username varchar (25),
    email varchar (100) UNIQUE,
    first_name varchar (100),
    surname varchar (100),
    password varchar (255),
    status varchar (25)
    );