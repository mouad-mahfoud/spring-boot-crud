package com.demo.app.ws.dao.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "companies")
public class CompanyEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column()
    private String address;

    @Column()
    private String logo;

    @OneToOne()
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private UserEntity manager;

}
