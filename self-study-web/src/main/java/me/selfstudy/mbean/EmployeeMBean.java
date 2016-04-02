package me.selfstudy.mbean;

import javax.faces.bean.RequestScoped;

import me.selfstudy.data.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;


@RequestScoped
public class EmployeeMBean {

	
	@Autowired
	EmployeeService employeeService;
	
}
