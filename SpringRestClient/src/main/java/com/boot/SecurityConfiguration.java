package com.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.boot.service.UserDetailsConfiguraciones;

//Zona de beans con configuraciones de spring security le heredo la clase de configuraciones
//aqui asignaremos usuarios desde base de datos y roles para permisos
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	// Usuarios desde base de datos
	@Autowired
	private UserDetailsConfiguraciones userConfig;
	// codificador
	@Autowired
	private BCryptPasswordEncoder encoder;

	// codificador de spring security lo declaro como bean en el contenedor de
	// spring
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	// usuarios desde base de datos y codificador
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userConfig).passwordEncoder(encoder);
	}

	// configuraciones de peticiones http
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// cada peticion debe estar autenticada por usuario
		// falta agregar token
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic().and().csrf().disable();
	}
}
