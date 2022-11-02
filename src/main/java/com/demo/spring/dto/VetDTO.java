package com.demo.spring.dto;



public class VetDTO {
	
	
	private Integer vetId;
	
	
	private String vetName;
	
	
	private String vetContact;
	
	
	private String vetCity;
	
	

	
	

	
	
	private Integer speciality;








	public VetDTO() {
		super();
	}








	public VetDTO(Integer vetId, String vetName, String vetContact, String vetCity, Integer speciality) {
		super();
		this.vetId = vetId;
		this.vetName = vetName;
		this.vetContact = vetContact;
		this.vetCity = vetCity;
		this.speciality = speciality;
	}








	public Integer getVetId() {
		return vetId;
	}








	public void setVetId(Integer vetId) {
		this.vetId = vetId;
	}








	public String getVetName() {
		return vetName;
	}








	public void setVetName(String vetName) {
		this.vetName = vetName;
	}








	public String getVetContact() {
		return vetContact;
	}








	public void setVetContact(String vetContact) {
		this.vetContact = vetContact;
	}








	public String getVetCity() {
		return vetCity;
	}








	public void setVetCity(String vetCity) {
		this.vetCity = vetCity;
	}








	public Integer getSpeciality() {
		return speciality;
	}








	public void setSpeciality(Integer speciality) {
		this.speciality = speciality;
	}


	

	

	
	
	

}

