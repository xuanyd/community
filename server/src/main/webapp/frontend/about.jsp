<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>中心简介_河南省心电学诊疗中心</title>
    <link href="frontend/lib/css/css.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="frontend/lib/js/jquery.min.js"></script>
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

</body>
</html>
