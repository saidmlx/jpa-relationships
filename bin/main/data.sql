
DROP TABLE IF  EXISTS USERS; 
CREATE TABLE USERS(id bigint auto_increment, NAME VARCHAR(255) DEFAULT '');
INSERT INTO USERS (NAME) VALUES ('Melissa');
INSERT INTO USERS (NAME) VALUES ('Fernando');



DROP TABLE IF  EXISTS TASKS; 
CREATE TABLE TASKS(ID bigint auto_increment, DESCRIPTION VARCHAR(255) null, PRIORITY bigint null);
INSERT INTO TASKS (DESCRIPTION, PRIORITY) VALUES ('Wake up',1);
INSERT INTO TASKS (DESCRIPTION, PRIORITY) VALUES ('Take a shower',2);


DROP TABLE IF  EXISTS USERS_TASKS; 
CREATE TABLE USERS_TASKS(id bigint auto_increment, ID_USER bigint null, ID_TASK bigint null );
INSERT INTO USERS_TASKS (ID_USER,ID_TASK) VALUES (1,1);
INSERT INTO USERS_TASKS (ID_USER,ID_TASK) VALUES (2,1);