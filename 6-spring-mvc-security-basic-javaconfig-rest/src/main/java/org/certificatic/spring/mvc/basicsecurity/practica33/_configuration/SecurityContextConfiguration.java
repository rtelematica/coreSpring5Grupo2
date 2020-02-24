package org.certificatic.spring.mvc.basicsecurity.practica33._configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration

// Habilita configuracion web con Spring Security

// Extiende de WebSecurityConfigurerAdapter
public class SecurityContextConfiguration {
	
	public static final String REALM_NAME = "Mi application realm";

	// Sobre escribe el metodo configure(AuthenticationManagerBuilder auth)
	
	// Sobre escribe el metodo configure(HttpSecurity http)
	
	// Define Bean AccessDeniedHandler
	
	// Define Bean BasicAuthenticationEntryPoint

	// Sobre escribe el metodo configure(WebSecurity web)
}
