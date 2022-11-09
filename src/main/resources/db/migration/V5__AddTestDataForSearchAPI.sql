-- 検索API用テストデータの挿入
INSERT INTO `M_ITEM_CLASS_INFO` (`ITEM_ID`, `ITEM_MAJOR_DIV`, `ITEM_MIDDLE_DIV`, `ITEM_MINOR_DIV`, `CREATE_PRG`, `CREATE_DATE_TIME`, `UPDATE_PRG`, `UPDATE_DATE_TIME`) VALUES
('i0000001', '000', '000', '000', 'sys', '2022-10-29 04:00:15', 'sys', '2022-10-29 23:31:10'),
('i0000002', '000', '000', '000', 'sys', '2022-10-29 04:00:15', 'sys', '2022-10-29 23:31:17'),
('i0000003', '000', '000', '000', 'sys', '2022-10-29 04:00:15', 'sys', '2022-10-29 23:31:22'),
('i0000004', '000', '000', '000', 'sys', '2022-10-29 04:00:15', 'sys', '2022-10-29 23:31:26'),
('i0000005', '000', '000', '000', 'sys', '2022-10-29 04:00:15', 'sys', '2022-10-29 23:31:30'),
('i0000006', '000', '000', '000', 'sys', '2022-10-29 04:00:15', 'sys', '2022-10-29 23:31:35'),
('i0000007', '000', '000', '000', 'sys', '2022-10-29 04:00:15', 'sys', '2022-10-29 23:31:39'),
('i0000008', '000', '000', '000', 'sys', '2022-10-29 04:00:15', 'sys', '2022-10-29 23:31:43'),
('i0000009', '000', '000', '000', 'sys', '2022-10-29 04:00:15', 'sys', '2022-10-29 23:31:26'),
('i0000010', '000', '000', '000', 'sys', '2022-10-29 04:00:15', 'sys', '2022-10-29 23:31:30'),
('i0000011', '000', '000', '000', 'sys', '2022-10-29 04:00:15', 'sys', '2022-10-29 23:31:35'),
('i0000012', '000', '000', '000', 'sys', '2022-10-29 04:00:15', 'sys', '2022-10-29 23:31:39'),
('i0000013', '000', '000', '000', 'sys', '2022-10-29 04:00:15', 'sys', '2022-10-29 23:31:43');

INSERT INTO `M_ITEM_CLASS_MAJOR_INFO` (`ITEM_MAJOR_DIV`, `ITEM_MAJOR_NAME`, `CREATE_PRG`, `CREATE_DATE_TIME`, `UPDATE_PRG`, `UPDATE_DATE_TIME`) VALUES
('000', '大分類テスト用', 'sys', '2022-10-29 13:14:15', '', '2022-10-29 23:07:35');

INSERT INTO `M_ITEM_CLASS_MIDDLE_INFO` (`ITEM_MIDDLE_DIV`, `ITEM_MAJOR_DIV`, `ITEM_MIDDLE_NAME`, `CREATE_PRG`, `CREATE_DATE_TIME`, `UPDATE_PRG`, `UPDATE_DATE_TIME`) VALUES
('000', '000', '中分類テスト用', 'sys', '2022-10-29 13:14:53', 'sys', '2022-10-29 23:08:01');
INSERT INTO `M_ITEM_CLASS_MINOR_INFO` (`ITEM_MINOR_DIV`, `ITEM_MAJOR_DIV`, `ITEM_MIDDLE_DIV`, `ITEM_MINOR_NAME`, `CREATE_PRG`, `CREATE_DATE_TIME`, `UPDATE_PRG`, `UPDATE_DATE_TIME`) VALUES
('000', '000', '000', '小分類テスト用', 'sys', '2022-10-29 13:15:19', 'sys', '2022-10-29 23:08:32');

INSERT INTO `M_ITEM_INFO` (`ITEM_ID`, `ITEM_NAME`, `ITEM_NAME_FOR_SEARCH`, `ITEM_PRICE`, `ITEM_DISCOUNT_DIV`, `CREATE_PRG`, `CREATE_DATE_TIME`, `UPDATE_PRG`, `UPDATE_DATE_TIME`) VALUES
('i0000001', '0', '一文字のみのテスト(数字)', 500, 'id000', 'sys', '2022-10-27 23:27:01', 'sys', '2022-11-03 05:45:39'),
('i0000002', 'a', '一文字のみのテスト(小文字アルファベット)', 600, 'id000', 'sys', '2022-10-27 23:27:01', 'sys', '2022-11-03 05:40:59'),
('i0000003', 'A', '一文字のみのテスト(大文字アルファベット)', 700, 'id000', 'sys', '2022-10-27 23:27:01', 'sys', '2022-11-03 05:41:02'),
('i0000004', 'あ', '一文字のみのテスト(ひらがな)', 800, 'id000', 'sys', '2022-10-27 23:27:01', 'sys', '2022-11-03 05:41:05'),
('i0000005', 'ア', '一文字のみのテスト(カタカナ)', 900, 'id000', 'sys', '2022-10-27 23:27:01', 'sys', '2022-11-03 05:45:03'),
('i0000006', 'ｱ', '一文字のみのテスト(半角カタカナ)', 1000, 'id000', 'sys', '2022-10-27 23:27:01', 'sys', '2022-11-03 05:45:08'),
('i0000007', '12345', '複数文字のテスト', 1100, 'id000', 'sys', '2022-10-27 23:27:01', 'sys', '2022-11-03 05:45:11'),
('i0000008', '23456', '複数文字のテスト', 1200, 'id000', 'sys', '2022-10-27 23:27:01', 'sys', '2022-11-03 05:45:14'),
('i0000009', '34567', '複数文字のテスト', 1300, 'id000', 'sys', '2022-10-27 23:27:01', 'sys', '2022-11-03 05:45:17'),
('i0000010', '45678', '複数文字のテスト', 1400, 'id000', 'sys', '2022-10-27 23:27:01', 'sys', '2022-11-03 05:45:22'),
('i0000012', '56789', '複数文字のテスト', 1500, 'id000', 'sys', '2022-10-27 23:27:01', 'sys', '2022-11-03 05:45:25'),
('i0000013', '98765', 'ｱｲｳｴｵ', 1600, 'id000', 'sys', '2022-10-27 23:27:01', 'sys', '2022-11-03 12:08:37');
