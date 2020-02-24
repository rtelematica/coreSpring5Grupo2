package org.certificatic.spring.mvc.digestsecurity.practica34._configuration;

import org.certificatic.spring.mvc.digestsecurity.practica34.repository.UserDetailsRepository;
import org.certificatic.spring.mvc.digestsecurity.practica34.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration

// Habilita configuracion web con Spring Security

// Extiende de WebSecurityConfigurerAdapter
public class SecurityContextConfiguration {

	public static final String REALM_NAME = "Spring Security with Digest Authentication App (java config)";

	// Inyecta
	private UserDetailsRepository userDetailsRepository;
	
	// Sobre escribe el metodo configure(AuthenticationManagerBuilder auth)

	// Sobre escribe el metodo configure(HttpSecurity http)
	
	// Define Bean UserDetailsService
	
	// Define Bean CustomDigestAuthenticationEntryPoint
	
	// Define Bean DigestAuthenticationFilter
	
	// Define Bean AccessDeniedHandler

	// Sobre escribe el metodo configure(WebSecurity web)
}
