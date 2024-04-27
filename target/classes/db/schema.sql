-- 用于初始化数据库

CREATE TABLE IF NOT EXISTS products (
  id varchar(200),
  tid varchar(200),
  price numeric,
  category varchar(20),
  quantity INTEGER,
  product_name varchar(200),
  stock INTEGER,
  img varchar(200)
);

CREATE TABLE IF NOT EXISTS categories(
  id varchar(20),
  tid INTEGER,
  category_name varchar(20)
);

CREATE TABLE IF NOT EXISTS settings(
  id varchar(20),
  tid INTEGER,
  app varchar(50),
  store varchar(20),
  address_one varchar(20),
  address_two varchar(20),
  contact varchar(20),
  tax varchar(20),
  symbol varchar(20),
  percentage varchar(20),
  footer varchar(20),
  img varchar(20)
);