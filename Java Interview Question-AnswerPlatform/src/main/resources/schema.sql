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
  date TIMESTAMP NOT NULL,
  userId int(20) NOT NULL,
  companyName varchar(255) NOT NULL,
  PRIMARY KEY (id),
  KEY user_id_fk (userId),
  CONSTRAINT user_id_fk FOREIGN KEY (userId) REFERENCES users (id)

);
CREATE TABLE if NOT EXISTS answers (
  id int(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) NOT NULL,
  date TIMESTAMP NOT NULL,
  authorId int(20) NOT NULL,
  questionId int(20) NOT NULL,
  PRIMARY KEY (id),
  KEY author_id_fk (authorId),
  CONSTRAINT author_id_fk FOREIGN KEY (authorId) REFERENCES users (id) ON DELETE CASCADE,
  KEY question_id_fk (questionId),
  CONSTRAINT question_id_fk FOREIGN KEY (questionId) REFERENCES questions (id) ON DELETE CASCADE

);

CREATE TABLE if NOT EXISTS reviews (
  id int(20) NOT NULL AUTO_INCREMENT,
  reviewType varchar(255) NOT NULL,
  date TIMESTAMP NOT NULL,
  userReviewId int(20) NOT NULL,
  answerId int(20) NOT NULL,
  PRIMARY KEY (id),
  KEY userReview_id_fk (userReviewId),
  CONSTRAINT userReview_id_fk FOREIGN KEY (userReviewId) REFERENCES users (id) ON DELETE CASCADE,
  KEY answer_id_fk (answerId),
  CONSTRAINT answer_id_fk FOREIGN KEY (answerId) REFERENCES answers (id) ON DELETE CASCADE

);