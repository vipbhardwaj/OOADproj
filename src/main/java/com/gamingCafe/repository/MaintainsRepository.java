package com.gamingCafe.repository;

import com.gamingCafe.model.Maintains;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintainsRepository extends CrudRepository<Maintains, String> {
    
}
    