<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>对比选择</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/member.css">
  </head>
  <body>
  	<div class='duibi-table'>
  		<c:if test="${pageInfo.infoList!= null && fn:length(pageInfo.infoList) != 0}">
		<table>
			<tbody>
				<tr>
					<th width='20%'>编号</th>
					<th width='20%'>姓名</th>
					<th width='20%'>检查时间</th>
					<th width='40%'>操作</th>
				</tr>
				<c:forEach var="card" items="${pageInfo.infoList}" varStatus="st">
					<tr>
						<td width='20%'>${st.count}</td>
						<td width='20%'>${card.patient_name}</td>
						<td width='20%'>${card.report_date_time}</td>
						<td width='40%'>
							<a id="check_record_${card.id}" href='javascript:void(0);' onclick='window.parent.checkConpareCard(${card.id})' class='a-link2'>选择对比
								<c:if test="${card.check_state=='1'}"><i class="h-i-img"></i></c:if>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<div id="pageDiv" class="cp-manu mtop20">
		</div>
		<div class='mtop20' style='text-align:right'><a href='#' class='a-link3'>关闭</a></div>
	</div>
  </body>
  <script src="js/jquery.min.1.8.1.js"></script>
  <script src="js/layer/layer.js"></script>
  <script type="text/javascript">
  	var currentPage = ${pageInfo.currentPage};
	var totalPage = ${pageInfo.totalPage};
	$(function(){
		initPageSize();
	});
  	function initPageSize(){
  		var pageInfoDiv = "<span>共有${pageInfo.totalCount}条记录，当前第${pageInfo.currentPage}/${pageInfo.totalPage}页 </span>";
  		if(currentPage == 1){
  			pageInfoDiv +="<span class='disabled'>上一页</span>";
  		} else {
  			pageInfoDiv +="<a href='javascript:void(0);' onclick='toPerPage()' >上一页</a>";
  		}
  		for(var i = 1; i <= totalPage;i++){
  			if(i == currentPage){
  				pageInfoDiv+="<span class='current'>"+currentPage+"</span>";
  			} else {
  				pageInfoDiv+="<a href='${pageInfo.url}?cId=${pageInfo.params.cId}&page="+i+"'>"+i+"</a>";
  			}
  		}
  		if(currentPage == totalPage){
  			pageInfoDiv +="<span class='disabled'>下一页</span>";
  		} else {
  			pageInfoDiv +="<a href='javascript:void(0);' onclick='toNextPage()' >下一页</a>";
  		}
  		$("#pageDiv").html(pageInfoDiv);
  	}
  	function toPerPage(){
  		if(currentPage >1 ){
			currentPage = currentPage -1;
			toPage(currentPage);
		}
  	}
  	function toNextPage(){
  		if(currentPage < totalPage){
			currentPage = currentPage +1;
			toPage(currentPage);
		}
  	}
  	function toPage(pageIndex){
		window.location.href="${pageInfo.url}?cId=${pageInfo.params.cId}&page="+pageIndex;
	}
  </script>
</html>
