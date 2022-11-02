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
import com.demo.spring.dto.SpecialityDTO;
import com.demo.spring.dto.VetDTO;

@Controller
public class VetUIController {
	public String domain1="vet-microservice";
	@Autowired
	RestTemplate restTemplate;

	@GetMapping(path = "/findV")
	public ModelAndView findById(@RequestParam(name = "vetId", required = true) int vetId) {
		ModelAndView mv = new ModelAndView();
       String message="vet not found";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Void> request = new HttpEntity<>(headers);
		ResponseEntity<VetDTO> response = restTemplate.exchange("http://"+domain1+"/vet/findVet/" + vetId,
				HttpMethod.GET, request, VetDTO.class);
		if (response.getBody().getVetName()!=null) {
			mv.addObject("vet", response.getBody());
		}else {
			mv.addObject("msg",message);
		}
		
		mv.setViewName("findVet");
		return mv;
	}

	@PostMapping(path = "/addV")
	public ModelAndView saveVet(@RequestParam(name = "specialityId", required = true) int specialityId, VetDTO vetDto) {
		ModelAndView mv = new ModelAndView();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<VetDTO> request = new HttpEntity<>(vetDto, headers);
		ResponseEntity<String> response = restTemplate.exchange("http://"+domain1+"/vet/addVet/" +specialityId,
				HttpMethod.POST, request, String.class);
		mv.addObject("response", response.getBody());
		mv.setViewName("addVetSuccess");
		return mv;
	}

	@PostMapping(path = "/deleteV")
	public ModelAndView deleteVet(@RequestParam(name = "vetId", required = true) int vetId) {
		ModelAndView mv = new ModelAndView();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Void> request = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange("http://"+domain1+"/vet/deleteVet/" + vetId,
				HttpMethod.DELETE, request, String.class);
		mv.addObject("response", response.getBody());
		mv.setViewName("deleteVSuccess");
		return mv;

	}

	@PostMapping(path = "/deleteS")
	public ModelAndView deleteSpeciality(@RequestParam(name = "specialityId", required = true) int specialityId) {
		ModelAndView mv = new ModelAndView();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Void> request = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(
				"http://"+domain1+"/vet/deleteSpeciality/" + specialityId, HttpMethod.DELETE, request, String.class);
		mv.addObject("response", response.getBody());
		mv.setViewName("deleteSSuccess");
		return mv;

	}

	@PostMapping(path = "/listV")
	public ModelAndView findAll(@RequestParam(name = "specialityId", required = true) int specialityId) {
		ModelAndView mv = new ModelAndView();
		String message="speciality not found";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Void> request = new HttpEntity<>(headers);
		 ResponseEntity<SpecialityDTO> response=restTemplate.exchange("http://"+domain1+"/vet/findSpec/"+specialityId, HttpMethod.GET,request,SpecialityDTO.class);
	     if(response.getBody().getsName()!=null) {
		 ResponseEntity<List<VetDTO>> response1 = restTemplate.exchange(
				"http://localhost:8185/vet/listVetsByspecialityId/" + specialityId, HttpMethod.GET, request,
				new ParameterizedTypeReference<List<VetDTO>>() {
				});
		mv.addObject("vetList", response1.getBody());
	     }else {
	    	 mv.addObject("msg",message);
	     }
		mv.setViewName("listVetForSpec");
		return mv;
	}

	@PostMapping(path = "/addS")
	public ModelAndView saveSpeciality(@RequestParam(name = "specialityId", required = true) int specialityId,
			SpecialityDTO specialityDto) {
		ModelAndView mv = new ModelAndView();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<SpecialityDTO> request = new HttpEntity<>(specialityDto, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				"http://"+domain1+"/vet/addSpeciality/" + specialityId, HttpMethod.POST, request, String.class);
		mv.addObject("response", response.getBody());
		mv.setViewName("addSpecSuccess");
		return mv;
	}

	@PostMapping(path = "/updateV")
	public ModelAndView updateVet(@RequestParam(name = "vetId", required = true) int vetId,
			@RequestParam(name = "vetContact", required = true) int vetContact) {
		ModelAndView mv = new ModelAndView();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Void> request = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(
				"http://"+domain1+"/vet/updateVet/" + vetId + "/" + vetContact, HttpMethod.PATCH, request,
				String.class);
		mv.addObject("response", response.getBody());
		mv.setViewName("updateVetSuccess");
		return mv;

	}
	
	@GetMapping(path="/listSpecc")
	public ModelAndView getListOfSpec() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Void> request = new HttpEntity<>(headers);
		ResponseEntity<List<SpecialityDTO>> response = restTemplate.exchange(
				"http://"+domain1+"/vet/listSpecialities" , HttpMethod.GET, request,
				new ParameterizedTypeReference<List<SpecialityDTO>>() {
				});
		ModelAndView mv=new ModelAndView();
		mv.addObject("specialityList", response.getBody());
		mv.setViewName("listSpec");
		return mv;
		
		
		
	}
	@GetMapping(path="/listVetss")
	public ModelAndView getListOfVets(VetDTO vetDto) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Void> request = new HttpEntity<>(headers);
		ResponseEntity<List<VetDTO>> response = restTemplate.exchange(
				"http://"+domain1+"/vet/listVets" , HttpMethod.GET, request,
				new ParameterizedTypeReference<List<VetDTO>>() {
				});
		ModelAndView mv=new ModelAndView();
		mv.addObject("vetList", response.getBody());
		mv.setViewName("listVets");
		return mv;
		
		
		
	}
	
	 @GetMapping(path="/findS")
	    public ModelAndView findSpecById(@RequestParam(name="specialityId",required=true) int specialityId) {
	        ModelAndView mv = new ModelAndView();
	        String message="Speciality not found";
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	        HttpEntity<Void> request = new HttpEntity<> (headers);
	        ResponseEntity<SpecialityDTO> response=restTemplate.exchange("htp://"+domain1+"/vet/findSpec/"+specialityId, HttpMethod.GET,request,SpecialityDTO.class);
	       if(response.getBody().getsName()!=null) {
	    	 mv.addObject("speciality",response.getBody())  ;
	       }else {
	    	   mv.addObject("msg",message);
	       }
	        
	        mv.setViewName("findSpeciality");
	        return mv;
	    }

}
