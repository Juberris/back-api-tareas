package com.tareas.app;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class ApiTareasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTareasApplication.class, args);
	}

	 @Bean
		public CorsConfigurationSource corsConfigurationSource() {
			CorsConfiguration corsConfig= new CorsConfiguration();
			corsConfig.setAllowedOrigins(Arrays.asList("*"));
			corsConfig.setAllowedMethods(Arrays.asList("POST","GET","PUT","DELETE","OPTIONS"));
			corsConfig.setAllowCredentials(true);
			corsConfig.setAllowedHeaders(Arrays.asList("Authorization","Content-Type"));

			UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", corsConfig);
			
			return source;
		}

		@Bean
		public FilterRegistrationBean<CorsFilter> corsFilter(){
			FilterRegistrationBean<CorsFilter> bean= new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
			bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
			return bean;
		}
}
