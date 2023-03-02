package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.entity;
import com.example.demo.service.service;


@RestController
public class controller {

	@Autowired
	service s;

	@GetMapping("/get")
	public List<entity> showDetails() {
		return s.getDetails();
	}

	@PostMapping("/post")
	public String addDetails(@RequestBody entity m) {
		s.add(m);
		return "Added product " + m.getId();
	}

	//sorting
	@GetMapping("/product/{field}")
	public List<entity> getWithSort(@PathVariable String field) {
		return s.getSorted(field);
	}

	// pagination
	@GetMapping("/product/{offset}/{pageSize}")
	public List<entity> productsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		return s.getWithPagination(offset,pageSize);
	}
}