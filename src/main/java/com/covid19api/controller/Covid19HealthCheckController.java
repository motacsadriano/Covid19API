package com.covid19api.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid19api.domain.Covid19HealthCheck;
import com.covid19api.service.Covid19HealthCheckService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/covid19")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Covid19HealthCheckController {

	@Autowired
	private Covid19HealthCheckService covid19HealthCheckService;
	
	public Covid19HealthCheckController(Covid19HealthCheckService service) {
		this.covid19HealthCheckService = service;
	}
	
	@RequestMapping(value = "/healthcheck", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> saveForm(@RequestBody Covid19HealthCheck covid19HealthCheck) throws JsonProcessingException {
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String today = format.format(new GregorianCalendar().getTime());

		System.out.println("today: "+today);
		List<Covid19HealthCheck> list = this.covid19HealthCheckService.findByEmail(covid19HealthCheck.getEmail());
		
		for (Covid19HealthCheck healthCheck : list) {
			System.out.println("format.format(healthCheck.getReplyFormDate()))>>> "+format.format(healthCheck.getReplyFormDate()));
			
			if(today.equals(format.format(healthCheck.getReplyFormDate()))) {
				return new ResponseEntity<String>("You already answered this form today. Please, we receive only one form reply per day. Try it tomorrow", HttpStatus.FORBIDDEN);
			}
		}
		
		list = this.covid19HealthCheckService.findByName(covid19HealthCheck.getName());
		
		for (Covid19HealthCheck healthCheck : list) {
			System.out.println("format.format(healthCheck.getReplyFormDate()))>>> "+format.format(healthCheck.getReplyFormDate()));
			
			if(today.equals(format.format(healthCheck.getReplyFormDate()))) {
				return new ResponseEntity<String>("You already answered this form today. Please, we receive only one form reply per day. Try it tomorrow", HttpStatus.FORBIDDEN);
			}
		}
		
		covid19HealthCheck.setReplyFormDate(new GregorianCalendar().getTime());
		this.covid19HealthCheckService.save(covid19HealthCheck);
	
		if(covid19HealthCheck.isNasalCongestionStatus()==true &&
				covid19HealthCheck.isRunnyNoseStatus()==true &&
						covid19HealthCheck.isPainsStatus()==true &&
								covid19HealthCheck.isDiarrheaStatus()==true &&
										covid19HealthCheck.isSoreThroatStatus()==true) {
			return new ResponseEntity<String>("You have all the symptoms for COVID19. Please, go to the Hospital and May the Force be with you...", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<String>("For while, you may have an Influeza or just a Cold, but take care with the symptoms evolution", HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
	public List<Covid19HealthCheck> findAll() {
		return this.covid19HealthCheckService.findAll();
	}
}
