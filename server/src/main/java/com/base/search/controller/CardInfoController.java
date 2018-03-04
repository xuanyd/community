package com.base.search.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.base.search.service.CardInfoService;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.core.util.PageInfo;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;

@Controller
public class CardInfoController {
	@Autowired
	private CardInfoService cardInfoService;

	@RequestMapping({ "search/login.html" })
	public String login(HttpServletRequest req, HttpSession httpSession,
			Map<String, Object> model) throws Exception {
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		String pwd = req.getParameter("namestr");
		String cardId = req.getParameter("cardid");
		Map<String, Object> cardPersonInfo = this.cardInfoService
				.qryPersonInfo(name, sex, pwd, cardId);
		if ((cardPersonInfo == null) || (cardPersonInfo.isEmpty())) {
			model.put("alertMsg", "登陆失败，请检查所填写信息是否正确！");
			return "search/login";
		}
		this.cardInfoService.modifyCheckStateByNameAndSex(name, sex);
		Map<String, String> loginInfo = new HashMap<String, String>();
		loginInfo.put("name", name);
		loginInfo.put("sex", sex);
		loginInfo.put("cardId", cardId);
		loginInfo.put("pId", cardPersonInfo.get("id").toString());
		httpSession.setAttribute("loginInfo", loginInfo);
		return "search/tomain";
	}

	@RequestMapping({ "search/logOut" })
	public String logOut(HttpSession httpSession) {
		httpSession.removeAttribute("loginInfo");
		return "search/login";
	}

