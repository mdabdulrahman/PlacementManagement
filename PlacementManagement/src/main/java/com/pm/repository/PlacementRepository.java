package com.pm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pm.model.Placement;

public interface PlacementRepository extends JpaRepository<Placement,Long> {

}
