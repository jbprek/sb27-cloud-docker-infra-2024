CREATE TABLE products
(
    product_id NUMBER(9, 0) PRIMARY KEY,
    name       VARCHAR2(255) NOT NULL,
    price      number(8, 2)  NOT NULL,
    duration   NUMBER(4)
);

CREATE SEQUENCE subscriptions_pk_seq
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999
    START WITH 1
    INCREMENT BY 1
    CACHE 20 NOORDER NOCYCLE NOKEEP NOSCALE GLOBAL;



CREATE TABLE subscriptions
(
    subscription_id NUMBER(19, 0) PRIMARY KEY,
    customer_id     NUMBER(38, 0) NOT NULL,
    product_id NUMBER(9, 0) PRIMARY KEY,
    start_date      date
);

ALTER TABLE subscriptions
    ADD CONSTRAINT SUBSCRIPTIONS_PRODUCTS_IFK FOREIGN KEY (product_id) REFERENCES products (product_id);