	@RequestMapping({ "search/index.html" })
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("redirect:card_info");
		return model;
	}

	@RequestMapping({ "search/toModifyPwd" })
	public String toModifyPwd() {
		return "search/modify_pwd";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping({ "search/modifyPwd" })
	public String modifyPwd(HttpServletRequest req, Map<String, Object> model,
			HttpSession httpSession) throws Exception {
		Map<String, String> loginInfo = (Map<String, String>) httpSession
				.getAttribute("loginInfo");
		String name = (String) loginInfo.get("name");
		String sex = (String) loginInfo.get("sex");
		String oldpwd = req.getParameter("oldpwd");
		String newpwd = req.getParameter("newpwd");
		String newpwd1 = req.getParameter("newpwd1");
		if ((oldpwd == null) || (newpwd == null) || (newpwd1 == null)) {
			return "search/modify_pwd";
		}
		if (!newpwd.equals(newpwd1)) {
			model.put("alertMsg", "两次密码输入不一致");
		} else {
			int eC = this.cardInfoService.modifyPwd(name, sex, oldpwd, newpwd);
			if (eC == 0) {
				model.put("alertMsg", "修改失败，请检查原密码输入是否正确");
			} else {
				model.put("alertMsg", "修改成功，下次请书用新密码登陆");
				return "search/login";
			}
		}
		return "search/modify_pwd";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping({ "search/card_info" })
	public String getCardInfo(HttpServletRequest req,
			Map<String, Object> model, HttpSession httpSession)
			throws Exception {
		Map<String, String> loginInfo = (Map<String, String>) httpSession
				.getAttribute("loginInfo");
		String name = (String) loginInfo.get("name");
		String sex = (String) loginInfo.get("sex");
		String cardId = (String) loginInfo.get("cardid");
		String currentP = req.getParameter("page");
		int page = 1;
		if ((currentP == null) || (currentP.equals(""))) {
			page = 1;
		} else {
			page = Integer.valueOf(req.getParameter("page")).intValue();
		}
		PageInfo pageInfo = this.cardInfoService.getCardInfo(name, sex,
				"123456", cardId, page, 10);
		pageInfo.setUrl("search/card_info");
		model.put("pageInfo", pageInfo);
		return "search/main";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping({ "search/ptoCheckInfoList" })
	public String getCheckInfoList(HttpServletRequest req,
			Map<String, Object> model, HttpSession httpSession)
			throws Exception {
		Map<String, String> loginInfo = (Map<String, String>) httpSession
				.getAttribute("loginInfo");
		String name = (String) loginInfo.get("name");
		String currentP = req.getParameter("currentPage");
		int page = 1;
		if ((currentP == null) || (currentP.equals(""))) {
			page = 1;
		} else {
			page = Integer.valueOf(req.getParameter("currentPage")).intValue();
		}
		PageInfo pageInfo = this.cardInfoService.getCheckInfo(name, page, 10);
		model.put("pageInfo", pageInfo);
		pageInfo.setUrl("search/ptoCheckInfoList");
		return "search/checkInfo";
	}

	@RequestMapping({ "search/seeCardInfo" })
	public String seeCardInfo(HttpServletRequest req, Map<String, Object> model) throws Exception {
		int id = Integer.valueOf(req.getParameter("id")).intValue();
		movePdf(id, req);
		//model.put("jpgId", Integer.valueOf(id));
		return "search/seeCardInfo";
	}

	/**
	 * 对比pdf差异
	 * @param req
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "search/compare" })
	public String compare(HttpServletRequest req, Map<String, Object> model)
			throws Exception {
		int cp1 = 0;
		int cp2 = 0;
		try {
			cp1 = Integer.valueOf(req.getParameter("cp1")).intValue();
			cp2 = Integer.valueOf(req.getParameter("cp2")).intValue();
			Map<String, Object> compInfo = this.cardInfoService.qryCompInfo(
					cp1, cp2);
			model.put("cp_date1", compInfo.get("cp_date1"));
			model.put("cp_date2", compInfo.get("cp_date2"));
			List<Map<String, String>> cardInfo1 = this.cardInfoService
					.getCardInfoById(cp1);
			List<Map<String, String>> cardInfo2 = this.cardInfoService
					.getCardInfoById(cp2);
			
			if ((cardInfo1 == null) || (cardInfo1.isEmpty()) || (cardInfo2 == null) || (cardInfo2.isEmpty())) {
				return null;
			}
			String fileName1 = cardInfo1.get(0).get("relative_path");
			
			if ((fileName1 == null) || (fileName1.equals(""))) {
				return null;
			}
			
			String fileName2 = cardInfo1.get(0).get("relative_path");
			if ((fileName2 == null) || (fileName2.equals(""))) {
				return null;
			}
			
			//拷贝两个文件到本地
			copyRemote2Local(fileName1,"D:\\search\\");
			copyRemote2Local(fileName1,"D:\\search\\");

			this.cardInfoService.modifyCheckStateById(cp1, cp2);
			fileName1 = fileName1.replace("ftp://NAS:EDS_China@10.169.160.82", "FTPRoot");
			fileName2 = fileName2.replace("ftp://NAS:EDS_China@10.169.160.82", "FTPRoot");
			fileName1 = fileName1.replace("/", "\\");
			fileName2 = fileName2.replace("/", "\\");
			if(fileName1.indexOf(1) == ':')
				fileName1 = fileName1.substring(2, fileName1.length());
			if(fileName2.indexOf(1) == ':')
				fileName2 = fileName2.substring(2, fileName1.length());
			String localFilePath1 = "D:\\search\\"+fileName1;
			String localFilePath2 = "D:\\search\\"+fileName2;
			
			mergeFile(new String[]{localFilePath1,localFilePath2}, req.getRealPath("")+"\\pdf\\compare.pdf");
			
			
		} catch (Exception localException) {
		}
		model.put("jpgId1", Integer.valueOf(cp1));
		model.put("jpgId2", Integer.valueOf(cp2));
		return "search/compareCard";
	}

	private boolean mergeFile(String[] files, String finalPath) {
		 boolean retValue = false;  
	        Document document = null;
	        try {  
	            document = new Document(new PdfReader(files[0]).getPageSize(1));  
	            PdfCopy copy = new PdfCopy(document, new FileOutputStream(finalPath));  
	            document.open();  
	            for (int i = 0; i < files.length; i++) {  
	                PdfReader reader = new PdfReader(files[i]);  
	                int n = reader.getNumberOfPages();  
	                for (int j = 1; j <= n; j++) {  
	                    document.newPage();  
	                    PdfImportedPage page = copy.getImportedPage(reader, j);  
	                    copy.addPage(page);  
	                }  
	            }  
	            retValue = true;  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            document.close();  
	        }  
	        return retValue;  
	}

	@RequestMapping({ "search/getCardJpg" })
	public void getCardJpg(HttpServletRequest request,
			Map<String, Object> model, HttpServletResponse response)
			throws Exception {
		int id = 0;
		try {
			id = Integer.valueOf(request.getParameter("id")).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Map<String, String>> cardInfo = this.cardInfoService
				.getCardInfoById(id);
		if ((cardInfo == null) || (cardInfo.isEmpty())) {
			return;
		}
		String fileName = (String) ((Map) cardInfo.get(0))
				.get("relative_path_jpg");
		if ((fileName == null) || (fileName.equals(""))) {
			return;
		}
		File file = new File(fileName);
		if ((!file.exists()) || (!file.canRead())) {
			file = new File(request.getSession().getServletContext()
					.getRealPath("/")
					+ "resource/icons/auth/root.png");
		}
		FileInputStream inputStream = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		int length = inputStream.read(data);
		inputStream.close();
		response.setContentType("image/png");
		OutputStream stream = response.getOutputStream();
		stream.write(data);
		stream.flush();
		stream.close();
	}

	@RequestMapping({ "search/toCheckCompare" })
	public String toCheckCompare(HttpServletRequest request,
			HttpSession httpSession, Map<String, Object> model)
			throws Exception {
		Map<String, String> loginInfo = (Map) httpSession
				.getAttribute("loginInfo");
		Integer compId = Integer.valueOf(request.getParameter("cId"));
		String name = (String) loginInfo.get("name");
		String sex = (String) loginInfo.get("sex");
		String currentP = request.getParameter("page");
		int page = 1;
		if ((currentP == null) || (currentP.equals(""))) {
			page = 1;
		} else {
			page = Integer.valueOf(request.getParameter("page")).intValue();
		}
		PageInfo cardPersonInfo = this.cardInfoService.qryPersonInfo(name, sex,
				compId.intValue(), page, 5);
		cardPersonInfo.setUrl("toCheckCompare");
		cardPersonInfo.getParams().put("cId", compId);
		model.put("pageInfo", cardPersonInfo);
		return "search/checkCompare";
	}

	@RequestMapping({ "search/downloadPdf" })
	public void downloadPdf(HttpServletRequest request,
			Map<String, Object> model, HttpServletResponse response)
			throws Exception {
		int id = 0;
		try {
			id = Integer.valueOf(request.getParameter("id")).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Map<String, String>> cardInfo = this.cardInfoService
				.getCardInfoById(id);
		if ((cardInfo == null) || (cardInfo.isEmpty())) {
			return;
		}
		String fileName = cardInfo.get(0).get("relative_path");
		if ((fileName == null) || (fileName.equals(""))) {
			return;
		}
		File file = new File(fileName);
		if ((!file.exists()) || (!file.canRead())) {
			file = new File(request.getSession().getServletContext()
					.getRealPath("/")
					+ "resource/icons/auth/root.png");
		}
		FileInputStream inputStream = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		int length = inputStream.read(data);
		inputStream.close();
		setFileDownloadHeader(request, response, file.getName());
		OutputStream stream = response.getOutputStream();
		stream.write(data);
		stream.flush();
		stream.close();
	}
	
	public void movePdf(int id,HttpServletRequest request) throws Exception {
		//1.先删除文件
		File deF = new File(request.getRealPath("")+"\\pdf\\see.pdf");
		if(deF.exists())
			deF.delete();
		List<Map<String, String>> cardInfo = this.cardInfoService
				.getCardInfoById(id);
		//1.远程拷贝文件到本地服务器
		//E:\\轩艳东\\项目\\陈立科\\医院查询\\1月1日-4日\\ARCHIVE\\2015\\01\\01\\00389757\\141328\\REPORT\\001.jpg
		if ((cardInfo == null) || (cardInfo.isEmpty())) {
			return;
		}
		String fileName = cardInfo.get(0).get("relative_path");
		if ((fileName == null) || (fileName.equals(""))) {
			return;
		}
	
		//1. 判断是否拷贝远程文件
		//计算出需要放置的本地文件名
		System.out.println("---刚开始filename---" + fileName);
		
		fileName = fileName.replace("ftp://NAS:EDS_China@10.169.160.82", "FTPRoot");
		if(fileName.charAt(1) == ':') {
			System.out.println("为本地文件");
			fileName = fileName.substring(2, fileName.length());
		}
		String localFilePath = "D:\\search\\";
		fileName = fileName.replace("/", "\\");
		File remoteFile = new File(fileName.replace("E:\\", "D:\\search\\"));
		if(!remoteFile.exists()) { 
			copyRemote2Local(fileName,"D:\\search\\");
		}
		System.out.println(localFilePath + fileName);
		/*if(fileName.indexOf(2) == ':')
			fileName = localFilePath + fileName;*/
		System.out.println("---------------------------------------------");
		System.out.println(localFilePath + fileName);
		FileInputStream inputStream = new FileInputStream(localFilePath + fileName);
		File file = new File(localFilePath + fileName);
		OutputStream os = null;
		byte[] bs = new byte[1024];
		int len;
		if ((file.exists()) && (file.canRead())) {
			os = new FileOutputStream(request.getRealPath("")+"\\pdf\\see.pdf");
			while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
		}
	}
	
	private static void copyRemote2Local(String remoteFile, String localPath){
		File localfile = null;
		InputStream is = null;
		OutputStream os = null;
		//smb://administrator:1qaz@192.168.141.130/c$/pdf/t.txt
		//查看文件是否复制过
		String localFile = localPath + remoteFile.substring(remoteFile.indexOf("\\") + 1,remoteFile.length());
		File file = new File(localFile);
		/*if(file.exists())
			return;*/
		try{
			//远程读取文件
			//D:\phpStudy\WWW\xindiantu\2015-06\ARCHIVE\2015\06\01\00509221\176943\REPORT\20150601083927_176943_5b7223d8-c6c6-473e-bfbd-183628e674b9.pdf
			remoteFile = remoteFile.replace("ftp://NAS:EDS_China@10.169.160.82", "FTPRoot");
			remoteFile = remoteFile.replace("\\", "/");
			SmbFile rmiFile = new SmbFile("smb://administrator:zzdx&ZDEFY@192.168.160.89/"+remoteFile.replace(":\\", "$/"));
			String filename = rmiFile.getName(); //获取文件名
			is = new BufferedInputStream(new SmbFileInputStream(rmiFile)); //对文件进行读取
			//将远程文件写到本地
			//查看文件夹是否存在，不存在，则新建
			String localFileFolder = localPath + remoteFile.substring(0, remoteFile.lastIndexOf("/"));
			
			localFileFolder = localFileFolder.replace("/", "\\");
			System.out.println("-------------本地文件夹--------------------");
			System.out.println(localFileFolder);
			System.out.println("----------------------------------------");
			File localFolder = new File(localFileFolder+"\\");
			System.out.println(localFolder.getAbsolutePath() + "--是否存在：" + localFolder.exists());
			if(!localFolder.exists()) {
				System.out.println(localFolder.mkdirs());
				System.out.println("----------创建文件夹--------------------------");
			}
			System.out.println("--------------创建本地文件-------------------");
			System.out.println(localPath + File.separator + filename);
			localfile = new File(localFolder + File.separator + filename);  //将远程拷贝的文件，指定到具体的本地的具体路径
			System.out.println("------------写本地文件地址------------------" + localfile.getAbsolutePath());
			os = new BufferedOutputStream(new FileOutputStream(localfile)); 
			int length = rmiFile.getContentLength();  //获取文件的内容大小
			byte[] buffer = new byte[length];
			is.read(buffer); 
			os.write(buffer);  //开始写
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		//System.out.println("E:\\轩艳东\\项目\\陈立科\\医院查询\\1月1日-4日\\ARCHIVE\\2015\\01\\01\\00389757\\141328\\REPORT\\001.jpg".replace(":\\", "$\\")); 
		//copyRemote2Local("D:\\phpStudy\\WWW\\xindiantu\\2015-06\\ARCHIVE\\2015\\06\\"
			//	+ "01\\00509221\\176943\\REPORT\\20150601083927_176943_5b7223d8-c6c6-473e-bfbd-183628e674b9.pdf","d:\\search\\");
		/*String remoteFile = "FTPRoot/cardioNet/FileDBData/ARCHIVE/2017/12/11/00632955/427801/Report/20171211173636_427801_e622d0c4-629b-4889-ac2f-092e94a312c2.pdf";
		String localFileFolder = "D:\\search\\" + remoteFile.substring(remoteFile.indexOf("/") + 1,remoteFile.lastIndexOf("/"));
		System.out.println(localFileFolder.replace("/", "\\"));*/
		String file="d:/";
	}

	private void setFileDownloadHeader(HttpServletRequest request,
			HttpServletResponse response, String fileName) {
		try {
			String encodedfileName = null;
			String agent = request.getHeader("USER-AGENT");
			if ((agent != null) && (-1 != agent.indexOf("MSIE"))) {
				encodedfileName = URLEncoder.encode(fileName, "UTF-8");
			} else if ((agent != null) && (-1 != agent.indexOf("Mozilla"))) {
				encodedfileName = new String(fileName.getBytes("UTF-8"),
						"iso-8859-1");
			} else {
				encodedfileName = URLEncoder.encode(fileName, "UTF-8");
			}
			response.setHeader("Content-Disposition", "attachment; filename=\""
					+ encodedfileName + "\"");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
