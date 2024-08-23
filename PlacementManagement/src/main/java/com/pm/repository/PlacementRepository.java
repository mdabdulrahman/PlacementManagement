package com.pm.repository;


import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pm.model.Placement;

public interface PlacementRepository extends JpaRepository<Placement,Long> 
{

	List<Placement> findAll(Specification<Placement> placements);


}
