package com.home.gou;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class GoUApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(GoUApplication.class, args);
    }
//
//    @Override
//    protected void configure(HttpSecurity security) throws Exception
//    {
//        security.httpBasic().disable();
//    }

}
