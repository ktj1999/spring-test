<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> <!-- jstl확장태그를 위한 선언  -->

<!DOCTYPE html>
<html>
<head>
  	<meta charset="utf-8">
	<link href="${path}/resources/css/loginstyle.css" rel="stylesheet"/>
	<style>
		.login-box{
			width:300px;
        	height:300px;
		}
		.error { 
			color: red; 
			margin: 5px; 
		}
	</style>
</head>
<body>
  <h3>${ message }</h3>
  <h3><fmt:formatDate pattern = "yyyy-MM-dd HH:mm:ss" value = "${ now }"/></h3> <!-- 날짜와 시각 표현을 위한 jstl문  -->
  <form method="POST">
  		<div class = "login-box">
            <div class="input-box">
                <label for="username">아이디</label>
                <input id="userid" type="text" name="userid" placeholder="아이디" value="${ userid }">
            </div>

            <div class="input-box">
                <label for="password">비밀번호</label>
                <input id="passwd" type="password" name="passwd" placeholder="비밀번호" value="${ password }">
            </div>
            <div id="forgot">비밀번호 찾기</div>
            <div id="autologin"><input type="checkbox" name="autologin" value="${ autologin }"/>자동 로그인</div>
            <input type="submit" value="로그인" value="${ login }">
            <input type="submit" value="회원가입" value="${ register }">
            <div class="error">${ errorMsg }</div>
       </div>
</form>
</body>
</html>