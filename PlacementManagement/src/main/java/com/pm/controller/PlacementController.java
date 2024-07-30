package com.pm.controller;

import java.util.ArrayList;
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
@RequestMapping("/placement")
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
	
	//Read all values in the placement table
	@GetMapping
	public List<Placement> getAll(@RequestParam(required=false,name="id") Long id)
	{
		if( id == null )
		  return placementService.getAll();
		
		List<Placement> ls = new ArrayList<>();
		ls.add(placementService.get(id));
		
		return ls;
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
