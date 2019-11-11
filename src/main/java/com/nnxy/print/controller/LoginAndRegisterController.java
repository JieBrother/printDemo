package com.nnxy.print.controller;

import com.nnxy.print.entity.User;
import com.nnxy.print.service.LoginAndRegisterService;
import com.nnxy.print.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginAndRegisterController {

    @Autowired
    private LoginAndRegisterService loginAndRegisterService;

    @RequestMapping("/register")
    @ResponseBody
    public Message register(User user) {

        System.out.println(user);
        //对接收到的学号进行判断，学号是否已存在
        boolean exist = loginAndRegisterService.exist(user.getRegisterNum());
        if (exist == true) {
            return new Message("error", "你的学号重复了，请重新输入！");
        } else {
            //调用register方法
            boolean b = loginAndRegisterService.register(user);
            if (true == b) {
                return new Message("success", "用户注册成功！");
            } else {
                return new Message("error", "用户注册失败，请重试");
            }
        }

    }

    @RequestMapping("/login")
    @ResponseBody
    public Message login(User user){

            boolean flag = loginAndRegisterService.login(user);
            System.out.println(user);
            if(flag == true){
                return new Message("success","登录成功");
            }else{
                return new Message("error","用户名或密码错误");
            }


    }

}
