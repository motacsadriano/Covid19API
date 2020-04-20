package com.covid19api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.covid19api.domain.Covid19HealthCheck;

public interface Covid19HealthCheckRepository extends JpaRepository<Covid19HealthCheck, Long>{

	public List<Covid19HealthCheck> findAll();
	
	public List<Covid19HealthCheck> findByEmail(@Param("email") String email);
	
	public List<Covid19HealthCheck> findByName(@Param("name") String name);
}
