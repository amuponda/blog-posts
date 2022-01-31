-- liquibase formatted sql
-- changeset alfred:CreateUserTable
CREATE TABLE `user` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`email` varchar(255) NOT NULL,
`first_name` varchar(255) NOT NULL,
`last_name` varchar(255) NOT NULL,
`password` varchar(255) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;