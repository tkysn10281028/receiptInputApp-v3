package com.sono.mybatch.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sono.mybatch.model.LoginInfoResultModel;

@Mapper
public interface LoginRepository {
	public Optional<LoginInfoResultModel> findUserByEmailAddress(@Param("emailAddress") String emailaddress);
}
