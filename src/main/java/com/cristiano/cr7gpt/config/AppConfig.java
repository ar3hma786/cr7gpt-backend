package com.cristiano.cr7gpt.config;

import java.util.Arrays;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;


@Configuration
@EnableWebSecurity
public class AppConfig {
	
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .sessionManagement(sessionManagement ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/api/**").permitAll()
                    .anyRequest().permitAll()
            )
            .addFilterBefore((Filter) new JwtValidator(), BasicAuthenticationFilter.class)
            .oauth2Login(oauth2 -> oauth2
            	    .loginPage("http://localhost:5173/login")  
            	    .defaultSuccessUrl("http://localhost:5173/", true)  
            	    .failureUrl("http://localhost:5173/login?error=true") 
            	)

            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(corsConfigurationSource()));

        return httpSecurity.build();
    }

	private CorsConfigurationSource corsConfigurationSource() {
        return new CorsConfigurationSource() {
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration cfg = new CorsConfiguration();
				 cfg.setAllowedOrigins(Arrays.asList(
		                    "http://localhost:5173"
		                ));
		                cfg.setAllowedMethods(Collections.singletonList("*"));
		                cfg.setAllowCredentials(true);
		                cfg.setAllowedHeaders(Collections.singletonList("*"));
		                cfg.setExposedHeaders(Arrays.asList("Authorization"));
		                cfg.setMaxAge(3600L);
		                return cfg;
			}
        };
	}
	
	@Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
}