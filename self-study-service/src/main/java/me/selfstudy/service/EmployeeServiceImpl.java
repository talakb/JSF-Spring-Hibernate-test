package me.selfstudy.service;

import me.selfstudy.data.repository.EmployeeRepository;
import me.selfstudy.data.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

}
