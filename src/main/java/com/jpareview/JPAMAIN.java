package com.jpareview;

import com.jpareview.domain.Member;
import com.jpareview.practice.MemberPrac;
import com.jpareview.practice.MemberProduct;
import com.jpareview.practice.MemberProductId;
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

            //기본키 값 생성
            MemberProductId memberProductId = new MemberProductId();
            memberProductId.setMember("member1");
            memberProductId.setProduct("productA");

            MemberProduct memberProduct = em.find(MemberProduct.class, memberProductId);

            MemberPrac member = memberProduct.getMember();
            ProductPrac product = memberProduct.getProduct();

            System.out.println("member.getUsername() = " + member.getUsername());
            System.out.println("product.getName() = " + product.getName());
            System.out.println("memberProduct.getOrderAmount() = " + memberProduct.getOrderAmount());

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