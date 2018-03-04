package com.base.frontend.service;

import com.base.frontend.dao.MainDao;
import com.core.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MainService {

    @Autowired
    private MainDao mainDao;

    public Map<String,Object> getAboutMap(String noticeType, int start) throws Exception {
        return mainDao.getInfoMap(noticeType, start);
    }

    public List<Map<String, Object>> getExpertList(int page) throws Exception {
        String noticeType = "10";
        int pageSize = 5;
        return  mainDao.getInfoList(noticeType, page, pageSize);
    }

    public PageInfo getCommunicateList(int page) throws Exception {
        PageInfo pageInfo = new PageInfo();
        String noticeType = "16";
        int pageSize = 5;
        int start = (page-1)*pageSize;
        pageInfo.setTotalCount(mainDao.getInfoCount(noticeType));
        pageInfo.setInfoList(mainDao.getInfoList(noticeType, start, pageSize));
        return pageInfo;
    }

    public Map<String,Object> communicateDetail(int id) throws Exception{
        return mainDao.getInfoMap(id);
    }

    public PageInfo getElectrocardiologyList(int page) throws Exception{
        PageInfo pageInfo = new PageInfo();
        String noticeType = "13";
        int pageSize = 5;
        int start = (page-1) * pageSize;
        pageInfo.setTotalCount(mainDao.getInfoCount(noticeType));
        pageInfo.setInfoList(mainDao.getInfoList(noticeType, start, pageSize));
        return pageInfo;
    }
    public Map<String,Object> getElectrocardiologyDetail(int id) throws Exception {
        return mainDao.getInfoMap(id);
    }

    public PageInfo getEducationList(int page) throws Exception{
        PageInfo pageInfo = new PageInfo();
        String noticeType = "20";
        int pageSize = 5;
        int start = (page-1) * pageSize;
        pageInfo.setTotalCount(mainDao.getInfoCount(noticeType));
        pageInfo.setInfoList(mainDao.getInfoList(noticeType, start, pageSize));
        return pageInfo;
    }
    public Map<String,Object> getEducationDetail(int id) throws Exception {
        return mainDao.getInfoMap(id);
    }

    public PageInfo getScienceList(int page) throws Exception{
        PageInfo pageInfo = new PageInfo();
        String noticeType = "20";
        int pageSize = 5;
        int start = (page-1) * pageSize;
        pageInfo.setTotalCount(mainDao.getInfoCount(noticeType));
        pageInfo.setInfoList(mainDao.getInfoList(noticeType, start, pageSize));
        return pageInfo;
    }

    public Map<String,Object> getScienceDetail(int id) throws Exception {
        return mainDao.getInfoMap(id);
    }

    public PageInfo getInstrumentList(int page) throws Exception{
        PageInfo pageInfo = new PageInfo();
        String noticeType = "20";
        int pageSize = 5;
        int start = (page-1) * pageSize;
        pageInfo.setTotalCount(mainDao.getInfoCount(noticeType));
        pageInfo.setInfoList(mainDao.getInfoList(noticeType, start, pageSize));
        return pageInfo;
    }

    public Map<String,Object> getInstrumentDetail(int id) throws Exception {
        return mainDao.getInfoMap(id);
    }

    public PageInfo getCheckingList(int page) throws Exception{
        PageInfo pageInfo = new PageInfo();
        String noticeType = "11";
        int pageSize = 5;
        int start = (page-1) * pageSize;
        pageInfo.setTotalCount(mainDao.getInfoCount(noticeType));
        pageInfo.setInfoList(mainDao.getInfoList(noticeType, start, pageSize));
        return pageInfo;
    }

    public Map<String,Object> getCheckingDetail(int id) throws Exception{
        return mainDao.getInfoMap(id);
    }
}
