/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvelon.service.config;

import akvelon.service.UsersService;
import akvelon.service.UsersServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Жека
 */
@Configuration
@ComponentScan({
        "akvelon.domain",
        "akvelon.domain.config",
        "akvelon.domain.DAO",
        "akvelon.service",
        "akvelon.service.config"
    })
public class ServiceConfig {
    
    
    @Bean
    public UsersService getUsersService(){
        return new UsersServiceImpl();
    }
    
    
}
