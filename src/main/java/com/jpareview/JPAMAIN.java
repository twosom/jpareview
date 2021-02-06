package com.jpareview;



import com.jpareview.item.Movie;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;


public class JPAMAIN {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("somang");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Movie movie = new Movie();
            movie.setName("TENET");
            movie.setPrice(15000);
            movie.setActor("존 데이비드 워싱턴");
            movie.setDirector("크리스토퍼 놀란");
            movie.setStockQuantity(1_000_000);
            movie.setCreatedDate(LocalDateTime.of(2020, 8, 12, 0, 0));


            em.persist(movie);
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