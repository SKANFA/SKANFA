package net.proselyte.jwtappdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import net.proselyte.jwtappdemo.security.jwt.JwtConfigurer;
import net.proselyte.jwtappdemo.security.jwt.JwtTokenProvider;

/**
 * Security configuration class for JWT based Spring Security application.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final JwtTokenProvider jwtTokenProvider;

	private static final String LOGIN_ENDPOINT = "/api/v1/auth/login";
	private static final String REGISTER_ENDPOINT = "/api/v1/auth/register";
	private static final String ADMIN_ENDPOINT = "/api/v1/admin/**";

	@Autowired
	public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.//
				httpBasic().disable()//
				.csrf().disable()//
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//
				.and()//
				.authorizeRequests()//
				.antMatchers(REGISTER_ENDPOINT).permitAll()//
				.antMatchers(LOGIN_ENDPOINT).permitAll()//
				.antMatchers(ADMIN_ENDPOINT).hasRole("ADMIN")//
				.anyRequest().authenticated()//
				.and()//
				.apply(new JwtConfigurer(jwtTokenProvider));
	}
}