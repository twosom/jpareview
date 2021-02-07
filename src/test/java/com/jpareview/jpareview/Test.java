package com.jpareview.jpareview;


import org.hibernate.Hibernate;

import javax.persistence.*;

public class Test {




    @org.junit.jupiter.api.Test
    void proxyTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("somang");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {


            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("e.getLocalizedMessage() = " + e.getLocalizedMessage());
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
