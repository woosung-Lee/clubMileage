package me.ws.clubmileage.domain;

import lombok.Builder;
import lombok.Getter;
import me.ws.clubmileage.domain.enums.ReviewAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.util.List;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
public class Review {
    @Id
    @Column(name="review_Id", nullable = false, unique = true)
    private String reviewId;

    @Enumerated(EnumType.STRING)
    private ReviewAction action; //액션종류 (ADD : 추가,  MOD : 수정,  DELETE : 삭제)

    private String content;  //리뷰내용

    @ManyToOne(fetch = LAZY) // 여러개의 리뷰(Many)가 하나의 멤버와 매핑됨(One)
    @JoinColumn(name = "userId") // Foreign Key의 이름
    private User user;

    @ManyToOne(fetch = LAZY) // 여러개의 장소(Many)가 하나의 멤버와 매핑됨(One)
    @JoinColumn(name = "placeId") // Foreign Key의 이름
    private Place place;


    @ElementCollection // Reivew의 ID에 연결되어 관리, 첨부파일 id 리스트
    @CollectionTable(name = "ATTACH_PHOTO", joinColumns = @JoinColumn(name = "review_Id"))
    private List<String> attachedPhotoIds;


    @Builder
    public Review(String reviewId, ReviewAction action, String content, User user, Place place, List<String> attachedPhotoIds) {
        this.reviewId = reviewId;
        this.action = action;
        this.content = content;
        this.user = user;
        this.place = place;
        this.attachedPhotoIds = attachedPhotoIds;
    }

    public Review() {

    }
}
