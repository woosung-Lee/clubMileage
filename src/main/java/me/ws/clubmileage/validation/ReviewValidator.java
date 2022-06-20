package me.ws.clubmileage.validation;

import lombok.RequiredArgsConstructor;
import me.ws.clubmileage.domain.Review;
import me.ws.clubmileage.domain.enums.ReviewAction;
import me.ws.clubmileage.dto.ReviewDTO;
import me.ws.clubmileage.exception.CustomException;
import me.ws.clubmileage.exception.ErrorCode;
import me.ws.clubmileage.repository.PlaceRepository;
import me.ws.clubmileage.repository.ReviewRepository;
import me.ws.clubmileage.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ReviewValidator {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;

    public void validate(ReviewDTO reviewDTO) {
        if (reviewDTO.getAction() == ReviewAction.ADD) {
            checkDuplication(reviewDTO);
        }

        if(reviewDTO.getContent().length() == 0) {
            //content는 필수 입력값 입니다.
            throw new CustomException("Content is mandatory.", ErrorCode.NOTEMPTY_CONTENT);
        }

    }

    private void checkDuplication(ReviewDTO reviewDTO) {
        List<Review> reviews = reviewRepository.findReview(reviewDTO.getUser().getUserId(), reviewDTO.getPlace().getPlaceId());

        if(reviews.size() >0) {
            for(Review review : reviews) {
                //리뷰가 이미 등록되어 있습니다.  에러메세지
                throw new CustomException("A review has already been registered.", ErrorCode.DUPLICATE_REVIEW);
            }
        }
    }


}
