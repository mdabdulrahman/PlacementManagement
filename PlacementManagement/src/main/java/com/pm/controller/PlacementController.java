package com.pm.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pm.model.Placement;
import com.pm.service.PlacementService;


@RestController
@RequestMapping("/api/placement")
public class PlacementController {
	
	@Autowired
	private PlacementService placementService;
	
	//Create Operation
	@PostMapping
	public ResponseEntity<Placement> create(@RequestBody Placement placement)
	{
		return 	placementService.create(placement);
	}
	
	//Read Operation
	
	//Read all values in the placement table if parameter is null
	@GetMapping
	public List<Placement> getAll()
	{
		  return placementService.getAll();
	}
	
	//Search
	@GetMapping("/search")
	public ResponseEntity<List<Placement>> get(
			@RequestParam(required=false,name="id") Long id,
			@RequestParam(required=false,name="companyname") String companyName,
			@RequestParam(required=false,name="jobtitle")  String jobTitle,
			@RequestParam(required=false,name="placementdate") LocalDate placementDate,
			@RequestParam(required=false,name="studentId") Long studentId
            )
	{
		return placementService.search(id,companyName,jobTitle,placementDate,studentId);
	}
	
	
	
	//Update Operation
	//Give id and all data in the request body
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Placement placement)
	{
		
		return placementService.update(placement);
	}
	
	//Delete Operation
	@DeleteMapping
	public ResponseEntity<String> delete(@RequestParam(name="id") Long id)
	{
		return placementService.delete(id);
	}
	
	
	
	  
}
