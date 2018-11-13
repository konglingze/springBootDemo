package edu.nuc.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
@ImportResource(locations = "classpath:bean.xml")
@SpringBootApplication
public class SpringBoot02ConfigApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBoot02ConfigApplication.class, args);
    }

}
