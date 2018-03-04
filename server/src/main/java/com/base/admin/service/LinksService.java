package com.base.admin.service;

import com.base.admin.dao.LinksDao;
import com.core.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinksService {

    @Autowired
    private LinksDao linksDao;

    public PageInfo getLinksPage(String title, int page, int pageSize) throws Exception{
        PageInfo pageInfo = new PageInfo();
        int start = (page -1) * pageSize;
        int size = pageSize;
        pageInfo.setPageSize(pageSize);
        pageInfo.setCurrentPage(page);
        pageInfo.setTotalCount(linksDao.getLinksCount(title));
        pageInfo.setInfoList(linksDao.getLinksList(title, start, size));
        return pageInfo;
    }
}
