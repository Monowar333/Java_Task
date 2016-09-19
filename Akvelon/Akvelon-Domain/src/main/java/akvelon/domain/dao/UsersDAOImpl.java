/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvelon.domain.dao;

import akvelon.domain.HibernateUtil;
import akvelon.domain.Users;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Жека
 */
public class UsersDAOImpl implements UsersDAO{

    @Override
    public void update(Users o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        try{
            session.update(o);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void remove(List<Users> o) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        try{
            for(Users u: o){
                session.delete(u);
            }
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public List<Users> getList() {
      Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Users.class); 
        List<Users> uList = (List<Users>)crit.list();
        session.close();
        return uList;  
    }
    
       @Override
    public int save(Users o) {
        int result;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        try{
            result = (Integer)session.save(o);
            tx.commit();
        }catch(Exception ex){
            result = 0;
            tx.rollback();
        }finally{
            session.close();
        }
        return result;   
    }
    
     @Override
    public Users getById(int id) {
         Session session = HibernateUtil.getSessionFactory().openSession();
               
        Criteria crit = session.createCriteria(Users.class)
                .add(Restrictions.eq("id", id));
        Users u = (Users)crit.uniqueResult();
        session.close();
        return u;
    }
    
}
