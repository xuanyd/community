package com.base.admin.dao;

import com.core.dao.IBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LinksDao {

    @Autowired
    private IBaseDao baseDao;

    public int getLinksCount(String title) throws Exception {
        Map<String, Object> params = new HashMap<>();
        String sql = "select 1 from t_n_links where 1 = 1 ";
        if (title  != null ) {
            params.put("title", title);
            sql += " and title like %:title% ";
        }
        return this.baseDao.getSqlCount(sql, params);
    }

    public List<Map<String, Object>> getLinksList(String title, int start, int size) throws Exception{
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("size", size);
        String sql = " select id, title, content, add_time from t_n_links where 1 = 1 ";
        if(title != null) {
            params.put("title", title);
            sql += " and title like %:title% ";
        }
        sql += " order by add_time desc limit :start, :size ";
        return this.baseDao.queryForList(sql, params);
    }
}
