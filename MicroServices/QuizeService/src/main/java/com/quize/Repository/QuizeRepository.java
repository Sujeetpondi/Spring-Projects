package com.quize.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quize.Entity.Quize;

public interface QuizeRepository extends JpaRepository<Quize, Long>{

}
