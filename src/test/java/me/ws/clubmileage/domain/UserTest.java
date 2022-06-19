package me.ws.clubmileage.domain;


import me.ws.clubmileage.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.UUID;

@SpringBootTest
@Transactional
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void domainTest() {
        String uuid  = UUID.randomUUID().toString();
        createUser(uuid, "홍길동1");
    }

    private User createUser(String userId, String name) {
        User user = User.builder()
                .userId(userId)
                .name(name)
                .build();
        userRepository.save(user);
        return user;
    }
}
