package com.jpareview;

import com.jpareview.practice.MemberPrac;
import com.jpareview.practice.ProductPrac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class JPAMAIN {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("somang");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

//            MemberPrac member1 = new MemberPrac();
//            member1.setId("member3");
//            member1.setUsername("회원3");
//            em.persist(member1);
//
//
//            ProductPrac productA = em.find(ProductPrac.class, "productA");
//            member1.addProduct(productA);

            em.flush();
            em.clear();

            ProductPrac findProduct = em.find(ProductPrac.class, "productA");
            List<MemberPrac> members = findProduct.getMembers();
            for (MemberPrac member : members) {
                System.out.println("member.getUsername() = " + member.getUsername());
            }
//            MemberPrac findMember = em.find(MemberPrac.class, "member1");
//            List<ProductPrac> products = findMember.getProducts();
//            for (ProductPrac product : products) {
//                System.out.println("product.getName() = " + product.getName());
//            }

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