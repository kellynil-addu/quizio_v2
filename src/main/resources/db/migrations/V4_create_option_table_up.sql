USE `quizio`;

CREATE TABLE IF NOT EXISTS `option` (
  `id` CHAR(36) PRIMARY KEY,
  `question_id` CHAR(36),
  `text` VARCHAR(64),
  `is_correct` BOOLEAN DEFAULT FALSE,

  FOREIGN KEY (`question_id`) REFERENCES `question`(`id`) ON DELETE CASCADE
);
