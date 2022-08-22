package com.varun.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class PlanCategory {
	
	@Id
	@GeneratedValue
	@Column(name= "PLAN_ID")
	private Integer id;
	
	@Column(name = "PLAN_CATEGORY")
	private String planCategoryName;

}
