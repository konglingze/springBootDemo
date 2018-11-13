package edu.nuc.springboot.config;

import edu.nuc.springboot.component.DateConverter;
import edu.nuc.springboot.component.LoginHandlerIntercepter;
import edu.nuc.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      //  registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**")
      //          .excludePathPatterns("/index.html", "/", "/user/login", "/asserts/**", "/webjars/**", "/templates/common/**");

    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard.html");

    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //super.addResourceHandlers(registry);
    }

       @Override
    public void addFormatters(FormatterRegistry registry) {
        DateConverter dateConverter = new DateConverter();
        registry.addConverter(dateConverter);
    }
}
