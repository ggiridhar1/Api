
CREATE SEQUENCE IF NOT EXISTS user_seq;


CREATE TABLE IF NOT EXISTS Users (
                                     user_id BIGINT NOT NULL DEFAULT nextval('user_seq') PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20) NOT NULL
    );


CREATE SEQUENCE IF NOT EXISTS pro_seq;


CREATE TABLE IF NOT EXISTS Products (
                                        id BIGINT NOT NULL DEFAULT nextval('pro_seq') PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    description VARCHAR(500) NOT NULL,
    image VARCHAR(500) NOT NULL,
    available BOOLEAN NOT NULL
    );


CREATE TABLE IF NOT EXISTS product_user (
                                            user_id BIGINT REFERENCES Users(user_id) ON DELETE CASCADE,
    product_id BIGINT REFERENCES Products(id) ON DELETE CASCADE
    );