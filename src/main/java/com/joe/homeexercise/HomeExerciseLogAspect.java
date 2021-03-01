/**
 * 
 */
package com.joe.homeexercise;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Aspect which outputs trace logs on annotated methods. 
 * @author Joe
 *
 */
@Component
@Aspect
public class HomeExerciseLogAspect {

	/**
	 * Intercept all properly annotated method calls and perform trace logging on them
	 * @param point
	 * @return
	 * @throws Throwable
	 */
	
	@Around("@annotation(com.joe.homeexercise.HomeExerciseTrace)")
	public Object intercept(final ProceedingJoinPoint point) throws Throwable {
	final Method method = MethodSignature.class.cast(point.getSignature()).getMethod();
	String mName=method.getName();
	Class<?> dClass = method.getDeclaringClass();
	String cName=dClass.getSimpleName();
	final Logger LOGGER = LoggerFactory.getLogger(dClass);
	
	LOGGER.trace("Entering {}:{}", cName, mName);
	Object out = null;
	out=point.proceed();
	LOGGER.trace("Exiting {}:{}", cName, mName);
	return out;
	}
}
