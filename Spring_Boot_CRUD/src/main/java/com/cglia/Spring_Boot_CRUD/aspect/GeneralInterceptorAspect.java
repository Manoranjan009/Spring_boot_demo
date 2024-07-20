package com.cglia.Spring_Boot_CRUD.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cglia.Spring_Boot_CRUD.Entity.Product;

@Aspect
@Component
public class GeneralInterceptorAspect {
	
	@Pointcut("execution( * com.cglia.Spring_Boot_CRUD.Controller.*.*(..))")
	//@Pointcut("within( * com.cglia.Spring_Boot_CRUD.Controller.*)")
	//@Pointcut("execution( * com.cglia.Spring_Boot_CRUD..*)")    //if you want to run in sub-packages
	//@Pointcut("this( * com.cglia.Spring_Boot_CRUD.ProductService.Anotherservice)")   // it will only execute for Anotherservice class inside service package
	public void loggingPointCut() {}
	
	Logger logger = LoggerFactory.getLogger(GeneralInterceptorAspect.class);
	
//	@Before("loggingPointCut()")
//	public void before(JoinPoint joinpoint) {
//		logger.info(" Before method invoked " + joinpoint.getSignature());
//	}
//	
//	@After("loggingPointCut()")
//	public void after(JoinPoint joinpoint) {
//		logger.info(" After method invoked " + joinpoint.getSignature());
//	}
	
	@AfterReturning(value="execution( * com.cglia.Spring_Boot_CRUD.Controller.*.*(..))",
			returning = "product")
	public void after(JoinPoint joinpoint ,Product product) {
		//logger.info(" AfterReturning method invoked : " + product);
		logger.info("After method invoked ......"+joinpoint.getArgs()[0]);
	}	
//	
//	@AfterThrowing(value="execution( * com.cglia.Spring_Boot_CRUD.Controller.*.*(..))",
//			throwing = "e")
//	public void after(JoinPoint joinpoint ,Exception e) {
//		logger.info(" AfterThrowing method invoked : " + e.getMessage());
//	}	
	
//   @Around("loggingPointCut()")
//	public Object around(ProceedingJoinPoint joinpoint) throws Throwable {
//		logger.info("Before method invoked ....... " + joinpoint.getSignature());
//		Object object=joinpoint.proceed();
//		if(object instanceof Product) {
//			logger.info("After method invoked ......"+joinpoint.getArgs()[0]);
//		}
//		return object;
//	}

}
