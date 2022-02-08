package com.demo.app.ws.dao.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity(name = "agencies")
public class AgencyEntity extends BaseEntity{

    @Column( unique = true)
    private String name;

    @ManyToOne()
    private CityEntity city;

    @ManyToOne()
    private CompanyEntity companyEntity;



}
