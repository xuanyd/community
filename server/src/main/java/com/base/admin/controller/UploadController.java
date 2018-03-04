package com.base.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

@Controller
public class UploadController {
    @RequestMapping(value="/uploadImage")
    public void uploadFile(@RequestParam(value = "file", required = false) MultipartFile file,
                           HttpServletRequest request, HttpServletResponse response) {
        System.out.println("-----------");
    }
    @RequestMapping(value="/admin/ueditorConfig")
    public @ResponseBody
    String ueditorConfig(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("-------config----");
        String configStr = "";
        String rootPath = request.getSession()
                .getServletContext().getRealPath("/");
        rootPath += "/ueditor/config.json";
        File f = new File(rootPath);
        Long filelength = f.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(f);
            in.read(filecontent);
            in.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        configStr = new String(filecontent);
        System.out.println(configStr);
        return  configStr;

    }


}
