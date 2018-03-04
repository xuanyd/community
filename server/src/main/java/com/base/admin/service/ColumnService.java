package com.base.admin.service;

import com.base.admin.dao.ColumnDao;
import com.core.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ColumnService {

    @Autowired
    private ColumnDao columnDao;

    public List<Map<String, Object>> getColumnPage(String title) throws Exception{
        List<Map<String, Object>> columnList = columnDao.getColumnList(title, 0);
        for (int i = 0; i < columnList.size(); i++) {
            int id = (int)(columnList.get(i).get("id"));
            List<Map<String, Object>> childList = columnDao.getColumnList(null, id);
            if(childList != null && !childList.isEmpty())
                columnList.get(i).put("child", childList);
        }
        return columnList;
    }
}
