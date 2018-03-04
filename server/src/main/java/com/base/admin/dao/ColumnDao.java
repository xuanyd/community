package com.base.admin.dao;

import com.core.dao.IBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ColumnDao {

    @Autowired
    private IBaseDao baseDao;
    public List<Map<String, Object>> getColumnList(String name, int pid) throws Exception{
        Map<String, Object> params = new HashMap<>();
        String sql = " select id, pid, name from t_n_column where 1 = 1 ";
        sql += " and pid = :pid";
        params.put("pid", pid);
        if(name != null) {
            params.put("name", name);
            sql += " and name like %:name% ";
        }
        return this.baseDao.queryForList(sql, params);
    }
}
