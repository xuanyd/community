package com.base.admin.controller;

import com.base.admin.service.AdminService;
import com.core.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import com.core.util.WebToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping({"admin/login"})
    public @ResponseBody Map login(HttpServletRequest req, HttpSession session,
                                   @RequestBody Map<String, String> map){
        String username = map.get("username");
        String password = map.get("password");
        Map<String, Object> retMap = new HashMap<>();
        try {
            Map<String,Object> userInfo = adminService.getUserInfo(username, password);
            if (userInfo != null){
                String loginToken = WebToken.createToken(username,password);
                session.setAttribute(userInfo.get("user_id").toString(), loginToken);
                session.setAttribute("U1001", loginToken);
                retMap.put("flag", Constant.RESCODE_SUCCESS);
                retMap.put("token",loginToken);
           } else {
                retMap.put("flag", Constant.RESCODE_EXCEPTION);
                retMap.put("msg", "登录异常");
            }
        } catch (Exception e) {
            retMap.put("flag",Constant.RESCODE_EXCEPTION);
            retMap.put("msg","异常");
            e.printStackTrace();
        }
        return retMap;
    }

    @RequestMapping({"admin/userlist"})
    public Map getUserList(){
        Map<String,Object> retMap = adminService.getUserList();
        return retMap;
    }
    @RequestMapping({"admin/userlistpage"})
    public Map getUserListPage(){
        Map<String,Object> retMap = adminService.getUserList();
        return retMap;
    }
}
