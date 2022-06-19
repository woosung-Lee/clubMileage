package me.ws.clubmileage;


import lombok.RequiredArgsConstructor;
import me.ws.clubmileage.domain.Place;
import me.ws.clubmileage.domain.User;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class initDB {

    private final InitService initService;



    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {

            //user 샘플데이터 생성
            String uuid = UUID.randomUUID().toString();

            User user = createUser(uuid, "홍길동");
            em.persist(user);

            //plcae 샘플데이터 작성
            uuid = UUID.randomUUID().toString();
            Place place =createPlace(uuid, "장소1");
            em.persist(place);


        }

        private User createUser(String uuid, String name) {
            User user = User.builder().userId(uuid)
                    .name(name)
                    .build();
            return user;
        }

        private Place createPlace(String uuid, String name) {
            Place place = Place.builder().placeId(uuid)
                    .name(name)
                    .build();
            return place;
        }

    }



}
