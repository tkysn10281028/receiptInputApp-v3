CREATE TABLE `DESTINATION_INFO` (
  `DESTINATION_ID` int NOT NULL,
  `DESTINATION_POST_CODE` int DEFAULT NULL,
  `DESTINATION_PREFECTURE` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `DESTINATION_CITY` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `DESTINATION_TOWN` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `DESTINATION_TOWN_NO` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `DESTINATION_PROP_NO` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `DESTINATION_ROOM_NO` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `DESTINATION_TEL_NO` varchar(15) NOT NULL,
  `EMAIL_ADDRESS` text NOT NULL,
  `PERSONAL_POST_CODE` int DEFAULT NULL,
  `PERSONAL_PREFECTURE` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `PERSONAL_CITY` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `PERSONAL_TOWN` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `PERSONAL_TOWN_NO` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `PERSONAL_PROP_NO` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `PERSONAL_ROOM_NO` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `PEROSNAL_TEL_NO` varchar(15) NOT NULL,
  `CREATE_PRG` text NOT NULL,
  `CREATE_DATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_PRG` text NOT NULL,
  `UPDATE_DATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`DESTINATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `MEMBER_INFO` (
  `MEMBER_NO` int NOT NULL,
  `TOTAL_POINT` int NOT NULL DEFAULT '0',
  `MEMBER_POST_CODE` int DEFAULT NULL,
  `MEMBER_PREFECTURE` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `MEMBER_CITY` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `MEMBER_TOWN` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `MEMBER_TOWN_NO` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `MEMBER_PROP_NO` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `MEMBER_ROOM_NO` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `MEMBER_TEL_NO` varchar(15) NOT NULL,
    `MEMBER_EMAIL_ADDRESS` text NOT NULL,
  `CREATE_PRG` text NOT NULL,
  `CREATE_DATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_PRG` text NOT NULL,
  `UPDATE_DATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`MEMBER_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `M_ITEM_INFO` (
  `ITEM_ID` varchar(8) NOT NULL,
  `ITEM_NAME` text NOT NULL,
  `ITEM_NAME_FOR_SEARCH` text NOT NULL,
  `ITEM_PRICE` int NOT NULL,
  `ITEM_DISCOUNT_DIV` varchar(8) NOT NULL,
  `CREATE_PRG` text NOT NULL,
  `CREATE_DATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_PRG` text NOT NULL,
  `UPDATE_DATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ITEM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ORDER_INFO` (
  `ORDER_ID` int NOT NULL,
  `ITEM_ID` varchar(8) NOT NULL,
  `DISCOUNT_DIV` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DISCOUNT_MONEY` int DEFAULT NULL,
  `DESTINATION_ID` int NOT NULL,
  `SETTLEMENT_ID` int NOT NULL,
  `MEMBER_NO` int DEFAULT NULL,
  `CREATE_PRG` text NOT NULL,
  `CREATE_DATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATE_USER` text NOT NULL,
  `UPDATE_DATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ORDER_ID`,`DESTINATION_ID`,`SETTLEMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `SETTLEMENT_INFO` (
  `SETTLEMENT_ID` int NOT NULL,
  `CREDIT_NO` text NOT NULL,
  `DATE_OF_EXPIRY` varchar(8) NOT NULL,
  `SECURITY_CODE` int NOT NULL,
  `SETTLEMENT_MONEY` int NOT NULL,
  `CREATE_PRG` text NOT NULL,
  `CREATE_DATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_PRG` text NOT NULL,
  `UPDATE_DATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`SETTLEMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
