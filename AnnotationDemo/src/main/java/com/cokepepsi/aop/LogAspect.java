package com.cokepepsi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author CokePepsi
 * @date 2023/10/8 20:15
 */


/***
 * 切面类
 *
 * @Aspect 告诉Spring 这是一个切面类
 * JoinPoint 必须出现在参数的第一位
 */
@Aspect
public class LogAspect {

    //抽取的公共切入点表达式
    //1.本类引用
    //2.其他切面引用
    @Pointcut("execution(public int com.cokepepsi.aop.MathCalculator.*(..))")
    public void pointCut(){

    }


    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName() + "运行...@Before 参数列表是: {" + Arrays.asList(args) +"}");
    }


    @After("com.cokepepsi.aop.LogAspect.pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() +"计算结束----@After");
    }


    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println(joinPoint.getSignature().getName()+"异常出现...@AfterThrowing异常信息:{"+exception+"}");
    }


    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturning( JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName()+"正常返回...@AfterReturning运行结果:{"+ result +"}");
    }
}
