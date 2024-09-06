CREATE DATABASE stock;
USE stock;

CREATE TABLE Category (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(50) NOT NULL UNIQUE,
                          description VARCHAR(90) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          UNIQUE(name)
);

CREATE TABLE Brand (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(50) NOT NULL UNIQUE,
                       description VARCHAR(120) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                       UNIQUE(name)
);

CREATE TABLE Item (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(60) NOT NULL,
                      description VARCHAR(120) NOT NULL,
                      quantity INT NOT NULL,
                      price DOUBLE NOT NULL,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      brand_id INT,
                      FOREIGN KEY (brand_id) REFERENCES Brand(id) ON DELETE CASCADE,
                      UNIQUE(name)
);

CREATE TABLE Item_Category (

                               id INT AUTO_INCREMENT PRIMARY KEY,
                               item_id INT NOT NULL,
                               category_id INT NOT NULL,
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                               FOREIGN KEY (item_id) REFERENCES Item(id),
                               FOREIGN KEY (category_id) REFERENCES Category(id)
);