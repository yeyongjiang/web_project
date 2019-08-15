package com.cn.zj.siwei.service.impl;

import com.cn.zj.siwei.dao.userMapper.TUserMapper;
import com.cn.zj.siwei.model.user.TUser;
import com.cn.zj.siwei.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private TUserMapper userMapper;
    @Override
    public List<TUser> getUserList() {
        return this.userMapper.queryTUser(new TUser());
    }
}
