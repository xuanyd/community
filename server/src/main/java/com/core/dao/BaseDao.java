package com.core.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class BaseDao implements IBaseDao{
    private Logger log = Logger.getLogger(BaseDao.class);

    @SuppressWarnings("deprecation")
    private SimpleJdbcTemplate jdbcTemplate;

    @SuppressWarnings("deprecation")
    public BaseDao(SimpleJdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    /**
     * 针对于SimpleJdbcTemplate 中的queryForList方法返回的List<Map<String,Object>>类型转化为List<Map<String,String>>类型
     * 为了方便使用！
     * @param param
     * @return
     */
    private List<Map<String,String>> Object2String(List<Map<String,Object>> param){
        List<Map<String,String>> retList = new ArrayList<Map<String,String>>();
        Iterator<Map<String, Object>> it = param.iterator();
        while(it.hasNext()){
            Map<String, Object> temp = it.next();
            retList.add(Object2String(temp));
        }
        return retList;
    }
    /**
     * 将Map<String,Object>强转为Map<String,String>
     * @param param
     * @return
     */
    private Map<String,String> Object2String(Map<String,Object> param){
        Map<String, String> retMap = new HashMap<String, String>();
        Iterator<String> it = param.keySet().iterator();
        String key;
        Object value;
        while(it.hasNext()){
            key = it.next();
            value = param.get(key);
            retMap.put(key, value!=null?value.toString():"");
        }
        return retMap;
    }
    /**
     * 查询
     * @param sql
     * @return
     */
    public List<Map<String,String>> queryForStrListBySql(String sql) throws Exception{
        Map<String, Object> param = new HashMap<String, Object>();
        List<Map<String,String>> retList = Object2String(jdbcTemplate.queryForList(sql, param));
        return retList;
    }
    /**
     * 查询
     * @param sql
     * @return
     */
    public List<Map<String,String>> queryForStrListBySql(String sql,Map<String, Object> param) throws Exception{
        List<Map<String,String>> retList = Object2String(jdbcTemplate.queryForList(sql, param));
        return retList;
    }
    /**
     * 查询
     * @param sql
     * @param param
     * @return
     * @throws
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
    public List<Map<String,Object>> queryForList(String sql, Map<String,Object> param) throws Exception{
        return this.jdbcTemplate.queryForList(sql, param);
    }
    /**
     * 查询
     * @param sql
     * @return
     */
    @SuppressWarnings("deprecation")
    public List<Map<String,Object>> queryForList(String sql) throws Exception{
        Map<String, String> param = new HashMap<String, String>();
        return this.jdbcTemplate.queryForList(sql, param);
    }
    /**
     * 用于返回单条数据的查询
     * @param sql
     * @param param
     * @return
     */
    @SuppressWarnings("deprecation")
    public Map<String,Object> queryForMap(String sql, Map<String,Object> param) throws Exception{
        Map<String,Object> retMap = null;
        try {
            retMap = this.jdbcTemplate.queryForMap(sql, param);
        } catch (EmptyResultDataAccessException e) {//查询不到数据，返回null
            return retMap;
        }
        return retMap;
    }
    /**
     * 用于返回单条数据的查询
     * @param sql
     * @param param
     * @return
     */
    @SuppressWarnings("deprecation")
    public Map<String, String> queryForStrMap(String sql, Map<String,Object> param) throws Exception{
        Map<String,String> retMap = null;
        try {
            retMap = this.Object2String(this.jdbcTemplate.queryForMap(sql, param));
        } catch (EmptyResultDataAccessException e) {//查询不到数据，返回null
            return retMap;
        }
        return retMap;
    }
    /**
     * 更新操作！
     * @param sql
     * @param param
     * @return
     */
    @SuppressWarnings("deprecation")
    public int updateStrPara(String sql, Map<String,Object> param) throws Exception{
        return this.jdbcTemplate.update(sql, param);
    }

    @SuppressWarnings("deprecation")
    public int update(String sql_name, Map<String,Object> param){
        return this.jdbcTemplate.update(sql_name, param);
    }

    @Override
    public String getSEQ() {
        return "";
    }

    @SuppressWarnings("deprecation")
    @Override
    public int batchUpdate(String sql, List<Object[]> params) throws Exception {
        return this.jdbcTemplate.batchUpdate(sql, params).length;
    }

    @SuppressWarnings("deprecation")
    @Override
    public String execProc(String proc) {
        try {
            jdbcTemplate.getJdbcOperations().execute(proc);
            return "success";
        } catch (DataAccessException e) {
            e.printStackTrace();
            return "excep";
        }

    }
    @Override
    public int getSqlCount(String sql1, Map<String, Object> paraMap)
            throws Exception {
        if(sql1.indexOf("limit") > 0){
            sql1 = sql1.substring(0, sql1.indexOf("limit"));
        }
        String sql = "select count(1) count from ( " + sql1 + " ) as total_count";
        return Integer.valueOf(this.jdbcTemplate.queryForMap(sql, paraMap).get("count").toString());
    }
    @Override
    public List<Map<String, String>> queryForStrList(String sql,
                                                     Map<String, Object> param) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<Map<String, String>> queryForStrList(String sql)
            throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
}

