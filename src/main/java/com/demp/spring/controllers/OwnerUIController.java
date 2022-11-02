package com.demp.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring.dto.OwnerDTO;
import com.demo.spring.dto.PetDTO;
import com.demo.spring.dto.VetDTO;

@Controller
public class OwnerUIController {
   public String domain="owner-microservice";
    @Autowired
    RestTemplate restTemplate;
    
    @GetMapping(path="/findone")
    public ModelAndView findById(@RequestParam(name="ownerId",required=true) int ownerId) {
        ModelAndView mv = new ModelAndView();
        String message="Owner not found";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Void> request = new HttpEntity<> (headers);
        ResponseEntity<OwnerDTO> response=restTemplate.exchange("http://"+domain+"/owner/findOwner/"+ownerId, HttpMethod.GET,request,OwnerDTO.class);
       if(response.getBody().getOwnerName()!=null) {
    	 mv.addObject("owner",response.getBody())  ;
       }else {
    	   mv.addObject("msg",message);
       }
        
        mv.setViewName("findOwner");
        return mv;
    }
    
    
   
    @PostMapping(path="/findP")
    public ModelAndView findPetById(@RequestParam(name="petId",required=true) int petId) {
        ModelAndView mv = new ModelAndView();
        String message="Pet not found";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Void> request = new HttpEntity<> (headers);
        ResponseEntity<PetDTO> response=restTemplate.exchange("http://"+domain+"/owner/find/"+petId, HttpMethod.GET,request,PetDTO.class);
       if(response.getBody().getPetName()!=null) {
    	   mv.addObject("pet",response.getBody());
       }else {
    	   mv.addObject("msg",message);
       }
       
        mv.setViewName("findPet");
        return mv;
    }
    
   
    
    @PostMapping(path="/addOwnerr")
    public ModelAndView saveOwner(@RequestParam(name="ownerId",required=true) int ownerId,OwnerDTO ownerDto) {
    	  ModelAndView mv = new ModelAndView();
          
          HttpHeaders headers = new HttpHeaders();
          headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
          HttpEntity<OwnerDTO> request = new HttpEntity<>(ownerDto,headers);
          ResponseEntity<String> response=restTemplate.exchange("http://"+domain+"/owner/addOwner/"+ownerId, 
        		  HttpMethod.POST,request, String.class);
          mv.addObject("response",response.getBody());
          mv.setViewName("addOwnerSuccess");
          return mv;
    }
    
    @PostMapping(path="/addPet")
    public ModelAndView savePet(PetDTO petDto) {
    	  ModelAndView mv = new ModelAndView();
          
          HttpHeaders headers = new HttpHeaders();
          headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
          HttpEntity<PetDTO> request = new HttpEntity<>(petDto,headers);
          ResponseEntity<String> response=restTemplate.exchange("http://"+domain+"/owner/addPetToOwner", 
        		  HttpMethod.POST,request, String.class);
          mv.addObject("response",response.getBody());
          mv.setViewName("addPetSuccess");
          return mv;
    }
	
	
	
	  @PostMapping(path="/list") public ModelAndView
	  findAll(@RequestParam(name="ownerId",required=true) int ownerId) {
	  ModelAndView mv = new ModelAndView();
	 String message="owner not found";
	  HttpHeaders headers = new HttpHeaders(); headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);
	  HttpEntity<Void> request = new HttpEntity<> (headers);
	  ResponseEntity<OwnerDTO> response=restTemplate.exchange("http://"+domain+"/owner/findOwner/"+ownerId, HttpMethod.GET,request,OwnerDTO.class);
      if(response.getBody().getOwnerName()!=null) {
	  ResponseEntity<List<PetDTO>>
	  response1=restTemplate.exchange("http://localhost:8181/owner/list/"+ownerId,
	  HttpMethod.GET,request,new ParameterizedTypeReference<List<PetDTO>>() {});
	  
	 
			mv.addObject("petList", response1.getBody());
			
		}else {
			mv.addObject("msg",message);
			
		}mv.setViewName("listPetsOfOwner");
		
		
		return mv;
	}

	  
	  
	 
	 
   
	
	    @PostMapping(path="/deleteOwner")
	    public ModelAndView deleteOwner(@RequestParam(name="ownerId",required=true) int ownerId) {
	    	  ModelAndView mv = new ModelAndView();
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	        HttpEntity<Void> request = new HttpEntity<> (headers);
	        ResponseEntity<String> response=restTemplate.exchange("http://"+domain+"/owner/deleteOwner/"+ownerId, 
	        		  HttpMethod.DELETE,request, String.class);
	        mv.addObject("response",response.getBody());
	          mv.setViewName("deleteSuccess");
	          return mv;
	       
	    	
	    }
	    

	    @PostMapping(path="/update")
	    public ModelAndView updateOwner(@RequestParam(name="ownerId",required=true) int ownerId,@RequestParam(name="ownerContact",required=true) int ownerContact) {
	    	  ModelAndView mv = new ModelAndView();
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	        HttpEntity<Void> request = new HttpEntity<> (headers);
	        ResponseEntity<String> response=restTemplate.exchange("http://"+domain+"/owner/update/"+ownerId+"/"+ownerContact, 
	        		  HttpMethod.PATCH,request, String.class);
	        mv.addObject("response",response.getBody());
	          mv.setViewName("updateSuccess");
	          return mv;
	       
	    	
	    }
	    
	    @PostMapping(path="/delete")
	    public ModelAndView deletePet(@RequestParam(name="petId",required=true) int petId,@RequestParam(name="ownerId",required=true) int ownerId) {
	    	  ModelAndView mv = new ModelAndView();
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	        HttpEntity<Void> request = new HttpEntity<> (headers);
	        ResponseEntity<String> response=restTemplate.exchange("http://"+domain+"/owner/delete/"+petId+"/"+ownerId, 
	        		  HttpMethod.DELETE,request, String.class);
	        mv.addObject("response",response.getBody());
	          mv.setViewName("deleteSuccess2");
	          return mv;
	       
	    	
	    }
	    
	    
	    @GetMapping(path="/listAllOwner")
		public ModelAndView getListOfVets(VetDTO vetDto) {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
			HttpEntity<Void> request = new HttpEntity<>(headers);
			ResponseEntity<List<OwnerDTO>> response = restTemplate.exchange(
					"http://"+domain+"/owner/listowner" , HttpMethod.GET, request,
					new ParameterizedTypeReference<List<OwnerDTO>>() {
					});
			ModelAndView mv=new ModelAndView();
			mv.addObject("ownerList", response.getBody());
			mv.setViewName("listAllOwnersWithPets");
			return mv;
			
			
			
		}
}

