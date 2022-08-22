package com.varun.Entity;

import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Entity
@Table
@Data
public class Plan {
	
	@Id
	@GeneratedValue
	@Column(name = "PLAN_ID")
	private Integer PlanId;
	@Column(name = "PLAN_NAME")
	private String PlaneName;
	
	@Column(name = "ACTIVE_SW")
	private String Planestatus;
	
	@Column(name = "PLAN_DATE")
	private int planDate;
	
	@Column(name = "START_DATE")
	private Date startDate;
	
	@Column(name = "END_DATE")
	private Date EndDate;
	
	@Column(name ="CREATED_DATE")
    @CreationTimestamp
	private Date createDate;
	
	@Column(name ="CREATED_BY")
    @CreationTimestamp
	private Timestamp createBy;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
    private Timestamp updatedate;
		
	

}
