
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
  user_name VARCHAR(250) NOT NULL,
  program_id INT,
  FOREIGN KEY (program_id) REFERENCES program(program_id)
);

INSERT INTO seller (user_name,program_id) VALUES
  ('john.doe@org1.com',100),
  ('joe.doe',100),
  ('samlam_seller',100);

  DROP TABLE IF EXISTS approved_category;
  
  CREATE TABLE approved_category(
  category_id INT AUTO_INCREMENT PRIMARY KEY,
  category_name VARCHAR(250),
  description VARCHAR(1000)
  );
  
  INSERT INTO approved_category (category_name,description) VALUES
  ('Appliances','All kinds of Household appliances fall into this category'),
  ('Baby','Baby products'),
  ('Beauty','Beauty products');
  
  DROP TABLE IF EXISTS minimum_price;
  
  CREATE TABLE minimum_price(
  price DOUBLE
  );
  
  INSERT INTO minimum_price(price) values (10.99);