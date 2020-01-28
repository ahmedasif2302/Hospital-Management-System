<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta charset="utf-8">
  <title>Health+ | error</title>
  <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600' rel='stylesheet' type='text/css'>
  <style type="text/css">
    body {
      text-align: center;
      font-family: 'Source Sans Pro', 'Helvetica', 'Arial', sans-serif;
      color: #222;
      background: #fff;
    }
    img { margin: 30px 0 30px;}
    a { color: #705AB2; text-decoration: none;}
    h1 { color: #000; font-size: 48px; margin: 0;}
    p { color: #000; font-size: 18px; margin: 6px 0 0 0;}
  </style>
</head>
<body>
  <img src="${pageContext.request.contextPath}/images/error.png"/>
  <h1>Error!!</h1>
  <p>
    ${errorString }
  </p>
  <p style="margin-top:45px">
    <a href="${pageContext.request.contextPath}/home">&raquo; Go back to the main page</a>
  </p>
</body>
</html>