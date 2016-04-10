/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Kevin W
 * Created: Mar 26, 2016
 */

CREATE TABLE `USR_TYPE` (
  `NAME` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`NAME`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

INSERT INTO USR_TYPE (NAME) VALUES
('STUDENT'),
('TEACHER'),
('PARENT'),
('SYSTEM'),
('SCHOOL_ADMIN'),
('DISTRICT_ADMIN');