package com.covid19api.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "covid19_health_check")
public class Covid19HealthCheck implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phoneInformation")
	private String phoneInformation;
	
	@Column(name = "replyFormDate")
	private Date replyFormDate;
	
	@Column(name = "painsStatus")
	private boolean painsStatus;
	
	@Column(name = "nasalCongestionStatus")
	private boolean nasalCongestionStatus;
	
	@Column(name = "runnyNoseStatus")
	private boolean runnyNoseStatus;
	
	@Column(name = "soreThroatStatus")
	private boolean soreThroatStatus;
	
	@Column(name = "diarrheaStatus")
	private boolean diarrheaStatus;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneInformation() {
		return phoneInformation;
	}
	public void setPhoneInformation(String phoneInformation) {
		this.phoneInformation = phoneInformation;
	}
	public Date getReplyFormDate() {
		return replyFormDate;
	}
	public void setReplyFormDate(Date replyFormDate) {
		this.replyFormDate = replyFormDate;
	}
	public boolean isPainsStatus() {
		return painsStatus;
	}
	public void setPainsStatus(boolean painsStatus) {
		this.painsStatus = painsStatus;
	}
	public boolean isNasalCongestionStatus() {
		return nasalCongestionStatus;
	}
	public void setNasalCongestionStatus(boolean nasalCongestionStatus) {
		this.nasalCongestionStatus = nasalCongestionStatus;
	}
	public boolean isRunnyNoseStatus() {
		return runnyNoseStatus;
	}
	public void setRunnyNoseStatus(boolean runnyNoseStatus) {
		this.runnyNoseStatus = runnyNoseStatus;
	}
	public boolean isSoreThroatStatus() {
		return soreThroatStatus;
	}
	public void setSoreThroatStatus(boolean soreThroatStatus) {
		this.soreThroatStatus = soreThroatStatus;
	}
	public boolean isDiarrheaStatus() {
		return diarrheaStatus;
	}
	public void setDiarrheaStatus(boolean diarrheaStatus) {
		this.diarrheaStatus = diarrheaStatus;
	}

	
}
