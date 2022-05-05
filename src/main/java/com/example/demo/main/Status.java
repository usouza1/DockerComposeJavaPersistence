package com.example.demo.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/status")
public class Status {

	@GetMapping
	public String status() {
    	return "ok";
	}

}