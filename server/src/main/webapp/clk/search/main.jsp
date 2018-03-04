<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html lang="zh-CN">
	<head>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="clk/search/css/reset.css">
		<link rel="stylesheet" type="text/css" href="clk/search/css/member.css">
		<title>心电图信息查看</title>
	</head>
	<body>

	<div class="nav-bar">
		<div class="container">
			<div class="bar-logo"><img src="clk/search/img/20151203img1.png" width="333" height="72" alt=""/></div>
			<div class="bar-right">
				欢迎您：${sessionScope.loginInfo.name }<i></i><a href="toModifyPwd">修改密码</a><i></i><a href="logOut">退出</a>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="h-title mtop20">
			<h4>心电图信息查看</h4>
		</div>
		<div class="h-msg mtop20">
			<a href="ptoCheckInfoList" class="a-link">综合诊断及建议</a>
			<span class="h-txt" style="margin-left:30px">姓名：</span><span class="h-txt2 mright50">${sessionScope.loginInfo.name }</span>
			<span class="h-txt" style="margin-left:30px">性别：</span><span class="h-txt2 mright50">${sessionScope.loginInfo.sex }</span>
			<!-- <span class="h-txt">身份证号：</span><span class="h-txt2">${sessionScope.loginInfo.cardId }</span>  -->
		</div>
		<div class="h-table mtop20">
			<c:if test="${pageInfo.infoList!= null && fn:length(pageInfo.infoList) != 0}">
				<table>
					<tbody>
						<tr>
							<th width="20%">编号</th>
							<th width="20%">姓名</th>
							<th width="20%">检查时间</th>
							<th width="40%">操作</th>
						</tr>
						<c:forEach var="card" items="${pageInfo.infoList}" varStatus="st">
						<tr>
							<td>${st.count}</td>
							<td>${card.patient_name}</td>
							<td>${card.report_date_time}</td>
							<td>
								<a href="seeCardInfo?id=${card.id}" class="a-link2" 
									<c:if test="${card.check_state=='1'}">
									style="margin-left: -50px;"
									</c:if>
									<c:if test="${card.check_state!='1'}">
										<c:if test="${card.first!='1'}">
										style="margin-left: -76px;"
										</c:if>
										<c:if test="${card.first=='1'}">
										style="margin-left: -1px;"
										</c:if>
									</c:if>
								>查看</a>
								<!-- <a href="downloadPdf?id=${card.id}" class="a-link3">下载</a> -->
								<c:if test="${card.first==1 && pageInfo.currentPage == 1}">
									<a id="show_record_${card.id}" href="javascript:;" class="a-link2"  onclick="checkCompare(${card.id})">对比
									</a>
								</c:if>
								<c:if test="${st.count!=1}">
									<c:if test="${card.check_state=='1'}">
										<i class="h-i-img"></i>
									</c:if>
								</c:if>
							</td>
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
<script src="clk/search/js/jquery.min.1.8.1.js"></script>
<script src="clk/search/js/layer/layer.js"></script>
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
		layer.close();
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
