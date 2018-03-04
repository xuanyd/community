<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>${title}</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="clk/lib/css/css.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="clk/lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="clk/lib/js/pagenav.cn.js"></script>
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
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>
<div class="news">
    <div class="news_l float">
        <div class="new">
            <h2><img src="clk/lib/images/011_06.jpg" /></h2>
            <ul>
                <li><a href="/zhuanjia/">专家简介</a></li>
                <li><a href='/linchuang/' class='left_current'>心电检查介绍</a></li>
                <li><a href="/en/">英文简介</a></li>
            </ul>
        </div>
        <div class="tutu">
            <a href="http://search.hnsxdx.cn/search/" target="_blank">
                <img src="clk/lib/images/011_21.jpg" /></a>
        </div>
    </div>
    <div class="news_r">
        <div class="news_con">
            <h2 class="news_con_h2">心电检查介绍</h2>
            <div class="sec_con">
                <div class="collb">
                    <div class="collb_l">
                        <h1>${title } </h1>
                        <div class="collb_la">
                            ${content }
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
