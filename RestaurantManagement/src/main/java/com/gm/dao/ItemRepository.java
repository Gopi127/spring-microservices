package com.gm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gm.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
