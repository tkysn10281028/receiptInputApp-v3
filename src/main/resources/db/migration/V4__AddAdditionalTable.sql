-- ログイン情報テーブルの作成及びテストデータの挿入

INSERT INTO `LOGIN_INFO` (`LOGIN_ID`, `EMAIL_ADDRESS`, `PASSWORD`, `USER_NAME`, `CREATE_PRG`, `CREATE_DATE_TIME`, `UPDATE_PRG`, `UPDATE_DATE_TIME`) VALUES
('L001', 'tkysn1028@gmail.com', '$2a$10$7.bQ6Ob1bhEmjrf7o1k83.T0Dcj2lG7IwhY3Kuq2RhIbGs80iYghO', 'test', 'sys', '2022-10-30 06:20:43', 'sys', '2022-10-30 06:20:43');

-- ログイン情報関連カラムを注文テーブルに追加
ALTER TABLE `ORDER_INFO` ADD `LOGIN_ID` VARCHAR(10) default NULL AFTER `SETTLEMENT_ID`;

INSERT INTO `DISCOUNT_INFO` (`DISCOUNT_DIV`, `DISCOUNT_RATE`, `DISCOUNT_NAME`, `CREATE_PRG`, `CREATE_DATE_TIME`, `UPDATE_PRG`, `UPDATE_DATE_TIME`) VALUES
('d000', 1, '割引なし', 'sys', '2022-10-30 06:46:42', 'sys', '2022-10-30 06:47:51');

INSERT INTO `M_ITEM_CLASS_MAJOR_INFO` (`ITEM_MAJOR_DIV`, `ITEM_MAJOR_NAME`, `CREATE_PRG`, `CREATE_DATE_TIME`, `UPDATE_PRG`, `UPDATE_DATE_TIME`) VALUES
('001', '食器・カトラリー', 'sys', '2022-10-29 22:14:15', '', '2022-10-30 08:07:35'),
('002', '調理用品', 'sys', '2022-10-29 22:14:15', '', '2022-10-30 08:07:43');

INSERT INTO `M_ITEM_CLASS_MIDDLE_INFO` (`ITEM_MIDDLE_DIV`, `ITEM_MAJOR_DIV`, `ITEM_MIDDLE_NAME`, `CREATE_PRG`, `CREATE_DATE_TIME`, `UPDATE_PRG`, `UPDATE_DATE_TIME`) VALUES
('001', '001', '食器', 'sys', '2022-10-29 22:14:53', 'sys', '2022-10-30 08:08:01'),
('001', '002', '台所用品', 'sys', '2022-10-29 22:14:53', 'sys', '2022-10-30 08:08:01'),
('002', '001', 'カトラリー', 'sys', '2022-10-29 22:14:53', 'sys', '2022-10-30 08:08:03'),
('002', '002', '調理用品', 'sys', '2022-10-29 22:14:53', 'sys', '2022-10-30 08:08:03');

INSERT INTO `M_ITEM_CLASS_MINOR_INFO` (`ITEM_MINOR_DIV`, `ITEM_MAJOR_DIV`, `ITEM_MIDDLE_DIV`, `ITEM_MINOR_NAME`, `CREATE_PRG`, `CREATE_DATE_TIME`, `UPDATE_PRG`, `UPDATE_DATE_TIME`) VALUES
('001', '001', '001', '機能食器', 'sys', '2022-10-29 22:15:19', 'sys', '2022-10-30 08:08:32'),
('001', '001', '002', '箸', 'sys', '2022-10-29 22:15:19', 'sys', '2022-10-30 08:08:32'),
('001', '002', '001', 'シンク周り用品', 'sys', '2022-10-29 22:15:19', 'sys', '2022-10-30 08:17:49'),
('001', '002', '002', '冷蔵庫周り用品', 'sys', '2022-10-29 22:15:19', 'sys', '2022-10-30 08:18:25'),
('002', '001', '001', '子供食器', 'sys', '2022-10-29 22:15:19', 'sys', '2022-10-30 08:08:34'),
('002', '001', '002', 'スプーン', 'sys', '2022-10-29 22:15:19', 'sys', '2022-10-30 08:08:34'),
('002', '002', '001', '調理器具', 'sys', '2022-10-29 22:15:19', 'sys', '2022-10-30 08:18:42'),
('002', '002', '002', 'テーブル周り用品', 'sys', '2022-10-29 22:15:19', 'sys', '2022-10-30 08:19:42');

INSERT INTO `M_ITEM_DISCOUNT_INFO` (`ITEM_DISCOUNT_DIV`, `ITEM_DISCOUNT_RATE`, `ITEM_DISCOUNT_NAME`, `CREATE_PRG`, `CREATE_DATE_TIME`, `UPDATE_PRG`, `UPDATE_DATE_TIME`) VALUES
('id000', 1, '割引なし', 'sys', '2022-10-30 07:32:30', 'sys', '2022-10-30 07:32:53');



--INSERT INTO `M_ITEM_CLASS_INFO` (`ITEM_ID`, `ITEM_MAJOR_DIV`, `ITEM_MIDDLE_DIV`, `ITEM_MINOR_DIV`, `CREATE_PRG`, `CREATE_DATE_TIME`, `UPDATE_PRG`, `UPDATE_DATE_TIME`) VALUES
--('i1110001', '001', '001', '001', 'sys', '2022-10-29 22:00:15', 'sys', '2022-10-30 08:27:15'),
--('i1110002', '001', '001', '001', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:27:27'),
--('i1110003', '001', '001', '001', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:27:34'),
--('i1110004', '001', '001', '001', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:27:39'),
--('i1120001', '001', '001', '002', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:27:57'),
--('i1120002', '001', '001', '002', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:28:17'),
--('i1120003', '001', '001', '002', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:28:23'),
--('i1120004', '001', '001', '002', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:28:30'),
--('i1210001', '001', '002', '001', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:28:58'),
--('i1210002', '001', '002', '001', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:29:03'),
--('i1210003', '001', '002', '001', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:29:08'),
--('i1210004', '001', '002', '001', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:29:12'),
--('i1220001', '001', '002', '002', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:29:26'),
--('i1220002', '001', '002', '002', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:29:34'),
--('i1220003', '001', '002', '002', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:29:41'),
--('i1220004', '001', '002', '002', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:29:45'),
--('i2110001', '002', '001', '001', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:30:02'),
--('i2110002', '002', '001', '001', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:30:17'),
--('i2110003', '002', '001', '001', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:30:23'),
--('i2110004', '002', '001', '001', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:30:28'),
--('i2120001', '002', '001', '002', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:30:50'),
--('i2120002', '002', '001', '002', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:30:55'),
--('i2120003', '002', '001', '002', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:30:59'),
--('i2120004', '002', '001', '002', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:31:04'),
--('i2210001', '002', '002', '001', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:31:10'),
--('i2210002', '002', '002', '001', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:31:17'),
--('i2210003', '002', '002', '001', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:31:22'),
--('i2210004', '002', '002', '001', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:31:26'),
--('i2220001', '002', '002', '002', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:31:30'),
--('i2220002', '002', '002', '002', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:31:35'),
--('i2220003', '002', '002', '002', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:31:39'),
--('i2220004', '002', '002', '002', 'sys', '2022-10-29 13:00:15', 'sys', '2022-10-30 08:31:43');

