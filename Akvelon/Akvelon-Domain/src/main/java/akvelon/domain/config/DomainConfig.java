/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvelon.domain.config;

import akvelon.domain.dao.UsersDAO;
import akvelon.domain.dao.UsersDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Жека
 */
@Configuration
@ComponentScan("akvelon.domain.DAO")
public class DomainConfig {
        //инекция зависимости самого контейнера, создаем бин который может быть внедренно  
    
    @Bean
    public UsersDAO getUserDao(){
        return new UsersDAOImpl();
    }
    
    
}
