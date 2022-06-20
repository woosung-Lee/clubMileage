package me.ws.clubmileage.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import me.ws.clubmileage.domain.QUser;
import me.ws.clubmileage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository  {

    @PersistenceContext
    private EntityManager em;


    public  User findByUser(User user){
        return em.find(User.class, user);
    }

    public void save(User user) {
        em.persist(user);
    }

    /*public List<User> findByUserList(User user) {
        JPAQueryFactory query = new JPAQueryFactory(em);
        QUser qUser = QUser.user;

        List<User> rsUser = query.selectFrom(qUser).stream().toList();

        return rsUser;
    }*/
}
