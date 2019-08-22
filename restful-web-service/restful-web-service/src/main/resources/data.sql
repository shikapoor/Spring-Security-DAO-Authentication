insert into Todo(task_id,task_name,target_date,is_complete) values(1, 'Learning java 8', sysdate(),false);

insert into Todo(task_id,task_name,target_date,is_complete) values(2, 'Learning Angular', sysdate(),false);

insert into Todo(task_id,task_name,target_date,is_complete) values(3, 'Learning Spring', sysdate(),false);

insert into Todo(task_id,task_name,target_date,is_complete) values(4, 'Learning Spring Boot', sysdate(),false);

insert into Todo(task_id,task_name,target_date,is_complete) values(5, 'Learning JPA', sysdate(),false);


INSERT INTO authority(name, id) VALUES ('ROLE_ADMIN', 1);
INSERT INTO authority(name, id) VALUES ('ROLE_USER', 2);

INSERT INTO user (id, username, password) VALUES (1,'ironman','$2a$10$C/./gM2J/WVcuFVNHkBMP.aGGlWtyv7vc1vuCm0LvmIg9h8BUVQ7u');
INSERT INTO user (id, username, password) VALUES (2,'rabi','$2a$10$C/./gM2J/WVcuFVNHkBMP.aGGlWtyv7vc1vuCm0LvmIg9h8BUVQ7u');

INSERT INTO user_authority(authority_id, user_id) VALUES (1, 1);
INSERT INTO user_authority(authority_id, user_id) VALUES (2, 2);