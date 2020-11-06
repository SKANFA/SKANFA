package com.github.skanfa.core;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Getter;
import lombok.Setter;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {
	@Getter
	@Setter
	private int port;

	public static void main(String[] args) {
		int initPort = 8086;

		Application mainApp = new Application();
		mainApp.setPort(initPort);
		mainApp.start();
	}

	private void start() {
		SpringApplication springApplication = new SpringApplication(Application.class);
		Map<String, Object> properties = new HashMap<>();

		// properties.put("server.servlet.context-path", "/api");

		properties.put("server.port", String.valueOf(getPort()));
		properties.put("spring.main.banner-mode", "off");

		// DB
		StringBuilder dbsStringBuilder = new StringBuilder();
		String postresqlHost = "localhost";
		int postresqlPort = 5432;

		String username = "db_test_user";
		String passwd = "db_test_user_pass";
		String DataBaseName = "db_test";

		dbsStringBuilder.append("jdbc:postgresql://");

		dbsStringBuilder.append(postresqlHost);
		dbsStringBuilder.append(":");
		dbsStringBuilder.append(postresqlPort);

		dbsStringBuilder.append("/");
		dbsStringBuilder.append(DataBaseName);
		dbsStringBuilder.append("?serverTimezone=UTC");

		System.err.println(dbsStringBuilder);
		properties.put("spring.datasource.hikari.connectionTimeout", "20000");
		// DEFAULT 5
		properties.put("spring.datasource.hikari.maximumPoolSize", "100");
		properties.put("spring.datasource.url", dbsStringBuilder.toString());
		properties.put("spring.datasource.username", username);
		properties.put("spring.datasource.password", passwd);
		properties.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("spring.jpa.hibernate.ddl-auto", "update");
		// DB

		//
		// WEB-SEC
		properties.put("jwt.token.secret", "jwtappdemojwtappdemo");
		properties.put("jwt.token.expired", "3600000");
		// WEB-SEC
		springApplication.setDefaultProperties(properties);
		springApplication.run("");
	}
}
