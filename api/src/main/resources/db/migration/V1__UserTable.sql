CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8MB4;


CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`),
  FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  UNIQUE(user_id, role_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8MB4;


INSERT INTO `roles` (
  `name`
) VALUES
  ('ROLE_USER'),
  ('ROLE_MODERATOR'),
  ('ROLE_ADMIN');


CREATE TABLE `parent_chart` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `user_id` bigint NOT NULL,
   `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`),
   UNIQUE KEY `user_id` (`user_id`),
   CONSTRAINT `Parent_Chart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE `child_chart` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `parent_id` bigint NOT NULL,
   `age` int NOT NULL,
   `score` int NOT NULL,
   `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `parent_id` (`parent_id`,`age`),
   CONSTRAINT `child_chart_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `parent_chart` (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

insert into `users` (
`username`,`password`,`email`) 
values 
("めし","testtest","yuta.fukui@seattleconsulting.co.jp"), 
("mei","testtest","mei.kishida@seattleconsulting.co.jp"), 
("須田ちゃん","testtest","mizuki.suda@seattleconsulting.co.jp"),
("simoharaguchi","testtest","reiki.shimoharaguchi@seattleconsulting.co.jp"),
("直也","testtest","naoya.hayashi@seattleconsulting.co.jp"),
("ヤマト","testtest","yamato.takezaki@seattleconsulting.co.jp");

