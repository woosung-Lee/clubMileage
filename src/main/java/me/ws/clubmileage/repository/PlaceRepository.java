package me.ws.clubmileage.repository;

import me.ws.clubmileage.domain.Place;
import me.ws.clubmileage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public interface PlaceRepository extends JpaRepository<Place, Long> {


}
