package com.itheima.vo;

import lombok.Data;

import java.sql.PreparedStatement;

/**
 * 统一的响应结果
 */
@Data
public class Result {
    private Integer code;// 0 代表失败，1 代表成功
    private String msg;// 提示信息
    private Object data;// 响应的数据

    public static Result success(){
        Result result = new Result();
        result.setCode(1);
        result.setMsg("请求成功");
        return result;
    }
    public static Result success(String msg){
        Result result = new Result();
        result.setCode(1);
        result.setMsg(msg);
        return result;
    }

    public static Result success(Object data){
        Result result = new Result();
        result.setCode(1);
        result.setMsg("请求成功");
        result.setData(data);
        return result;
    }


    public static Result error(String msg){
        Result result = new Result();
        result.setCode(0);
        result.setMsg(msg);
        return result;
    }




}
