package com.icims.tony.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icims.tony.school.dto.ClassDTO;

@RestController
@RequestMapping("school")
public class SchoolController {

	@GetMapping("/class")
	public ClassDTO getClassDTO() {
		return new ClassDTO();
	}
}
