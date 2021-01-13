package com.aopfoo.aspect;

import com.aopfoo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
public class MyDemoLoggingAspect {
    private static Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

    @Pointcut("execution(* com.aopfoo.dao.*.*(..))")
    public void forDaoPackage() {}

    /*
    @Before("forDaoPackage()")
    public void beforeMethod(JoinPoint joinPoint) {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            System.out.println("Method: " + methodSignature);
            Object[] args = joinPoint.getArgs();

            for (Object tempArg : args) {
                System.out.print(tempArg.getClass() + ", ");
                System.out.println(tempArg);
                /*
                if (tempArg instanceof Account) {
                    System.out.println("Account name: " + ((Account) tempArg).getName());
                    System.out.println("Account level: " + ((Account) tempArg).getLevel());
                }

            }
    }

    @AfterReturning(
            pointcut = "forDaoPackage()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======>>> EXECUTING AFTER RETURNING METHOD: " + method);

        System.out.println("\n======>>> RESULT IS: " + result);

        convertAccountNamesToUpperCase(result);

        System.out.println("\n======>>> NEW RESULT IS: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for (Account acc: result) {
            acc.setName(acc.getName().toUpperCase());
        }
    }

    @AfterThrowing(
            pointcut = "forDaoPackage()",
            throwing = "exc"
    )
    public void afterThrowing (JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======>>> EXECUTING AFTER EXCEPTION METHOD: " + method);

        System.out.println("\n======>>> EXCEPTION IS: " + exc);
    }

    @After("forDaoPackage()")
    public void afterFinally(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======>>> EXECUTING AFTER FINALLY METHOD: " + method);
    }
     */

    @Around("execution(* com.aopfoo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n======>>> EXECUTING @AROUND (BEFORE) METHOD: " + method);

        long start = System.currentTimeMillis();

        Object result = null;

        try {
            result = joinPoint.proceed();
        } catch (Exception exc) {
            logger.warning("==========>>> EXCEPTION HAPPENED");
            throw exc;
        }

        long finish = System.currentTimeMillis();

        long duration = finish - start;
        logger.info("=======>>> DURATION: " + duration/1000.0 + " seconds");
        return result;
    }
}
