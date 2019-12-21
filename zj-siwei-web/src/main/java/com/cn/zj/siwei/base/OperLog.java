package com.cn.zj.siwei.base;

import com.cn.zj.siwei.basic.Constant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.UUID;

@Component
@Aspect
public class OperLog {

    private static final Logger LOGGER = LoggerFactory.getLogger(OperLog.class);
    @Pointcut("execution(* com.cn.zj.siwei.controller.*Controller.*(..))")
    public void logPointCut(){

    }

    @Before(value = "logPointCut()")
    public void before(JoinPoint joinPoint){
        String trace_log_id = UUID.randomUUID().toString().replace("-","");
        MDC.put(Constant.TRACE_LOG_ID, trace_log_id);
        LOGGER.debug("invoke "+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName()+"()");
    }

//    @After(value = "logPointCut()")
//    public void after(){
//        LOGGER.debug("after...");
//    }

    @AfterReturning(returning = "obj",value = "logPointCut()")
    public void onReturning(JoinPoint joinPoint, Object obj){
        LOGGER.debug("return...");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String clientIp = request.getRemoteAddr();
        String serverIp = request.getRemoteHost();
        String url = request.getRequestURL().toString();
        String httpMethod = request.getMethod();
        String requestArgs = Arrays.toString(joinPoint.getArgs());
        String classMethod = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName()+"()";
//        String o = obj.toString();

//        LOGGER.debug(o);
        LOGGER.debug("url {},httpMethod {},args {}", url,httpMethod,requestArgs);
        LOGGER.info("invoke {}, client ip {}, server ip {}",classMethod,clientIp,serverIp);

    }

    @AfterThrowing(value = "logPointCut()")
    public void onThrowing(){
        LOGGER.debug("throwing...");
    }

    @Around(value = "logPointCut()")
    public void onAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        LOGGER.debug(String.valueOf(startTime));
        proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        LOGGER.debug(String.valueOf(endTime));
    }

}
