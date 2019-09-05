package com.zzus.blog.bean.dto;

import com.zzus.blog.enums.RespStatusEnum;

public class RespDTO<T>  {
    private int status;
    private String msg;
    private T data;

    public RespDTO() {
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> RespDTO<T> success() {
        RespDTO<T> resp = new RespDTO();
        resp.status =RespStatusEnum.SUCCESS.getStatus();
        resp.msg = RespStatusEnum.SUCCESS.getMsg();
        return resp;
    }

    public static <T> RespDTO<T> success(T data) {
        RespDTO<T> resp = new RespDTO();
        resp.data = data;
        resp.status = RespStatusEnum.SUCCESS.getStatus();
        resp.msg = RespStatusEnum.SUCCESS.getMsg();
        return resp;
    }

    public static <T> RespDTO<T> success(String msg, T data) {
        RespDTO<T> resp = new RespDTO();
        resp.data = data;
        resp.status = RespStatusEnum.SUCCESS.getStatus();
        resp.msg = msg;
        return resp;
    }







}
