package com.github.skanfa.core.init.config;

import com.github.skanfa.core.service.HelloService;
import com.github.skanfa.core.service.ReverseService;
import com.github.skanfa.core.service.users.UserService;
import com.github.skanfa.core.service.vk.CodeFromVkService;
import javax.servlet.Filter;
import org.apache.catalina.filters.RequestDumperFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HelloService.class);
        register(ReverseService.class);
        register(CodeFromVkService.class);
        register(UserService.class);
    }

    @Bean
    public FilterRegistrationBean requestDumperFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        Filter requestDumperFilter = new RequestDumperFilter();
        registration.setFilter(requestDumperFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }
}
