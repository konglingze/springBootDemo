package edu.nuc.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    //@Bean
    public Student student(){
        System.out.println("调用构造注入手段");
        return new Student();
    }


}
