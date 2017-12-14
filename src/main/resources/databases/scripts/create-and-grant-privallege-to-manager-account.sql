USE qposts;


DROP USER 'qposts-manager'@'127.0.0.1';
CREATE USER 'qposts-manager'@'localhost' IDENTIFIED BY 'qposts-password';

GRANT SELECT,INSERT,UPDATE,DELETE,CREATE ON qposts.post  TO 'qposts-manager'@'localhost';
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE ON qposts.category  TO 'qposts-manager'@'localhost';

FLUSH PRIVILEGES;