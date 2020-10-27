CREATE TABLE `ACCOUNT` (
  `account_id` bigint NOT NULL AUTO_INCREMENT,
  `document_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`account_id`),
UNIQUE KEY `UKmsth19dujo7yi10b1p33cmf1g` (`document_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `OPERATION_TYPE` (
  `operation_type_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `is_payment` bit(1) DEFAULT NULL,
PRIMARY KEY (`operation_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `TRANSACTION` (
  `transaction_id` bigint NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
`event_date` datetime(6) DEFAULT NULL,
`account_id` bigint DEFAULT NULL,
`operation_type_id` int DEFAULT NULL,
PRIMARY KEY (`transaction_id`),
KEY `FKhuqg4kl7byh8y1k7c1ksy06ij` (`account_id`),
KEY `FK8dgu9u1by3iji0ejuv6hb6ape` (`operation_type_id`),
CONSTRAINT `FK8dgu9u1by3iji0ejuv6hb6ape` FOREIGN KEY (`operation_type_id`) REFERENCES `OPERATION_TYPE` (`operation_type_id`),
CONSTRAINT `FKhuqg4kl7byh8y1k7c1ksy06ij` FOREIGN KEY (`account_id`) REFERENCES `ACCOUNT` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
