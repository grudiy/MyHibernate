package com.grudiy.myhibernate.dao;

import com.grudiy.myhibernate.entity.Customer;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by grudiy on 21.09.2016.
 */
public class CustomerDao {

    private static final String PERSISTENT_UNIT_NAME = "item-manager-pu";

    private static final EntityManagerFactory emf;

    static {//EntityManagerFactory reads the configuration 1 time for all the time while creating all the exemplars
        // of EMs
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);// now ready EMF
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void findById(int id){
        EntityManager em = emf.createEntityManager(); //creates concrete entity manager. for each method - separate
        em.getTransaction().begin();
        Customer result = em.find(Customer.class, id);
        em.getTransaction().commit();
        em.close();
        System.out.println(result);
    }

    public static void create (Customer customer){
        EntityManager em = emf.createEntityManager();
        Session session = (Session) em.getDelegate();
        session.beginTransaction();
        em.find(Customer.class, session.save(customer));
        session.getTransaction().commit();
        em.close();
    }

}
