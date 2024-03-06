create database mydb;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `profession` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1

INSERT INTO users (name, email, profession) values ('Peter', 'peter@gmail.com', 'Programmer');
INSERT INTO users (name, email, profession) values ('Tom', 'tom@hotmail.com', 'Developer');
INSERT INTO users (name, email, profession) values ('Sam', 'sam@yahoo.com', 'Consultant');
INSERT INTO users (name, email, profession) values ('David', 'david@gmail.com', 'Designer');