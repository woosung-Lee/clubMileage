package me.ws.clubmileage.domain;

import me.ws.clubmileage.domain.enums.ReviewAction;
import me.ws.clubmileage.repository.PlaceRepository;
import me.ws.clubmileage.repository.ReviewRepository;
import me.ws.clubmileage.repository.UserRepository;
import me.ws.clubmileage.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
//@Transactional
public class ReviewTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserService userService;

    @Test
    void domainTest() {
        //user
        String userId  = UUID.randomUUID().toString();
        User user = createUser(userId, "홍길동1");

        //Place
        String placeId  = UUID.randomUUID().toString();
        Place place = createPlace(placeId, "장소1");

        User rsUser = userService.findUser(user);

        //List<User> rsUserList = userService.findByUserList(user);

        //Review
        String reviewId  = UUID.randomUUID().toString();


        //첨부파일 리스트 셋팅
        List<String> attachLists = new ArrayList<String>();
        String attachedPhotoIds  = UUID.randomUUID().toString();
        attachLists.add(attachedPhotoIds);

        attachedPhotoIds  = UUID.randomUUID().toString();
        attachLists.add(attachedPhotoIds);

        attachedPhotoIds  = UUID.randomUUID().toString();
        attachLists.add(attachedPhotoIds);

        Review review = createReview(reviewId, ReviewAction.ADD, "좋아요!", rsUser, place, attachLists);
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

    private Review createReview(String reviewId, ReviewAction action, String content, User user, Place place, List<String> attachedPhotoIds) {
        Review review = Review.builder()
                .reviewId(reviewId)
                .action(action)
                .content(content)
                .user(user)
                .place(place)
                .attachedPhotoIds(attachedPhotoIds)
                .build();
        reviewRepository.save(review);
        return review;
    }
}
