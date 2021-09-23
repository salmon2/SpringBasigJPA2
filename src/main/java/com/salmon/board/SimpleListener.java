package com.salmon.board;

import com.salmon.board.domain.Board;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@NoArgsConstructor
@Component
public class SimpleListener implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        for(int i = 0; i <10; i++){
            Board newBoard = new Board("new title " + i, "new contents " + i,  "writer");

            em.persist(newBoard);
        }

        em.getTransaction().commit();

    }
}
