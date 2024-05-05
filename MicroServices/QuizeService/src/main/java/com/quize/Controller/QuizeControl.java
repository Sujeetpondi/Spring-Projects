 package com.quize.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quize.Entity.Quize;
import com.quize.Services.QuizeServices;

@RestController
@RequestMapping("/quiz")
 public class QuizeControl {
	

	@Autowired
	private QuizeServices quizeServices;

	public QuizeControl(QuizeServices quizeServices) { 
		this.quizeServices = quizeServices;
	}
	
	//Create
	@PostMapping
	public Quize create(@RequestBody Quize quize)
	{
		
		return quizeServices.add(quize);
		
	}
	
	//GetAll
	@GetMapping
	public List<Quize> GetAllQuize()
	{
		return quizeServices.get();
	}
	
	//Get Single Quiz
	@GetMapping("/{id}")
	public Quize GetSingleQuize(@PathVariable Long id)
	{
		return quizeServices.get(id);
	}
	
	
}
