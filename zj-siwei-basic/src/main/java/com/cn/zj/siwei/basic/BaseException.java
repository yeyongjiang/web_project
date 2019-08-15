package com.cn.zj.siwei.basic;

public class BaseException extends Exception {

    private String code;
    private String message;
    public BaseException(){
        super();
    }

    public BaseException(String code,String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[code : "+this.code+"|message : "+this.message+"]";
    }
}
