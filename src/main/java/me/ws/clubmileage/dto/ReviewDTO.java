package me.ws.clubmileage.dto;

import lombok.Data;
import me.ws.clubmileage.domain.Place;
import me.ws.clubmileage.domain.User;
import me.ws.clubmileage.domain.enums.ReviewAction;

import java.util.List;

@Data
public class ReviewDTO {
    private String reviewId;

    private ReviewAction action; //액션종류 (ADD : 추가,  MOD : 수정,  DELETE : 삭제)

    private String content;  //리뷰내용

    private User user;

    private Place place;

    private List<String> attachedPhotoIds;

    public ReviewDTO(String reviewId, ReviewAction action, String content, User user, Place place, List<String> attachedPhotoIds) {
        this.reviewId = reviewId;
        this.action = action;
        this.content = content;
        this.user = user;
        this.place = place;
        this.attachedPhotoIds = attachedPhotoIds;
    }
}
