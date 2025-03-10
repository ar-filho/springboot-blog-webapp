-- SQL Script to Create Admin User
-- Use below SQL statements to create an admin user in database tables.
-- Email: admin@gmail.com
-- Password: admin

INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_GUEST');

INSERT INTO `users` VALUES (1,'admin@gmail.com','admin','$2a$10$k9644mshajjDvMhU8p76.u4sgOFuINZDkZ/csNgzFY99W1diZjBuC');

INSERT INTO `users_roles` VALUES (1,1);

