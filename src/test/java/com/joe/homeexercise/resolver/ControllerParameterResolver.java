package com.joe.homeexercise.resolver;

import com.joe.homeexercise.controller.AdminController;
import com.joe.homeexercise.controller.GreetingsController;
import com.joe.homeexercise.controller.ItemEligibilityController;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ControllerParameterResolver implements ParameterResolver {


    /**
     * Determine if this resolver supports resolution of an argument for the
     * {@link Parameter} in the supplied {@link ParameterContext} for the supplied
     * {@link ExtensionContext}.
     *
     * <p>The {@link Method} or {@link Constructor}
     * in which the parameter is declared can be retrieved via
     * {@link ParameterContext#getDeclaringExecutable()}.
     *
     * @param parameterContext the context for the parameter for which an argument should
     *                         be resolved; never {@code null}
     * @param extensionContext the extension context for the {@code Executable}
     *                         about to be invoked; never {@code null}
     * @return {@code true} if this resolver can resolve an argument for the parameter
     * @see #resolveParameter
     * @see ParameterContext
     */
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        boolean ret = false;
        if(parameterContext.getParameter().getType()==ItemEligibilityController.class)
            ret= true;
        if(parameterContext.getParameter().getType()==GreetingsController.class)
            ret= true;
        if(parameterContext.getParameter().getType()==AdminController.class)
            ret= true;
        return ret ;
    }

    /**
     * Resolve an argument for the {@link Parameter} in the supplied {@link ParameterContext}
     * for the supplied {@link ExtensionContext}.
     *
     * <p>This method is only called by the framework if {@link #supportsParameter}
     * previously returned {@code true} for the same {@link ParameterContext}
     * and {@link ExtensionContext}.
     *
     * <p>The {@link Method} or {@link Constructor}
     * in which the parameter is declared can be retrieved via
     * {@link ParameterContext#getDeclaringExecutable()}.
     *
     * @param parameterContext the context for the parameter for which an argument should
     *                         be resolved; never {@code null}
     * @param extensionContext the extension context for the {@code Executable}
     *                         about to be invoked; never {@code null}
     * @return the resolved argument for the parameter; may only be {@code null} if the
     * parameter type is not a primitive
     * @see #supportsParameter
     * @see ParameterContext
     */
    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Object ret = null;
        if(parameterContext.getParameter().getType()==ItemEligibilityController.class)
            ret= new ItemEligibilityController();
        if(parameterContext.getParameter().getType()==GreetingsController.class)
            ret= new GreetingsController();
        if(parameterContext.getParameter().getType()==AdminController.class)
            ret= new AdminController();
        return ret;
    }
}
