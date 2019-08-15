package com.cn.zj.siwei.test;

import com.cn.zj.siwei.model.user.TUser;
import com.cn.zj.siwei.service.IUserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration(locations = {"classpath:conf/spring/spring-mybatis.xml"})
public class UserTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserTest.class);
    @Resource
    private IUserService userService;

//    @Test
//    public void test(){
//        List<TUser> userList = userService.getUserList();
//        if (userList.isEmpty())
//        {
//            LOGGER.info("empty");
//        }
//    }
}
