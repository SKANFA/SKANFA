package com.github.skanfa.core.init;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);

        Map<String, Object> properties = new HashMap<>();
        properties.put("server.servlet.context-path", "/api");
        properties.put("server.port", "8086");
        properties.put("spring.main.banner-mode", "off");
        application.setDefaultProperties(properties);
        application.run(args);
    }

    /*
    @Bean
    ServletRegistrationBean myServletRegistration() {
        //FIXME
        ServletRegistrationBean srb = new ServletRegistrationBean();
        return srb;
    }*/
}
