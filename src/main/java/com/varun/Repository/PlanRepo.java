package com.varun.Repository;

import java.util.Optional;

import com.varun.Entity.Plan;
import java.util.Optional;

public interface PlanRepo {

	Plan save(Plan plan);

	void findAll();

	Optional<Plan> findById(Integer planId);

	void deleteById(Integer planId);

	Optional<Plan> findByID(Integer planId);
	

}
