package me.ws.clubmileage.repository;

import me.ws.clubmileage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByName(String name);
}
