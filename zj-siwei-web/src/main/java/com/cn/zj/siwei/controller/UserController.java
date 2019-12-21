package com.cn.zj.siwei.controller;

import com.cn.zj.siwei.model.user.TUser;
import com.cn.zj.siwei.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(HttpServletRequest httpRequest, Model model){
//        LOGGER.info("test controller");
        String id = httpRequest.getParameter("id");

        return "test";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String userTest(HttpServletRequest httpRequest, Model model){
        LOGGER.info("test user");
        List<TUser> userList = null;

        try {
            userList = userService.getUserList();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("{}", e);
        }
        if (userList.isEmpty())
        {
            LOGGER.info("empty");
    }
        return "success";
    }

}
