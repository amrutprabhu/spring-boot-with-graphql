package com.amrut.prabhu.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, String> {

    List<Address> findByPersonId(Integer personId);
}
