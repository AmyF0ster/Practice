CREATE TABLE IF NOT EXISTS employee
(
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    position VARCHAR(150) NOT NULL,
    department VARCHAR(100) NOT NULL,
    hiring_date DATE NOT NULL
    );


CREATE TABLE IF NOT EXISTS day_type
(
    day_type_id INT AUTO_INCREMENT PRIMARY KEY,
    day_type VARCHAR(50) NOT NULL UNIQUE
    );


CREATE TABLE IF NOT EXISTS timesheet
(
    record_id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE NOT NULL,
    employee_FK INT NOT NULL,
    hours FLOAT NOT NULL DEFAULT 0,
    day_type_FK INT NOT NULL,

    FOREIGN KEY (employee_FK) REFERENCES employee(employee_id) ON DELETE CASCADE,
    FOREIGN KEY (day_type_FK) REFERENCES day_type(day_type_id) ON DELETE NO ACTION
    );

CREATE TABLE IF NOT EXISTS system_settings
(
    name VARCHAR (100) NOT NULL UNIQUE PRIMARY KEY,
    setting_value VARCHAR(150),
    description VARCHAR(150)
    );

merge into system_settings (name, setting_value, description) values ('normal_day_hours', 8, 'Норма часов в рабочем дне');
merge into system_settings (name, setting_value, description) values ('normal_week_hours', 40, 'Норма часов в рабочей неделе');
