package com.gm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gm.model.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

}
