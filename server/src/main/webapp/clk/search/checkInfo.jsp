<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<title>${sessionScope.loginInfo.name}综合诊断及建议</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/member.css">
</head>
<body>
	<div class="nav-bar">
		<div class="container">
			<div class="bar-logo"><img src="images/20151203img1.png" width="333" height="72" alt=""/></div>
			<div class="bar-right">
				欢迎您：${sessionScope.loginInfo.name }<i></i><a href="toModifyPwd">修改密码</a><i></i><a href="logOut">退出</a>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="h-title mtop20">
			<h4>
				综合诊断及建议
				<a href="javascript:void(0);" onclick="javascript:history.go(-1)" class="advisory">返回&gt;&gt;</a>
			</h4>
		</div>
		
		<div class="h-table mtop20">
			<c:if test="${pageInfo.infoList!= null && fn:length(pageInfo.infoList) != 0}">
			<table>
				<tbody>
					<tr>
						<th width="20%">编号</th>
						<th width="20%">诊断时间</th>
						<th width="60%">综合诊断及建议</th>
					</tr>
					<c:forEach var="check" items="${pageInfo.infoList}" varStatus="st">
					<tr>
						<td>${st.count}</td>
						<td>${check.check_date}</td>
						<td>${check.check_info}</td>
					</tr>	
					</c:forEach>
				</tbody>
			</table>
			</c:if>
			<div id="pageDiv" class="cp-manu mtop20">
			</div>
		</div>
	</div>
</body>
<script src="js/jquery.min.1.8.1.js"></script>
<script type="text/javascript">
	var comp1 = "";
	var currentPage = ${pageInfo.currentPage};
	var totalPage = ${pageInfo.totalPage};
	$(function(){
		initPageSize();
	});
	function checkCompare(curId){
		comp1=curId;
		layer.open({
		    type: 2,
		    skin: 'layui-layer-rim', //加上边框
		    area: ['748px', '500px'], //宽高
		    content: "toCheckCompare?cId="+curId
		});
	}
	function checkConpareCard(id2){
		layer.closeAll();
		window.location.href="compare?cp1=" + comp1 + "&cp2="+id2;
	}
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

