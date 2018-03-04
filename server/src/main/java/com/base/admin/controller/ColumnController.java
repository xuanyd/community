package com.base.admin.controller;

import com.base.admin.service.ColumnService;
import com.core.util.Constant;
import com.core.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ColumnController {

	@Autowired
    private ColumnService columnService;

    @RequestMapping("admin/columnlist")
    public @ResponseBody Map columnList(HttpServletRequest request) {
        Map<String, Object> retMap = new HashMap<>();
        String name = request.getParameter("name");
        try {
            List<Map<String, Object>> columnList= columnService.getColumnPage(name);
            retMap.put("columnList", columnList);
            retMap.put("flag", Constant.RESCODE_SUCCESS);
        } catch (Exception e) {
            retMap.put("flag", Constant.RESCODE_EXCEPTION);
            e.printStackTrace();
        }

        return retMap;
    }
}