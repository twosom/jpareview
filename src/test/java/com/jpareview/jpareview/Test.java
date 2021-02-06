package com.jpareview.jpareview;


import org.assertj.core.api.Assertions;
import org.hibernate.Hibernate;
import org.hibernate.jpa.internal.PersistenceUnitUtilImpl;
import org.hibernate.proxy.HibernateProxy;
import review.MemberPrac;
import review.TeamPrac;

import javax.persistence.*;

public class Test {




    @org.junit.jupiter.api.Test
    void proxyTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("somang");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            MemberPrac member = em.getReference(MemberPrac.class, 3L);

            System.out.println("member.getClass().getSimpleName() = " + member.getClass().getSimpleName());

            Hibernate.initialize(member);

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
