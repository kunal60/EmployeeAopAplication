package com.spring.aop;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void getEmployeebyNameAndId(int id, String name) {
		System.out.println("Emp Id "+id+" Name is "+name);
		
	}

	@Override
	public void addEmployee() {
		System.out.println("One Employee Is addeded");
		
	}

	@Override
	public void getEmployeebyName(String name)throws NullPointerException {
		System.out.println("Get Emp by name is Called");
		try
		{
		if (name==null)
		{
			throw new NullPointerException(" name cant be null");
		}
		}catch (Exception e) {
			System.out.println("Exception caught");
		}
		System.out.println("Emp name is "+name);
	}

	@Override
	public void getEmployee() {
		
		System.out.println("Get Employee method called");
	}
	
	

}
