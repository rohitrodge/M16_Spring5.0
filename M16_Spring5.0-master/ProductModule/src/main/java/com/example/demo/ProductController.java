package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProductController 
{
	@Autowired
	private ProductService service;
	//retrieve all the records
	@GetMapping("/hritik")
	public List<Product>list()
	{
		return service.listAll();
		
	}
	//to retrieve the specific records
	@GetMapping("/hritik/{id}")
	public ResponseEntity<Product>get(@PathVariable Integer id)
	{
		try
		{
			Product p=service.get(id);
			return new ResponseEntity<Product>(p,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	//to add the records
	@PostMapping("/hritik")
	public void add(@RequestBody Product p)
	{
		
		service.save(p);
	}
	//update
	@PutMapping("hritik/{id}")
	public ResponseEntity<?>update(@RequestBody Product p,@PathVariable Integer id)
	{
		try
		{
			@SuppressWarnings("unused")
			Product p1=service.get(id);
			service.save(p);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	//delete
	@DeleteMapping("/hritik/{id}")
	public void delete(@PathVariable Integer id)
	{
		service.delete(id);
	}
	

}