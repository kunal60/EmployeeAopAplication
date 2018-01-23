package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("I am here");
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeService s=(EmployeeService)ctx.getBean("empservimpl");
		//s.getEmployeebyNameAndId(101, "Ravic");
		//s.addEmployee();
		//s.getEmployeebyName(null);
		s.getEmployee();
		s.addEmployee();

	}

}
