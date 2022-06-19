package me.ws.clubmileage.domain;

import me.ws.clubmileage.repository.PlaceRepository;
import me.ws.clubmileage.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

//@SpringBootTest
//@Transactional
public class PlaceTest {
    @Autowired
    private PlaceRepository placeRepository;

    //@Test
 /*   void domainTest() {
        String uuid  = UUID.randomUUID().toString();
        createPlace(uuid, "장소1");
    }*/

    private Place createPlace(String placeId, String name) {
        Place place = Place.builder()
                .placeId(placeId)
                .name(name)
                .build();
        placeRepository.save(place);
        return place;
    }

}
