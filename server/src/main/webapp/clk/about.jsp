<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>中心简介_河南省心电学诊疗中心</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="clk/lib/css/css.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/clk/lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="/clk/lib/js/util.js"></script>
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
                <h2><img src="/clk/lib/images/19.jpg" /> </h2>
                <ul>

                    <li><a href="/zhuanjia/">专家简介</a></li>

                    <li><a href="/linchuang/">心电检查介绍</a></li>

                    <li><a href="/en/">英文简介</a></li>

                </ul>
            </div>
            <div class="tutu">
                <a href="http://search.hnsxdx.cn/search/" target="_blank">
                    <img src="/clk/lib/images/011_21.jpg" /><a/>
            </div>
        </div>
        <div class="news_r">
            <div class="news_con about_con">
                <h2 class="news_con_h2">${title }</h2>
                <div class="sec_con" >
                    ${content }
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
