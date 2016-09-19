package akvelon.damin.dao.test;


import akvelon.domain.Users;
import akvelon.domain.dao.UsersDAOImpl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
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
public class UserDAOTest {
     static int iduser;
    static int iduser1;
    @BeforeClass 
    public static void newUser(){
            
            Users user = new Users();
             user.setName("Test");   
             user.setAge(50);
             user.setRegisterDate(new Date());
             user.setRole("admin");
             user.setStatusregistr(true);
             user.setPassword("Test");
             BigDecimal b = new BigDecimal(24);
             user.setWeight(b);
             user.setUsername("Test");
            iduser1 = new UsersDAOImpl().save(user);
            System.out.println(iduser1 + " Creat");
            
    }
    
    @AfterClass
     public static void removeUser(){
            List<Users> us = new ArrayList<Users>();
          Users user = new UsersDAOImpl().getById(iduser);
           Users user1 = new UsersDAOImpl().getById(iduser1);
           us.add(user);
           us.add(user1);
           new UsersDAOImpl().remove(us);
    }
   
    @Test
    public void step_01_saveUsertest(){
         System.out.println(" Save to DB Test");
         Users user = new Users();
             user.setName("Test2");   
             user.setAge(50);
             user.setRegisterDate(new Date());
             user.setRole("admin2");
             user.setStatusregistr(true);
             user.setWeight(BigDecimal.ZERO);
             user.setUsername("Test2");
             user.setPassword("Test2");
            iduser = new UsersDAOImpl().save(user);
            System.out.println(iduser + " Creat");
            Users user1 = new UsersDAOImpl().getById(iduser);
        Assert.assertNotNull("entity not found", user1);
        Assert.assertEquals(iduser, (long)user1.getId());
    }
    
    @Test
    public void step_02_getByIdTest(){
        System.out.println(" Get by ID Test");
        Users user = new UsersDAOImpl().getById(iduser1);
        Assert.assertNotNull("entity not found", user);
        Assert.assertEquals(iduser1, (long)user.getId());
    }
    
      @Test
    public void step_03_getList(){
        System.out.println(" Get all Users from DB Test");
       List<Users> user = new UsersDAOImpl().getList();
        Assert.assertNotNull("entity not found", user);
    }
    
  
    
    @Test
    public void step_04_insertUpdate(){
        
        Users user = new UsersDAOImpl().getById(iduser1);
            user.setPassword("TestPassword");
            new UsersDAOImpl().update(user);
            Users user1 = new UsersDAOImpl().getById(iduser1);
        Assert.assertNotNull("entity not found", user1);
        Assert.assertEquals("TestPassword", user1.getPassword());
    }
    
    
    
    
//    @Test
//    public void step_03_removeTest(){
//          
//           user = new UsersDAO().getById(iduser1);
//        Assert.assertNull("entity not found", user);
//       // Assert.assertEquals(iduser, (long)user.getId());
//    }
}
