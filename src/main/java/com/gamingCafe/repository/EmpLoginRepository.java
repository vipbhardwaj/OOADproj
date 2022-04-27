package com.gamingCafe.repository;

import com.gamingCafe.model.EmpLogin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpLoginRepository extends CrudRepository<EmpLogin, String> {

}
