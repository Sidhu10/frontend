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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring.dto.NumberOfVisitsByPetID;
import com.demo.spring.dto.VisitDTO;

@Controller
public class VisitUIController {
	public String domain2="visit-microservice";
	@Autowired
	RestTemplate restTemplate;
	
	
	@PostMapping(path = "/addVis")
	public ModelAndView saveVet( VisitDTO visitDto) {
		ModelAndView mv = new ModelAndView();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<VisitDTO> request = new HttpEntity<>(visitDto, headers);
		ResponseEntity<String> response = restTemplate.exchange("http://"+domain2+"/visit/add",
				HttpMethod.POST, request, String.class);
		mv.addObject("response", response.getBody());
		mv.setViewName("addVisitSuccess");
		return mv;
	}
	
	@PostMapping(path = "/listVis")
	public ModelAndView findAll(@RequestParam(name = "petId", required = true) int petId) {
		ModelAndView mv = new ModelAndView();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Void> request = new HttpEntity<>(headers);
		ResponseEntity<List<VisitDTO>> response = restTemplate.exchange("http://"+domain2+"/visit/list/" + petId, HttpMethod.GET, request,
				new ParameterizedTypeReference<List<VisitDTO>>() {});
		mv.addObject("visitList",response.getBody());
		
		mv.setViewName("listVisit");
		return mv;
	}
	
	

}
