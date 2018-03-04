<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>中心简介  /  专家简介_河南省心电学诊疗中心</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<link href="clk/lib/css/css.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="clk/lib/js/jquery.min.js"></script>
	<script>
        $(document).ready(function(){
            var screen_width = window.screen.width;
            var body_width = window.document.body.clientWidth;

            if(body_width <= 1280){
                if(screen_width <= 1280){
                    $('body').css('width','1280px');
                }else{
                    $('body').css('width',screen_width);
                }

            }else {
                $('body').css('width',screen_width-20);
            }
        });
	</script>
	<body>
		<jsp:include page="common/header.jsp"></jsp:include>
		<div class="special_con">
			<h2 class="news_con_h2">专家简介</h2>
			<ul class="special_ul">
				<c:if test="${expertList!= null && fn:length(expertList) != 0}">
					<c:forEach var="expert" items="${expertList}" varStatus="st">
						<li>
							<a href="expert-detail.html?id=${expert.id}" title="${expert.title}" class="special_img">
								<img src="/uploads/160115/1-1601151P251120.jpg">
							</a>
							<div class="special_div">
								<h3>
									<a href="/zhuanjia/1937.html" >
										${expert.title}
									</a>
								</h3>
								<p>${expert.sub_title}...</p>
								<div class="bottom">
									<font>浏览量：191</font>
									<a href="expert-detail.html?id=${expert.id}">更多详细>></a>
								</div>
							</div>
						</li>
					</c:forEach>
				</c:if>
			</ul>
		</div>
		<jsp:include page="common/footer.jsp"></jsp:include>
	</body>
</html>