/* source C:/CP FS-A1 2027/Unit-V/stu_cou_inst.sql;
source C:/CP FS-A1 2027/Unit-V/08_04_2026/stu_cou_inst.sql; */
USE Stu_cou_inst;

/* current database */
SELECT DATABASE();

DROP DATABASE IF EXISTS Stu_cou_inst;
CREATE DATABASE Stu_cou_inst;
USE Stu_cou_inst;

SHOW TABLES;

DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS instructor;
DROP TABLE IF EXISTS student_course;
DROP TABLE IF EXISTS course_instructor;

CREATE TABLE student (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100) NOT NULL,
    mobile_number VARCHAR(15)
);


CREATE TABLE course (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100),
    units DECIMAL(5,2)
);

CREATE TABLE instructor (
    instructor_id INT PRIMARY KEY,
    instructor_name VARCHAR(100),
    instructor_mobile VARCHAR(15)
);

CREATE TABLE student_course (
    student_id INT,
    course_id INT,
    PRIMARY KEY (student_id, course_id),
	FOREIGN KEY (student_id) REFERENCES student(student_id),
    FOREIGN KEY (course_id) REFERENCES course(course_id)
);

CREATE TABLE course_instructor (
    course_id INT,
    instructor_id INT,
	PRIMARY KEY (course_id, instructor_id),
    FOREIGN KEY (course_id) REFERENCES course(course_id),
	FOREIGN KEY (instructor_id) REFERENCES instructor(instructor_id) 
);

INSERT INTO student VALUES (1, 'Ravi Kumar', '9876543210');
INSERT INTO student VALUES (2, 'Anjali Sharma', '9123456780');
INSERT INTO student VALUES (3, 'Suresh Reddy', '9012345678');
INSERT INTO student VALUES (4, 'Priya Singh', '9988776655');
INSERT INTO student VALUES (5, 'Kiran Patel', '9090909090');

INSERT INTO instructor VALUES (201, 'Prof. Kavitha Rao', '9123402222');
INSERT INTO instructor VALUES (202, 'Dr. Manish Gupta', '9012303333');
INSERT INTO instructor VALUES (203, 'Prof. Lakshmi Devi', '9988704444');
INSERT INTO instructor VALUES (204, 'Dr. Rakesh Sharma', '9090805555');
INSERT INTO instructor VALUES (205, 'Prof. Sunita Reddy', '9871206666');

INSERT INTO course VALUES (301, 'Database Management Systems', 4.00);
INSERT INTO course VALUES (302, 'Operating Systems', 3.50);
INSERT INTO course VALUES (303, 'Computer Networks', 3.00);
INSERT INTO course VALUES (304, 'Data Structures', 4.50);
INSERT INTO course VALUES (305, 'Software Engineering', 3.00);
INSERT INTO course VALUES (306, 'Artificial Intelligence', 4.00);

INSERT INTO student_course VALUES (1, 301);
INSERT INTO student_course VALUES (1, 303);
INSERT INTO student_course VALUES (1, 305);

INSERT INTO student_course VALUES (2, 302);

INSERT INTO student_course VALUES (3, 303);
INSERT INTO student_course VALUES (3, 301);
INSERT INTO student_course VALUES (3, 302);
INSERT INTO student_course VALUES (3, 305);

INSERT INTO student_course VALUES (4, 303);
INSERT INTO student_course VALUES (4, 305);

INSERT INTO course_instructor VALUES (301, 201);
INSERT INTO course_instructor VALUES (302, 202);
INSERT INTO course_instructor VALUES (303, 203);
INSERT INTO course_instructor VALUES (304, 204);
INSERT INTO course_instructor VALUES (305, 201);

select * from student;
select * from course;
select * from instructor;
select * from student_course;
select * from course_instructor;
