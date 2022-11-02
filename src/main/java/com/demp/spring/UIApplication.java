package com.demp.spring;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class UIApplication implements WebMvcConfigurer{
	public static void main(String[] args) {
		SpringApplication.run(UIApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/findOwner").setViewName("findOwner");
		registry.addViewController("/addOwner").setViewName("addOwner");
		registry.addViewController("/updateOwnerr").setViewName("updateOwner");
		registry.addViewController("/deleteOwnerr").setViewName("deleteOwner");
		registry.addViewController("/add").setViewName("addPetToOwner");
		registry.addViewController("/deletepet").setViewName("deletePetFromOwner");
		registry.addViewController("/listP").setViewName("listPetsOfOwner");
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/find").setViewName("findPet");
		
		registry.addViewController("/homeVet").setViewName("homeVet");
		registry.addViewController("/findVett").setViewName("findVet");
		
		registry.addViewController("/addSpecc").setViewName("addSpec");
		registry.addViewController("/addVett").setViewName("addVet");
		registry.addViewController("/listSpecc").setViewName("listSpec");
		registry.addViewController("/listt").setViewName("listVetForSpec");
		registry.addViewController("/listVetss").setViewName("listVets");
		registry.addViewController("/removeSpecc").setViewName("removeSpec");
		registry.addViewController("/removeVett").setViewName("removeVet");
		registry.addViewController("/updateVett").setViewName("updateVet");
		registry.addViewController("/homeVisit").setViewName("homeVisit");
		registry.addViewController("/addVisitt").setViewName("addVisit");
		registry.addViewController("/listVisitt").setViewName("listVisit");
		registry.addViewController("/findSpec").setViewName("findSpeciality");
		
	}
	
	@Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        HttpClient httpClient = HttpClientBuilder.create().build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));



       return restTemplate;
    }

}
