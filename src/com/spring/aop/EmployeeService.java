package com.spring.aop;

public interface EmployeeService {
	// Primary concerns
	public void getEmployeebyNameAndId(int id,String name);
	public void addEmployee();
	public void getEmployeebyName(String name);
	public void getEmployee();

}
