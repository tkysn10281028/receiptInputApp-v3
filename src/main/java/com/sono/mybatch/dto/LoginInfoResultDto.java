package com.sono.mybatch.dto;

import lombok.Data;

@Data
public class LoginInfoResultDto {
	/**
	 * ログインID
	 */
	private String loginId;

	/**
	 * メールアドレス
	 */
	private String emailAddress;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * ユーザー名
	 */
	private String userName;
}
