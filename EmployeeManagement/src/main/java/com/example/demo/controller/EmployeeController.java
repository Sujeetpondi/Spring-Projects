package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.EmpRepo;
import com.example.demo.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	EmpRepo repo;
	
	@GetMapping("index")
	public String home()
	{
		return "index.jsp";
	}
	
	@GetMapping("/show_data")
	public ModelAndView show_data(int id)
	{
		ModelAndView mv = new ModelAndView("Display.jsp");
		Employee employee = repo.findById(id).orElse(new Employee());
		mv.addObject(employee);
		return mv;
	}
	
	@PostMapping("/Employee")
	public Employee Add_Employee(Employee employee)
	{
		repo.save(employee);
		return employee;
	}
	
	@DeleteMapping("/Employee/{id}")
	public String Delete_Employee(@PathVariable("id") int eid)
	{
		Boolean avl  = repo.existsById(eid);
		if (avl)
		{
			repo.deleteById(eid);
			return "record deleted for employee id : "+eid;
		}
		return "Record doesn't exist for employee id : "+eid;
	}

	@PutMapping("/Employee")
	public Employee SaveOrUpdate_Employee(@RequestBody Employee emp)
	{
		repo.save(emp);
		return emp;
	}
	
	@ResponseBody
	@GetMapping("/Employee")
	public List<Employee> Show_Details()
	{
		return repo.findAll();
	}
	
	@ResponseBody
	@GetMapping("/Employee/{id}")
	public Optional<Employee> Show_DetailsByID(@PathVariable("id")  int id)
	{
		return repo.findById(id);
	}

}
