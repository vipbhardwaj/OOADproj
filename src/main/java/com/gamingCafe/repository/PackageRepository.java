package com.gamingCafe.repository;

import java.util.List;

import com.gamingCafe.model.Package;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends CrudRepository<Package, String> {
    @Query("FROM Package AS pkg JOIN pkg.buys AS buy")
    public List<Package> FindAllWithDescriptionQuery();
}
