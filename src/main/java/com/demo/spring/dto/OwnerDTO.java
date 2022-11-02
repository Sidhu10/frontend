package com.demo.spring.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OwnerDTO {

	 @JsonProperty("ownerId")
private int ownerId;
	
	
	private String ownerName;
	
	
	private String ownerContact;
	
	
	private String ownerCity;
	
	
	private Set<PetDTO> pets;


	public OwnerDTO() {
		
	}


	public OwnerDTO(int ownerId) {
		super();
		this.ownerId = ownerId;
	}


	public OwnerDTO(int ownerId, String ownerName, String ownerContact, String ownerCity, Set<PetDTO> pets) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownerContact = ownerContact;
		this.ownerCity = ownerCity;
		this.pets = pets;
	}


	public int getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}


	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public String getOwnerContact() {
		return ownerContact;
	}


	public void setOwnerContact(String ownerContact) {
		this.ownerContact = ownerContact;
	}


	public String getOwnerCity() {
		return ownerCity;
	}


	public void setOwnerCity(String ownerCity) {
		this.ownerCity = ownerCity;
	}


	public Set<PetDTO> getPets() {
		return pets;
	}


	public void setPets(Set<PetDTO> pets) {
		this.pets = pets;
	}


}
