
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="ru"> <!--<![endif]-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="com.testHotel.controller.IHotelController" %>
<%@ page import="com.dependencyService.DependencyService" %>
<%@ page import="com.entity.Guest" %>
<%@ page import="com.dao.IRoomDAO" %>
<%@ page import="com.serverQueryService.ClientQueryService.ClientQueryService" %>

<head>

    <meta charset="utf-8">

    <title>Заголовок</title>
    <meta name="description" content="">

    <link rel="shortcut icon" href="img/favicon/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="img/favicon/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="img/favicon/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="img/favicon/apple-touch-icon-114x114.png">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link rel="stylesheet" href="libs/bootstrap/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="libs/animate/animate.css">

    <link rel="stylesheet" href="css/fonts.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/media.css">

    <script src="libs/modernizr/modernizr.js"></script>

</head>

<body>


    <%

        Object response1=ClientQueryService.queryHandler("{\"someMethod\":\"addRoom\",\"allParamList\":[{\"type\":\"room\",\"id\":12,\"number\":22,\"cost\":33,\"capacity\":123,\"stars\":55,\"status\":\"FREE\"}]}");
    %>
    Hello, world !

    <h1>Добро пожаловать!<%= response1%></h1>









    <div>
        <form class="auth-forms">
            <div id="auth-info"></div>
            <input type="text" placeholder="Логин" id="login"/>
            <br/>
            <input type="password" placeholder="Пароль" id="password"/>
            <br/>
        </form>
        <br/>
        <button id="button">Вход</button>
    </div>


















<div class="hidden"></div>

<div class="loader">
    <div class="loader_inner">
    </div>
</div>

<!--[if lt IE 9]>
<script src="libs/html5shiv/es5-shim.min.js"></script>
<script src="libs/html5shiv/html5shiv.min.js"></script>
<script src="libs/html5shiv/html5shiv-printshiv.min.js"></script>
<script src="libs/respond/respond.min.js"></script>
<![endif]-->

<script src="libs/jquery/jquery-1.11.2.min.js"></script>
<script src="libs/waypoints/waypoints.min.js"></script>
<script src="libs/animate/animate-css.js"></script>
<script src="libs/plugins-scroll/plugins-scroll.js"></script>
<script src="js/common.js"></script>

</body>
</html>







