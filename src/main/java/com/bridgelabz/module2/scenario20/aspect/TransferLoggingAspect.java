package com.bridgelabz.module2.scenario20.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransferLoggingAspect {

    @Before(
            "execution(* com.bridgelabz.module2.scenario20.service.*.*(..))"
    )
    public void beforeService(
            JoinPoint joinPoint) {

        System.out.println(
                "===== AOP BEFORE SERVICE ====="
        );

        System.out.println(
                "Method: "
                        + joinPoint
                        .getSignature()
                        .getName()
        );
    }

    @AfterReturning(
            pointcut =
                    "execution(* com.bridgelabz.module2.scenario20.service.*.*(..))",
            returning = "result"
    )
    public void afterService(
            JoinPoint joinPoint,
            Object result) {

        System.out.println(
                "===== AOP AFTER SERVICE ====="
        );

        System.out.println(
                "Method completed: "
                        + joinPoint
                        .getSignature()
                        .getName()
        );
    }

    @AfterThrowing(
            pointcut =
                    "execution(* com.bridgelabz.module2.scenario20.service.*.*(..))",
            throwing = "exception"
    )
    public void afterException(
            JoinPoint joinPoint,
            Exception exception) {

        System.out.println(
                "===== AOP SERVICE EXCEPTION ====="
        );

        System.out.println(
                "Exception: "
                        + exception.getMessage()
        );
    }
}