package me.ws.clubmileage.service;

import lombok.RequiredArgsConstructor;
import me.ws.clubmileage.domain.Review;
import me.ws.clubmileage.domain.User;
import me.ws.clubmileage.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User findUser(User user) {
        return userRepository.findByUser(user);
    }

    public String join(User user) {
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getUserId();
    }

    private void validateDuplicateUser(User user) {

    }

   /* public List<User> findByUserList(User user) {
        return userRepository.findByUserList(user);
    }*/
}
