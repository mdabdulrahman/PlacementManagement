package com.pm.specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.pm.model.Placement;

import jakarta.persistence.criteria.Predicate;


public class PlacementSpecification {
    public static Specification<Placement> getPlacements(Long id, String companyName, String jobTitle, LocalDate placementDate, Long studentId) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (id != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), id));
            }
            if (companyName != null) {
                predicates.add(criteriaBuilder.equal(root.get("companyName"), companyName));
            }
            if (jobTitle != null) {
                predicates.add(criteriaBuilder.equal(root.get("jobTitle"), jobTitle));
            }
            if (placementDate != null) {
                predicates.add(criteriaBuilder.equal(root.get("placementDate"), placementDate));
            }
            if (studentId != null) {
                predicates.add(criteriaBuilder.equal(root.get("studentId"), studentId));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
