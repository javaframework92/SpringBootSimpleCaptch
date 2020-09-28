package com.ajt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "EMP_ID")
	private Integer id;
	@Column(name = "EMP_NAME")
	private String name;
	@Column(name = "EMP_SALARY")
	private Double salary;
	
	@Transient
	private String captchaData;
	
	@Transient
	private String userAnswer;
	
	@Transient
	private String captchaAnswer;
}
