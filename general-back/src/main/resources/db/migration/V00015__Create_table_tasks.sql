CREATE TABLE IF NOT EXISTS `tasks` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `task_name` varchar(80) NOT NULL,
  `user_id` bigint NOT NULL,
  `target_date` date DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `enabled` BIT(1) NOT NULL DEFAULT b'1',

  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
