<!DOCTYPE html>
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
							<span class="blue bolder">山东大学</span>
							ING工作室 &copy; 2017-2022
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
        var child = menu.child;
        var menuReturn = '';

        if (child.length != 0 && child != undefined && child != null) {
            var childStr = '';
            for (var tmp of child) {
                childStr += makeMenu(tmp);
            }
            var active = 'active open';


            var menuReturn = '<li class="'+(menu.active?active:"")+'">\
                <a href="#" class="dropdown-toggle">\
                <i class="' + menu.menuIcon + '"></i>\
                <span class="menu-text"> ' + menu.name + ' </span>\
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
            menuReturn = '<li class="'+(menu.active?active:"")+'">\
                <a href="#" class="dropdown-toggle">\
                <i class="' + menu.menuIcon + '"></i>\
                <span class="menu-text"> ' + menu.name + ' </span>\
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
        for (let ttt = breadCrumb;; ttt = ttt.child) {
            if(ttt.child == null || ttt.child == undefined)
                break;
            //TODO viewId
            if(ttt.id == 1){
                result = result+'<li class = "active">\
            <a href="#">'+ttt.name+'</a>\
            </li>';
            }
        else{
                result = result+'<li>\
            <a href="#">'+ttt.name+'</a>\
            </li>';
            }

        }
        result = result + '</ul><!-- /.breadcrumb -->';
        return result;
    }

    $(document).ready(function () {
        $.ajax({
            type: "get",
            data: {},
            //TODO 
            url: "",
            success: function (data) {
                var viewResult = eval('(' + data + ')');
                var menuResult = viewResult.menuResult;
                var breadResult = viewResult.breadCrumb;
                var menuStr = '';
                var breadStr = '';
                for (var tmp of menuResult) {
                    menuStr += makeMenu(tmp);
                }
                breadStr = makeBreadCrumb(breadResult);

                console.log(breadResult)

                $('#breadcrumbs').append(breadStr);
                $("#navList").append(menuStr);
            }
        })
    })
</script>
</body>
</html>
