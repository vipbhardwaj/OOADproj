package com.gamingCafe.repository;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import com.gamingCafe.model.Owns;
import com.gamingCafe.model.OwnsComposite;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnsRepository extends CrudRepository<Owns, Integer> {
    @Query("select o from Owns o join Game g where o.p_email = :p_email AND g.g_id = o.g_id")
    List<Owns> findAllBypEmail(@Param("p_email") String p_email);
    
    @Transactional
    @Query("delete from Owns o where o.p_email = :email AND o.g_id = :id")
    void deleteBypEmailAndGid(@Param("email") String e, @Param("id") String g);
}
