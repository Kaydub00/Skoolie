/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  kevinw
 * Created: Mar 20, 2016
 */

INSERT INTO USR_ROLES
VALUES
('ROLE_TEACHER'),
('ROLE_STUDENT'),
('ROLE_SCHOOL_ADMIN'),
('ROLE_DISTRICT_ADMIN'),
('ROLE_PARENT'),
('ROLE_SYSTEM');


INSERT INTO USR_GROUPS (`GROUP`) VALUES
('GRP_TEACHER'),
('GRP_STUDENT'),
('GRP_SCHOOL_ADMIN'),
('GRP_DISTRICT_ADMIN'),
('GRP_PARENT'),
('GRP_SYSTEM');

INSERT INTO USR_GROUP_ROLES (GROUP_ID,ROLE)
VALUES 
((SELECT `GROUP` FROM USR_GROUPS G WHERE G.GROUP = 'GRP_SYSTEM') ,'ROLE_SYSTEM'),
((SELECT `GROUP` FROM USR_GROUPS G WHERE G.GROUP = 'GRP_TEACHER') ,'ROLE_TEACHER'),
((SELECT `GROUP` FROM USR_GROUPS G WHERE G.GROUP = 'GRP_STUDENT') ,'ROLE_STUDENT'),
((SELECT `GROUP` FROM USR_GROUPS G WHERE G.GROUP = 'GRP_SCHOOL_ADMIN') ,'ROLE_SCHOOL_ADMIN'),
((SELECT `GROUP` FROM USR_GROUPS G WHERE G.GROUP = 'GRP_DISTRICT_ADMIN') ,'ROLE_DISTRICT_ADMIN'),
((SELECT `GROUP` FROM USR_GROUPS G WHERE G.GROUP = 'GRP_PARENT') ,'ROLE_PARENT');

INSERT INTO USR_USER_GROUP (USERNAME, GROUP_ID)
VALUES
('admin','GRP_SYSTEM');