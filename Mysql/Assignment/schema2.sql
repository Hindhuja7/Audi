USE test;

/* current database */
SELECT DATABASE();

DROP DATABASE IF EXISTS catalog;
CREATE DATABASE catalog;
USE catalog;

SHOW TABLES;

DROP TABLE IF EXISTS supplier;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS supprodproj;

CREATE TABLE supplier(
  supNo varchar(20) primary key,
  supName varchar(20) not null,
  supStatus int(2) not null,
  supCity varchar(20) not null
);

CREATE TABLE products(
  prodNo varchar(20) primary key,
  prodName varchar(20) not null,
  prodVer decimal(5,2) not null,
  prodCity varchar(20) not null
);

CREATE TABLE project(
  jobNo varchar(20) primary key,
  jobName varchar(20) not null,
  jobCity varchar(20) not null
);

CREATE TABLE supprodproj(
  supNo varchar(20) not null,
  prodNo varchar(20) not null,
  jobNo varchar(20) not null,
  quantity int(2) not null
);

ALTER TABLE supprodproj ADD CONSTRAINT fk_SupNo FOREIGN KEY (supNo) 
  REFERENCES supplier (supNo);

ALTER TABLE supprodproj ADD CONSTRAINT fk_prodNo FOREIGN KEY (prodNo) 
  REFERENCES products (prodNo);

ALTER TABLE supprodproj ADD CONSTRAINT fk_jobNo FOREIGN KEY (jobNo) 
  REFERENCES project (jobNo);

insert into supplier values ('s1','Sonata Software',20, 'Hyderabad');
insert into supplier values ('s2','Wipro Tech',10, 'Bangalore');
insert into supplier values ('s3','Hexaware InfoSystems',30, 'Chennai');
insert into supplier values ('s4','Jay Traders',50, 'Hyderabad');
insert into supplier values ('s5','Sunil Distributor',20, 'Bangalore');

insert into products values ('p1','MySql',2.0, 'Bangalore');
insert into products values ('p2','Sql Server',7.0, 'Hyderabad');
insert into products values ('p3','Windows OS',8.0, 'Chennai');
insert into products values ('p4','Informix',5.0, 'Bangalore');
insert into products values ('p5','Adobe',4.0, 'Bangalore');

insert into project values ('j1','ERP','Bangalore');
insert into project values ('j2','Accounting','Chennai');
insert into project values ('j3','UI','Hyderabad');
insert into project values ('j4','Sales','Hyderabad');
insert into project values ('j5','CMS','Bangalore');
insert into project values ('j6','Testing','Chennai');

insert into supprodproj values ('s1','p1','j1', 1);
insert into supprodproj values ('s1','p1','j4', 2);
insert into supprodproj values ('s2','p2','j5', 3);
insert into supprodproj values ('s1','p2','j1', 1);
insert into supprodproj values ('s3','p2','j1', 3);
insert into supprodproj values ('s3','p2','j2', 2);
insert into supprodproj values ('s4','p4','j1', 3);
insert into supprodproj values ('s4','p4','j2', 1);
insert into supprodproj values ('s5','p1','j3', 1);
insert into supprodproj values ('s5','p2','j4', 2);
insert into supprodproj values ('s5','p3','j5', 3);
