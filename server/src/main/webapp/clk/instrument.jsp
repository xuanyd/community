<%--
  Created by IntelliJ IDEA.
  User: xuan
  Date: 2018/1/20
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>仪器进展_河南省心电学诊疗中心</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="/clk/lib/css/css.css" rel="stylesheet" type="text/css" />
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
<body>
<jsp:include page="common/header.jsp"></jsp:include>
<div class="news">
    <div class="news_l float">
        <div class="new">
            <h2><img src="/skin/images/011_06.jpg" /></h2>
            <ul>

            </ul>
        </div>
        <div class="tutu"><a href="http://search.hnsxdx.cn/search/" target="_blank"><img src="/skin/images/011_21.jpg" /><a/></div>
    </div>
    <div class="news_r">
        <div class="news_con">
            <h2 class="news_con_h2">仪器进展</h2>
            <div class="">
                <!--right--con--start-->
                <ul class="sec_news_ul">
                    <li><h3><a href="/jinzhan/2753.html" title="澳特科心血管功能检测仪">澳特科心血管功能检测仪</a><i>2017-08-22 12:20:01</i></h3>
                        <p>澳特科心血管功能检测仪...</p>
                        <a href="/jinzhan/2753.html" title="澳特科心血管功能检测仪" class="a_more">查看详情</a> </li><li><h3><a href="/jinzhan/2743.html" title="杭州高联仪器新进展">杭州高联仪器新进展</a><i>2017-08-11 13:06:38</i></h3>
                    <p>杭州高联仪器新进展...</p>
                    <a href="/jinzhan/2743.html" title="杭州高联仪器新进展" class="a_more">查看详情</a> </li><li><h3><a href="/jinzhan/2746.html" title="深圳博英公司仪器进展">深圳博英公司仪器进展</a><i>2017-08-11 12:55:42</i></h3>
                    <p>深圳博英公司仪器进展...</p>
                    <a href="/jinzhan/2746.html" title="深圳博英公司仪器进展" class="a_more">查看详情</a> </li><li><h3><a href="/jinzhan/2745.html" title="武汉中旗公司仪器进展">武汉中旗公司仪器进展</a><i>2017-08-11 01:48:22</i></h3>
                    <p>武汉中旗公司仪器进展...</p>
                    <a href="/jinzhan/2745.html" title="武汉中旗公司仪器进展" class="a_more">查看详情</a> </li><li><h3><a href="/jinzhan/2744.html" title="交大辰方公司仪器进展">交大辰方公司仪器进展</a><i>2017-08-11 01:47:39</i></h3>
                    <p>交大辰方公司仪器进展...</p>
                    <a href="/jinzhan/2744.html" title="交大辰方公司仪器进展" class="a_more">查看详情</a> </li>
                </ul>
                <!--list-page--start-->
                <div class="dede_pages"><li><a>首页</a></li>
                    <li class="thisclass">1</li>
                    <li><a href='list_5_2.html'>2</a></li>
                    <li><a href='list_5_3.html'>3</a></li>
                    <li><a href='list_5_2.html'>下一页</a></li>
                    <li><a href='list_5_3.html'>末页</a></li>
                </div>
                <!--list-page--end-->
                <!--right--con--end-->
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
</div>
<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
