package com.base.search.dao;

import com.core.dao.IBaseDao;
import com.core.util.PageInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class CardInfoDao {
	@Autowired
	private IBaseDao baseDao;

	public PageInfo getCardInfo(String name, String sex, String pwd,
			String cardId, int page, int pageSize) throws Exception {
		PageInfo pageInfo = new PageInfo();
		Map<String, Object> params = new HashMap<String, Object>();
		/*String sql = " select id,visit_date_time, patient_name, report_date_time,relative_path_jpg,compare_ids from patinfo where PATIENT_NAME=:name and "
				+ " SEX=:sex and (IDENTIFICATION_CARD=:cardId or :cardId is null) order by report_name desc  :start, :end ";*/
		String c_sql = " select count(1) count from patinfo where PATIENT_NAME=:name and SEX=:sex ";
				//+ " SEX=:sex and (IDENTIFICATION_CARD=:cardId or :cardId is null) ";
		/*String m_sql = " DECLARE @Start INT"
				+ " DECLARE @End INT"
				+ "\r SELECT id,visit_date_time, patient_name, report_date_time,relative_path_jpg,compare_ids"
				+ " FROM (SELECT id,visit_date_time, patient_name, report_date_time,relative_path_jpg,compare_ids,"
				+ " ROW_NUMBER() OVER (order by id) AS RowNumber"
				+ " FROM patinfo where PATIENT_NAME=:name and SEX=:sex ) patinfopage"
				+ " WHERE  RowNumber > @Start AND RowNumber <= @End ";
*/
		int start = (page - 1) * pageSize;
		String sql = " select id,visit_date_time, patient_name, report_date_time,relative_path_jpg,compare_ids from patinfo where "
				+ " patient_name=:name and "
				+ " sex=:sex order by id desc limit :start, :size";
		params.put("name", name);
		params.put("sex", sex);
		params.put("cardId", cardId);
		params.put("size", pageSize);
		params.put("start", start);
		//int count = this.baseDao.getSqlCount(m_sql, params);\
		int count = Integer.parseInt(this.baseDao.queryForList(c_sql, params).get(0).get("count").toString());
		List<Map<String, Object>> infoList = this.baseDao.queryForList(sql,
				params);
		pageInfo.setCurrentPage(page);
		pageInfo.setTotalCount(count);
		pageInfo.setPageSize(pageSize);
		pageInfo.setParams(params);
		pageInfo.setInfoList(infoList);
		return pageInfo;
	}

	public List<Map<String, String>> getCardInfoById(Map<String, Object> params)
			throws Exception {
		String sql = " select id, visit_date_time, relative_path, relative_path_jpg,compare_ids from patinfo where id=:id  ";
		return this.baseDao.queryForStrListBySql(sql, params);
	}

	public Map<String, Object> qryPersonInfo(Map<String, Object> params)
			throws Exception {
		String sql = " select id from patinfo where PATIENT_NAME=:name and "
				+ " SEX=:sex and PWD=:pwd limit 1";

		return this.baseDao.queryForMap(sql, params);
	}

	public PageInfo getCheckInfo(String name, int page, int pageSize)
			throws Exception {
		PageInfo pageInfo = new PageInfo();
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = " select id,patient_name,check_info,check_date from t_check_info where 1=1 ";
		params.put("patientName", name);
		sql = sql + " and patient_name = :patientName ";
		sql = sql + " limit :start, :end";
		int start = (page - 1) * pageSize;
		int end = pageSize;
		String m_sql = "select top " + pageSize + "id, patient_name, check_info, check_date from t_check_info where id not in (select top "+ start +" id from t_check_info order by id desc) "
				+ " order by id desc ";
		params.put("start", Integer.valueOf(start));
		params.put("pageSize", pageSize);
		//params.put("end", Integer.valueOf(end));
		int count = this.baseDao.getSqlCount(sql, params);
		List<Map<String, Object>> infoList = this.baseDao.queryForList(m_sql,
				params);
		pageInfo.setCurrentPage(page);
		pageInfo.setTotalCount(count);
		pageInfo.setPageSize(pageSize);
		pageInfo.setParams(params);
		pageInfo.setInfoList(infoList);
		return pageInfo;
	}

	public PageInfo qryPersonInfo(String name, String sex, int compId,
			int page, int pageSize) throws Exception {
		PageInfo pageInfo = new PageInfo();
		Map<String, Object> params = new HashMap<String, Object>();
		String c_sql =  " select count(1) count from patinfo where PATIENT_NAME=:name and "
				+ " SEX=:sex and id <> :compId ";
		int start = (page - 1) * pageSize;
		int end = pageSize;
		String sql = " select top " + pageSize + " id,visit_date_time, patient_name, report_date_time,relative_path_jpg,"
				+ " compare_ids from patinfo where id not in (select top "+ start +" id from patinfo order by id desc) and PATIENT_NAME=:name and "
				+ " SEX=:sex and id <> :compId  order by id desc ";

		params.put("name", name);
		params.put("sex", sex);
		params.put("compId", Integer.valueOf(compId));
		params.put("start", Integer.valueOf(start));
		params.put("end", Integer.valueOf(end));
		int count = Integer.parseInt((this.baseDao.queryForList(c_sql, params).get(0).get("count").toString()));
		List<Map<String, Object>> infoList = this.baseDao.queryForList(sql,
				params);
		pageInfo.setCurrentPage(page);
		pageInfo.setTotalCount(count);
		pageInfo.setPageSize(pageSize);
		pageInfo.setParams(params);
		pageInfo.setInfoList(infoList);
		return pageInfo;
	}

	public int modifyPwd(String name, String sex, String oldpwd, String newpwd)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("sex", sex);
		params.put("oldpwd", oldpwd);
		params.put("newpwd", newpwd);
		String sql = " update patinfo set pwd=:newpwd where patient_name=:name and sex=:sex and pwd=:oldpwd ";
		return this.baseDao.update(sql, params);
	}

	public Map<String, Object> qryCompInfo(int cp1, int cp2) throws Exception {
		String sql = "select (select report_date_time from patinfo where id=:cp1) cp_date1, (select report_date_time from patinfo where id=:cp2) cp_date2";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("cp1", Integer.valueOf(cp1));
		params.put("cp2", Integer.valueOf(cp2));
		return this.baseDao.queryForMap(sql, params);
	}

	public int modifyCheckStateById(int id, int id2) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//事先查询出compare_ids
		params.put("id", Integer.valueOf(id));
		String cid_sql = " select compare_ids from patinfo where id=:id ";
		Map<String, String> resultMap = this.baseDao.queryForStrMap(cid_sql, params);
		String compare_ids = resultMap.get("compare_ids").replace(" ", "") + "," + id2;
		String sql = "update patinfo set compare_ids = :compare_ids where id=:id";
		params.put("compare_ids", compare_ids);
		return this.baseDao.update(sql, params);
	}

	public int modifyCheckStateByNameAndSex(String name, String sex)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = " update patinfo set compare_ids='0' where patient_name=:name and sex=:sex ";
		params.put("name", name);
		params.put("sex", sex);
		return this.baseDao.update(sql, params);
	}
}
