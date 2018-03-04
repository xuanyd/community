package com.base.admin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.core.dao.IBaseDao;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AdminDao {

    @Autowired
    private IBaseDao baseDao;

    public Map<String, Object> queryUserByNameAndPwd(String username, String password) throws Exception{
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("pwd", password);
        String sql = "select user_id, user_name from t_m_user where user_name=:username and user_password=:pwd";
        return  baseDao.queryForMap(sql, params);
    }
}
