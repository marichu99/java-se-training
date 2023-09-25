CREATE TABLE IF NOT EXISTS tasks(task_id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255) NOT NULL, start_date DATE, due_date DATE,status TINYINT NOT NULL,priority TINYINT NOT NULL, description VARCHAR(255) NOT NULL),ENGINE=INNODB;

INSERT INTO TASKS(title,start_date,due_date,status,priority,description) VALUES(?,?,?,?,?,?);

-- LET US CREATE A TABLE FOR THE ITEMS TO BE BOUGHT AT THE POS SYSTEM
CREATE TABLE IF NOT EXISTS items(item_id INT AUTO_INCREMENT PRIMARY KEY, item_name VARCHAR(255) NOT NULL, item_price INT(11), item_quantity INT(11)), ENGINE=INNODB;
-- PREPARED STATEMENT FOR THE ITEM TABLE
INSERT INTO items(item_id,item_name,item_price,item_quantity) VALUES(?,?,?,?);
