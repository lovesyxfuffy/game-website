<!DOCTYPE html>
<#setting number_format="#">
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>
    <@block name="title"></@block>
    </title>

    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/font-awesome/4.5.0/css/font-awesome.min.css"/>

    <!-- page specific plugin styles -->
<@block name="specificCSS"></@block>

    <!-- text fonts -->
    <link rel="stylesheet" href="/assets/css/fonts.googleapis.com.css"/>

    <!-- ace styles -->
    <link rel="stylesheet" href="/assets/css/ace.min.css" class="ace-main-stylesheet"
          id="main-ace-style"/>

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="/assets/css/ace-part2.min.css" class="ace-main-stylesheet"/>
    <![endif]-->
    <link rel="stylesheet" href="/assets/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="/assets/css/ace-rtl.min.css"/>

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="/assets/css/ace-ie.min.css"/>
    <![endif]-->

    <!-- inline styles related to this page -->
<@block name="inlineCSS"></@block>

    <!-- ace settings handler -->
    <script src="/assets/js/ace-extra.min.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="/assets/js/html5shiv.min.js"></script>
    <script src="/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="no-skin">
<div id="navbar" class="navbar navbar-default          ace-save-state">
<#include "components/navbar.ftl">
    <!-- /.navbar-container -->
</div>

<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.loadState('main-container')
        } catch (e) {
        }
    </script>

<#include "components/slidebar.ftl">

    <div class="main-content">
        <div class="main-content-inner">
        <#include "components/breadcrumb.ftl">

            <div class="page-content">

                <div class="page-header">
                    <h1>
                    <@block name="pageHeader"></@block>
                    </h1>
                </div><!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                    <@block name="contents"></@block>
                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->

    <div class="footer">
        <div class="footer-inner">
            <div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Cat</span>
							Studio &copy; 2017-
						</span>

                &nbsp; &nbsp;
            </div>
        </div>
    </div>

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->
<script src="/assets/js/jquery-2.1.4.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="/assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
<script type="text/javascript">
    if ('ontouchstart' in document.documentElement) document.write("<script src='/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->
<@block name="specificPluginJS"></@block>
<!-- ace scripts -->
<script src="/assets/js/ace-elements.min.js"></script>
<script src="/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->
<@block name="specificInlineJS"></@block>

<script>

    function makeMenu(menu) {
        var child = menu.children;
        var menuReturn = '';
        console.log(menu)

        if (child != undefined && child != null && child.length != 0) {
            var childStr = '';
            for (var tmp of child) {
                childStr += makeMenu(tmp);
            }
            var active = 'active open';

            var menuReturn = '<li class="' + (menu.active ? active : "") + '">\
                <a href="' + (menu.menuUrl == null ? "#" : menu.menuUrl) + '" class="dropdown-toggle" onclick="changeUrl(\'' + (menu.menuUrl == null ? "#" : menu.menuUrl) + '\')">\
                <i class="' + menu.menuIcon + '"></i>\
                <span class="menu-text"> ' + menu.menuName + ' </span>\
\
                <b class="arrow fa fa-angle-down"></b>\
                </a>\
\
                <b class="arrow"></b>\
\
                <ul class="submenu">\
                ' + childStr + '\
                </ul>\
                </li>'
        } else {
            active = 'active';
            menuReturn = '<li class="' + (menu.active ? active : "") + '">\
                <a href="' + (menu.menuUrl == null ? "#" : menu.menuUrl) + '" class="dropdown-toggle" onclick="changeUrl(\'' + (menu.menuUrl == null ? "#" : menu.menuUrl) + '\')">\
                <i class="' + menu.menuIcon + '"></i>\
                <span class="menu-text"> ' + menu.menuName + ' </span>\
\
                </a>\
\
                <b class="arrow"></b>\
\
                </li>'
        }
        return menuReturn;

    }

    function makeBreadCrumb(breadCrumb) {
        var result = '<ul class="breadcrumb">';
        for (let ttt = breadCrumb; ; ttt = ttt.child) {
            if (ttt == null || ttt == undefined)
                break;
            if (ttt.url != null && ttt.url != undefined) {
                result = result + '<li class = "active">\
            <a href="#">' + ttt.name + '</a>\
            </li>';
            }
            else {
                result = result + '<li>\
            <a href="#">' + ttt.name + '</a>\
            </li>';
            }

        }
        result = result + '</ul><!-- /.breadcrumb -->';
        return result;
    }
    function changeUrl(url) {
        if (url != undefined && url != null)
            window.location.href = url
    }
    $(document).ready(function () {
        $.ajax({
            type: "post",
            data: {
                requestURI: "${requestURI}"
            },
            //TODO 
            url: "/api/system/getMenu",
            success: function (data) {
                var viewResult = data.data;
                var menuResult = viewResult.menuResult;
                var breadResult = viewResult.breadCrumb;
                var menuStr = '';
                var breadStr = '';
                for (var tmp of menuResult) {
                    menuStr += makeMenu(tmp);
                }
                breadStr = makeBreadCrumb(breadResult);
                $('#breadcrumbs').append(breadStr);
                $("#navList").append(menuStr);
            }
        })
    })
</script>
<script>
    function logout() {
        $.ajax({
            type: "post",
            url: "/api/system/logout",
            data: {},
            success: function () {
                alert("登出成功")
                window.location.href = "/api/views/login"
            }
        })
    }
</script>
</body>
</html>
