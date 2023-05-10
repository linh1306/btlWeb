CREATE DATABASE clothes_store;

USE clothes_store;

CREATE TABLE user(
	user VARCHAR(255) NOT NULL,
    password VARCHAR(255),
    name VARCHAR(255),
	address VARCHAR(255),
    phone VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    primary key (user)
);


CREATE TABLE seller(
	user VARCHAR(255),
    id_seller VARCHAR(255),
    name VARCHAR (255),
    address VARCHAR (255),
    phone VARCHAR(255),
    PRIMARY KEY (id_seller),
    FOREIGN KEY (user)
    REFERENCES user(user)
);

CREATE TABLE product(
	id_product INT AUTO_INCREMENT,
    id_seller VARCHAR(255),
    img VARCHAR(255),
    name VARCHAR(255),
    description VARCHAR(255),
    detail VARCHAR(1000),
    company VARCHAR(255),
    price INT,
    PRIMARY KEY (id_product),
	FOREIGN KEY (id_seller) REFERENCES seller(id_seller) ON DELETE CASCADE
);

CREATE TABLE cart(
	user VARCHAR(255),
    id_product INT,
    count INT,
    FOREIGN KEY(user)
    REFERENCES user(user),
    FOREIGN KEY(id_product)
    REFERENCES product(id_product) ON DELETE CASCADE
);


CREATE TABLE oder(
	id_seller VARCHAR(255),
	user VARCHAR(255),
    id_product INT,
    count INT,
	FOREIGN KEY(id_seller)
    REFERENCES seller(id_seller),
    FOREIGN KEY(user)
    REFERENCES user(user),
    FOREIGN KEY(id_product)
    REFERENCES product(id_product) ON DELETE CASCADE
);


