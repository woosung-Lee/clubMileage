package me.ws.clubmileage.repository;

import me.ws.clubmileage.domain.Review;
import me.ws.clubmileage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, String> {

}
