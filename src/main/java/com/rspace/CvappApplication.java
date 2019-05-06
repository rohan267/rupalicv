package com.rspace;

import com.rspace.properties.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.rspace.controller", "com.rspace.service"})
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class CvappApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CvappApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CvappApplication.class);
    }
}