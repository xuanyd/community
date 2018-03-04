package com.base.admin.controller;

import com.base.admin.service.LinksService;
import com.core.util.Constant;
import com.core.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LinksController {

	@Autowired
    private LinksService linksService;

    @RequestMapping("admin/linklist")
    public @ResponseBody Map linksList(HttpServletRequest request) {
        Map<String, Object> retMap = new HashMap<>();
        String title = request.getParameter("title");
        String currentPage = request.getParameter("page");
        int page = 1;
        int pageSize = 10;
        if ((currentPage == null) || (currentPage.equals(""))) {
            page = 1;
        } else {
            page = Integer.valueOf(request.getParameter("page")).intValue();
        }
        try {
            PageInfo pageInfo = linksService.getLinksPage(title, page, pageSize);
            retMap.put("pageInfo", pageInfo);
        } catch (Exception e) {
            retMap.put("flag", Constant.RESCODE_EXCEPTION);
        }
        return retMap;
    }
}