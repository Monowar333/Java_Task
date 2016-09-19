/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvelon.domain;

import java.io.File;
import java.net.URL;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import static org.hibernate.cfg.AvailableSettings.URL;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Жека
 */
public class HibernateUtil {

   private static final SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;
       
    private static SessionFactory buildSessionFactory() {
        try {
            // Создает сессию с hibernate.cfg.xml "user" + File.separator + "password" + File.separator + "host" + File.separator+
           
            
            Configuration configuration = new Configuration().configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
 
            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
//    public File filename (){
//         URL url = this.getClass().getResource("user" + File.separator + "password" + File.separator + "host" + File.separator+"hibernate.cfg");
//         File f = new File(this.getClass().getClassLoader().getResource("555.xml").getFile());
//         System.out.println(f.getAbsoluteFile() + " sdasdasdasdwq23123124341");
//         return f;
//        
//    }
}
