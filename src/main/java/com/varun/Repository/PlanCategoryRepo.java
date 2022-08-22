package com.varun.Repository;

import java.util.List;

import com.varun.Entity.PlanCategory;

public interface PlanCategoryRepo {

	List<PlanCategory> findAll();

}
