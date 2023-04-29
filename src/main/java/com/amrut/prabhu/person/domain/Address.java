package com.amrut.prabhu.person.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {

    @Id
    private Integer id;
    private Integer personId;

    private String street;
    private AddressType type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }
}
