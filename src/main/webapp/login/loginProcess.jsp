<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.login.dao.LoginDao" %>
<%@ page import="com.login.dto.LoginDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인 체킹</h2>
	<c:set var="id" value="${param.user_id}" />
	<c:set var="pass" value="${param.user_pw}" />
	
	<c:set var="dao" value="${new LoginDao()}" />
	<c:set var="dto" value="${dao.login(id, pw)}" />
	<c:set var="userId" value="${id}" />
	
	<c:choose>
	    <c:when test="${not empty dto}">
	        <!-- 로그인 성공 -->
	        <c:set var="loginDto" value="${dto}" />
	        <c:set var="userId" value="${id}" />
	        <c:set var="sessionScope.memberDto" value="${loginDto}" />
	        <c:set var="sessionScope.userId" value="${userId}" />
	        <c:redirect url="../book/bookMain.jsp" />
	    </c:when>
	    <c:otherwise>
	        <!-- 로그인 실패 -->
	        <c:redirect url="loginForm.jsp?isError=1" />
	    </c:otherwise>
	</c:choose>

</body>
</html>