package com.salmon.board;

import com.salmon.board.domain.Board;
import com.salmon.board.domain.Comment;
import com.salmon.board.domain.User;
import com.salmon.board.domain.UserRoleEnum;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

@NoArgsConstructor
@Component
public class SimpleListener implements ApplicationListener<ApplicationStartedEvent> {
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationStartedEvent event) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        User testUser1 = new User("슈가1", passwordEncoder.encode("123"), "sugar1@sparta.com", UserRoleEnum.USER);
        User testUser2 = new User("슈가2", passwordEncoder.encode("123"), "sugar2@sparta.com", UserRoleEnum.USER);
        User admin = new User("root", passwordEncoder.encode("asdf"), "root@sparta.com", UserRoleEnum.ADMIN);

        em.persist(testUser1);
        em.persist(testUser2);

        for(int i = 0; i <10; i++){
            Board newBoard = new Board("new title " + i, "new contents " + i,  "writer " + i, testUser1);

            em.persist(newBoard);


            for (int j = 0; j<2; j++){
                Comment newComment = new Comment("new comment " + i, newBoard, testUser2);
                em.persist(newComment);

            }

        }
        em.getTransaction().commit();

    }
}
