package com.core.util;

import java.util.List;
import java.util.Map;


public class PageInfo {
    //当前页
    private int currentPage;
    //总页数
    private int totalPage;
    //总数
    private int totalCount;
    //每页条数
    private int pageSize;
    //查询条件
    private Map<String, Object> params;
    //路径
    private String url;
    //数据
    private List<Map<String, Object>> infoList;

    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getTotalPage() {
        return totalCount%pageSize == 0 ? totalCount/pageSize : totalCount/pageSize+1;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public Map<String, Object> getParams() {
        return params;
    }
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public List<Map<String, Object>> getInfoList() {
        return infoList;
    }
    public void setInfoList(List<Map<String, Object>> infoList) {
        this.infoList = infoList;
    }

    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
