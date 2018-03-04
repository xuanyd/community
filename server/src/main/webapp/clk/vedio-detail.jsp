<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>“文明号”健康行_河南省心电学诊疗中心</title>
    <meta name="keywords" content="“,文明号,”,健康,行," />
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
</head>
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
                <h2 class="news_con_h2">视频专区</h2>
                <div class="sec_con">
                    <!--right--con--start-->
                    <!--article--news--start-->

                    <div class="collb">
                        <div class="collb_l">
                            <h1>“文明号”健康行</h1>
                            <div class="collb_la">
                                <p> <span>文章出处：未知  │  网站编辑：心电诊疗所 │  发表时间：2016-05-05</span> </p>
                            </div>
                            <div class="collb_lb"> <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" height="480" width="600"><param name="quality" value="high" /><param name="movie" value="/uploads/media/2016.4.25.swf" /><embed height="480" pluginspage="http://www.macromedia.com/go/getflashplayer" quality="high" src="/uploads/media/2016.4.25.swf" type="application/x-shockwave-flash" width="600"></embed></object> </div>
                            <div class="collb_lc">
                                <!-- Baidu Button BEGIN -->
                                <div class="bdsharebuttonbox"></div>
                                <!-- Baidu Button END -->
                            </div>
                            <div class="collb_ld">
                                <div>上一篇：<a href='/shipin/2015/0618/293.html'>郑大二附院心电图科进展</a> </div>
                                <div>下一篇：<a href='/shipin/2016/0711/2086.html'>2016年6月18日全球心电图查询系统新闻发布会—胡大一教授贺辞</a> </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
    <jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
