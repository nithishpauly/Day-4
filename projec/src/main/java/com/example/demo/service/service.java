package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.entity;
import com.example.demo.repository.repositary;


@Service
public class service {

@Autowired
repositary r;
	
public String add( entity m) {
		r.save(m);
		return "Added";
	}
	
	public List<entity> getDetails() {
		return r.findAll();
	}
	
	public List<entity> getSorted(String field) {
		return r.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	
	public List<entity> getWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		Page<entity> page =r.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}

}

