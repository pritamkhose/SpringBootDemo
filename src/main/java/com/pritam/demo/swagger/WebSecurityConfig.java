package com.pritam.demo.swagger;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

// https://howtodoinjava.com/spring-boot2/security-rest-basic-auth-example/
// https://www.mkyong.com/spring-boot/spring-rest-spring-security-example/

@Configuration
@EnableSwagger2
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		Enable security to all endpoint
//		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
//		Enable security to only mention endpoint
		http.csrf().disable().authorizeRequests()
				.antMatchers("/swagger-ui.html", "/swagger-resources", "/v2/api-docs", "/actuator/*").authenticated()
				.and().httpBasic();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER");
		// Login via Username = user & Password = password
	}

	// Internationalization
	// https://www.baeldung.com/spring-boot-internationalization
	// https://www.journaldev.com/2610/spring-mvc-internationalization-i18n-and-localization-l10n-example

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

}