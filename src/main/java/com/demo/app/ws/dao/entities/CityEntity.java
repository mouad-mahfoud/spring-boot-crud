package com.demo.app.ws.dao.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "cities")
public class CityEntity{

    @Id
    @GeneratedValue
    protected long id;
    private String name;
}
