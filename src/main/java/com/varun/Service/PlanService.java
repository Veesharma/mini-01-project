package com.varun.Service;

import java.util.List;
import java.util.Map;

import com.varun.Entity.Plan;

public interface PlanService {
	
	public Map<Integer, String> getPlanCategory();
	public Boolean SavePlan(Plan plan);
	public List<Plan> getAllPlans();
	public Plan getPlanById(Integer planId);
	public boolean updatePlan(Plan plan);
	public boolean deletePlanById(Integer planId);
	public boolean PlanStatusChange(Integer planId, String status);
	
	
	

}
