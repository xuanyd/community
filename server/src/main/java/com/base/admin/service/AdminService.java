package com.base.admin.service;

import com.base.admin.dao.AdminDao;
import com.core.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public Map<String, Object> getUserInfo(String username, String password) throws Exception {
        return adminDao.queryUserByNameAndPwd(username, password);
    }

    public Map<String,Object> getUserList() {
        return null;
    }
}
