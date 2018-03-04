package com.core.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao {
    /**
     * 查询  返回List<Map<String,String>>
     * @param param    参数
     * @return
     * @throws Exception
     */
    public List<Map<String,String>> queryForStrList(String sql,Map<String,Object> param) throws Exception;
    /**
     * 查询  返回List<Map<String,String>>
     * @return
     * @throws Exception
     */
    public List<Map<String,String>> queryForStrList(String sql) throws Exception;
    /**
     * 查询  返回List<Map<String,Object>>
     * @param param    参数
     * @return
     * @throws Exception
     */
    public List<Map<String,Object>> queryForList(String sql, Map<String,Object> param) throws Exception;
    /**
     * 查询  返回List<Map<String,String>>
     * @return
     * @throws Exception
     */
    public List<Map<String,Object>> queryForList(String sql) throws Exception;
    /**
     * 查询  返回Map<String,Object>
     * @param sql
     * @param param    参数
     * @return  查询不到数据的时候返回null
     * @throws Exception
     */
    public Map<String,Object> queryForMap(String sql, Map<String,Object> param) throws Exception;
    /**
     * 查询  返回List<Map<String,String>>
     * @param param    参数
     * @return 查询不到数据的时候返回null
     * @throws Exception
     */
    public Map<String, String> queryForStrMap(String sql, Map<String,Object> param) throws Exception;
    /**
     * 更新
     * @param param    参数
     * @return
     * @throws Exception
     */
    public int updateStrPara(String sql, Map<String,Object> param) throws Exception;
    /**
     * 更新
     * @param param
     * @return
     */
    public int update(String sql, Map<String,Object> param) throws Exception;
    public int batchUpdate(String sql, List<Object[]> params) throws Exception;

    /**
     *
     * @param sql
     * @param paraMap
     * @return
     * @throws Exception
     */
    public int getSqlCount(String sql, Map<String, Object> paraMap) throws Exception;

    public String execProc(String proc);

    /**
     * 获取序列
     * @return
     */
    String getSEQ();
    public List<Map<String,String>> queryForStrListBySql(String sql) throws Exception;
    public List<Map<String,String>> queryForStrListBySql(String sql,Map<String, Object> paraMap) throws Exception;

}

