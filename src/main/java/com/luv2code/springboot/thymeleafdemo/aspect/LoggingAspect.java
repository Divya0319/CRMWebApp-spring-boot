package com.luv2code.springboot.thymeleafdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Aspect
@Component
public class LoggingAspect {
	
	private Logger myLogger = LoggerFactory.getLogger(this.getClass());
	
	
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.EmployeeServiceImpl.findAll())")
	private void forEmployeeServicefindAll() {}
	
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.EmployeeServiceImpl.findBy*(*))")
	private void forEmployeeServicefindById() {}
	
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.EmployeeServiceImpl.save*(*))")
	private void forEmployeeServiceSave() {}
	
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.EmployeeServiceImpl.delete*(*))")
	private void forEmployeeServiceDelete() {}
	
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.LoginController.showMyLoginPage())")
	private void forLoginControllerShowLogin() {}
	
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.LoginController.showAccessDenied())")
	private void forLoginControllerAccessDenied() {}
	
	
	@AfterReturning(pointcut = "forEmployeeServicefindAll()", returning = "employees")
	public void afterReturningListEmployee(JoinPoint theJoinPoint, List<Employee> employees) {
		
		String methodSig = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("Calling---->>>  " + methodSig);
		
		myLogger.info("Response------>>>>> " + employees);
		
	}
	
	@AfterReturning(pointcut="forEmployeeServicefindById()", returning="theEmployee")
	public void afterReturningFindById(JoinPoint theJoinPoint, Employee theEmployee) {

		String methodSig = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("Calling---->>>" + methodSig);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArg: args) {
			myLogger.info("------>>>> Searching employee with id: " + tempArg);
		}
		
		
		myLogger.info("Response---->>>> " + theEmployee);
		
		
	}
	
	
	@AfterReturning(pointcut="forEmployeeServiceSave()")
	public void afterEmployeeSaved(JoinPoint theJoinPoint) {
		
		String methodSig = theJoinPoint.getSignature().toShortString();
		
		Object[] args = theJoinPoint.getArgs();
		
		
		myLogger.info("Calling---->>>  " + methodSig);
		
		for(Object tempArg: args) {
			
			myLogger.info("--->>  Saving employee details..." + tempArg);
		}
		
		myLogger.info("Coming out of --->>> " + methodSig);
		
	}
	
	
	
	@AfterReturning(pointcut="forEmployeeServiceDelete()")
	public void afterEmployeeDeleted(JoinPoint theJoinPoint) {
		
		String methodSig = theJoinPoint.getSignature().toShortString();
		
		Object[] args = theJoinPoint.getArgs();
		
		myLogger.info("Calling---->>>  " + methodSig);
		
		for(Object tempArg: args) {
			
			myLogger.info("--->>  Deleting employee details for employee id: " + tempArg);
		}
		
		myLogger.info("Coming out of --->>> " + methodSig);
		
	}

	
	@AfterReturning(pointcut="forLoginControllerAccessDenied()")
	public void afterReturningFromAccessDenied() {
		
		myLogger.info("---->> Access denied page shown");
		
	}
	
	@AfterReturning(pointcut="forLoginControllerShowLogin()")
	public void afterReturningFromshowLoginForm() {
		
		myLogger.info("---->> Login page shown");
		
	}
	
	@Before("execution(* com.luv2code.springboot.thymeleafdemo.service.EmployeeServiceImpl.*(..))")
	public void beforeEveryControllerMethodCall() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		myLogger.info("---->>  Logged in user:  " + username);
	}
	
	@Before("execution(* org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler.logout(..))")
	public void beforeLogout(JoinPoint joinPoint) throws Throwable {        
	    myLogger.info(
	                ">>> Aspect : User " + SecurityContextHolder.getContext().getAuthentication().getName() + " successfully logged out.");
	}
	

}
