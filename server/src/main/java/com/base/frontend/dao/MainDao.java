package com.base.frontend.dao;

import com.core.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MainDao {

    @Autowired
    private BaseDao baseDao;


    public Map<String,Object> getInfoMap(int id) throws Exception{
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        String sql = " select * from t_n_notice where id=:id";
        return baseDao.queryForMap(sql, params);
    }

    public Map<String, Object> getInfoMap(String noticeType,int start) throws Exception{
        Map<String, Object> params = new HashMap<>();
        params.put("noticeType", noticeType);
        params.put("start", start);
        String sql = " select n.id,(select name from t_n_column c where c.id = n.id) as noticeType, n.title, n.content" +
                " from t_n_notice n where notice_type=:noticeType  limit :start, 1";
        return baseDao.queryForMap(sql, params);
    }

    public List<Map<String, Object>> getInfoList(String noticeType, int start, int end) throws Exception{
        Map<String, Object> params = new HashMap<>();
        params.put("noticeType", noticeType);
        params.put("start", start);
        params.put("end", end);
        String sql = " select id, title, sub_title from t_n_notice where notice_type=:noticeType limit :start, :end";
        return baseDao.queryForList(sql, params);
    }

    public int getInfoCount(String noticeType) throws Exception{
        Map<String, Object> params = new HashMap<>();
        params.put("noticeType", noticeType);
        String countSql = " select count(1) count from t_n_notice where notice_type=:noticeType ";
        int count = Integer.parseInt(this.baseDao.queryForList(countSql, params).get(0).get("count").toString());
        return count;
    }

}
