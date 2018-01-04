
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>

<%!
String getFormattedDate()
{
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
    return sdf.format(new Date());
}
%>
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Добро пожаловать, JSP!</title>
  </head>
  <body>
       <h1>Добро пожаловать!</h1>
       <i>Сегодня <%= getFormattedDate() %></i>


       <div id="result">Тут будет ответ от сервера</div><br /><br />
       <div onclick="SendGet();">Отправить GET запрос через Ajax</div><br />
       <div onclick="SendPost();">Отправить POST запрос через Ajax</div><br />
       <div onclick="SendHead();">Отправить HEAD запрос через Ajax</div><br />


  </body>
</html>

