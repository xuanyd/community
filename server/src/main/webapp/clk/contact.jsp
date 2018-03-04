<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>联系我们_河南省心电学诊疗中心</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="/clk/lib/css/css.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/clk/lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="/clk/lib/js/util.js"></script>
    <!--引用百度地图API-->
    <style type="text/css">
        html,body{margin:0;padding:0;}
        .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
        .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
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

            </ul>
        </div>
        <div class="tutu"><img src="/clk/lib/images/011_21.jpg" /></div>
    </div>
    <div class="news_r">
        <div class="news_con about_con">
            <h2 class="news_con_h2">联系我们</h2>
            <div class="sec_con" >
                <!--百度地图容器-->
                <div style="width:760px;height:400px;border:#ccc solid 1px;" id="dituContent"></div>
                <p></p>
                <div style="margin: 0px; padding: 0px; font-size: 14px; color: rgb(59, 59, 59); line-height: 30px;">
                    <div style="margin: 0px; padding: 0px; border: 0px; font-size: 13px; color: rgb(56, 56, 56); line-height: 26px; background-color: rgb(230, 237, 243);">
                        <p style="font-family: Arial; width: auto;">
                            <br />
                            <span style="font-size: 16px; line-height: 150%; text-align: justify; width: auto;"><strong style="WIDTH: auto"><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">&nbsp; &nbsp; &nbsp;河南省心电学诊疗中心：</span></strong></span><span style="font-size: 16px; line-height: 150%; text-align: justify; font-family: 仿宋_gb2312; width: auto;">郑州市金水区经八路</span><span style="font-size: 16px; line-height: 150%; text-align: justify; font-family: 'times new roman', serif; width: auto;">2</span><span style="font-size: 16px; line-height: 150%; text-align: justify; font-family: 仿宋_gb2312; width: auto;">号，郑州大学第二附属医院门诊楼</span><span style="font-size: 16px; line-height: 150%; text-align: justify; font-family: 'times new roman', serif; width: auto;">3</span><span style="font-size: 16px; line-height: 150%; text-align: justify; font-family: 仿宋_gb2312; width: auto;">楼心电图科</span></p>
                        <p style="font-family: Arial; width: auto; line-height: 150%;">
                            <span style="font-size:16px;"><span style="FONT-FAMILY: 宋体; WIDTH: auto"><span style="FONT-FAMILY: times new roman; WIDTH: auto"><strong style="WIDTH: auto"><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">&nbsp; &nbsp; &nbsp;电话：</span></strong></span><strong style="WIDTH: auto"><span style="FONT-FAMILY: times new roman; WIDTH: auto">0371-63974141</span></strong><strong style="WIDTH: auto"><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">，</span></strong><strong style="WIDTH: auto">0371-63974736 </strong></span></span></p>
                        <p style="font-family: Arial; width: auto; text-align: justify;">
                            <span style="font-size:16px;"><span style="FONT-FAMILY: 宋体; WIDTH: auto"><span style="width: auto;"><strong style="WIDTH: auto"><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">&nbsp; &nbsp; &nbsp;附近公交站点：</span></strong></span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">郑大二附院站（</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">63</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路）、纬一路经八路站（</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">21</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路，</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">32</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路，</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">205</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路）、新通桥站（</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">6</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">, 21</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">, 28</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">,32</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">, 34</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">, 63</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">, 78</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">支</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">, 93</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">, 95</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">, 105</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">南线</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">, 506</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">, 603</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">, 916</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路，</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">919</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路，</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">k6</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">, k806</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路</span><span style="FONT-FAMILY: times new roman,serif; WIDTH: auto">, k903</span><span style="FONT-FAMILY: 仿宋_gb2312; WIDTH: auto">路）</span></span></span></p>
                    </div>
                </div>
                <br />

            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
<jsp:include page="common/footer.jsp"></jsp:include>
</body>
<script language="javascript">
    var tips;
    var theTop = 100;
    var old = theTop;
    function initFloatTips()
    {
        tips = document.getElementById('divQQbox');
        moveTips();
    }
    function moveTips()
    {
        var tt=50;
        if (window.innerHeight)
        {
            pos = window.pageYOffset
        }else if (document.documentElement && document.documentElement.scrollTop) {
            pos = document.documentElement.scrollTop
        }else if (document.body) {
            pos = document.body.scrollTop;
        }
        pos=pos-tips.offsetTop+theTop;
        pos=tips.offsetTop+pos/10;
        if (pos < theTop){
            pos = theTop;
        }
        if (pos != old) {
            tips.style.top = pos+"px";
            tt=10; //alert(tips.style.top);
        }
        old = pos;
        setTimeout(moveTips,tt);
    }
    initFloatTips();
    if(typeof(HTMLElement)!="undefined") //firefox定义contains()方法，ie下不起作用
    {
        HTMLElement.prototype.contains=function (obj)
        {
            while(obj!=null&&typeof(obj.tagName)!="undefind"){
                if(obj==this) return true;
                obj=obj.parentNode;
            }
            return false;
        }
    }


</script>
<!--kefu--end-->
</body>
<script type="text/javascript">
    //创建和初始化地图函数：
    function initMap(){
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
        addMarker();//向地图中添加marker
    }

    //创建地图函数：
    function createMap(){
        var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
        var point = new BMap.Point(113.676812,34.772408);//定义一个中心点坐标
        map.centerAndZoom(point,17);//设定地图的中心点和坐标并将地图显示在地图容器中
        window.map = map;//将map变量存储在全局
    }

    //地图事件设置函数：
    function setMapEvent(){
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
    }

    //地图控件添加函数：
    function addMapControl(){
        //向地图中添加缩放控件
        var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
        map.addControl(ctrl_nav);
        //向地图中添加缩略图控件
        var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
        map.addControl(ctrl_ove);
        //向地图中添加比例尺控件
        var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
        map.addControl(ctrl_sca);
    }

    //标注点数组
    var markerArr = [{title:"郑州大学第二附属医院",content:"郑州大学第二附属医院",point:"113.676462|34.772363",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
    ];
    //创建marker
    function addMarker(){
        for(var i=0;i<markerArr.length;i++){
            var json = markerArr[i];
            var p0 = json.point.split("|")[0];
            var p1 = json.point.split("|")[1];
            var point = new BMap.Point(p0,p1);
            var iconImg = createIcon(json.icon);
            var marker = new BMap.Marker(point,{icon:iconImg});
            var iw = createInfoWindow(i);
            var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
            marker.setLabel(label);
            map.addOverlay(marker);
            label.setStyle({
                borderColor:"#808080",
                color:"#333",
                cursor:"pointer"
            });

            (function(){
                var index = i;
                var _iw = createInfoWindow(i);
                var _marker = marker;
                _marker.addEventListener("click",function(){
                    this.openInfoWindow(_iw);
                });
                _iw.addEventListener("open",function(){
                    _marker.getLabel().hide();
                })
                _iw.addEventListener("close",function(){
                    _marker.getLabel().show();
                })
                label.addEventListener("click",function(){
                    _marker.openInfoWindow(_iw);
                })
                if(!!json.isOpen){
                    label.hide();
                    _marker.openInfoWindow(_iw);
                }
            })()
        }
    }
    //创建InfoWindow
    function createInfoWindow(i){
        var json = markerArr[i];
        var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>"+json.content+"</div>");
        return iw;
    }
    //创建一个Icon
    function createIcon(json){
        var icon = new BMap.Icon("http://app.baidu.com/map/images/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
        return icon;
    }
    initMap();//创建和初始化地图
</script>
</html>
