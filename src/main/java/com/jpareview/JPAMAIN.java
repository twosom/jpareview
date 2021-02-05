package com.jpareview;


import com.jpareview.domain.Category;
import com.jpareview.domain.CategoryItem;
import com.jpareview.domain.Item;
import com.jpareview.practice.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JPAMAIN {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("somang");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            ParentId id1 = new ParentId();
            id1.setId1("myId1");
            id1.setId2("myId2");

            ParentId id2 = new ParentId();
            id2.setId1("myId1");
            id2.setId2("myId2");


            System.out.println("id1 == it2 : " + id1.equals(id2));

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("e.getLocalizedMessage() = " + e.getLocalizedMessage());
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}