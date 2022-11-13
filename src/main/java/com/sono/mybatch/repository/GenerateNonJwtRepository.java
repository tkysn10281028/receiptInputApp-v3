package com.sono.mybatch.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GenerateNonJwtRepository {
	public String searchJwtTokenByJwtTokenId(@Param("jwtTokenId") String jwtTokenId);

	public void generateNonJwtToken(@Param("tokenId") String tokenId, @Param("jwtToken") String jwtToken);

	public void deleteJwtTokenId(@Param("tokenId") String tokenId);

	public void deleteInsertedJwtTokenId();
}
