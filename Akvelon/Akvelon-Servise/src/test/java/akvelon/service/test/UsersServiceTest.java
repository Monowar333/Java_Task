package akvelon.service.test;


import akvelon.domain.Users;
import akvelon.domain.dao.UsersDAOImpl;
import akvelon.service.ODEException;
import akvelon.service.UsersServiceImpl;
import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Test;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Жека
 */
public class UsersServiceTest {
     static int iduser;
    static int iduser1;
   
   
    @Test
    public void step_01_saveUsertest(){
         System.out.println(" Save to DB Test, ODEException");
          try {
            Users user = null;
            new UsersServiceImpl().save(user);
            fail("ODEException was expected");
         } catch (ODEException ex) {
    }
    }
    
      @Test
      public void step_02_saveUsertest(){
         System.out.println(" Save to DB Test, Excetion");
          try {
            Users user = new Users();
             user.setName("Test");   
            new UsersServiceImpl().save(user);
            fail("Exception was expected");
         } catch (Exception ex) {
    }
    }
    @Test
    public void step_03_getByIdTest(){
         System.out.println(" Get by id to DB Test, ODEException");
         try {
            new UsersServiceImpl().getById(-5);
            fail("Exception was expected");
         } catch (Exception ex) {
    }
    }
      
         @Test
    public void step_04_getUsrsList(){
         System.out.println(" Get users list Test, Exception");
         try {
            new UsersServiceImpl().getList();
            fail("Exception was expected");
         } catch (Exception ex) {
    }
    }
     @Test
    public void step_05_updateUsertest(){
         System.out.println(" Update  Test, ODEException");
          try {
            Users user = null;
            new UsersServiceImpl().update(user);
            fail("ODEException was expected");
         } catch (ODEException ex) {
    }
    }
    
      @Test
      public void step_06_updateUsertest(){
         System.out.println("Update Test, Excetion");
          try {
            Users user = new Users();
             user.setName("Test");   
            new UsersServiceImpl().update(user);
            fail("Exception was expected");
         } catch (Exception ex) {
    }
    }
    
        
    }
    