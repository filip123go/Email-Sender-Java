package com.stavros.mailscheduler.security;

import javax.sql.DataSource;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private UserPrincipalDetailsService userPrincipalDetailsService;
	private DataSource dataSource;

	public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService) {
		this.userPrincipalDetailsService = userPrincipalDetailsService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());

//		auth
//				.inMemoryAuthentication()
//				.withUser("admin")
//				.password(passwordEncoder().encode("admin")).roles("ADMIN") //mandatory to use encoder
//				.and()
//				.withUser("stavros")
//				.password(passwordEncoder().encode("stavros")).roles("USER") //mandatory to use encoder
//				.and()
//				.withUser("manager")
//				.password(passwordEncoder().encode("manager")).roles("MANAGER"); //mandatory to use encoder
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/index.html").permitAll() // the index.html is accessible by everyone
				.antMatchers("/swagger-ui.html").authenticated() // the /swagger-ui.html can be accessed only by authenticated users (you must login)
				.antMatchers("/admin/**").hasRole("ADMIN") //accessible only to "ADMINS"
				.antMatchers("/management/**").hasAnyRole("ADMIN","MANAGER")//accessible only to "ADMINS" and "MANAGERS"
//				.anyRequest().authenticated() //authorize any request from authenticated users (any request needs to be authenticated)
				.and()
				.httpBasic();
		//we can use /** to select all the subdomains from a specific path ex: /management/**"
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

		return daoAuthenticationProvider;
	}


	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
