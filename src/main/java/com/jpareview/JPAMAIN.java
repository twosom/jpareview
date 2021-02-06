package com.jpareview;


import com.jpareview.domain.*;
import com.jpareview.item.Book;
import com.jpareview.item.Item;
import com.jpareview.item.Movie;
import review.MemberPrac;
import review.TeamPrac;
import review.example.*;


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

            //주문생성
            Delivery delivery = new Delivery();
            delivery.setStatus(DeliveryStatus.ORDER);
            delivery.setCity("INCHEON");
            delivery.setStreet("GILJUNAM-RO");
            delivery.setZipcode("20213");
            delivery.setCreatedDate(LocalDateTime.now());
            delivery.setLastModifiedDate(LocalDateTime.now());



            //주문아이템 생성
            OrderItem orderItem1 = new OrderItem();
            Movie movie = new Movie();
            movie.setName("TENET");
            movie.setCreatedDate(LocalDateTime.of(2020, 8, 12, 0, 0));
            movie.setActor("John David Washington");
            movie.setPrice(15_000);
            movie.setDirector("Christopher Nolan");
            movie.setStockQuantity(1_992_467);
            em.persist(movie);
            orderItem1.setItem(movie);


            //주문아이템 생성
            OrderItem orderItem2 = new OrderItem();
            Book book = new Book();
            book.setCreatedDate(LocalDateTime.of(2015, 07, 28, 0, 0));
            book.setName("자바 ORM 표준 JPA 프로그래밍 ");
            book.setIsbn("9788960777330");
            book.setAuthor("김영한");
            book.setPrice(43_000);
            book.setStockQuantity(5_000_000);
            em.persist(book);
            orderItem2.setItem(book);




            Order order = new Order();
            order.setDelivery(delivery);
            order.addOrderItem(orderItem1);
            order.addOrderItem(orderItem2);



            em.persist(order);

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