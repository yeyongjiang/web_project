package com.cn.zj.siwei.api;

import com.esms.MessageData;
import com.esms.PostMsg;
import com.esms.common.entity.MTPack;

import java.util.UUID;

public class SiChuanSms {

    public void doSendSms() throws Exception{

        MTPack pack = new MTPack();
        pack.setBatchID(UUID.randomUUID()); //批次唯一id
        pack.setBatchName("平台告警短信批次"); //批次名称
        pack.setMsgType(MTPack.MsgType.SMS); //短信
        pack.setDistinctFlag(false);
        pack.setSendType(MTPack.SendType.MASS);//群发




    }
}
