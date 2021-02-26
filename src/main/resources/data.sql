DROP TABLE IF EXISTS seller;

CREATE TABLE seller (
  seller_id INT AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL
);

INSERT INTO seller (user_name) VALUES
  ('john.doe@org1.com'),
  ('joe.doe'),
  ('samlam_seller');
  
  DROP TABLE IF EXISTS program;

CREATE TABLE program (
  program_id INT PRIMARY KEY,
  program_name VARCHAR(250) NOT NULL,
  active_ind VARCHAR(1)
);

INSERT INTO program (program_id, program_name, active_ind) VALUES
  (100,'remote location shipping program','Y');
  --(200,'leisure program', 'N'),
  --(300,'Large Items program' 'N');
  
   DROP TABLE IF EXISTS seller_program_mapping;

CREATE TABLE seller_program_mapping (
  seller_id INT NOT NULL,
  program_id INT NOT NULL,
  comments VARCHAR(1000) NULL

);

INSERT INTO seller_program_mapping (seller_id,program_id, comments) VALUES
  (1,100,'User mapped'),
  (2,100,'User mapped');