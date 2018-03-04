package com.base.admin.service;

import com.base.admin.dao.NoticeDao;
import com.core.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    public PageInfo getNoticePage(String title, int page, int pageSize) throws Exception{
        PageInfo pageInfo = new PageInfo();
        int start = (page -1) * pageSize;
        int size = pageSize;
        pageInfo.setPageSize(pageSize);
        pageInfo.setCurrentPage(page);
        pageInfo.setTotalCount(noticeDao.getNoticeCount(title));
        pageInfo.setInfoList(noticeDao.getNoticeList(title, start, size));
        return pageInfo;
    }

    public boolean noticeAdd(String noticeType, String title, String content) throws Exception{
        return noticeDao.noticeAdd(noticeType, title, content);
    }

    public Map<String,Object> getNoticeInfo(String id) throws Exception{
        return noticeDao.getNoticeInfo(id);
    }

    public boolean noticeEdit(String id, String noticeType, String title, String content) throws Exception{
        return noticeDao.noticeEdit(id, noticeType, title, content);
    }
}
