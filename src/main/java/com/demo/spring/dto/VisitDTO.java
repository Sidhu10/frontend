package com.demo.spring.dto;



public class VisitDTO {
	
    private Integer visitId;
    private Integer ownerId;
	private Integer petId;
	private String purpose;
	private String speciality;
	private String dateTime;
	
	
	public VisitDTO() {
		
	}


	public VisitDTO(Integer visitId, Integer ownerId, Integer petId, String purpose, String speciality,
			String dateTime) {
		
		this.visitId = visitId;
		this.ownerId = ownerId;
		this.petId = petId;
		this.purpose = purpose;
		this.speciality = speciality;
		this.dateTime = dateTime;
	}


	public Integer getVisitId() {
		return visitId;
	}


	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}


	public Integer getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}


	public Integer getPetId() {
		return petId;
	}


	public void setPetId(Integer petId) {
		this.petId = petId;
	}


	public String getPurpose() {
		return purpose;
	}


	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}


	public String getSpeciality() {
		return speciality;
	}


	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	public String getDateTime() {
		return dateTime;
	}


	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
	

}
