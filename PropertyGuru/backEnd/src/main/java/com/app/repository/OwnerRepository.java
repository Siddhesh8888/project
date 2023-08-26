package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{

}
