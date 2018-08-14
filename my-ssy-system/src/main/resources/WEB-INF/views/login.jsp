<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html lang="zh-cn">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>my Frame</title>
    <!-- Bootstrap -->
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" >

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>

    <!--<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>-->
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .col-center-block {
            float: none;
            display: block;
            margin-left: auto;
            margin-right: auto;
            margin-top: 200px;
            padding-top: 10px;
            padding-bottom: 10px;
            background-color: blanchedalmond;
        }
    </style>
</head>
<body>
<div class="page-wrapper container">
    <div class="col-center-block col-xs-6 col-md-4">
        <form>
            <div class="form-group">
                <label for="username">用户名</label>
                <input type="username" class="form-control" id="username" placeholder="Enter email、username">
            </div>
            <div class="form-group">
                <label for="password">密码</label>
                <input type="password" class="form-control" id="password" placeholder="Password">
            </div>
            <button type="submit" class="btn btn-default" onclick="login();">登录</button>
        </form>
    </div>
</div>
<script>
    function login() {
        debugger;
        var username = $("#username").val();
        var password = $("#password").val();
        $.ajax({
            url: "/frame/ajaxLogin",
            type: "POST",
            async: false,
            data : {
                "username" : username,
                "password" : password
            },
            success: function (data) {
                alert(data);
            },
            error: function (response, ajaxOptions, thrownError) {
                alert("error");
            }
        });
    }
</script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="static/module/scripts/jquery-1.10.1.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>