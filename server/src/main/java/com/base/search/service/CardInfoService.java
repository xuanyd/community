package com.base.search.service;

import com.base.search.dao.CardInfoDao;
import com.core.util.PageInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardInfoService {
	@Autowired
	private CardInfoDao cardInfoDao;

	public PageInfo getCardInfo(String name, String sex, String pwd,
			String cardId, int page, int pageSize) throws Exception {
		PageInfo resultPageInfo = this.cardInfoDao.getCardInfo(name, sex, pwd,
				cardId, page, pageSize);
		List<Map<String, Object>> infoList = resultPageInfo.getInfoList();
		Map<String, Object> cardInfoMap = resultPageInfo.getInfoList().get(0);
		for (int i = 0; i < infoList.size(); i++) {
			if(i == 0)
				infoList.get(i).put("first", 1);
			if (cardInfoMap.get("compare_ids").toString()
					.contains((infoList.get(i)).get("id").toString())) {
				infoList.get(i).put("check_state", 1);
			}
		}
		return resultPageInfo;
	}

	public List<Map<String, String>> getCardInfoById(int id) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", Integer.valueOf(id));
		return this.cardInfoDao.getCardInfoById(params);
	}

	public Map<String, Object> qryPersonInfo(String name, String sex,
			String pwd, String cardId) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("sex", sex);
		params.put("pwd", pwd);
		params.put("cardId", cardId);
		return this.cardInfoDao.qryPersonInfo(params);
	}

	public PageInfo getCheckInfo(String name, int page, int pageSize)
			throws Exception {
		return this.cardInfoDao.getCheckInfo(name, page, pageSize);
	}

	public PageInfo qryPersonInfo(String name, String sex, int compId,
			int page, int pageSize) throws Exception {
		PageInfo resultPageInfo = this.cardInfoDao.qryPersonInfo(name, sex,
				compId, page, pageSize);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", Integer.valueOf(compId));
		List<Map<String, Object>> infoList = resultPageInfo.getInfoList();
		Map<String, String> cardInfoMap =  this.cardInfoDao
				.getCardInfoById(params).get(0);
		for (int i = 0; i < infoList.size(); i++) {
			if (((String) cardInfoMap.get("compare_ids"))
					.contains(( infoList.get(i)).get("id").toString())) {
				(infoList.get(i)).put("check_state", Integer.valueOf(1));
			}
		}
		return resultPageInfo;
	}

	public int modifyPwd(String name, String sex, String oldpwd, String newpwd)
			throws Exception {
		return this.cardInfoDao.modifyPwd(name, sex, oldpwd, newpwd);
	}

	public Map<String, Object> qryCompInfo(int cp1, int cp2) throws Exception {
		return this.cardInfoDao.qryCompInfo(cp1, cp2);
	}

	public int modifyCheckStateById(int id, int id2) throws Exception {
		return this.cardInfoDao.modifyCheckStateById(id, id2);
	}

	public int modifyCheckStateByNameAndSex(String name, String sex)
			throws Exception {
		return this.cardInfoDao.modifyCheckStateByNameAndSex(name, sex);
	}
}
