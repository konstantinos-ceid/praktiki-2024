package gr.knowledge.internship.banksystem.aop.logging;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@Log4j2
public class LoggingAspect {

	@Pointcut("within(gr.knowledge.internship.banksystem.service..*)")
	public void servicePointcut() {
	}

	@Before(value = "servicePointcut()")
	public void beforeServicePointcut(JoinPoint joinPoint) {
		CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
		String[] parameters = codeSignature.getParameterNames();
		Map<String, String> arguments = new HashMap<String, String>();
		for (int i = 0; i < parameters.length; i++) {
			arguments.put(parameters[i], joinPoint.getArgs()[i].toString());
		}
		String joinMethod = joinPoint.getSignature().getName();
		String joinClass = joinPoint.getSignature().getDeclaringType().getSimpleName();
		log.debug("Entered " + joinMethod + " in " + joinClass + " with arguments " + arguments);
	}
	
	@AfterReturning(value = "servicePointcut()", returning = "result")
	public void afterServicePointcut(JoinPoint joinPoint, Object result) {
		String joinMethod = joinPoint.getSignature().getName();
		String joinClass = joinPoint.getSignature().getDeclaringType().getSimpleName();
		log.debug("Exited " + joinMethod + " in " + joinClass + " with return statement " + result.toString());
	}

}
