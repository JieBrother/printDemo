package com.nnxy.print.controller;

import com.nnxy.print.entity.Print;
import com.nnxy.print.service.PrintService;
import com.nnxy.print.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: LuoFuJie
 * @time: 2019/11/12 20:04
 */
@Controller
public class PrintController {

    @Autowired
    private PrintService printService;

    @RequestMapping("/print")
    @ResponseBody
    public Message print(@RequestBody Print print){
        print.setGmtCreate(System.currentTimeMillis());
        print.setGmtModify(System.currentTimeMillis());
        System.out.println(print.toString());
        boolean b = printService.insert(print);
        if (b == true){
            return new Message("success","预约成功");
        }else {
            return new Message("error","预约失败，请重试");
        }

    }


}
