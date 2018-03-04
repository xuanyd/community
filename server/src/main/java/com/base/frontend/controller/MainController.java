package com.base.frontend.controller;

import com.base.frontend.service.MainService;
import com.core.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;

	@RequestMapping({"index.html"})
	public String index(){
		return "index";
	}

	/**
	 * 中心简介
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping({"about.html"})
	public String about(HttpServletRequest req, Map<String,Object> model){
		String lan = req.getParameter("lang");
		int start=0;
		try {
			if("en".equals(lan))
				start = 1;
			Map<String, Object> aboutMap = mainService.getAboutMap("13", start);
			model.put("content", aboutMap.get("content"));
			model.put("title", aboutMap.get("title"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "about";
	}

	/**
	 * 专家介绍
	 * @param req
	 * @param model
	 * @return
	 */
 	@RequestMapping({"expert-list.html"})
	public String expertList(HttpServletRequest req, Map<String,Object> model){
		int page;
		try {
			page = req.getParameter("page") == null ? 1 : Integer.valueOf(req.getParameter("page"));
		} catch (Exception e) {
			page=1;
		}
		try {
			List<Map<String, Object>> expertList = mainService.getExpertList(page);
			model.put("expertList", expertList);
		} catch (Exception e) {
			e.printStackTrace();
		}
 		return "expert-list";
	}
	/**
	 * 心电检查介绍
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping({"checking.html"})
	public String checkingList(HttpServletRequest req, Map<String,Object> model){
		int page;
		try {
			page = req.getParameter("page") == null ? 1 : Integer.valueOf(req.getParameter("page"));
		} catch (Exception e) {
			page=1;
		}
		try {
			PageInfo pageInfo = mainService.getCheckingList(page);
			pageInfo.setPageSize(5);
			pageInfo.setCurrentPage(page);
			model.put("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "checking";
	}

	@RequestMapping({"checking-detail.html"})
	public String checkingDetail(HttpServletRequest req, Map<String,Object> model){
		try {
			int id = req.getParameter("id") == null ? 1 : Integer.valueOf(req.getParameter("id"));
			Map<String, Object> communicateDetail = mainService.getCheckingDetail(id);
			model.put("content", communicateDetail.get("content"));
			model.put("title", communicateDetail.get("title"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "checking-detail";
	}

	/**
	 * 国内外影响
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping({"influences.html"})
	public String influences(HttpServletRequest req, Map<String,Object> model){
		int start = 0;
		try {
			Map<String, Object> aboutMap = mainService.getAboutMap("17", start);
			model.put("content", aboutMap.get("content"));
			model.put("title", aboutMap.get("title"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "influences";
	}

	/**
	 * 国内外领先方向
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping({"lead.html"})
	public String lead(HttpServletRequest req, Map<String,Object> model){
		int start = 0;
		try {
			Map<String, Object> aboutMap = mainService.getAboutMap("14", start);
			model.put("content", aboutMap.get("content"));
			model.put("title", aboutMap.get("title"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "lead";
	}

	/**
	 * 国内外知名度
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping({"reputation.html"})
	public String reputation(HttpServletRequest req, Map<String,Object> model){
		int start = 0;
		try {
			Map<String, Object> aboutMap = mainService.getAboutMap("15", start);
			model.put("content", aboutMap.get("content"));
			model.put("title", aboutMap.get("title"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "reputation";
	}

	/**
	 * 国内外交流
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping({"communicate.html"})
	public String communicate(HttpServletRequest req, Map<String,Object> model){
		int page;
		try {
			page = req.getParameter("page") == null ? 1 : Integer.valueOf(req.getParameter("page"));
		} catch (Exception e) {
			page=1;
		}
		try {
			PageInfo pageInfo = mainService.getCommunicateList(page);
			pageInfo.setPageSize(5);
			pageInfo.setCurrentPage(page);
			model.put("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "communicate";
	}

	@RequestMapping({"communicate-detail.html"})
	public String communicateDetail(HttpServletRequest req, Map<String,Object> model){
		try {
			int id = req.getParameter("id") == null ? 1 : Integer.valueOf(req.getParameter("id"));
			Map<String, Object> communicateDetail = mainService.communicateDetail(id);
			model.put("content", communicateDetail.get("content"));
			model.put("title", communicateDetail.get("title"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "communicate-detail";
	}

	/**
	 * 心电学之声
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping({"electrocardiology.html"})
	public String electrocardiology(HttpServletRequest req, Map<String,Object> model){
		int page;
		try {
			page = req.getParameter("page") == null ? 1 : Integer.valueOf(req.getParameter("page"));
		} catch (Exception e) {
			page=1;
		}
		try {
			PageInfo pageInfo = mainService.getElectrocardiologyList(page);
			pageInfo.setPageSize(5);
			pageInfo.setCurrentPage(page);
			model.put("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "electrocardiology";
	}

	@RequestMapping({"electrocardiology-detail.html"})
	public String electrocardiologyDetail(HttpServletRequest req, Map<String,Object> model){
		try {
			int id = req.getParameter("id") == null ? 1 : Integer.valueOf(req.getParameter("id"));
			Map<String, Object> electrocardiologyDetail = mainService.getElectrocardiologyDetail(id);
			model.put("content", electrocardiologyDetail.get("content"));
			model.put("title", electrocardiologyDetail.get("title"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "electrocardiology-detail";
	}

	/**
	 * 继续教育
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping({"education.html"})
	public String education(HttpServletRequest req, Map<String,Object> model){
		int page;
		try {
			page = req.getParameter("page") == null ? 1 : Integer.valueOf(req.getParameter("page"));
		} catch (Exception e) {
			page=1;
		}
		try {
			PageInfo pageInfo = mainService.getEducationList(page);
			pageInfo.setPageSize(5);
			pageInfo.setCurrentPage(page);
			model.put("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "education";
	}

	@RequestMapping({"education-detail.html"})
	public String getEducationDetail(HttpServletRequest req, Map<String,Object> model){
		try {
			int id = req.getParameter("id") == null ? 1 : Integer.valueOf(req.getParameter("id"));
			Map<String, Object> educationDetail = mainService.getEducationDetail(id);
			model.put("content", educationDetail.get("content"));
			model.put("title", educationDetail.get("title"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "education-detail";
	}

	@RequestMapping({"instrument.html"})
	public String instrument(HttpServletRequest req, Map<String,Object> model){
		int page;
		try {
			page = req.getParameter("page") == null ? 1 : Integer.valueOf(req.getParameter("page"));
		} catch (Exception e) {
			page=1;
		}
		try {
			PageInfo pageInfo = mainService.getInstrumentList(page);
			pageInfo.setPageSize(5);
			pageInfo.setCurrentPage(page);
			model.put("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "instrument";
	}

	@RequestMapping({"instrument-detail.html"})
	public String instrumentDetail(HttpServletRequest req, Map<String,Object> model){
		try {
			int id = req.getParameter("id") == null ? 1 : Integer.valueOf(req.getParameter("id"));
			Map<String, Object> educationDetail = mainService.getInstrumentDetail(id);
			model.put("content", educationDetail.get("content"));
			model.put("title", educationDetail.get("title"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "instrument-detail";
	}

	/**
	 * 科普知识
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping({"science.html"})
	public String science(HttpServletRequest req, Map<String,Object> model){
		int page;
		try {
			page = req.getParameter("page") == null ? 1 : Integer.valueOf(req.getParameter("page"));
		} catch (Exception e) {
			page=1;
		}
		try {
			PageInfo pageInfo = mainService.getScienceList(page);
			pageInfo.setPageSize(5);
			pageInfo.setCurrentPage(page);
			model.put("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "science";
	}

	@RequestMapping({"science-detail.html"})
	public String scienceDetail(HttpServletRequest req, Map<String,Object> model){
		try {
			int id = req.getParameter("id") == null ? 1 : Integer.valueOf(req.getParameter("id"));
			Map<String, Object> educationDetail = mainService.getScienceDetail(id);
			model.put("content", educationDetail.get("content"));
			model.put("title", educationDetail.get("title"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "science-detail";
	}

	@RequestMapping({"contact.html"})
	public String contact(){
		return "contact";
	}
	
	/*kejianxiazai*/
	@RequestMapping({"courseware.html"})
	public String courseware(){
		return "courseware";
	}

	/*kejianxiazai*/
	@RequestMapping({"courseware-detail.html"})
	public String coursewareDetail(){
		return "courseware-detail";
	}

	/*shipin*/
	@RequestMapping({"vedio.html"})
	public String vedio(){
		return "vedio";
	}

	/*shipin*/
	@RequestMapping({"vedio-detail.html"})
	public String vedioDetail(){
		return "vedio-detail";
	}

}