<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>视频专区_河南省心电学诊疗中心</title>
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
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>
<div class="news">
    <div class="news_l float">
        <div class="new">
            <h2><img src="/clk/lib/images/011_06.jpg" /></h2>
            <ul>
            </ul>
        </div>
        <div class="tutu">
            <a href="http://search.hnsxdx.cn/search/" target="_blank">
                <img src="/clk/lib/images/011_21.jpg" /></a>
            <a/>
        </div>
    </div>
    <div class="news_r">
        <div class="news_con">
            <h2 class="news_con_h2">视频专区</h2>
            <div class="">
                <!--right--con--start-->
                <ul class="sec_news_ul">
                    <li>
                        <h3>
                            <a href="/shipin/2016/0711/2086.html" title="2016年6月18日全球心电图查询系统新闻发布会—胡大一教授贺辞">
                                2016年6月18日全球心电图查询系统新闻发布会—胡大一教授贺辞
                            </a>
                            <i>2016-07-11 18:41:04</i>
                        </h3>
                        <p>...</p>
                        <a href="/shipin/2016/0711/2086.html" title="2016年6月18日全球心电图查询系统新闻发布会—胡大一教授贺辞" class="a_more">
                            查看详情
                        </a>
                    </li>
                    <li>
                        <h3>
                            <a href="/shipin/2016/0505/1923.html" title="“文明号”健康行">“文明号”健康行</a>
                            <i>2016-05-05 17:54:49</i>
                        </h3>
                        <p>...</p>
                        <a href="/shipin/2016/0505/1923.html" title="“文明号”健康行" class="a_more">
                            查看详情
                        </a>
                    </li>
                    <li>
                        <h3>
                            <a href="/shipin/2015/0618/293.html" title="郑大二附院心电图科进展">郑大二附院心电图科进展</a>
                            <i>2015-06-18 17:10:31</i>
                        </h3>
                    <p>郑大二附院心电图科进展...</p>
                    <a href="/shipin/2015/0618/293.html" title="郑大二附院心电图科进展" class="a_more">
                        查看详情</a>
                    </li>
                </ul>
                <!--list-page--start-->
                <div class="dede_pages"><li><span class="pageinfo">共 <strong>1</strong>页<strong>3</strong>条记录</span></li>
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
