package com.lsl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileUploadController {

    private Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    //使用MultipartFile
    @RequestMapping("/upload")
    public ModelAndView fileUpload(MultipartFile file){
        ModelAndView mv = new ModelAndView();
        //设置json视图
        mv.setView(new MappingJackson2JsonView());

        //获取原始文件名
        String filename = file.getOriginalFilename();

        logger.info("上传的文件名:"+filename);

        file.getContentType();
        //目标文件位置
        File dest = new File("E:\\upload\\"+filename);//如果不加路径前缀则默认上传到Tomcat服务器bin目录下

        try {
            //保存文件
            file.transferTo(dest);
            mv.addObject("success",true);
            mv.addObject("msg","上传文件成功");
        } catch (IOException e) {
            mv.addObject("success",false);
            mv.addObject("msg","上传文件失败");
            e.printStackTrace();
        }
        return mv;
    }

}
