package com.gamingCafe.repository;

import com.gamingCafe.model.Owns;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnsRepository extends CrudRepository<Owns, Integer> {
    
}
