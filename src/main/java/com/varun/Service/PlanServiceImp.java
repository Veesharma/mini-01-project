package com.varun.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varun.Entity.Plan;
import com.varun.Entity.PlanCategory;
import com.varun.Repository.PlanCategoryRepo;
import com.varun.Repository.PlanRepo;

@Service
public class PlanServiceImp implements PlanService {

	@Autowired
	private PlanRepo planRepo;
	private PlanCategoryRepo planCategoryRepo;
	
	@Override
	public Map<Integer, String> getPlanCategory() {
		List<PlanCategory> categories = planCategoryRepo.findAll();
		Map<Integer, String> categoryMap = new HashMap<>();
		categories.forEach(category -> {
			categoryMap.put(category.getId(), category.getPlanCategoryName());
		});
		return categoryMap;
	}

	@Override
	public Boolean SavePlan(Plan plan) {
		Plan savePlan = planRepo.save(plan);
		return savePlan.getPlanId() != null;
	}

	@Override
	public List<Plan> getAllPlans() {
		planRepo.findAll();
		return null;
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> findById = planRepo.findById(planId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		planRepo.save(plan);
		return plan != null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		
		boolean status = false;
		try {
			planRepo.deleteById(planId);
			status = true;
		} catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean PlanStatusChange(Integer planId, String status) {
		Optional<Plan> findById = planRepo.findByID(planId);
		if(findById.isPresent()) {
			Plan plan = findById.get();
			planRepo.save(plan);
			return true;
		}
		return false;
	}

}
