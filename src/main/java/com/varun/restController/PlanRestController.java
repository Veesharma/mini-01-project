package com.varun.restController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.varun.Entity.Plan;
import com.varun.Service.PlanService;

@RestController
public class PlanRestController {
	
	@Autowired
	private PlanService planService;
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategory(){
		
		Map<Integer, String> categories = planService.getPlanCategory();
		
		return new ResponseEntity<>(categories, HttpStatus.OK);
		
	}
	@PostMapping("/savePlan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		
		boolean isSaved = planService.SavePlan(plan);
		
		String msg ="";
		if(isSaved) {
			msg ="Plan Craeted Successfully";
		} else {
			msg ="Plan not created";
		}
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans(){
		
		List<Plan> plans = planService.getAllPlans();
		return new ResponseEntity<>(plans, HttpStatus.OK);
		
	}
	
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		
		String msg ="Plan Updated";
		boolean updatePlan = planService.updatePlan(plan);
		
		if(updatePlan) {
			return new ResponseEntity<>(msg,  HttpStatus.OK);
		}
		return null;
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		boolean isDeleted = planService.deletePlanById(planId);
		
		 String msg ="";
		if(isDeleted) {
			msg = "Your plan has been deleted";
		} else {
			msg = "Something went wrong";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
		
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String staus){
		boolean isStatusChange = planService.PlanStatusChange(planId, staus);
		
		String msg ="";
		if(isStatusChange) {
			msg = "Status changed";
		} else {
			msg = "status is remained same";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	

}
