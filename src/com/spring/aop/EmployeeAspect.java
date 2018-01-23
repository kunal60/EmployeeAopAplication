package com.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EmployeeAspect {
	@Pointcut ("execution(* com.spring.aop.EmployeeService.addEmployee(..))")
	public void addEmpPointcut(){}
	
	
	@Pointcut ("execution(* com.spring.aop.EmployeeService.getEmployeebyName(..))")
	public void getEmpPointcut(){}
	
	@Pointcut ("execution(* *.*(..))")
	public void allMethod(){}
	
	@After("addEmpPointcut() || getEmpPointcut()")
	public void afterAdvice()
	{
		System.out.println("After Advice");
	}
	
	@AfterThrowing("addEmpPointcut() || getEmpPointcut()")
	public void afterThrowingAdvice()
	{
		System.out.println("This advice is after throwing the exception");
	}
	
	
	@Before("execution(* com.spring.aop.EmployeeService.getEmployeebyNameAndId(..))")
	// Secondary concern
	public void myBeforeAdvice(JoinPoint jpoint)
	{
		System.out.println("Before Advice Executed...");
		System.out.println("Entering inside Method "+jpoint.getSignature().getName());
		System.out.println("Method "+Arrays.toString(jpoint.getArgs()));
		System.out.println("Target class "+jpoint.getTarget().getClass().getName());
	}
	
	@Around("allMethod()")
	public void logAround(ProceedingJoinPoint jpoint)throws Throwable
	{
		long start=System.currentTimeMillis();
		String name=jpoint.getSignature().getName();
	   jpoint.proceed();
		long etime=System.currentTimeMillis()-start;
		System.out.println("Method "+name+" execution time "+etime);
	}

}
