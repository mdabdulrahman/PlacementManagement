package com.pm.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pm.model.Placement;
import com.pm.repository.PlacementRepository;

@Service
public class PlacementService {
		
	@Autowired
	private PlacementRepository repo;
	
	//to check ID is present in db
	public boolean checkId(Long id)
	{
		return repo.findById(id).isEmpty();
	}
	
	//create a new placement entry
	public ResponseEntity<Placement> create(Placement placement)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(placement));
	}
	
	
	//get all entry
	public List<Placement> getAll()
	{
		return repo.findAll();
	}
	
	//get specific id
	public Placement get(Long id)
	{
		if( checkId(id) )
		  return null;
		
		return repo.findById(id).get();
	}
	
	//update
	public ResponseEntity<String> update(Placement placement)
	{
		if(placement.getId() == null )
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request : Id is mandatory ");
		
		if( checkId(placement.getId()) )
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Given Id not found");
		
		Placement placementDB = repo.findById(placement.getId()).get();
		
		if(placement.getCompanyName() == null )
		  placement.setCompanyName(placementDB.getCompanyName());
		
		if( placement.getJobTitle() == null )
		  placement.setJobTitle(placementDB.getJobTitle());
		
		if( placement.getPlacementDate() == null )
		  placement.setPlacementDate(placementDB.getPlacementDate());
	    
		if( placement.getStudentId() == null )
		  placement.setStudentId(placementDB.getStudentId());
		
	
			
		repo.save(placement);
		
		
		return ResponseEntity.ok(placement.toString());
		
		
	}
	
	//delete
	public ResponseEntity<String> delete(Long id)
	{
		if(checkId(id))
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id not found");
			
	    Placement placement = repo.findById(id).get();
		repo.delete(placement);
		return ResponseEntity.ok("Deleted Successfully!");
	}
	
	
	
}
