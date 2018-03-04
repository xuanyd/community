package com.base.admin.dao;

import com.core.dao.IBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NoticeDao {

    @Autowired
    private IBaseDao baseDao;

    public int getNoticeCount(String title) throws Exception {
        Map<String, Object> params = new HashMap<>();
        String sql = "select 1 from t_n_notice where 1 = 1 ";
        if (title  != null ) {
            params.put("title", title);
            sql += " and title like %:title% ";
        }
        return this.baseDao.getSqlCount(sql, params);
    }

    public List<Map<String, Object>> getNoticeList(String title, int start, int size) throws Exception{
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("size", size);
        String sql = " select id, (select name from t_n_column c where c.id=n.notice_type) as column_type_name, title, content, add_time from t_n_notice n where 1 = 1 ";
        if(title != null) {
            params.put("title", title);
            sql += " and title like %:title% ";
        }
        sql += " order by add_time desc limit :start, :size ";
        return this.baseDao.queryForList(sql, params);
    }

    public boolean noticeAdd(String noticeType, String title, String content) throws Exception {
        Map<String, Object> params = new HashMap<>();
        String sql = " insert into t_n_notice (notice_type, title, content, add_time) values (:noticeType, :title, :content, sysdate()) ";
        params.put("noticeType", noticeType);
        params.put("title", title);
        params.put("content", content);
        int addC = this.baseDao.update(sql, params);
        if(addC > 0)
            return true;
        return false;
    }

    public Map<String,Object> getNoticeInfo(String id) throws  Exception{
        Map<String, Object> params = new HashMap<>();
        String sql = " select * from t_n_notice where id = :id ";
        params.put("id", id);
        return this.baseDao.queryForMap(sql, params);
    }

    public boolean noticeEdit(String id, String noticeType, String title, String content) throws  Exception{
        Map<String, Object> params = new HashMap<>();
        String sql = " update t_n_notice set notice_type = :noticeType, title = :title, content=:content where id = :id";
        params.put("id", id);
        params.put("noticeType", noticeType);
        params.put("title", title);
        params.put("content", content);
        int updateC = this.baseDao.update(sql, params);
        if(updateC >0)
            return true;
        return false;
    }
}
