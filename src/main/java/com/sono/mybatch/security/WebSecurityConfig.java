package com.sono.mybatch.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService detailsService;

	@Autowired
	AuthenticationSuccessHandler successHandler;

	@Autowired
	AuthenticationFailureHandler failureHandler;

	@Autowired
	JwtTokenFilter jwtTokenFilter;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**").antMatchers("/js/**").antMatchers("/img/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.formLogin().loginProcessingUrl("/").loginPage("/").usernameParameter("emailaddress")
				.passwordParameter("password").permitAll().successHandler(successHandler)
				.failureHandler(failureHandler);
		http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated();
		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/api/v1/logout")).logoutSuccessUrl("/");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = passwordEncoder();
		auth.userDetailsService(detailsService).passwordEncoder(encoder);
	}
}