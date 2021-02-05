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

            ParentId parentId = new ParentId("myId1", "myId2");
            Parent parent = em.find(Parent.class, parentId);
            System.out.println("parent = " + parent);



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