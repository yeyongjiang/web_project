package com.cn.zj.siwei.dao.userMapper;


import com.cn.zj.siwei.model.user.TUser;

import java.util.List;

/**
*  @author author
*/
public interface TUserMapper{

    int insertTUser(TUser object);

    int updateTUser(TUser object);

    int update(TUser.UpdateBuilder object);

    List<TUser> queryTUser(TUser object);

    TUser queryTUserLimit1(TUser object);

}