package com.demo.spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PetDTO {
	    
	 @JsonProperty("petId")
		private Integer petId;
	    
	   
		private String petName;
	    
	    
		private String petType;
	    
	    
		private Integer owner;


		public PetDTO() {
			
		}


		public PetDTO(Integer petId, String petName, String petType, Integer owner) {
			super();
			this.petId = petId;
			this.petName = petName;
			this.petType = petType;
			this.owner = owner;
		}


		public Integer getPetId() {
			return petId;
		}


		public void setPetId(Integer petId) {
			this.petId = petId;
		}


		public String getPetName() {
			return petName;
		}


		public void setPetName(String petName) {
			this.petName = petName;
		}


		public String getPetType() {
			return petType;
		}


		public void setPetType(String petType) {
			this.petType = petType;
		}


		public Integer getOwner() {
			return owner;
		}


		public void setOwnerId(Integer owner) {
			this.owner = owner;
		}
 
		
		

}
