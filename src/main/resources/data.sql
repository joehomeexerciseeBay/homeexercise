
DROP TABLE IF EXISTS program;

CREATE TABLE program (
  program_id INT PRIMARY KEY,
  program_name VARCHAR(250) NOT NULL,
  active_ind VARCHAR(1)
);

INSERT INTO program (program_id, program_name, active_ind) VALUES
  (100,'remote location shipping program','Y'),
  (200,'leisure program', 'N');
  --(300,'Large Items program' 'N');
 
  DROP TABLE IF EXISTS seller;

CREATE TABLE seller (
  seller_id INT AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL
);

INSERT INTO seller (user_name) VALUES
  ('john.doe@org1.com'),
  ('joe.doe'),
  ('samlam_seller');

  DROP TABLE IF EXISTS approved_category;
  
  CREATE TABLE approved_category(
  category_id INT AUTO_INCREMENT PRIMARY KEY,
  category_name VARCHAR(250)
  );
  
  INSERT INTO approved_category (category_name) VALUES
  ('Appliances'),
  ('Baby'),
  ('Beauty');
  
  DROP TABLE IF EXISTS minimum_price;
  
  CREATE TABLE minimum_price(
  price DOUBLE
  );
  
  INSERT INTO minimum_price(price) values (10.99);