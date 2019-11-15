package com.nnxy.print.controller;

import com.nnxy.print.entity.Print;
import com.nnxy.print.service.PrintService;
import com.nnxy.print.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/uploadFile")
    @ResponseBody
    public Message uploadFile(MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        try {
            if(originalFilename != null){
                //将接受到的文件写入硬盘
                file.transferTo(new File("D:/printFile/"+originalFilename));
                return new Message("success","上传成功");
            }else{
                return new Message("error","上传失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
            return new Message("error","上传失败");
        }
    }

    @RequestMapping("/printQueue")
    public @ResponseBody List<Print> printQueue(){
        List<Print> list = new ArrayList<>();
        list = printService.select();
        System.out.println(list);
        return list;
    }

}
