package com.leechr.community.entity;
import lombok.Data;
import java.util.Date;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String salt;
    private String email;
    //用户类型: 0为普通用户，1为管理员，2为楼主
    private int type;
    //用户状态：0未激活，1已激活
    private int status;
    private String activationCode;
    //头像的访问路径
    private String headerUrl;
    private Date createTime;
}
