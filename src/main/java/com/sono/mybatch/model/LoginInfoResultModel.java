package com.sono.mybatch.model;

import lombok.Data;

@Data
public class LoginInfoResultModel {
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
