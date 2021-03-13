CREATE SCHEMA IF NOT EXISTS modular;
set schema 'modular';
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
ALTER DATABASE crud SET timezone TO 'EUROPE/ISTANBUL';
CREATE SEQUENCE IF NOT EXISTS modular.hibernate_sequence;