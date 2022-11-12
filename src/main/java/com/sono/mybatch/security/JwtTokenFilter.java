package com.sono.mybatch.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sono.mybatch.repository.GenerateNonJwtRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {
	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	UserDetailsService detailsService;

	@Autowired
	GenerateNonJwtRepository generateNonJwtRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// httpヘッダーのAuthorizationヘッダの中身を取得
		final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (StringUtils.isEmpty(header)) {
			filterChain.doFilter(request, response);
			return;
		}

		String token = header;
		if (!jwtUtils.validate(token)) {
			log.info("token validation failed. -> check if token mapped in the token table.");
			token = generateNonJwtRepository.searchJwtTokenByJwtTokenId(token);
			if (!jwtUtils.validate(token)) {
				filterChain.doFilter(request, response);
				return;
			}
		}
		UserDetails userDetails = detailsService.loadUserByUsername(jwtUtils.getUserEmailAddress(token));
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
				userDetails.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		filterChain.doFilter(request, response);
	}

}
