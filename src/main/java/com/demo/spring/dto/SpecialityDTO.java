package com.demo.spring.dto;

import java.util.HashSet;
import java.util.Set;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;



public class SpecialityDTO {
	
	private Integer specialityId;

	
	private String sName;

	
	
	
	private Set<VetDTO> vets;




	public SpecialityDTO() {
		super();
	}




	public SpecialityDTO(Integer specialityId, String sName, Set<VetDTO> vets) {
		super();
		this.specialityId = specialityId;
		this.sName = sName;
		this.vets = vets;
	}




	public SpecialityDTO(Integer specialityId, String sName) {
		super();
		this.specialityId = specialityId;
		this.sName = sName;
	}




	public Integer getSpecialityId() {
		return specialityId;
	}




	public void setSpecialityId(Integer specialityId) {
		this.specialityId = specialityId;
	}




	public String getsName() {
		return sName;
	}




	public void setsName(String sName) {
		this.sName = sName;
	}




	public Set<VetDTO> getVets() {
		return vets;
	}




	public void setVets(Set<VetDTO> vets) {
		this.vets = vets;
	}

	

	

}

