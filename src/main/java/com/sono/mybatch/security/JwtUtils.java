package com.sono.mybatch.security;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtils {
	private static final String base64SecretBytes = "Vm8QJZxUUw+exZm+J91u0X8CUR2GfJ7Fg5BnCTvBf9g=";

	private final String jwtIssuer = "com.sono.mybatch";

	public boolean validate(String token) {
		try {
			Jwts.parser().setSigningKey(base64SecretBytes).parseClaimsJws(token);

			return true;
		} catch (SignatureException ex) {
			ex.printStackTrace();
		} catch (MalformedJwtException ex) {
			ex.printStackTrace();
		} catch (ExpiredJwtException ex) {
			ex.printStackTrace();
		} catch (UnsupportedJwtException ex) {
			ex.printStackTrace();
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public String getUserEmailAddress(String token) {
		Claims claims = Jwts.parser().setSigningKey(base64SecretBytes).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public String generateAccessToken(String emailAddress) {
		return Jwts.builder().setSubject(emailAddress).setIssuer(jwtIssuer).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000))
				.signWith(SignatureAlgorithm.HS256, base64SecretBytes).compact();
	}

	public String removeJwtIdBearer(String jwtId) {
		return StringUtils.replace(jwtId, "jwtid: ", "");
	}
}
