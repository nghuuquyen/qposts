DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS post;

CREATE TABLE category(
  id            VARCHAR(50) PRIMARY KEY NOT NULL,
  name          NVARCHAR(255),
  description   NVARCHAR(255)
);

CREATE TABLE post(
   id              VARCHAR(50) PRIMARY KEY NOT NULL,
   name            NVARCHAR(255),
   description     NVARCHAR(255),
   content         NVARCHAR(2550),
   category_id     VARCHAR(50),
   FOREIGN KEY(category_id) REFERENCES category(id)
);



