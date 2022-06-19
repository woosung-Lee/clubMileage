package me.ws.clubmileage.domain;

import me.ws.clubmileage.domain.enums.ReviewAction;
import me.ws.clubmileage.repository.PlaceRepository;
import me.ws.clubmileage.repository.ReviewRepository;
import me.ws.clubmileage.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@SpringBootTest
@Transactional
public class ReviewTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void domainTest() {
        //user
        String userId  = UUID.randomUUID().toString();
        User user = createUser(userId, "홍길동1");

        //Place
        String placeId  = UUID.randomUUID().toString();
        Place place = createPlace(placeId, "장소1");

        User rsUser = userRepository.findByName("홍길동1");

        //Review
        String reviewId  = UUID.randomUUID().toString();
        Review review = createReview(reviewId, ReviewAction.ADD, "좋아요!", rsUser, place);

        System.out.println("review : " + review.getReviewId());

    }

    private User createUser(String userId, String name) {
        User user = User.builder()
                .userId(userId)
                .name(name)
                .build();
        userRepository.save(user);
        return user;
    }

    private Place createPlace(String placeId, String name) {
        Place place = Place.builder()
                .placeId(placeId)
                .name(name)
                .build();
        placeRepository.save(place);
        return place;
    }

    private Review createReview(String reviewId, ReviewAction action, String content, User user, Place place) {
        Review review = Review.builder()
                .reviewId(reviewId)
                .action(action)
                .content(content)
                .user(user)
                .place(place)
                .build();
        reviewRepository.save(review);
        return review;
    }
}
