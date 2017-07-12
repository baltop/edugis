package com.ziumks.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

@Aspect
public class DevLogAspect {

//	@Pointcut("execution(public * com.jieum..*.*(..))")
//	public void adminMethod() { }

//	@Before("execution(* com.jieum.trm..*Controller.*(..))")
//	public void aaa(){
//		System.out.println("======================================================before==================================");
//	}
	
	
	private static final Logger logger = LoggerFactory.getLogger(DevLogAspect.class);
	
	@Around("execution(* xxxcom.kospo.pms..*Controller.*(..))")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {

		HttpServletRequest request = null;
		HttpServletResponse response = null;
		Model model = null;
		Object result= null;
		for (Object o : joinPoint.getArgs()) {
			if (o instanceof HttpServletRequest) {
				request = (HttpServletRequest) o;
			}
			else if (o instanceof HttpServletResponse) {
				response = (HttpServletResponse) o;
			}
			else if (o instanceof Model) {
				model = (Model) o;
			}
		}
		try {
			
			String className = joinPoint.getTarget().getClass().getName()+"  .  ";
			String methodName = joinPoint.getSignature().getName()+"()";
			logger.debug("======= "+className+methodName);
			if( model != null){
				model.addAttribute("servletFileName", className+methodName);
			}

			result = joinPoint.proceed();
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("************************************************************************************** Exception########");
			logger.debug(e.getMessage());
		}
		return result;
	}
	
	
	
	@Around("execution(* xxxcom.kospo.pms..*Service.*(..))")
	public Object traceService(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		try {
			
			String className = joinPoint.getTarget().getClass().getName()+"  .  ";
			String methodName = joinPoint.getSignature().getName()+"()";
			logger.debug("####### "+className+methodName);
			
			 result = joinPoint.proceed();
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("************************************************************************************** Exception########");
			logger.debug(e.getMessage());
		}
		return result;
	}
	
	
	
	
	
	
	
	@Around("execution(* xxxcom.ibatis.sqlmap.client.SqlMapClient.*(..))")
	public Object traceIbatis(ProceedingJoinPoint joinPoint) throws Throwable {

		try {

			Object[] args = joinPoint.getArgs();
			
//			for (int i = 0; i < args.length; i++) {
//				argSb.append("\n * " + (i + 1) + " arg's value : "
//						+ args[i].toString());
//			}
			
			if( args.length > 0 && args[0] instanceof String){
				logger.debug("###SQL#####################  "+ args[0]);
			}
			

		} catch (Exception e) {
			// do nothing
		}
		Object result = joinPoint.proceed();
		return result;
	}
	
}
