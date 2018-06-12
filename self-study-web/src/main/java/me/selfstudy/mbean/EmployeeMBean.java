package me.selfstudy.mbean;

import javax.enterprise.context.RequestScoped;

import me.selfstudy.data.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;


@RequestScoped
public class EmployeeMBean {

	
	@Autowired
	EmployeeService employeeService;
	
}
