ALTER TABLE department_t
    ADD COLUMN parent_id int REFERENCES department_t(id);

ALTER TABLE employee_t
    ADD COLUMN department_id int REFERENCES department_t(id),
    ADD COLUMN profession_id int REFERENCES profession_t(id);