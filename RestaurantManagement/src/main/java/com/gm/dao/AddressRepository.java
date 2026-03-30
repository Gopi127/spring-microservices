package com.gm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gm.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
