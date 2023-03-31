CREATE TABLE IF NOT EXISTS `technician` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(80) NOT NULL,
  `last_name` varchar(80) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `enabled` BIT(1) NOT NULL DEFAULT b'1',

  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3y1mov1fb6f0uxmuq52xu9gea` (`cpf`),
  UNIQUE KEY `UK_crs6ef6e2yblrw13n1fe4ma53` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
