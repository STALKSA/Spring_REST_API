DROP TABLE IF EXISTS employee_t;
DROP TABLE IF EXISTS profession_t;
DROP TABLE IF EXISTS department_t;

CREATE TABLE department_t
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    note VARCHAR(50)
);

CREATE TABLE profession_t
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    note VARCHAR(50)
);

CREATE TABLE employee_t
(
    id SERIAL PRIMARY KEY,
    fio VARCHAR(100) NOT NULL,
    note VARCHAR(50)
);