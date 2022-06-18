package me.ws.clubmileage.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Place {
    @Id
    @Column(name="place_Idd", nullable = false, unique = true)
    private String placeId;

    private String name;

    @Builder
    public Place(String placeId, String name) {
        this.placeId = placeId;
        this.name = name;
    }

    public Place() {

    }
}
