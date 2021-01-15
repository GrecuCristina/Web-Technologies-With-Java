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
CREATE TABLE if NOT EXISTS quizzes (
  id int(20) NOT NULL AUTO_INCREMENT,
  totalPoints int(20),
  PRIMARY KEY (id)

);
CREATE TABLE if NOT EXISTS quizQuestions (
  id int(20) NOT NULL AUTO_INCREMENT,
  quizId int(20) NOT NULL,
  description varchar(255),
  point int(20),
  PRIMARY KEY (id),
  KEY quiz_id_fk (quizId),
  CONSTRAINT quiz_id_fk FOREIGN KEY (quizId) REFERENCES quizzes(id) ON DELETE CASCADE

);
CREATE TABLE if NOT EXISTS quizAnswers (
  id int(20) NOT NULL AUTO_INCREMENT,
  quizQuestionId int(20) NOT NULL,
  description varchar (255),
  isCorrect  varchar (255),
  PRIMARY KEY (id),
  KEY quizQuestion_id_fk (quizQuestionId),
  CONSTRAINT quizQuestion_id_fk FOREIGN KEY (quizQuestionId) REFERENCES quizQuestions(id)

);
CREATE TABLE if NOT EXISTS userQuizzes (
  id int(20) NOT NULL AUTO_INCREMENT,
  uId int(20),
  quId int(20),
  qeId int(20),
  aId int(20),
  points int(20),

  PRIMARY KEY (id),
  KEY u_id_fk (uId),
  CONSTRAINT u_id_fk FOREIGN KEY (uId) REFERENCES users (id) ,
   KEY qu_id_fk (quId),
  CONSTRAINT qu_id_fk FOREIGN KEY (quId) REFERENCES quizzes (id) ,
  KEY qe_id_fk (qeId),
  CONSTRAINT qe_id_fk FOREIGN KEY (qeId) REFERENCES quizQuestions (id) ,
   KEY a_id_fk (aId),
  CONSTRAINT a_id_fk FOREIGN KEY (aId) REFERENCES quizAnswers (id)
);
CREATE TABLE if NOT EXISTS takenQuiz (
  id int(20) NOT NULL AUTO_INCREMENT,
  userId int(20),
  questionId int(20),

  PRIMARY KEY (id),
  KEY us_id_fk (userId),
  CONSTRAINT us_id_fk FOREIGN KEY (userId) REFERENCES users (id),
  KEY question_id_fk (questionId),
  CONSTRAINT question_id_fk FOREIGN KEY (questionId) REFERENCES quizQuestions(id)

);