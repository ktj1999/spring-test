<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> <!-- jstl확장태그를 위한 선언  -->
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
</head>
<body>
  <h3>${ message }</h3>
  <h3><fmt:formatDate pattern = "yyyy-MM-dd HH:mm:ss" value = "${ now }"/></h3> <!-- 날짜와 시각 표현을 위한 jstl문  -->
  <h3>ID: ${ userid }</h3>
  <h3>PWD: ${ password }</h3>
  <h3>AutoLogin: ${ autologin ? "checked" : "unchecked" }</h3>
</body>
</html>