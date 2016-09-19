/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvelon.service;

import akvelon.domain.Users;
import akvelon.domain.dao.UsersDAO;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Жека
 */
public class UsersServiceImpl implements UsersService{
      @Autowired
    private UsersDAO usersDao;
      
    @Override
    public void update(Users o) {
        
        Users u = o;
        try{
             if(null == u){
                throw new ODEException("such user is not exist");
            }
            usersDao.update(u);
        }catch(ODEException ex){
            System.out.println("write log - user does not exist");
            throw ex;
        }catch(HibernateException ex){
            System.out.println("hibernate exception occured");
            throw ex;
        }catch(Exception ex){
            System.out.println((ex.getClass()).getName()+ " exception occured");
            throw ex;
        }
     
    }

    @Override
    public void remove(List<Users> o) {
        List<Users> u = o;
        try{
             if(null == u){
                throw new ODEException("such user is not exist");
            }
            usersDao.remove(o);
           
        }catch(ODEException ex){
            System.out.println("write log - user does not exist");
            throw ex;
        }catch(HibernateException ex){
            System.out.println("hibernate exception occured");
            throw ex;
        }catch(Exception ex){
            System.out.println((ex.getClass()).getName()+ " exception occured");
            throw ex;
        }
    }

    @Override
    public List<Users> getList() {
        List<Users> u = null;
        try{
            u = usersDao.getList();
            System.out.println(u.get(0));
            if(null == u){
                throw new ODEException("such user is not exist");
            }
        }catch(ODEException ex){
            System.out.println("write log - user does not exist");
            throw ex;
        }catch(HibernateException ex){
            System.out.println("hibernate exception occured");
            throw ex;
        }catch(Exception ex){
            System.out.println((ex.getClass()).getName()+ " exception occured");
            throw ex;
        }
        return u;
    }
    
     @Override
    public int save(Users o) {
        Integer i  = null;
        Users u = o;
        try{
             if(u == null){
                throw new ODEException("such user is not exist");
            }
            i = usersDao.save(u);
            if( 0 == i){
                throw new ODEException("invalid save");
            }
        }catch(ODEException ex){
            System.out.println("write log - user does not exist");
            throw ex;
        }catch(HibernateException ex){
            System.out.println("hibernate exception occured");
            throw ex;
        }catch(Exception ex){
            System.out.println((ex.getClass()).getName()+ " exception occured");
            throw ex;
        }
       return i;
    } 
    
      @Override
    public Users getById(int id) {
        Users u = null;
        try{
            u = usersDao.getById(id);
            if(null == u){
                throw new ODEException("such user is not exist");
            }
        }catch(ODEException ex){
            System.out.println("write log - user does not exist");
            throw ex;
        }catch(HibernateException ex){
            System.out.println("hibernate exception occured");
            throw ex;
        }catch(Exception ex){
            System.out.println((ex.getClass()).getName()+ " exception occured");
            throw ex;
        }
        return u;
         
    }

}
