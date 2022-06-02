package com.webservice.main.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.main.models.Unit;

@Transactional
@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

}
