create database	bootcamp_2604;

use bootcamp_2604;

create table users (
    id bigint,
    first_name varchar(50),
    last_name varchar(50),
    gender varchar(1),
    salary decimal(13,2),
    login_time datetime,
    dob date
);

select * from users;

delete from users;
insert into users (id, first_name, last_name, gender, salary, login_time, dob)
values (1, 'John', 'Lau', 'M', 28000, now(), '1998-10-02');
insert into users (id, first_name, last_name, gender, salary, login_time, dob)
values (2, 'Sally', 'Lau', 'F', 15000, now(), '1980-01-02');
insert into users (id, first_name, last_name, gender, salary, login_time, dob)
values (3, 'Jennie', 'Chan', 'F', 40000, now(), '1990-12-31');
insert into users (id, first_name, last_name, gender, salary, login_time, dob)
values (4, 'Tommy', 'Lau', 'F', 24000, now(), '2000-03-02');
insert into users (id, first_name, last_name, gender, salary, login_time, dob)
values (5, 'Kennny', 'Chan', 'F', 50000, now(), '1990-11-29');

select * from users where last_name = 'Lau';

-- where -> and or
select * from users where salary > 16000 and (gender = 'M' or length(first_name) > 4);
select * from users where salary > 16000 or gender = 'M';

-- * means all columns
select first_name, last_name, salary, gender from users;

-- alias
select u.* from users u;
select u.login_time, u.first_name, u.* from users u;

-- SQL statement Case incensitive (Small = Capital Letter)

-- Field Value: case in-censitive (MYSQL)
-- Field Value: case censitive (Oracle, Postgres)
select * from users where first_name = 'John'; -- MySQL
select * from users where upper(first_name) = 'JOHN'; 

-- group by
select * from users;
select avg(salary) from users group by gender; -- select information from group 

-- Group Data
select salary from users group by gender; -- wrong

select 'hello', u.* from users u;

select gender, min(salary), max(salary), avg(salary), sum(salary), count(1) from users -- SQL step 4
where salary > 20000 -- SQL step 1 (Filter Data Row)
group by gender -- SQL step 2 
having max(salary) > 30000; -- SQL step 3 (Filter Group after grouping) -> check any row value 

-- offer name, price, exact locaiton, region -> group by region (which region is the highest sales) -> having order > 3000 (count)
-- min, max, group by yy-mm
-- group by region

-- 1 ms -> 1/1000s
-- 0.0060 -> 0.6 ms

-- Like
-- Find user where first name start with l
select * from users where last_name Like 'l%';
select * from users where first_name Like '%o%';
select * from users where first_name not like '%o%';

-- Between
select * 
from users 
where login_time not between str_to_date('2026-06-13 20:00:00', '%Y-%m-%d $H:%i:%s')
	and str_to_date('2026-06-13 20:00:00', '%Y-%m-%d $H:%i:%s');
    
select * 
from users 
where login_time between str_to_date('1900-01-01', '%Y-%m-%d')
	and str_to_date('2026-06-14', '%Y-%m-%d');
    
-- in (or)
select * 
from users
where last_name in ('Lau', 'Wong');

-- not (not in, not between, not exists, etc)
select * 
from users
where last_name in ('Lau', 'Wong');

-- create table (AL, SL)
CREATE TABLE leave_application (
    id BIGINT,
    leave_type VARCHAR(2), -- 'AL' or 'SL'
    apply_time datetime,        -- Date when leave was applied
    user_id BIGINT
);

INSERT INTO leave_application (id, leave_type, apply_time, user_id)
VALUES (1, 'AL', '2026-06-13 09:30:00', 2);
INSERT INTO leave_application (id, leave_type, apply_time, user_id)
VALUES (2, 'AL', '2026-06-13 09:30:00', 3);
INSERT INTO leave_application (id, leave_type, apply_time, user_id)
VALUES (3, 'SL', '2026-06-13 09:30:00', 4);

-- Exists
-- Find users whose applied AL
select u.*
from users u
where exists (
	select l.* from leave_application l where u.id = l.user_Id and l.leave_type = 'AL'
);

-- Find users whose did not applied SL
SELECT u.*
FROM users u
WHERE NOT EXISTS (
    SELECT l.* FROM leave_application l 
    WHERE u.id = l.user_id 
    AND l.leave_type = 'SL' 
    AND l.apply_time BETWEEN STR_TO_DATE('2026-05-01 00:00:00', '%Y-%m-%d %H:%i:%s') 
    AND STR_TO_DATE('2026-05-31 23:59:59', '%Y-%m-%d %H:%i:%s')
);

-- 步驟 1：刪除表格（正確順序：先刪子表，再刪父表）
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;

-- 步驟 2：建立表格（正確順序：先建父表，再建子表）
CREATE TABLE departments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    dep_name VARCHAR(30) NOT NULL,
    dep_location VARCHAR(40) NOT NULL
);

CREATE TABLE employees (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(20) NOT NULL,
    department_id BIGINT,  -- ✅ 先定義這個欄位！
    FOREIGN KEY (department_id) REFERENCES departments (id)  -- ✅ 再用它來當外鍵
);

-- 步驟 3：插入部門資料
INSERT INTO departments (dep_name, dep_location) 
VALUES 
    ('IT', 'Hong Kong'),
    ('HR', 'Japan');

-- 步驟 4：插入員工資料（正確寫法）
INSERT INTO employees (emp_name, department_id) 
VALUES 
    ('John', 1),    -- ✅ John 在 IT 部門 (ID=1)
    ('Mary', 2),    -- ✅ Mary 在 HR 部門 (ID=2)
    ('Johnny', 1),  -- ✅ Johnny 也在 IT 部門
    ('Jennie', NULL); -- ✅ Jennie 還沒有部門

-- inner join
select e.emp_name, d.dep_location
from employees e inner join departments d on e.department_id = d.id
where dep_name = 'IT';

-- 步驟 5：查看結果
SELECT * FROM departments;
SELECT * FROM employees;