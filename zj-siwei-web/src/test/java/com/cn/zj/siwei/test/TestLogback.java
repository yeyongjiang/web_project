package com.cn.zj.siwei.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class TestLogback {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestLogback.class);
    @Test
    public void testLogback(){
        LOGGER.info("test logback");
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String clientIp = request.getRemoteAddr();
        LOGGER.info("client ip {}",clientIp);
    }
}
