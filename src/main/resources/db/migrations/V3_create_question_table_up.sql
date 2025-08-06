USE `quizio`;

CREATE TABLE IF NOT EXISTS `question` (
  `id` CHAR(36) PRIMARY KEY,
  `quiz_id` CHAR(36),
  `answer_id` CHAR(36),
  `type` VARCHAR(32),
  `text` VARCHAR(256),

  FOREIGN KEY (`quiz_id`) REFERENCES `quiz`(`id`) ON DELETE CASCADE,
  FOREIGN KEY (`answer_id`) REFERENCES `option`(`id`) ON DELETE SET NULL
);
