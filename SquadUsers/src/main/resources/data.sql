DROP TABLE IF EXISTS settings;
DROP TABLE IF EXISTS captcha;

CREATE TABLE settings (
  id int AUTO_INCREMENT  PRIMARY KEY,  
  attempts INT ,
  length int ,
  alphanumeric int 
);
CREATE TABLE captcha (
  id INT AUTO_INCREMENT PRIMARY KEY,  
  captcha varchar(256) ,
  attempts int 
);

