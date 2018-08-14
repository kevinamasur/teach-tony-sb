package com.icims.tony.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icims.tony.demo.dto.DemoDTO;
import com.icims.tony.demo.services.DemoService;
import com.icims.tony.demo.services.DemoServiceInterface;

@RestController
@RequestMapping("test")
public class DemoController {
	
	@Autowired
	private DemoServiceInterface service;
	
	@GetMapping("/demo")
	public DemoDTO getDemo() {
		DemoDTO demoDTO = new DemoDTO();
		demoDTO.setBar(5);
		demoDTO.setFoo("String fofo");
		service.runDemo();
		return demoDTO;
	}

}
