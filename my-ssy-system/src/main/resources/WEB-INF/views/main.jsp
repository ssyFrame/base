<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>
<head>

    <title>Bootstrap布局</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet" media="screen">
    <style>
        body{
            margin:0;
            padding:0;
            font-family: Lato,Helvetica,Arial,sans-serif;
            font-size: 14px;
            line-height: 1.72222;
            color: #34495e;
            background-color: #fff;
        }
        .wrap {
            min-width: 100%;
            position: absolute;
            background: #eff3f6 bottom;
            min-height: 100%;
            overflow: hidden;
        }
        .left{
            margin-left:0px;
            position: absolute;
            box-sizing: border-box;
            width: 200px;
            height: 100%;
            background: #4d5e70 bottom;
        }
        .logoDiv{
            padding-top: 20px;
            padding-bottom: 20px;
            height: 70px;
            background-color: #354457;
            font-size: 17px;
            color: #fff;
            vertical-align: bottom;
        }
        .logoTitle{
            margin-left:15px;
            line-height: 1.7;
        }
        .menu-title {
            margin-left:15px;
            color: #828e9a;
            padding-top: 10px;
            padding-bottom: 10px;
            font-size: 14px;
            font-weight: bold;
        }
        .menu-item {
            padding-left:15px;
            line-height: 40px;
            height: 40px;
            color: #aab1b7;
            cursor: pointer;
        }
        .menu-item-active {
            background-color: #3d4e60;
            border-right: 4px solid #647f9d;
            color: #fff;
        }
        .right{
            box-sizing: border-box;
            float: left;
            box-sizing: border-box;
            padding-left: 200px;
            overflow-y: overlay;
            overflow-x: hidden;
            clear: both;
            color: #717592;
            min-width: 100%;
            min-height: 500px;
        }
    </style>
</head>
<body>
<div class="wrap">
    <!-- 左边内容 -->
    <div id="left" class="left">
        <div id="logoDiv" class="logoDiv">
            <p id="logoTitle" class="logoTitle">
                <img id="logo" alt="左右布局" src="http://tool.what21.com/page/image/menu/cf.png"
                     style="height: 28px; padding-right: 5px;vertical-align: middle;">
                <span style="font-size:18px;">左右布局</span>
            </p>
        </div>
        <div class="menu-title">菜单管理一</div>
        <div class="menu-item" href="#one" data-toggle="tab">
            －用户管理
        </div>
        <div class="menu-item" href="#two" data-toggle="tab">
            －权限管理
        </div>
        <div class="menu-title">菜单管理二</div>
        <div class="menu-item" href="#three" data-toggle="tab">
            －用户管理
        </div>
        <div class="menu-item" href="#four" data-toggle="tab">
            －权限管理
        </div>
    </div>
    <!-- 右边内容 -->
    <div id="right" class="tab-content right">
        <div id="one" class="tab-pane active">
							 <span style="margin-left:40px;text-shadow: 2px 0px 6px rgba(94, 35, 255, 0.91);">
							 		内容一
							</span>
        </div>
        <div id="two" class="tab-pane">
							 <span style="margin-left:40px;text-shadow: 2px 0px 6px rgba(94, 35, 255, 0.91);">
							 		内容二
							</span>
        </div>
        <div id="three" class="tab-pane">
							 <span style="margin-left:40px;text-shadow: 2px 0px 6px rgba(94, 35, 255, 0.91);">
							 		内容三
							</span>
        </div>
        <div id="four" class="tab-pane">
            <iframe id="fourIfm" frameborder="no" border="0" style="width:100%;"
                    src="http://www.what21.com/" scrolling="no" onload="changeFrameHeight()">
            </iframe>
        </div>
    </div>
</div>
<script src="http://code.jquery.com/jquery.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
<script>
    $(function() {
        $(".menu-item").click(function() {
            $(".menu-item").removeClass("menu-item-active");
            $(this).addClass("menu-item-active");
            var itmeObj = $(".menu-item").find("img");
            itmeObj.each(function() {
                var items = $(this).attr("src");
                items = items.replace("_grey.png", ".png");
                items = items.replace(".png", "_grey.png")
                $(this).attr("src", items);
            });
            var attrObj = $(this).find("img").attr("src");;
            attrObj = attrObj.replace("_grey.png", ".png");
            $(this).find("img").attr("src", attrObj);
        });
    });
    function changeFrameHeight(){
        var ifm=document.getElementById("fourIfm");
        ifm.height = document.documentElement.clientHeight;
    }
    window.onresize=function(){
        changeFrameHeight();
    }
</script>
</html>