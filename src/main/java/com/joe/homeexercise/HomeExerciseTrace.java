/**
 * 
 */
package com.joe.homeexercise;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotating a class or method with this annotation will cause @HomeExerciseLogAspect to be applied to the call, or 
 * all calls to methods of a class. This will enable logging of calls to the method at TRACE level.
 * @author Joe
 *
 */
@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface HomeExerciseTrace {

}
