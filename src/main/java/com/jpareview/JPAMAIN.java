package com.jpareview;



import com.jpareview.domain.Member;
import com.jpareview.item.Movie;
import review.MemberPrac;
import review.TeamPrac;
import review.example.MemberEx;
import review.example.OrderEx;
import review.example.ProductEx;
import review.example.TeamEx;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;


public class JPAMAIN {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("somang");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

//            TeamEx team = new TeamEx();
//            team.setId("team1");
//            team.setName("teamA");
//            em.persist(team);
//
//
//            MemberEx member = new MemberEx();
//            member.setAge(27);
//            member.setId("member1");
//            member.setUsername("SM");
//            member.setTeamEx(team);
//            em.persist(member);
//
//
//            OrderEx order = new OrderEx();
//            order.setId("order1");
//            em.persist(order);
//            member.addOrder(order);
//
//
//            ProductEx product = new ProductEx();
//            product.setId("product1");
//            product.setName("상품1");
//            em.persist(product);
//
//            order.setProductEx(product);


            MemberEx member = em.find(MemberEx.class, "member1");
            TeamEx team = member.getTeamEx();
            System.out.println("team.getName() = " + team.getName());


            System.out.println("===========================");
            List<OrderEx> orders = member.getOrderExList();
            System.out.println("orders.getClass().getSimpleName( = " + orders.getClass());
            System.out.println("===========================");


            System.out.println("===========================");
            for (OrderEx order : orders) {
                System.out.println(order.getProductEx().getName());
            }
            System.out.println("===========================");

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