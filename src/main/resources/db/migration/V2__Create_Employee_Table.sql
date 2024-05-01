CREATE TABLE employee (
                          id SERIAL PRIMARY KEY,
                          fio VARCHAR(255),
                          note TEXT,
                          department_id INT,
                          profession_id INT,
                          FOREIGN KEY (department_id) REFERENCES department_t (id),
                          FOREIGN KEY (profession_id) REFERENCES profession_t (id)
);