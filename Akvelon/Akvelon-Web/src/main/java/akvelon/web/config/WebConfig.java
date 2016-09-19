/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvelon.web.config;

import akvelon.web.validate.UsersValidate;
import akvelon.web.validate.ValidateRegular;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Жека
 */
@Configuration
@EnableWebMvc
@ComponentScan({
                               "akvelon.domain",
                                "akvelon.domain.config",
                                "akvelon.domain.DAO",
                                "akvelon.service",
                                "akvelon.service.config",
                                "akvelon.web",
                                "akvelon.web.controller.*",
                                "akvelon.web.config",
                                "akvelon.web.validate"

                                
        
    })
    public class WebConfig extends WebMvcConfigurerAdapter {
        
    /**
     * <mvc:resources mapping="/resources/**" location="/resources/" />
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
        @Bean
         public InternalResourceViewResolver viewResolver() {
         InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
         viewResolver.setViewClass(JstlView.class);
         viewResolver.setPrefix("/WEB-INF/");
         viewResolver.setSuffix(".jsp");
         return viewResolver;
        }
         
         
         @Bean(name = "usersValidate")
        public UsersValidate usersValidate(){
            return new UsersValidate();
        }
        
          @Bean(name = "validateRegular")
        public ValidateRegular validateRegular(){
            return new ValidateRegular();
        }
         
       
    }
