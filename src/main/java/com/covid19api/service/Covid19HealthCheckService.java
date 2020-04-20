package com.covid19api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.covid19api.domain.Covid19HealthCheck;
import com.covid19api.repository.Covid19HealthCheckRepository;

@Service
public class Covid19HealthCheckService {

	@Autowired
	private Covid19HealthCheckRepository covid19HealthCheckRepository;
	
	public List<Covid19HealthCheck> findAll() {
		return this.covid19HealthCheckRepository.findAll();
	}
	
	public List<Covid19HealthCheck> findByEmail(@Param("email") String email) {
		return this.covid19HealthCheckRepository.findByEmail(email);
	}
	
	public List<Covid19HealthCheck> findByName(@Param("name") String name) {
		return this.covid19HealthCheckRepository.findByName(name);
	}
	
	public void save(Covid19HealthCheck covid19HealthCheck) {
		this.covid19HealthCheckRepository.save(covid19HealthCheck);
	}
}
