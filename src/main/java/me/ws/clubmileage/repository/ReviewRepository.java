package me.ws.clubmileage.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import me.ws.clubmileage.domain.QReview;
import me.ws.clubmileage.domain.QUser;
import me.ws.clubmileage.domain.Review;
import me.ws.clubmileage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ReviewRepository {

    @PersistenceContext
    private EntityManager em;

    public  List<Review> findReview(String userId, String placeId){
        JPAQueryFactory query = new JPAQueryFactory(em);
        QReview qReview = QReview.review;

        List<Review> reviewList = query.selectFrom(qReview).stream().toList();

        return reviewList;
    }

    public void save(Review review) {
        em.persist(review);
    }

}
