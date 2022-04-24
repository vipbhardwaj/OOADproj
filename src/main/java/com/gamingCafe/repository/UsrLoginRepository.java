package com.gamingCafe.repository;

import com.gamingCafe.model.UsrLogin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsrLoginRepository extends CrudRepository<UsrLogin, String> {
    
}
