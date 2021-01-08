create database if not exists qa_platform;

create table if not exists users(
    id int not null auto_increment,
    firstName varchar(100) not null,
    lastName varchar(100) not null,
    email varchar(100) not null,
    age int not null,
    password varchar(100) not null,
    isLoggedIn varchar(100) not null,
     PRIMARY KEY (id, email)
);
CREATE TABLE if NOT EXISTS questions (
  id int(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) NOT NULL,
  jobType varchar(255) NOT NULL,
  date DATE NOT NULL,
  userId int(20) NOT NULL,
  PRIMARY KEY (id),
  KEY user_id_fk (userId),
  CONSTRAINT user_id_fk FOREIGN KEY (userId) REFERENCES users (id)

);