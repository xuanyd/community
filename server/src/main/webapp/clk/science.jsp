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
    <title>学术动态  /  继续教育_河南省心电学诊疗中心</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="clk/lib/css/css.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="clk/lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="clk/lib/js/pagenav.cn.js"></script>
    <script>
        var currentPage = ${pageInfo.currentPage};
        var totalPage = ${pageInfo.totalPage};
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
            initPage(currentPage,totalPage);
        });
        function initPage(p,pn){
            pageNav.pre="&lt;上一页";
            pageNav.next="下一页&gt;";
            pageNav.fn = function(p,pn){$("#pageinfo").text("当前页:"+p+" 总页: "+pn);};
            pageNav.go( p,pn);
        }
        function refeshPage(page){
            if(page == currentPage){
                return;
            }
            window.location.href="communicate.html?page="+page;
        }
    </script>
<body>
<jsp:include page="common/header.jsp"></jsp:include>
<div class="news">
    <div class="news_l float">
        <div class="new">
            <h2><img src="clk/lib/images/011_06.jpg" /></h2>
            <ul>
                <li><a href='/xdxzs/'>心电学之声</a></li>
                <li><a href="/jiaoyu/" class='left_current'>继续教育</a></li>
            </ul>
        </div>
        <div class="tutu">
            <a href="http://search.hnsxdx.cn/search/" target="_blank">
                <img src="clk/lib/images/011_21.jpg" />
            </a>
        </div>
    </div>
    <div class="news_r">
        <div class="news_con">
            <h2 class="news_con_h2">继续教育</h2>
            <div class="">
                <ul class="sec_news_ul">
                    <c:if test="${pageInfo.infoList!= null && fn:length(pageInfo.infoList) != 0}">
                        <c:forEach var="communicate" items="${pageInfo.infoList}" varStatus="st">
                            <li>
                                <h3>
                                    <a href="communicate-detail.html?id=${communicate.id}" >${communicate.title}</a>
                                    <i>2016-06-15 09:32:26</i>
                                </h3>
                                <p>${communicate.sub_title}...</p>
                                <a href="communicate-detail.html?id=${communicate.id}"class="a_more">查看详情</a>
                            </li>
                        </c:forEach>
                    </c:if>
                </ul>
                <div id="pageNav" class="dede_pages"></div>
            </div>
        </div>
    </div>
    <jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
