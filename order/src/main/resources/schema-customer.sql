DROP TABLE CUSTOMER IF EXISTS;

CREATE TABLE CUSTOMER  (
   ID VARCHAR (36) NOT NULL PRIMARY KEY,
   NAME VARCHAR(30),
   ADDRESS VARCHAR(100)
);