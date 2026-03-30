package com.gm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gm.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
