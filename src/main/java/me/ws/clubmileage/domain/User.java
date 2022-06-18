package me.ws.clubmileage.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class User {

    @Id
    @Column(name="user_Id", nullable = false, unique = true)
    private String userId;

    private String name;

    @Builder
    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public User() {

    }
}
