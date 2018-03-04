$(function() {
    var online_html = "<div class='met-online'><ul class='blocks hidebacktop'>";
    online_html+= '<li><a href="javascript:void(0);" class="btn btn-icon btn-info btn-squared" id="btn-meqia" onclick="_MEIQIA._SHOWPANEL()" target="_blank"><i class="fa fa-commenting" aria-hidden="true"></i></a></li>';
    online_html+= '<li><button type="button" class="btn btn-icon btn-info btn-squared feed-online" data-toggle="modal" data-target="#indexFeed" data-backdrop="false"><i class="icon fa-pencil" aria-hidden="true"></i></button></li>';
    online_html+= '<li><button type="button" class="btn btn-icon btn-info btn-squared met-scroll-top" onclick="goTop()"><i class="icon wb-chevron-up" aria-hidden="true"></i></button></li>';
    online_html+="</ul></div>";
    $('body').append(online_html);
    if (getUrlParam('demo') == 1) $('.met-online').addClass('hide');
    /*打开反馈关闭美恰*/
    $('.feed-online').click(function() {
        _MEIQIA('hidePanel');
    });
    $('#btn-meqia').click(function() {
        $('#indexFeed').modal('hide');
        pyRegisterCvt1();
    });
    /*售前售后咨询*/
    $('#btn-meqia').click(function() {
        $('#indexFeed').modal('hide');
        pyRegisterCvt1();
    });
    // pyRegisterCvt2();
    /*点击注册返回统计*/
    $('.met-nav .met-nav-login .btn-success').click(function() {
        pyRegisterCvt('metinfo' + nowTime());
    });
    /*返回顶部显示/隐藏*/
    var wh = $(window).height();
    $(window).scroll(function() {
        if ($(this).scrollTop() > wh) {
            $(".met-online .blocks").removeClass('hidebacktop');
        } else {
            $(".met-online .blocks").addClass('hidebacktop');
        }
    });
})
/*美洽客服*/
$(function() {
    (function(m, ei, q, i, a, j, s) {
        m[a] = m[a] || function() {
            (m[a].a = m[a].a || []).push(arguments)
        };
        j = ei.createElement(q),
            s = ei.getElementsByTagName(q)[0];
        j.async = true;
        j.src = i;
        s.parentNode.insertBefore(j, s)
    })(window, document, 'script', '//eco-api.meiqia.com/dist/meiqia.js', '_MEIQIA');
    // _MEIQIA('assign',{
    //     agentToken:'f2faae5e00a3e18c2fae05229ef94af2' // 只有我会起作用
    //     // groupToken:'客服组的 Token' // 我被抛弃了
    // });
    _MEIQIA('entId', 1715);
    _MEIQIA('withoutBtn', true);
    if ($("a.user_name").length) {
        var username = $("a.user_name").data('username'),
            meqia_code = $('input[name=meqia_code]').val();
        $.ajax({
            url: 'https://app.metinfo.cn/index.php?lang=cn&n=platform&c=meiqia&a=doinfo',
            type: 'GET',
            dataType: 'jsonp',
            data: {
                code: meqia_code
            },
            success: function(jsonlist) {
                var user_info = '';
                if (jsonlist.length) {
                    for (var i = 0; i < jsonlist.data.length; i++) {
                        user_info += '{' + jsonlist.data[i].type + '：' + jsonlist.data[i].domain + '，名称：' + jsonlist.data[i].with + '，价格：' + jsonlist.data[i].money + "}\n";
                    }
                }
                _MEIQIA('clientId', username);
                _MEIQIA('metadata', {
                    '用户名': username,
                    '消费记录': user_info,
                });
            }
        })
    }
    if (!$('.met-showproduct').length) _MEIQIA('getInviting', yourFunction); //禁止邀请
})

function yourFunction() {}
/*售前咨询*/
function pyRegisterCvt1() {
    var w = window,
        d = document,
        e = encodeURIComponent;
    var b = location.href,
        c = d.referrer,
        f, g = d.cookie,
        h = g.match(/(^|;)\s*ipycookie=([^;]*)/),
        i = g.match(/(^|;)\s*ipysession=([^;]*)/);
    if (w.parent != w) {
        f = b;
        b = c;
        c = f;
    };
    u = '//stats.ipinyou.com/cvt?a=' + e('5Kh.Ukh.Gzm9eAfOTHSD8L8SMow3Y0') + '&c=' + e(h ? h[2] : '') + '&s=' + e(i ? i[2].match(/jump\%3D(\d+)/)[1] : '') + '&u=' + e(b) + '&r=' + e(c) + '&rd=' + (new Date()).getTime() + '&e=';
    (new Image()).src = u;
}
/*售后咨询*/
function pyRegisterCvt2() {
    var w = window,
        d = document,
        e = encodeURIComponent;
    var b = location.href,
        c = d.referrer,
        f, g = d.cookie,
        h = g.match(/(^|;)\s*ipycookie=([^;]*)/),
        i = g.match(/(^|;)\s*ipysession=([^;]*)/);
    if (w.parent != w) {
        f = b;
        b = c;
        c = f;
    };
    u = '//stats.ipinyou.com/cvt?a=' + e('5Kh.ckh.hHvqkCfx1RLVtC4q3L1kl0') + '&c=' + e(h ? h[2] : '') + '&s=' + e(i ? i[2].match(/jump\%3D(\d+)/)[1] : '') + '&u=' + e(b) + '&r=' + e(c) + '&rd=' + (new Date()).getTime() + '&e=';
    (new Image()).src = u;
}
/*参数说明
_orderno：注册用户ID，需要替换为注册用户的ID值*/
function pyRegisterCvt(_orderno) {
    var w = window,
        d = document,
        e = encodeURIComponent;
    var b = location.href,
        c = d.referrer,
        f, g = d.cookie,
        h = g.match(/(^|;)\s*ipycookie=([^;]*)/),
        i = g.match(/(^|;)\s*ipysession=([^;]*)/);
    if (w.parent != w) {
        f = b;
        b = c;
        c = f;
    };
    u = '//stats.ipinyou.com/cvt?a=' + e('5Kh.1kh.trevdniVmRo5ujRXGrzrzP') + '&c=' + e(h ? h[2] : '') + '&s=' + e(i ? i[2].match(/jump\%3D(\d+)/)[1] : '') + '&u=' + e(b) + '&r=' + e(c) + '&rd=' + (new Date()).getTime() + '&OrderNo=' + e(_orderno) + '&e=';
    (new Image()).src = u;
}
/*获取当前时间*/
function nowTime() {
    function p(s) {
        return s < 10 ? '0' + s : s;
    }
    var myDate = new Date();
    //获取当前年
    var year = myDate.getFullYear();
    //获取当前月
    var month = myDate.getMonth() + 1;
    //获取当前日
    var date = myDate.getDate();
    var h = myDate.getHours(); //获取当前小时数(0-23)
    var m = myDate.getMinutes(); //获取当前分钟数(0-59)
    var s = myDate.getSeconds();
    var now = year + '-' + p(month) + "-" + p(date) + " " + p(h) + ':' + p(m) + ":" + p(s);
    return now;
}
/*返回顶部*/
function goTop() {
    $('html,body').animate({
        scrollTop: 0
    }, 500);
};
