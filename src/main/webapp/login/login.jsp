<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인 화면</h2>
<c:set var="isError" value="${param.isError}" />
<c:if test="${not empty isError and isError eq '1'}">
    <c:out value="아이디 비밀번호를 확인해주세요" />
</c:if>
<form action="loginProcess.jsp" method="post" name="loginFrm">
	아이디   : <input type="text" name="user_id" required="required">
	<br>
	비밀번호 : <input type="password" name="user_pw" required="required">
	<br>
	<input type="submit" value="로그인하기">
</form>

</body>
</html>