package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-05
 * Time: 17:14
 */
@Aspect     // 告诉框架我是切面
@Component  // 随着框架的启动而启动
public class UserAspect {
    //  切点(配置拦截规则
    @Pointcut("execution(* com.example.demo.controller.UserController.*(..))")
    public void pointcut(){

    }
    // 前置通知
    @Before("pointcut()")
    public void beforeAdvice(){
        System.out.println("执行了前置通知.");
    }

    // 后置通知
    @After("pointcut()")
    public void afterAdvice(){
        System.out.println("执行了后置通知.");
    }

    // 环绕通知
    @Around("pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("进入环绕通知了.");
        Object obj = null;
        // 执行目标方法
        obj = joinPoint.proceed();
        System.out.println("退出环绕通知了.");
        return obj;
    }
}
