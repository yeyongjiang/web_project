package com.cn.zj.siwei.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogback {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestLogback.class);
    @Test
    public void testLogback(){
        LOGGER.info("test logback");
    }
}
